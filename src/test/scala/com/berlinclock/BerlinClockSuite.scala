package com.berlinclock

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.FunSuite

/**
 * Test suite of the class <code>BerlinClock</code>.
 */
@RunWith(classOf[JUnitRunner])
class BerlinClockSuite extends FunSuite {
  trait TestTimes {
    val t1 = new BerlinClock("17:22:20")
    val t2 = new BerlinClock("17:22:21")

    val t3 = new BerlinClock("00:00:00")
    val t4 = new BerlinClock("13:17:01")
    val t5 = new BerlinClock("23:59:59")
    val t6 = new BerlinClock("24:00:00")
  }

  test("Seconds: t1 - lamp is on") {
    new TestTimes {
      val result = t1.seconds
      println(result)
      assert((Colours.Yellow + "\n").equals(result))
    }
  }

  test("Seconds: t2 - lamp is off") {
    new TestTimes {
      val result = t2.seconds
      println(result)
      assert((Colours.Off + "\n").equals(result))
    }
  }

  test("Hour representation of the time t1") {
    new TestTimes {
      val result = t1.hours
      println(result)
      assert("RRRO\nRROO\n".equals(result))
    }
  }

  test("Minute representation of the time t2") {
    new TestTimes {
      val result = t2.minutes
      println(result)
      assert("YYRYOOOOOOO\nYYOO\n".equals(result))
    }
  }

  test("Minute representation of the time t4") {
    new TestTimes {
      val result = t4.minutes
      println(result)
      assert("YYROOOOOOOO\nYYOO\n".equals(result))
    }
  }

  test("Berlin Clock - representation of the time t3") {
    new TestTimes {
      val result = t3.clock
      println(result)
      assert("Y\nOOOO\nOOOO\nOOOOOOOOOOO\nOOOO\n".equals(result))
    }
  }

  test("Berlin Clock - representation of the time t4") {
    new TestTimes {
      val result = t4.clock
      println(result)
      assert("O\nRROO\nRRRO\nYYROOOOOOOO\nYYOO\n".equals(result))
    }
  }

  test("Berlin Clock - representation of the time t5") {
    new TestTimes {
      val result = t5.clock
      println(result)
      assert("O\nRRRR\nRRRO\nYYRYYRYYRYY\nYYYY\n".equals(result))
    }
  }

  /**
   * IMHO as the time 24:00:00 is equal to 00:00:00 I think it is correct, that this test fails.
   */
  test("Berlin Clock - representation of the time t6") {
    new TestTimes {
      val result = t6.clock
      println(result)
      assert("Y\nRRRR\nRRRR\nOOOOOOOOOOO\nOOOO\n".equals(result))
    }
  }
}
