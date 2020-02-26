package com.yaakoub.cryptocurrencymarket.api;

import com.yaakoub.cryptocurrencymarket.Service.CryptoCurrencyUserService;
import com.yaakoub.cryptocurrencymarket.model.Credentiel;
import com.yaakoub.cryptocurrencymarket.model.Role;
import com.yaakoub.cryptocurrencymarket.model.User;
import com.yaakoub.cryptocurrencymarket.security.AuthenticationService;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-29T15:18:53.033Z")

@RestController
public class UserApiController implements UserApi {

    private static final Logger log = LoggerFactory.getLogger(UserApiController.class);

    @Autowired
    private CryptoCurrencyUserService cryptoCurrencyUserService;

    @Autowired
    private AuthenticationService authenticationService;


    public ResponseEntity<User> getCurrentUser() {
        return new ResponseEntity<User>(cryptoCurrencyUserService.getCryptoCurrencyUserById(authenticationService.getServerSideUser().getUsername()),HttpStatus.OK) ;
    }

    public ResponseEntity<User> getUserByName(@ApiParam(value = "The name that needs to be fetched. Use user1 for testing.",required=true) @PathVariable("username") String username) {
        return new ResponseEntity<User>(cryptoCurrencyUserService.getCryptoCurrencyUserById(username),HttpStatus.OK);
    }

    public ResponseEntity<User>  retrieveUsersById(@PathVariable ("id") Long id) {
        return new ResponseEntity<User>(cryptoCurrencyUserService.getUsersById(id),HttpStatus.OK);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<User>  login(@RequestBody Credentiel crendentiel) {
        return new ResponseEntity<User>(cryptoCurrencyUserService.getCryptoCurrencyUserByLogin(crendentiel),HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> retrieveUsers() {
        return new ResponseEntity<List<User>>(cryptoCurrencyUserService.getUsers(),HttpStatus.OK);
    }

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getRole() {
        return  new ResponseEntity<List<Role>>(cryptoCurrencyUserService.getRoles(),HttpStatus.OK);
    }



}
