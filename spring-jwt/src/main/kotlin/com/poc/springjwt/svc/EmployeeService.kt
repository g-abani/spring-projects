package com.poc.springjwt.svc

import com.poc.springjwt.ent.Employee
import com.poc.springjwt.repos.EmployeeRepository
import org.springframework.stereotype.Component

@Component
class EmployeeService(val empRepo: EmployeeRepository) {
    fun save(employee: Employee): Employee = empRepo.save(employee)
    fun listAll(): List<Employee> = empRepo.findAll()
    fun getById(id: Long): Employee = empRepo.findById(id).get()
}