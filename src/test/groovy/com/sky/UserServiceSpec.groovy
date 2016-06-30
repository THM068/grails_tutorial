package com.sky

import grails.test.mixin.TestFor
import org.junit.Rule
import org.mockserver.client.server.MockServerClient
import org.mockserver.junit.MockServerRule
import org.mockserver.model.HttpRequest
import org.mockserver.model.HttpResponse
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(UserService)
class UserServiceSpec extends Specification {
    def userService

    @Rule
    public MockServerRule mockServerRule = new MockServerRule(this, 9000)
    private MockServerClient mockServerClient

    def setup() {
        RestTemplate restTemplate = new RestTemplate()
        userService = new UserService()
        userService.restTemplate = restTemplate
        grailsApplication.config.user.base.url = 'http://jsonplaceholder.typicode.com'
        userService.grailsApplication = grailsApplication
    }

    def cleanup() {
    }

    void "Get users returms a list of Users"() {
        given:
            mockServerClient.when(
                    HttpRequest.request().
                    withMethod("GET")
                    .withPath('/users')
            )
            .respond(
                    HttpResponse.response()
                    .withStatusCode(200)
                    .withBody(getUserListJson())
            )
        when:
            List<User> result = userService.getUsers()
        then:
            result != null
            result.size() == 10
            User user = result.first()
        user.id ==1
        user.name == "Leanne Graham"
        user.username == "Bret"
        user.email == "Sincere@april.biz"
    }

    void 'A todo can be posted'() {

    }


    private String getUserListJson() {
        String result = UserServiceSpec.class.getClassLoader().getResource('com/sky/userList.json').text
        return result
    }
}
