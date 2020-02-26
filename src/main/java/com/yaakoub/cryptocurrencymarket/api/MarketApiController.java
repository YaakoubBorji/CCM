package com.yaakoub.cryptocurrencymarket.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yaakoub.cryptocurrencymarket.Service.PositonMarketService;
import com.yaakoub.cryptocurrencymarket.helper.Helper;
import com.yaakoub.cryptocurrencymarket.model.ModelApiResponse;
import com.yaakoub.cryptocurrencymarket.model.Position;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-29T15:18:53.033Z")

@RestController
public class MarketApiController implements MarketApi {

    private static final Logger log = LoggerFactory.getLogger(MarketApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    @Autowired
    private PositonMarketService positonMarketService;


    @org.springframework.beans.factory.annotation.Autowired
    public MarketApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<ModelApiResponse> addPosition(@ApiParam(value = "adds new sell position", required = true) @Valid @RequestBody Position body) {

        try {
            positonMarketService.createPosition(body);
            return new ResponseEntity<ModelApiResponse>(Helper.generateReponse("CREATE"), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<ModelApiResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<ModelApiResponse> buyPosition(@ApiParam(value = "ID of position that needs to be buyed", required = true) @PathVariable("id") Long id) {
        try {

            positonMarketService.buyPositionById(id);
            return new ResponseEntity<ModelApiResponse>(Helper.generateReponse("BUY"), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<ModelApiResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ResponseEntity<ModelApiResponse> deletePosition(@ApiParam(value = "The name that needs to be deleted", required = true) @PathVariable("id") Long id) {
        try {
            positonMarketService.deletePositionById(id);
            return new ResponseEntity<ModelApiResponse>(Helper.generateReponse("DELETE"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<ModelApiResponse>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity<Position> getPositionById(@ApiParam(value = "The ID that needs to be fetched. Use get list for position.", required = true) @PathVariable("id") Long id) {
        try {
            Position position = positonMarketService.findPostionMarketById(id);
            return new ResponseEntity<Position>(position, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<Position>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<Position> searchPositionsByStatus(String statusPosition) {
        return positonMarketService.getAllPositionByStatus(statusPosition);
    }


}



