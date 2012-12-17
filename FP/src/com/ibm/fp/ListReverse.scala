package com.ibm.fp

object ListReverse extends App {

  val a = "A" :: "B" :: "C" :: Nil
  val b = List("A", "B", "C")

  println(a == b)

  def reverse[A](list: List[A]): List[A] = list match {
    case head :: tail => reverse(tail) :+ head
    case _ => Nil
  }

  println("a reverse : " + reverse(a))
  println("b reverse : " + reverse(b))
  println("empty list reverse : " + reverse(Nil))

  println(reverse(a) == reverse(b))

}