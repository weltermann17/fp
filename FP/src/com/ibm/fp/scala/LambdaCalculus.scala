package com.ibm.fp.scala

object LambdaCalculus extends App {

  def print(a: Any) = { println(a); Thread.sleep(500) }

  def λ(b: => Unit) = new Thread(new Runnable { def run = b }).start

  λ((1 to 100).foreach(print))

  λ('A' to 'Z' foreach print)

}