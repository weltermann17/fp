package com.ibm.fp.scala

object ParallelComputing extends App {

  val max = 10000000

  val runs = 10

  type S = collection.GenSeq[Int]

  def measure(body: => Unit) = { val b = System.nanoTime; body; (System.nanoTime - b) / 1000000000.0 }

  def stress(l: S) = {
    l.foldLeft(0) { case (l, e) => l + e }
    l.map(_ + 42)
    l.foldLeft(0) { case (l, e) => l + e }
  }

  def benchmark(l: S) = {
    var c = 0.0
    for (i <- 1 to runs) { println(i); c += measure(stress(l)) }
    c / runs
  }

  val linear = (1 to max).toList
  val parallel = (1 to max).toList.par

  println("linear average : " + benchmark(linear) + " sec")
  println("parallel average : " + benchmark(parallel) + " sec")

}
