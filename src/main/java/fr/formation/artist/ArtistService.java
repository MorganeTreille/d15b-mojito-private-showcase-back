package fr.formation.artist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {

    private ArtistRepository artistRepository;

    @Autowired
    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }


    public Artist getArtist(String artistName) {

        Artist artist = artistRepository.findByArtistName(artistName);
        return artist;
    }
}
