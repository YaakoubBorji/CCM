/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.10).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.yaakoub.cryptocurrencymarket.api;

import com.yaakoub.cryptocurrencymarket.model.Credentiel;
import com.yaakoub.cryptocurrencymarket.model.RoleEnum;
import com.yaakoub.cryptocurrencymarket.model.User;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-29T15:18:53.033Z")

@Api(value = "user", description = "the user API")
@CrossOrigin("http://localhost:4200")
public interface UserApi {

    @ApiOperation(value = "Returs current user details.", nickname = "getCurrentUser", notes = "", response = User.class, authorizations = {
        @Authorization(value = "cookieAuth")
    }, tags={ "user", })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "successful operation", response = User.class),
        @ApiResponse(code = 400, message = "Invalid username/password supplied") })
    @GetMapping(path = "/user")
    ResponseEntity<User> getCurrentUser();


    @ApiOperation(value = "Get user by user name", nickname = "getUserByName", notes = "", response = User.class, authorizations = {
        @Authorization(value = "cookieAuth")
    }, tags={ "user", })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "successful operation", response = User.class),
        @ApiResponse(code = 400, message = "Invalid username supplied"),
        @ApiResponse(code = 404, message = "User not found")})
    @PreAuthorize("hasRole('ADMINISTRATOR') or @currencySecurityService.canDoAction(T(com.yaakoub.cryptocurrencymarket.model.User).userFactory(),#username)")
    @GetMapping(path = "/user/{username}")
    ResponseEntity<User> getUserByName(@ApiParam(value = "The name that needs to be fetched. Use user1 for testing.", required = true) @PathVariable("username") String username);


    @GetMapping("/users/{id}")
    ResponseEntity<User> retrieveUsersById(@PathVariable ("id") Long id);

    @PostMapping("/authenticate")
    ResponseEntity<User> login(@RequestBody Credentiel crendentiel);

    @GetMapping("/users")
    public ResponseEntity<List<User>> retrieveUsers();

}
