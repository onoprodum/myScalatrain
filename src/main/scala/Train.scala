
/**
 * Created by Irina on 8/1/14.
 */
package org.scalatrain

case class Station(name: String) {
  require( name != null, "name must not be null" )
}
case class Train( kind: String, number: String, schedule: Seq[(Time,Station)] ) {
  require( kind != null, "kind must not be null" )
  require( number != null, "number must not be null" )
  require( schedule != null, "schedule must not be null")
  require( schedule.size >=2 , "schedule must have at least two stations")
  // TODO schedule aufsteigende Reihenfolge von Zeiten

  val stations: Seq[Station] = schedule map { _._2 }
}
