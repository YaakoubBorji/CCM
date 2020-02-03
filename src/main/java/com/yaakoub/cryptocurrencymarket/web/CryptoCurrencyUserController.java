package com.yaakoub.cryptocurrencymarket.web;

import com.yaakoub.cryptocurrencymarket.Service.CryptoCurrencyUserService;
import com.yaakoub.cryptocurrencymarket.model.Role;
import com.yaakoub.cryptocurrencymarket.model.RoleEnum;
import com.yaakoub.cryptocurrencymarket.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/ws/v1")
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

}
