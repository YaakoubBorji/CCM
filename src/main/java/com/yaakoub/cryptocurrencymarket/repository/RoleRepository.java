package com.yaakoub.cryptocurrencymarket.repository;

import com.yaakoub.cryptocurrencymarket.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

public interface RoleRepository extends CrudRepository<Role,Long> {

    public List<Role> findAll();

}
