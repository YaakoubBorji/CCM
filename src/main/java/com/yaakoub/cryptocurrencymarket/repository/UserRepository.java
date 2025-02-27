package com.yaakoub.cryptocurrencymarket.repository;

import com.yaakoub.cryptocurrencymarket.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    public User findByuserName(String username);

    public User save(User user);

    public User findByuserNameAndFamilyName(String username, String familyName);

}
