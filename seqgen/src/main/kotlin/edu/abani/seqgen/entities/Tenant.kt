package edu.abani.seqgen.entities

import edu.abani.seqgen.annotation.BCode
import edu.abani.seqgen.listener.TenantListener
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EntityListeners
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.io.Serializable

@Entity
@Table(name = "tenant", schema = "pms")
@EntityListeners(TenantListener::class)
data class Tenant(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0L,
    /*@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SID-SEQ")
    @GenericGenerator(
        name ="SID-SEQ",
        strategy = "edu.abani.seqgen.generator.DBSequenceGenerator",
        parameters = [
            Parameter(name = "tableName", value = "tenant"),
            Parameter(name = "columnName", value = "id"),
            Parameter(name = "valuePrefix", value = "T"),
            Parameter(name = "numberFormat", value = "%05d")
        ]
    )*/
    @Column(name = "bcode", length = 25)
    @BCode(table = "tenant", column = "id")
    var code: String = "",
    var name: String = "",
    var city: String = ""

): Serializable
