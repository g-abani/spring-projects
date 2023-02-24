package com.poc.springjwt.svc

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.poc.springjwt.dto.CacheMsg
import com.poc.springjwt.dto.Messages
import jakarta.annotation.PostConstruct
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component
import java.net.URL

@Component
class ErrorMsgService(val redisTemplate: RedisTemplate<String, Map<String, String>>) {

    private val cacheKey = "DEMO"

    private val LOGGER: Logger = LoggerFactory.getLogger(ErrorMsgService::class.java)

    fun getMsg(key: String): String? =
        redisTemplate.opsForHash<String, Map<String, String>>()
            .get(cacheKey, cacheKey)
            ?.getOrDefault(key,"No error message found")

    fun refreshCache() = prepareCache()

    @PostConstruct
    fun init() {
        LOGGER.info("ErrorMsgService initialising")
        prepareCache()
    }

    private fun prepareCache(){
        val response = jacksonObjectMapper()
            .readValue<Messages>( URL("http://demo4806758.mockable.io/api/messages") )

        val errorMap = response.messages.associate { it.key to it.value }
        LOGGER.info("errorMap {} ",  errorMap)
        redisTemplate.opsForHash<String, Map<String, String>>()
            .put( cacheKey, cacheKey, errorMap )
    }

}