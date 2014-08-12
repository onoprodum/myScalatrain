package org.scalatrain

/**
 * Created by Irina on 8/12/14.
 */

import org.specs2.mutable._

class TrainSpec extends Specification{
  "Creating a Train" should {
    "trow an IllegalArgumentException for a null kind" in {
      new Train(null, "number") must throwA[IllegalArgumentException]
    }
    "throw an IllegalArgumentException for a null number" in {
      new Train("kind", null) must throwA[IllegalArgumentException]
    }
  }
}
