package com.poc.springjwt.ctlr

import com.poc.springjwt.dto.CacheMsg
import com.poc.springjwt.svc.ErrorMsgService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/cache")
class MsgCtlr (val msgSvc: ErrorMsgService) {

    @PostMapping("refresh")
    fun refresh(): ResponseEntity<String> {
        msgSvc.refreshCache()
        return ResponseEntity.ok("cache refreshed")
    }

    @RequestMapping("")
    fun getMsg(@RequestParam("key") key: String): ResponseEntity<String>{
        val msg = msgSvc.getMsg(key)
        return ResponseEntity.ok(msg)
    }
}