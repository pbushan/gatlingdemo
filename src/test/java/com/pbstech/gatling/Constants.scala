package com.pbstech.gatling

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.core.Predef.{BlackList, WhiteList}
import io.gatling.http.protocol.HttpProtocolBuilder

object Constants {
  val headers: Map[String, String] = Map(
    "Content-Type" -> "application/json",
    "User-Agent" -> "Java/1.8.0_152")

  val httpProtocol: HttpProtocolBuilder = http
    .baseUrl("http://pbstech-ubuntu.eastus.cloudapp.azure.com:8080")
    .inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""), WhiteList())
    .acceptHeader("application/json; */*")
    .headers(headers)
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.13; rv:66.0) Gecko/20100101 Firefox/66.0")
}
