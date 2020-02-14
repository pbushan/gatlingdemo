package com.pbstech.gatling

import io.gatling.core.Predef._
import io.gatling.core.pause.UniformDuration
import io.gatling.core.structure.PopulationBuilder
import scala.concurrent.duration._

class ProductSimulation extends Simulation {

  /*

    before {
    }
  */
  /*
   * Here we get a product
   */
  val getProduct: PopulationBuilder =
  scenario("get product")
    .exec(
      Product.getProduct
    )
    /*
     * The number and arrival rate of users for the scenario is configured.
     */
    .inject(
      atOnceUsers(1),
      nothingFor(2 seconds),
      rampUsers(1) during (1 seconds)
    )

  /*
   * A Simulation is then created based off of the Scenario
   */
  setUp(getProduct)
    /*
     * Here we define configuration for how HTTP requests are executed against the REST API
     */
    .protocols(Constants.httpProtocol)
    /*
     * To simulate real user behavior, we add in pauses between requests with varying duration
     */
    .pauses(UniformDuration(2 seconds))
    /*
     * Here we define assertions against response times based on SLAs
     */
    .assertions(global.responseTime.percentile(95).lt(3000))
}