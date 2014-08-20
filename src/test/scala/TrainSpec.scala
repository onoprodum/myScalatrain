/**
 * Created by Irina on 8/12/14.
 */
package org.scalatrain

import org.specs2.mutable._

class StationSpec extends Specification{
  "Creating a Station" should {
    "trow an IllegalArgumentException for a null name" in {
      new Station(null) must throwA[IllegalArgumentException]
    }
  }
}

class TrainSpec extends Specification{
  "Creating a Train" should {
    val schedule = Seq((Time(1,1),Station("1")), (Time(2,2),Station("2")))
    "trow an IllegalArgumentException for a null kind" in {
      new Train(null, "number", schedule) must throwA[IllegalArgumentException]
    }
    "throw an IllegalArgumentException for a null number" in {
      new Train("kind", null, schedule) must throwA[IllegalArgumentException]
    }
    "throw an IllegalArgumentException for a null schedule" in {
      new Train("kind", "number", null) must throwA[IllegalArgumentException]
    }
    "throw an IllegalArgumentException for a schedule with one station" in {
      new Train("kind", "number", Seq((Time(1,1),Station("1")))) must throwA[IllegalArgumentException]
    }
  }
  "Getting stations" should {
    "return the correct stations in the correct sequence" in {
      val train = Train( "kind", "number", List( Time(0,0) -> Station("0"), Time(1,1) -> Station("1")))
      train.stations mustEqual List( Station("0"), Station("1"))
    }
  }
}
