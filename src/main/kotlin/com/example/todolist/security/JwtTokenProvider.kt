package com.example.todolist.security

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt
import org.springframework.stereotype.Component
import java.util.Date

@Component
class JwtTokenProvider {

    private val secretKey = "123456789"

    fun createToken(userName:String):String{
        val claims = Jwts.claims().setSubject(userName)
        val now = Date()
        val validity = Date(now.time+3600000)

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256,secretKey)
                .compact()

    }

    fun validateToken(token:String):Boolean{
        return try {
            val claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token)
            !claims.body.expiration.before(Date())
        }catch (e:Exception){
            false
        }

    }
}