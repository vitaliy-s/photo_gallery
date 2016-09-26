package ua.sosna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.sosna.model.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Integer> {
}
