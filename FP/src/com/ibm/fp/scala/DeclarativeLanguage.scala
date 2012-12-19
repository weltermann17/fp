package com.ibm.fp.scala

object DeclarativeLanguage extends App {

  final case class Employee(firstname: String, lastname: String, department: String, salary: Int, ismanager: Boolean)

  val employees = List(
    Employee("Joe", "Smith", "Sales", 50000, false),
    Employee("Suzanne", "Harrison", "Sales", 40000, false),
    Employee("Mary", "Jones", "Sales", 100000, true),
    Employee("Ben", "Simpson", "Accounting", 90000, true),
    Employee("Paul", "Miller", "Accounting", 25000, false))

  println(employees); println

  val managers = employees.filter(_.ismanager)
  val highestsalaryofallmanagers = employees.filter(_.ismanager).map(_.salary).sorted.last
  val firstnameofbestpaidmanager = employees.filter(_.ismanager).sortBy(_.salary).last.firstname
  val employeesperdepartment = employees.groupBy(_.department).map { case (k, v) => (k, v.size) }

  println(managers)
  println(highestsalaryofallmanagers)
  println(firstnameofbestpaidmanager)
  println(employeesperdepartment)

}
