package com.berlinclock

import java.text.SimpleDateFormat
import java.util.Calendar

/**
 * Representation of the Berlin Clock.
 */
class BerlinClock(time: String) {

  private val parsedTime = Calendar.getInstance()
  parsedTime.setTime(new SimpleDateFormat("HH:mm:ss").parse(time))

  /**
   * @return String representation of seconds on the clock
   */
  def seconds: String = line((parsedTime.get(Calendar.SECOND) + 1) % 2, 1, 1, yellowLamp)

  /**
   * @return String representation of hours on the clock
   */
  def hours: String = {
    def hoursLamp(field: Int, step: Int, length: Int): String =
      if (field >= step) Colours.Red
      else Colours.Off

    line(parsedTime.get(Calendar.HOUR_OF_DAY), 5, 4, hoursLamp) +
    line(parsedTime.get(Calendar.HOUR_OF_DAY) % 5, 1, 4, hoursLamp)
  }

  /**
   * @return String representation of minutes on the clock
   */
  def minutes: String = {
    def minutesLamp(field: Int, step: Int, length: Int): String = 
      if (field >= step && length % 3 == 0) Colours.Red
      else if (field >= step && length % 3 > 0) Colours.Yellow
      else Colours.Off
      
    line(parsedTime.get(Calendar.MINUTE), 5, 11, minutesLamp) +
    line(parsedTime.get(Calendar.MINUTE) % 5, 1, 4, yellowLamp)
  }

  /**
   * @return string representation of the clock
   */
  def clock: String = seconds + hours + minutes

  private def yellowLamp(field: Int, step: Int, length: Int): String =
    if (field >= step) Colours.Yellow
    else Colours.Off

  private def line(field: Int, step: Int, length: Int, color: (Int, Int, Int) => String): String = {
    if (length > 0) color(field, step, length) + line(field - step, step, length - 1, color)
    else "\n"
  }
}

object Colours {
  val Off = "O"
  val Red = "R"
  val Yellow = "Y"
}

