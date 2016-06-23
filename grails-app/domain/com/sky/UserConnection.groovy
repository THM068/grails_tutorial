package com.sky

import groovy.transform.EqualsAndHashCode

//@EqualsAndHashCode(includes = ['userId','providerId','providerUserId'])
class Userconnection implements Serializable{

    String userId
    String providerId
    String providerUserId
    Integer rank
    String displayName
    String profileUrl
    String imageUrl
    String accessToken
    String secret
    String refreshToken
    BigInteger expireTime

    static constraints = {
        displayName(nullable: true)
        profileUrl(nullable: true)
        imageUrl(nullable: true)
    }

    static mapping = {
        table 'userconnection'
        id composite: ['userId', 'providerId', 'providerUserId']
        userId(column: 'userId')
        providerId(column: 'providerId')
        providerUserId(column: 'providerUserId')
        rank(column: 'rank')
        displayName(column: 'displayName')
        profileUrl(column: 'profileUrl')
        imageUrl(column: 'imageUrl')
        accessToken(column: 'accessToken')
        secret(column: 'secret')
        refreshToken(column: 'refreshToken')
        expireTime(column: 'expireTime')
    }
}