package com.berlinclock

import java.text.ParseException

/**
 * Main class of the app.
 */
object Main extends App {

  if (args.length == 0) {
    println("please specify the time (in the format 'hh:mm:ss') you want to display as the Berlin Clock.")
  } else {
    val time = args(0)

    try {
      println(new BerlinClock(time).clock)
    } catch {
      case e: ParseException => {
        printf("'%s' is not a valid time. Please specify time in the format 'hh:mm:ss'.\n\n", time)
      }
      case _: Throwable => {
        println("Something unexpected happened!")
      }
    }
  }
}
