/**
 * Created by Irina on 8/20/14.
 */
package org.scalatrain

case class JourneyPlanner(trains: Set[Train]) {
  require(trains != null, "trains must not be null")

  val stations: Set[Station] = trains flatMap { _.stations }

  def trains(station: Station): Set[Train] = {
    require(station != null, "station must not be null")
    trains filter { _.stations contains station }
  }
}
