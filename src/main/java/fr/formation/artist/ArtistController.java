package fr.formation.artist;

import fr.formation.controller.AbstractController;
import fr.formation.user.User;
import fr.formation.user.UserNotFoundException;
import fr.formation.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/artist")
public class ArtistController extends AbstractController {

    @Autowired
    private ArtistService artistService;
    @Autowired
    private UserService userService;

    Logger logger = LoggerFactory.getLogger(ArtistController.class);

    @GetMapping("/")
    @Secured("ROLE_USER")
    public ResponseEntity<Artist> getArtist(@RequestParam String name) throws ArtistNotFoundException, UserNotFoundException {
        User user = userService.getUser(super.getAuthenticatedUserName());
        Artist artist = artistService.getArtist(name);
        logger.info(artist.toString());
        return new ResponseEntity<>(artist, HttpStatus.OK);
    }

    @GetMapping("/list")
    @Secured("ROLE_USER")
    public ResponseEntity<List<Artist>> getAllArtist() throws  ArtistNotFoundException, UserNotFoundException {
        User user = userService.getUser(super.getAuthenticatedUserName());
        List<Artist> listArtist = artistService.getAllArtist();

        return new ResponseEntity<>(listArtist, HttpStatus.OK);
    }
}
