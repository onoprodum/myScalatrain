/**
 * Created by Irina on 8/20/14.
 */
package org.scalatrain

import org.specs2.mutable._

class JourneyPlannerSpec extends Specification {
  "Creating a JourneyPlanner" should {
    "trow an IllegalArgumentException for a null trains" in {
      new JourneyPlanner(null) must throwA[IllegalArgumentException]
    }
  }

  "Getting stations" should {
    val journeyPlanner = new JourneyPlanner(Set(train1, train2))
    "return the correct stations" in {
      journeyPlanner.stations mustEqual Set(stationA, stationB, stationC, stationD)
    }
  }

  "Getting trains" should {
    val journeyPlanner = new JourneyPlanner(Set(train1, train2))
    "trow an IllegalArgumentException for a null station" in {
      journeyPlanner trains null.asInstanceOf[Station] must throwA[IllegalArgumentException]
    }

    "return the correct result" in {
      journeyPlanner trains stationA mustEqual Set(train1, train2)
      journeyPlanner trains stationB mustEqual Set(train1, train2)
      journeyPlanner trains stationC mustEqual Set(train1)
      journeyPlanner trains stationD mustEqual Set(train2)
      journeyPlanner trains Station("") mustEqual Set.empty

    }
  }
  private lazy val train1 = new Train("k1", "n1", schedule1)
  private lazy val train2 = new Train("k2", "n2", schedule2)
  private lazy val schedule1 = List(Time(0, 0) -> stationA, Time(1, 1) -> stationB, Time(2, 2) -> stationC)
  private lazy val schedule2 = List(Time(0, 0) -> stationD, Time(1, 1) -> stationB, Time(2, 2) -> stationA)
  private lazy val stationA = new Station("A")
  private lazy val stationB = new Station("B")
  private lazy val stationC = new Station("C")
  private lazy val stationD = new Station("D")
}
