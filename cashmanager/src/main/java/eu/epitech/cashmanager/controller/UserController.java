package eu.epitech.cashmanager.controller;

import eu.epitech.cashmanager.domain.User;
import eu.epitech.cashmanager.exception.HttpException;
import eu.epitech.cashmanager.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return this.userService.getAllUser();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable int id) {
        try {
            return this.userService.getUser(id);
        } catch (HttpException e) {
            throw new ResponseStatusException(
                    e.getStatusCode(), e.getMessage(), e
            );
        }
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void addUser(@RequestBody User user) {
        this.userService.addUser(user);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user) {
        this.userService.updateUser(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable int id) {
        this.userService.deleteUser(id);
    }
}
