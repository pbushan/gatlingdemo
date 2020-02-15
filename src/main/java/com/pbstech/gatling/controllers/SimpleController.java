package com.pbstech.gatling.controllers;

import com.pbstech.gatling.models.Product;
import com.pbstech.gatling.models.ProductResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @ApiOperation(value = "Get an id with custom delay")
    @GetMapping(value = "/getdelayed/{delay}")
    public HttpEntity<ProductResult> findById(@PathVariable("delay") Long delay) throws InterruptedException {
        ProductResult productResult = new ProductResult();
        productResult.setId(UUID.randomUUID().toString());
        Thread.sleep(delay);
        return ResponseEntity.ok().body(productResult);
    }

    @ApiOperation(value = "Shows delay in product shipping")
    @PostMapping(value = "/productdelay")
    public  HttpEntity<String> findProductDelay(@RequestBody @Valid Product product) throws InterruptedException {
        Thread.sleep(product.getDelay());
        return ResponseEntity.accepted().body(product.getProductName() + " of "+product.getProductCategory() +" is delayed by " + product.getDelay() +" days");
    }


}
