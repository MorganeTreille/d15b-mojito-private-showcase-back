package fr.formation.artist;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

    public Artist findByArtistName(String artistName);

}
