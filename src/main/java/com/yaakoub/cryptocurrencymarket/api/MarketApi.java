/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.10).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.yaakoub.cryptocurrencymarket.api;

import com.yaakoub.cryptocurrencymarket.model.ModelApiResponse;
import com.yaakoub.cryptocurrencymarket.model.Position;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-29T15:18:53.033Z")

@Api(value = "market", description = "the market API")
public interface MarketApi {

    @ApiOperation(value = "Add a new sell position", nickname = "addPosition", notes = "", response = ModelApiResponse.class, authorizations = {
        @Authorization(value = "cookieAuth")
    }, tags={ "market", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = ModelApiResponse.class),
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/market",
        produces = { "application/json", "application/xml" }, 
        consumes = { "application/json", "application/xml" },
        method = RequestMethod.POST)
    ResponseEntity<ModelApiResponse> addPosition(@ApiParam(value = "adds new sell position", required = true) @Valid @RequestBody Position body);


    @ApiOperation(value = "buys open new sell position", nickname = "buyPosition", notes = "", response = ModelApiResponse.class, authorizations = {
        @Authorization(value = "cookieAuth")
    }, tags={ "market", })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "successful operation", response = ModelApiResponse.class),
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/market/buy/{id}",
        produces = { "application/json", "application/xml" },
        consumes = { "application/json", "application/xml" },
        method = RequestMethod.POST)
    ResponseEntity<ModelApiResponse> buyPosition(@ApiParam(value = "ID of position that needs to be buyed", required = true) @PathVariable("id") Long id);


    @ApiOperation(value = "Delete sell position", nickname = "deletePosition", notes = "delete sell position if it was opened by current user or if user has administartor role.", tags={ "market", })
    @ApiResponses(value = {
        @ApiResponse(code = 400, message = "Invalid id supplied"),
        @ApiResponse(code = 404, message = "position not found") })
    @RequestMapping(value = "/market/{id}",
        produces = { "application/json", "application/xml" },
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deletePosition(@ApiParam(value = "The name that needs to be deleted", required = true) @PathVariable("id") Long id);


    @ApiOperation(value = "find open or sold position by ID", nickname = "getPositionById", notes = "", response = Position.class, authorizations = {
        @Authorization(value = "cookieAuth")
    }, tags={ "market", })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "successful operation", response = Position.class),
        @ApiResponse(code = 400, message = "Invalid username supplied"),
        @ApiResponse(code = 404, message = "User not found") })
    @RequestMapping(value = "/market/{id}",
        produces = { "application/json", "application/xml" },
        method = RequestMethod.GET)
    ResponseEntity<Position> getPositionById(@ApiParam(value = "The ID that needs to be fetched. Use get list for position.", required = true) @PathVariable("id") Long id);

}
