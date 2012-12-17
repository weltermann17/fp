package com.ibm.fp.scala

object DeclarativeLanguage extends App {

  case class Employee(firstname: String, lastname: String, department: String, salary: Int, ismanager: Boolean)

  val table = List(
    Employee("Joe", "Smith", "Sales", 50000, false),
    Employee("Suzanne", "Harrison", "Sales", 40000, false),
    Employee("Mary", "Jones", "Sales", 100000, true),
    Employee("Ben", "Simpson", "Accounting", 90000, true),
    Employee("Paul", "Miller", "Accounting", 25000, false))

  println(table)

  val managers = table.filter(_.ismanager)
  val highestsalaryofallmanagers = table.filter(_.ismanager).map(_.salary).sorted.last
  val firstnameofbestpaidmanager = table.filter(_.ismanager).sortBy(_.salary).last.firstname
  val employeesperdepartment = table.groupBy(_.department).map { case (k, v) => (k, v.size) }

  println(managers)
  println(highestsalaryofallmanagers)
  println(firstnameofbestpaidmanager)
  println(employeesperdepartment)

}