package com.ibm.fp.scala

object HigherOrderFunctions extends App {

  def currency(rate: Double, in: Double) = (math rint (in * rate * 100)) / 100

  val c = currency _ curried

  val euro2dollar = c(1 / 0.75954)

  val euro2pound = c(1 / 1.22856)

  val dollar2euro = c(0.75954)

  val pound2euro = c(1.22856)

  val pound2dollar = pound2euro compose euro2dollar

  val dollar2pound = dollar2euro compose euro2pound

  println("1.00 € -> " + euro2dollar(1.00) + " $")
  println("1.00 € -> " + euro2pound(1.00) + " £")
  println(dollar2euro(euro2dollar(1.00)) == 1)
  println(pound2euro(euro2pound(1.00)) == 1)

  println("1.00 £ -> " + pound2dollar(1.00) + " $")
  println("1.00 $ -> " + dollar2pound(1.00) + " £")

}