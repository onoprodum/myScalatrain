package org.scalatrain

/**
 * Created by Irina on 8/3/14.
 */
object Time {
  def fromMinutes( minutes: Int ) = {
    // TODO check preconditions
    new Time( minutes / 60, minutes % 60 )
  }
}

case class Time( hours: Int = 0, minutes: Int = 0 ) {

  // TODO check preconditions

  lazy val asMinutes: Int = hours* 60 + minutes
  def -( that: Time ) : Int = {
    asMinutes - that.asMinutes
  }
}
