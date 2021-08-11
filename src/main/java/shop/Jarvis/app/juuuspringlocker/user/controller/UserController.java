package shop.Jarvis.app.juuuspringlocker.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import shop.Jarvis.app.juuuspringlocker.user.entity.User;
import shop.Jarvis.app.juuuspringlocker.user.service.UserService;
import shop.Jarvis.app.juuuspringlocker.user.service.UserServiceImpl;

import java.util.List;

@RestController @RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    @GetMapping("/users/all")
    public List<User> getAllUsers() {
        return userService.findAll();
    }
    @GetMapping("/users/name/{name}")
    public List<User> findByName(@PathVariable String name) {
        return userService.findAllByName(name);
    }
}
