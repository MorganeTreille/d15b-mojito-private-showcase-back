package fr.formation.user;

import fr.formation.controller.AbstractController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController extends AbstractController {

	@Autowired
	private UserService userService;

	Logger logger = LoggerFactory.getLogger(UserController.class);

	@PostMapping("/")
	public ResponseEntity<Object> signup(@RequestBody SignInDto signInDto) {

		try {
			userService.addNewUser(
					signInDto.getUsername(), 
					signInDto.getPassword(), 
					signInDto.getEmail(), 
					signInDto.getArtistName(),
					signInDto.getDescription());

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		


	}
	@GetMapping("/userName")
	@Secured("ROLE_USER")
	public ResponseEntity<User> getUser() throws UserNotFoundException{
		User user = userService.getUser(super.getAuthenticatedUserName());

		logger.info(user.toString());
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

}
