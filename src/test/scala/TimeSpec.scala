/**
 * Created by Irina on 8/13/14.
 */
package org.scalatrain

import org.specs2.ScalaCheck
import org.scalacheck.{Prop, Gen}
import Prop.forAll
import Gen.choose
import org.specs2.mutable._

class TimeSpec extends Specification with ScalaCheck {
  "Calling fromMinutes" should {
    "throw an IllegalArgumentException for negative minutes" in {
      forAll(choose(Int.MinValue, -1)) { (minutes: Int) =>
        Time fromMinutes minutes must throwA[IllegalArgumentException]
      }
    }
    "return a correctly initialized Time instance for minutes within [0, 24*60-1]" in {
      forAll(choose(0, 24 * 60 - 1)) { (minutes: Int) =>
        val time = Time fromMinutes minutes
        time.hours mustEqual minutes / 60
        time.minutes mustEqual minutes % 60
      }
    }
  }

  "Creating Time" should {
    "throw an IllegalArgumentException for negative hours" in {
      forAll(choose(Int.MinValue, -1)) { (hours: Int) =>
        new Time(hours, 0) must throwA[IllegalArgumentException]
      }
    }
    "throw an IllegalArgumentException for hours >= 24" in {
      forAll(choose(24, Int.MaxValue)) { (hours: Int) =>
        new Time(hours, 0) must throwA[IllegalArgumentException]
      }
    }
    "throw an IllegalArgumentException for negative minutes" in {
      forAll(choose(Int.MinValue, -1)) { (minutes: Int) =>
        new Time(0, minutes) must throwA[IllegalArgumentException]
      }
    }
    "throw an IllegalArgumentException for minutes >= 60" in {
      forAll(choose(60, Int.MaxValue)) { (minutes: Int) =>
        new Time(0, minutes) must throwA[IllegalArgumentException]
      }
    }
    "return an instance with correct defaults" in {
      val time = new Time
      time.hours mustEqual 0
      time.minutes mustEqual 0
    }
  }

  "Calling - " should {
    val time1 = new Time(2, 20)
    val time2 = new Time(1, 10)
    "throw an IllegalArgumentException for null that" in {
      time1 - null must throwA[IllegalArgumentException]
    }
    "return the corect time difference" in {
      time1 - time2 mustEqual 70
      time2 - time1 mustEqual -70
    }
  }

  "Calling asMinutes" should {
    "return the correct value" in {
      new Time(0, 10).asMinutes mustEqual 10
      new Time(1, 10).asMinutes mustEqual 70
    }
  }
}
