package fr.formation.artist;

import fr.formation.user.User;
import fr.formation.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    private ArtistService artistService;
    @Autowired
    private UserService userService;

    Logger logger = LoggerFactory.getLogger(ArtistController.class);

    @GetMapping("/")
    @Secured("ROLE_USER")
    public ResponseEntity<Artist> getArtist(String artistName) {
        User user = userService.getUser(super.getAuthentification());
        Artist artist = artistService.getArtist(artistName);
        logger.info(artist.toString());
        return ResponseEntity<>(artist, HttpStatus.OK);
    }
}
