package in.swatiksingh.phonebook_sys_020624.repositories;

import in.swatiksingh.phonebook_sys_020624.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findByFirstNameStartingWith(String prefix);
    List<User> findByLastNameStartingWith(String suffix);
    List<User> findByPhoneNumberStartingWith(String phoneNumber);
}
