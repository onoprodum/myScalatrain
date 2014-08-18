package org.scalatrain

/**
 * Created by Irina on 8/3/14.
 */
object Time {
  def fromMinutes( minutes: Int ) = {
    require( minutes >= 0, "minutes must not be negative")
    new Time( minutes / 60, minutes % 60 )
  }
}

case class Time( hours: Int = 0, minutes: Int = 0 ) {
  require( hours >= 0, "hours must not be negative")
  require( hours < 24, "hours must be >= 24")
  require( minutes >= 0, "minutes must not be negative")
  require( minutes < 60, "minutes must not >= 60")

  lazy val asMinutes: Int = hours* 60 + minutes
  def -( that: Time ) : Int = {
    require( that != null, "that must not be null")
    asMinutes - that.asMinutes
  }
}
