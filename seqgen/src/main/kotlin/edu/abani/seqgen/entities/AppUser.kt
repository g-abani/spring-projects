package edu.abani.seqgen.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.IdClass
import jakarta.persistence.Table
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Parameter
import java.io.Serializable

@Entity
@Table(name = "appuser", schema = "pms")
@IdClass(UserComposite::class)
data class AppUser(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0L,
    var name: String = "",
    var email: String = "",
    var phone: String = "",
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SID-SEQ")
    @GenericGenerator(
        name ="SID-SEQ",
        strategy = "edu.abani.seqgen.generator.DBSequenceGenerator",
        parameters = [
            Parameter(name = "tableName", value = "appuser"),
            Parameter(name = "columnName", value = "id"),
            Parameter(name = "valuePrefix", value = "U"),
            Parameter(name = "numberFormat", value = "%05d")
        ]
    )
    @Column(name = "bcode", length = 25)
    var code: String = ""

): Serializable