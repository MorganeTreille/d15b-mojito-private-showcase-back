package fr.formation.artist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArtistService {

    private ArtistRepository artistRepository;

    @Autowired
    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }


    public Artist getArtist(String name) throws ArtistNotFoundException {

        Artist artist = artistRepository.findArtistByName(name);

        if(artist == null) {
            throw new ArtistNotFoundException("Artiste inexistant");
        }

        return artist;

    }

    public List<Artist> getAllArtist() throws ArtistNotFoundException {
        List<Artist> listArtist = new ArrayList<Artist>();
        listArtist = artistRepository.findAll();

        if(listArtist == null) {
            throw new ArtistNotFoundException("Aucun artiste enregistré");
        }

        return listArtist;
    }
}
