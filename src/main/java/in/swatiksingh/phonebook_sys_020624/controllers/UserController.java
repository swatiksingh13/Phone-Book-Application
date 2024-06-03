package in.swatiksingh.phonebook_sys_020624.controllers;

import in.swatiksingh.phonebook_sys_020624.entities.User;
import in.swatiksingh.phonebook_sys_020624.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phone")

public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        User u1 = userService.registerUser(user);
        return u1;
    }

    @GetMapping("/searchFirst/{firstName}")
    public List<User> serachByFirstName(@PathVariable String firstName) {
        return userService.serachByFirstName(firstName);

    }

    @GetMapping("/searchLast/{lastName}")
    public List<User> searchByLastName(@PathVariable String lastName) {
        return userService.searchByLastName(lastName);
    }

    @GetMapping("/searchNumber/{phoneNumber}")
    public List<User> searchByPhoneNumber(@PathVariable String phoneNumber) {
        return userService.searchByPhoneNumber(phoneNumber);
    }

  @DeleteMapping("/delete/{id}")
    public User deleteUser(@PathVariable Long id) {
        return userService.delete(id);
    }

    @PatchMapping("/update/{id}")
    public User updateuser(@PathVariable Long id, @RequestBody User user) {
        return userService.update(id,user);
    }

}
