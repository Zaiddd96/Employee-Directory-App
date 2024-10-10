package com.example.androidassignment1.model

data class Employee(
    val age: Int,
    val name: String = "Name",
    val salary: Int
)

data class Employees(
    val employees: List<Employee>
)