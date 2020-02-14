package com.pbstech.gatling

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object Product {

  val getProduct = exec(http("/Product")
    .get("/product")
    .check(jsonPath("$.id").exists.saveAs("productId")))

}