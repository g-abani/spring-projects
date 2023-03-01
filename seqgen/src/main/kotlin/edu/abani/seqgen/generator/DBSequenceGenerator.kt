package edu.abani.seqgen.generator

import org.hibernate.engine.spi.SharedSessionContractImplementor
import org.hibernate.id.IdentifierGenerator
import org.hibernate.service.ServiceRegistry
import org.hibernate.type.Type
import java.io.Serializable
import java.util.*

class DBSequenceGenerator: IdentifierGenerator {

    var tableName = ""
    var columnName = ""
    var numberFormat = ""
    var prefix = ""
    override fun generate(session: SharedSessionContractImplementor?, `object`: Any?): Serializable {
        val connection = session?.connection()
        val statement = connection?.createStatement()
        val resultSet = statement?.executeQuery("SELECT MAX($columnName) FROM $tableName")
        val max = resultSet?.takeIf { it.next() }?.getInt(1)?.plus(1)
        return prefix + numberFormat.format(max)
    }

    override fun configure(type: Type?, params: Properties?, serviceRegistry: ServiceRegistry?) {
        super.configure(type, params, serviceRegistry)
        tableName = params?.getProperty("tableName", "appuser").toString()
        columnName = params?.getProperty("columnName","id").toString()
        numberFormat = params?.getProperty("numberFormat", "%05d").toString()
        prefix = params?.getProperty("valuePrefix","SY").toString()
    }
}