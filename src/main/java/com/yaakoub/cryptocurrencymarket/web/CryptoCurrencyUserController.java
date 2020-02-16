package com.yaakoub.cryptocurrencymarket.web;

import com.yaakoub.cryptocurrencymarket.Service.CryptoCurrencyUserService;
import com.yaakoub.cryptocurrencymarket.model.Credentiel;
import com.yaakoub.cryptocurrencymarket.model.Role;
import com.yaakoub.cryptocurrencymarket.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/ws/v1")
@CrossOrigin("http://localhost:4200")
public class CryptoCurrencyUserController {
    @Autowired
    CryptoCurrencyUserService cryptoCurrencyUserService;


    @GetMapping("/user/{username}")
    private User getPerson(@PathVariable(name = "username") String username) {
        return cryptoCurrencyUserService.getCryptoCurrencyUserById(username);
    }

    @GetMapping("/roles")
    private List<Role> getRole() {
        return cryptoCurrencyUserService.getRoles();
    }

    @PostMapping("/authenticate")
    private User login(@RequestBody Credentiel crendentiel) {
        return cryptoCurrencyUserService.getCryptoCurrencyUserByLogin(crendentiel);
    }


    @GetMapping("/users")
    private List<User> retrieveUsers() {
        return cryptoCurrencyUserService.getUsers();
    }

    @GetMapping("/users/{id}")
    private User retrieveUsersById(@PathVariable ("id") Long id) {
        return cryptoCurrencyUserService.getUsersById(id);
    }
}
