package fr.formation.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import fr.formation.artist.Artist;
import fr.formation.artist.ArtistRepository;
import fr.formation.security.SecurityUtils;

@Service
public class UserService implements UserDetailsService {
	
	Logger logger = LoggerFactory.getLogger(UserService.class);

	private UserRepository userRepository;
	private UserRoleRepository userRoleRepository;
	private ArtistRepository artistRepository;

	@Autowired
	public UserService(UserRepository userRepository, 
			UserRoleRepository userRoleRepository,
			ArtistRepository artistRepository) {
		this.userRepository = userRepository;
		this.userRoleRepository = userRoleRepository;
		this.artistRepository = artistRepository;
	}

	public User getUser(String name) throws UserNotFoundException{
	    User user = userRepository.findByUsername(name);
	    if (user == null) {
            throw new UserNotFoundException("utilisateur inexistant");
        }

        return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
            User user = getUser(username);
            List<String> roles = userRoleRepository.findRoleByUserName(username);
            return new org.springframework.security.core.userdetails.User(username, user.getPassword(),
                    transformToAuthorities(roles));
        }catch (UserNotFoundException e){
            throw new UsernameNotFoundException("No user exists with username: " + username);
        }

	}

	/**
	 * Add a new user with the user repository
	 * 
	 * @param username
	 * @param password
	 * @param roles
	 */
	public void addNewUser(
			String username,
			String password, 
			String email,
			String artistName,
			String descriptionCourt) throws IllegalArgumentException {
		
		// 1- Control des paramètres d'entées
		Assert.notNull(username,"Le champ username est requis");
		Assert.notNull(password, "Le champ password est requis");
		Assert.notNull(email, "Le champ email est requis");
		
		// 1.1- Controle de la validité du mot de passe
		
		if(SecurityUtils.validatePassword(password) == false) {
			throw new IllegalArgumentException("password non valide");
		}
		
		// 2- Si les champs sont rensiegnés, 
		//    - création de l'artiste 
		//    - insert en bdd
		//    - Ajout du rôle artiste
		Artist artist = null;
		List<String> roles = new ArrayList<>();
		if(artistName != null && descriptionCourt != null) {
			logger.info("Création de l'artiste" + artistName);
			artist = new Artist();
			artist.setName(artistName);
			artist.setDescriptionCourt(descriptionCourt);
			artist = artistRepository.save(artist);
					
			roles.add("ARTISTE");
		}
		
		// 3- Création du user et insert en BDD

		User user = new User();
		if(artist != null) {
			user.setArtist(artist);
		}

		user.setUsername(username);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(password));
		user.setEmail(email);
		user = userRepository.save(user);
		roles.add("USER");


		// 4- Création des roles pour l'utilisateur et insert en BDD
		
		for (String role : roles) {

			UserRole userRole = new UserRole();
			userRole.setRole(role);
			userRole.setUserId(user.getId());

			userRoleRepository.save(userRole);
		}

	}

	/**
	 * transform a list of roles (as {@link String}) into a list of
	 * {@link GrantedAuthority}
	 * 
	 * @param userRoles
	 * @return
	 */
	private static Collection<? extends GrantedAuthority> transformToAuthorities(List<String> userRoles) {
		String roles = StringUtils.collectionToCommaDelimitedString(userRoles);
		return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
	}
}