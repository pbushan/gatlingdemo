package com.pbstech.gatling.controllers;

import com.pbstech.gatling.models.ProductResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Api(value = "Simple Controller", description = "Operations for creating a simple rest API to use in gatling tests")
public class SimpleController {

    @ApiOperation(value = "Get a product id")
    @GetMapping("/product")
    public HttpEntity<ProductResult> getProductId() {
        ProductResult productResult = new ProductResult();
        productResult.setId(UUID.randomUUID().toString());
        return ResponseEntity.accepted().body(productResult);
    }

}
