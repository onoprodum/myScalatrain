package org.scalatrain

/**
 * Created by Irina on 8/1/14.
 */
case class Train( kind: String, number: String ) {
  require( kind != null, "kind must not be null" )
  require( number != null, "number must not be null" )
}
