package edu.abani.seqgen

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SeqgenApplication

fun main(args: Array<String>) {
	runApplication<SeqgenApplication>(*args)
}
