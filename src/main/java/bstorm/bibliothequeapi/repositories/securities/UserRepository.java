package bstorm.bibliothequeapi.repositories.securities;

import bstorm.bibliothequeapi.models.entities.securities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);

    boolean existsByUsername(String username);
}
