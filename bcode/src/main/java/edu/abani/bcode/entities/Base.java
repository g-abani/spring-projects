package edu.abani.bcode.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public class Base {
    @Column(name = "bcode", length = 25)
    private String code;
}
