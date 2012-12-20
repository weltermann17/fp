package com.ibm.fp.scala

object Monade extends App {

  /*
   *  What defines a Monad?
   *  1. A generic type constructor, e.g. Type[A]
   *  2. A function to create a new Monad for a one or more values, e.g. A -> Type[A]
   *  3. One or more methods for monad operations, e.g. Type[A].map(A => B)
   *  
   *  A very simple example would be:
   */

  val list = List(2, 3)
  println(list.map(_ * 3))

  /*
   * Another basic example
   */

  case class MiniMonade[A](wert: A) {
    def bind[B](f: A => MiniMonade[B]) = f(wert)
  }

  def plusEins(i: Int) = MiniMonade(i + 1)

  def alsString(a: Any) = MiniMonade(a.toString)

  val m1 = new MiniMonade(1)

  val m2 = m1 bind plusEins

  val m3 = m2 bind alsString

  println("m1 = " + m1);
  println("m2 = " + m2);
  println("m3 = " + m3);
  println("m2 == m3 ? " + (m2 == m3))

  val kette = m1 bind plusEins bind alsString

  println("Kette " + kette.wert)

  val a = Some("Hallo")

  /*
   * Usually you do don't need any knowledge about the theoretical Monad stuff,
   * although you are using it very often, e.g.
   */

  def eval(opt: Option[String]) = opt match {
    case Some(value) =>
      // Do something with the value
      value.toUpperCase()
    case None =>
      // Use the default value, do nothing or whatever you want
      "DEFAULT"
  }

  println(eval(Some("Parameter")))

  // Behind the scenes: Option is also an Monad ... 

  def monadEval(opt: Option[String]) {
    val newOpt = (opt map { _.trim } filter { _.length != 0 } map { _.toUpperCase })
    newOpt.getOrElse("DEFAULT");
  }
  
  println(monadEval(Some("OtherParameter")))
}