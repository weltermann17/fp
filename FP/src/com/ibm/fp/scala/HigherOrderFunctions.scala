package com.ibm.fp.scala

object HigherOrderFunctions extends App {

  def currency(rate: Double, in: Double) = (math rint (in * rate * 100)) / 100

  def c = currency _ curried

  def euro2dollar = c(1 / 0.75954)

  def euro2pound = c(1 / 1.22856)

  def dollar2euro = c(0.75954)

  def pound2euro = c(1.22856)

  def pound2dollar = pound2euro compose euro2dollar

  def dollar2pound = dollar2euro compose euro2pound

  println("1.00 € -> " + euro2dollar(1.00) + " $")
  println("1.00 € -> " + euro2pound(1.00) + " £")
  println(dollar2euro(euro2dollar(1.00)) == 1)
  println(pound2euro(euro2pound(1.00)) == 1)

  println("1.00 £ -> " + pound2dollar(1.00) + " $")
  println("1.00 $ -> " + dollar2pound(1.00) + " £")

}