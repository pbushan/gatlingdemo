package com.pbstech.gatling

import io.gatling.core.Predef._
import io.gatling.core.feeder._
import io.gatling.http.Predef._

object Product {

  def orderRef() = new scala.util.Random().nextInt(1500)

  val getProduct = exec(http("/Product")
    .get("/product")
    .check(jsonPath("$.id").exists.saveAs("productId")))

  val getdelayed = exec(http("/getdelayed")
    .get("/getdelayed/" + orderRef())
    .check(jsonPath("$.id").exists.saveAs("productId")))


}