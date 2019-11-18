package eu.epitech.cashmanager.service;

import eu.epitech.cashmanager.domain.User;
import eu.epitech.cashmanager.exception.NotFoundException;
import eu.epitech.cashmanager.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();

        this.userRepository.findAll()
                .forEach(users::add);
        return users;
    }

    public User getUser(int id) {
        return this.userRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("user with id %d", id)));
    }

    public void addUser(User user) {
        this.userRepository.save(user);
    }

    public void updateUser(User user) {
        this.userRepository.save(user);
    }

    public void deleteUser(int id) {
        this.userRepository.deleteById(id);
    }
}
