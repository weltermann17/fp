package com.ibm.fp.scala

object PatternMatching extends App {

  sealed trait Expression

  sealed trait UnaryExpression extends Expression { val unary: Expression }

  sealed trait BinaryExpression extends Expression { val left: Expression; val right: Expression }

  case class Not(unary: Expression) extends UnaryExpression

  case class And(left: Expression, right: Expression) extends BinaryExpression

  case class Or(left: Expression, right: Expression) extends BinaryExpression

  case object True extends Expression

  case object False extends Expression

  def eval(e: Expression): Boolean = e match {
    case And(l, r) => eval(l) && eval(r)
    case Or(l, r) => eval(l) || eval(r)
    case Not(u) => !eval(u)
    case True => true
    case False => false
  }

  val a = Not(And(True, Not(Or(False, True))))

  println("a =" + a)
  println("eval(a) = " + eval(a))

}