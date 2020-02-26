package com.yaakoub.cryptocurrencymarket.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yaakoub.cryptocurrencymarket.Service.CryptoCurrencyUserService;
import com.yaakoub.cryptocurrencymarket.helper.Helper;
import com.yaakoub.cryptocurrencymarket.model.ModelApiResponse;
import com.yaakoub.cryptocurrencymarket.model.User;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-29T15:18:53.033Z")

@RestController
public class RegisterApiController implements RegisterApi {

    private static final Logger log = LoggerFactory.getLogger(RegisterApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    CryptoCurrencyUserService cryptoCurrencyUserService;

    @org.springframework.beans.factory.annotation.Autowired
    public RegisterApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<ModelApiResponse> addUser(@ApiParam(value = "User object that needs to be added to the system", required = true) @Valid @RequestBody User body) {

        try {
            cryptoCurrencyUserService.createUser(body);
            return new ResponseEntity<ModelApiResponse>(Helper.generateReponse("CREATE"), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<ModelApiResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
