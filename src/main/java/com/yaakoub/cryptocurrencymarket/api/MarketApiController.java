package com.yaakoub.cryptocurrencymarket.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yaakoub.cryptocurrencymarket.Service.PositonMarketService;
import com.yaakoub.cryptocurrencymarket.model.ModelApiResponse;
import com.yaakoub.cryptocurrencymarket.model.Position;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-29T15:18:53.033Z")

@RestController
public class MarketApiController implements MarketApi {

    private static final Logger log = LoggerFactory.getLogger(MarketApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    @Autowired
    private  PositonMarketService positonMarketService;


    @org.springframework.beans.factory.annotation.Autowired
    public MarketApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<ModelApiResponse> addPosition(@ApiParam(value = "adds new sell position" ,required=true )  @Valid @RequestBody Position body) {
        String accept = request.getHeader("Accept");
        if (1==1) {
            try {
                positonMarketService.createPosition(body);
                return new ResponseEntity<ModelApiResponse>(objectMapper.readValue("{  \"code\" : 0,  \"type\" : \"type\",  \"message\" : \"message\"}", ModelApiResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ModelApiResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<ModelApiResponse>(objectMapper.readValue("<null>  <code>123</code>  <type>aeiou</type>  <message>aeiou</message></null>", ModelApiResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<ModelApiResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ModelApiResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ModelApiResponse> buyPosition(@ApiParam(value = "ID of position that needs to be buyed",required=true) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ModelApiResponse>(objectMapper.readValue("{  \"code\" : 0,  \"type\" : \"type\",  \"message\" : \"message\"}", ModelApiResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ModelApiResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<ModelApiResponse>(objectMapper.readValue("<null>  <code>123</code>  <type>aeiou</type>  <message>aeiou</message></null>", ModelApiResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<ModelApiResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ModelApiResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deletePosition(@ApiParam(value = "The name that needs to be deleted",required=true) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Position> getPositionById(@ApiParam(value = "The ID that needs to be fetched. Use get list for position.",required=true) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        if (1==1) {
            try {
                //TODO UPDATE ID TYPE IN SWAGGER DOC
                Position object=positonMarketService.findPostionMarketById(id);
                return new ResponseEntity<Position>(object, HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Position>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<Position>(objectMapper.readValue("<position>  <id>123456789</id>  <currency>aeiou</currency>  <amount>123456789</amount>  <status>aeiou</status></position>", Position.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<Position>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Position>(HttpStatus.NOT_IMPLEMENTED);
    }

}
