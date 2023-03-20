package com.poc.springjwt.repos

import com.poc.springjwt.ent.Employee
import org.springframework.data.jpa.repository.JpaRepository
interface EmployeeRepository: JpaRepository<Employee, Long>