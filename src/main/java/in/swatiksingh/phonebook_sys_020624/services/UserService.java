package in.swatiksingh.phonebook_sys_020624.services;

import in.swatiksingh.phonebook_sys_020624.entities.User;
import in.swatiksingh.phonebook_sys_020624.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;
    public UserService (UserRepository userRepository){
        this.userRepository=userRepository;
    }
    public User  registerUser(User user) {
        return userRepository.save(user);
    }

    public List<User> serachByFirstName(String firstName) {
        return userRepository.findByFirstNameStartingWith(firstName);
    }

    public List<User> searchByLastName( String lastName) {
        return userRepository.findByLastNameStartingWith(lastName);
    }
    public List<User> searchByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumberStartingWith(phoneNumber );
    }

    public User delete(Long UserId) {
       User user = userRepository.findById(UserId).orElse(null);
       userRepository.delete(user);
       return  user;
    }

    public User update(Long id,User user) {
        User userInDb =userRepository.findById(id).orElse(null);

        if( user.getFirstName() != null) {
            userInDb.setFirstName(user.getFirstName());
        }
        if(user.getLastName() != null) {
            userInDb.setLastName(user.getLastName());
        }
        if(user.getPhoneNumber() != null ) {
            userInDb.setPhoneNumber(user.getPhoneNumber());
        }
           return userRepository.save(userInDb);

    }
}
