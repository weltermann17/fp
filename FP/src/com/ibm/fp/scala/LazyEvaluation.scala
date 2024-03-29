package com.ibm.fp.scala

import language.implicitConversions

object LazyEvaluation extends App {

  def trivial = {

    val max = 5

    lazy val x = {
      println("We do not like side effects, but produce them all the time.")
      (1 to max).foldLeft(0) { case (l, e) => l + e }
    }

    println("start computing, x is not yet evaluated")
    println("x (1) = " + x)
    println("x (2) = " + x)

    println(x == ((max * (max + 1)) / 2))

  }

  val fibs: Stream[BigInt] = BigInt(0) #:: BigInt(1) #:: fibs.zip(fibs.tail).map(n => n._1 + n._2)

  def fibunacci = {

    def fibunacci(n: Int) = fibs.take(n).foreach(println)

    fibs.take(10).foreach(println)

    println("lazy evaluated : " + fibs.take(100))
    println("forced : " + fibs.take(100).force)
    println("just the result : " + fibs.take(100).force.last)

  }

  trivial

  fibunacci

}