package com.yaakoub.cryptocurrencymarket.Service;

import com.yaakoub.cryptocurrencymarket.model.Credentiel;
import com.yaakoub.cryptocurrencymarket.model.Role;
import com.yaakoub.cryptocurrencymarket.model.User;
import com.yaakoub.cryptocurrencymarket.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yaakoub.cryptocurrencymarket.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CryptoCurrencyUserService {
    @Autowired
    UserRepository cryptoCurrencyUserRepository;
    @Autowired
    RoleRepository roleRepository;

    public User getCryptoCurrencyUserById(String username) {
        return cryptoCurrencyUserRepository.findByusername(username);
    }

    public User getCryptoCurrencyUserByLogin(Credentiel credentiel ) {
        return cryptoCurrencyUserRepository.findByusernameAndFamilyName(credentiel.getLogin(), credentiel.getPassword());
    }

    public List<User> getUsers() {
        return (List<User>) cryptoCurrencyUserRepository.findAll();
    }


    public User createUser(User user) {
        return cryptoCurrencyUserRepository.save(user);
    }


    public User getCurrentUser(User user) {
        return cryptoCurrencyUserRepository.save(user);
    }

    public List<Role> getRoles() {
        return roleRepository.findAll();
    }


    public User getUsersById(Long id) {
        return  cryptoCurrencyUserRepository.findById(id).orElse(null);
    }
}

