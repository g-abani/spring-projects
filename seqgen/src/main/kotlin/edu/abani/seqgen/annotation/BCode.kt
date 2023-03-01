package edu.abani.seqgen.annotation

import java.lang.annotation.ElementType
import java.lang.annotation.RetentionPolicy

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class BCode(val table: String = "user_detail",
                       val column: String = "id")
