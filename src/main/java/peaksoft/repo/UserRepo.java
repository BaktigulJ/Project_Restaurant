package peaksoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.model.User;

import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

    @Query("select u from User u where u.email =:email")
    Optional<User> findByEmil(String email);


    default User getByEmail(String email){
        return findByEmil(email).orElseThrow(()-> new NoSuchElementException("User with email"+email+" not found"));
    }
}
