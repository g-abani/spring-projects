package com.poc.springjwt.ent

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import lombok.Data
import lombok.NoArgsConstructor
import org.jetbrains.annotations.NotNull

@Entity
@Data
@NoArgsConstructor
class Employee {
    @Id
    @GeneratedValue
    var id: Long? = null
    @NotNull
    var name: String = "";
    @NotNull
    var pin: String = "";
    @NotNull
    var email: String = "";
    @NotNull
    var role: String = "";
}
