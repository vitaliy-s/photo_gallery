package ua.sosna.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.sosna.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);


    @Query("SELECT count(*) from User where email = :mail")
    int findByEmailExists(@Param("mail") String mail);

    @Query("SELECT count(*) from User where username = :name")
    int findByUserNameExists(@Param("name") String userName);
}
