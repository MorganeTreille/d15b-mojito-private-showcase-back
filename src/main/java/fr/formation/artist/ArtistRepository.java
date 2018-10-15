package fr.formation.artist;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

    public Artist findArtistByName(String name);

    public List<Artist> findAll();

}
