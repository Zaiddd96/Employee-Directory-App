package com.example.androidassignment1.data

import com.example.androidassignment1.model.Employee
import com.example.androidassignment1.model.Employees
import retrofit2.http.GET

interface ApiInterface {
    @GET("EmployeeDetails.json")
    suspend fun getDetails(): Employees
}