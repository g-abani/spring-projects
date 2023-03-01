package edu.abani.bcode.entities;

import edu.abani.bcode.annot.BCode;
import edu.abani.bcode.listener.TenantListener;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(schema = "pms")
@EntityListeners(TenantListener.class)
@BCode(table = "owner", prefix = "O")
public class Owner extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0l;
    private String city;
    private String name;

}
