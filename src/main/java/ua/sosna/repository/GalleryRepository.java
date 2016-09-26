package ua.sosna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.sosna.model.Gallery;

import java.util.List;

@Repository
public interface GalleryRepository extends JpaRepository<Gallery, Integer> {

    @Query("select id from Gallery where name = :name ")
    int getId(@Param("name") String name);


    /*@Query("select from where user.id= :userId")
    List<Gallery> getAllGallerybyUserId(@Param("userId") int userId);*/

    List<Gallery> findByUser_Id(int userId);
}
