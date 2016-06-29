package com.sky

import grails.transaction.Transactional
import org.springframework.web.client.RestTemplate

@Transactional
class UserService {

    RestTemplate restTemplate
    def grailsApplication

    public List<User> getUsers() {
        String url = grailsApplication.config.user.base.url + '/users'
        User[] userArray = restTemplate.getForObject(url, User[].class)
        List<User> userList = []

        if(userArray?.length > 0) {
            userList = Arrays.asList(userArray)
        }

        return userList

    }
}
