package edu.abani.seqgen.entities

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
@Table
@IdClass(AppUser::class)
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
        strategy = "edu.abani.seqgen.generator.StringSequenceGenerator",
        parameters = [
            Parameter(name = "increment_size", value = "5"),
            Parameter(name = "valuePrefix", value = "U_"),
            Parameter(name = "numberFormat", value = "%05d")
        ]
    )
    var bid: String = ""

): Serializable