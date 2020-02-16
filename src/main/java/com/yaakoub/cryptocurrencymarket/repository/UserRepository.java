package com.yaakoub.cryptocurrencymarket.repository;

import com.yaakoub.cryptocurrencymarket.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    public User findByusername(String username);

    public User save(User user);

    public User findByusernameAndFamilyName(String username, String familyName);

}
