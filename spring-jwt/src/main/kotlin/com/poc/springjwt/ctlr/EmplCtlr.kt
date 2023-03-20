package com.poc.springjwt.ctlr

import com.poc.springjwt.ent.Employee
import com.poc.springjwt.svc.EmployeeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/emp")
class EmplCtlr(val empService: EmployeeService) {
    @GetMapping("all")
    fun getAll(): List<Employee> = this.empService.listAll();

    @PostMapping
    fun save(employee: Employee): Employee = this.empService.save(employee)

    @GetMapping("{id}")
    fun findById(@PathVariable("id") id: Long): Employee = this.empService.getById(id)
}