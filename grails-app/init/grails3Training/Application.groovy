package grails3Training

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.context.annotation.ComponentScan

@ComponentScan(['com.sky'])
@EnableDiscoveryClient
class Application extends GrailsAutoConfiguration {
    static void main(String[] args) {
      System.setProperty("spring.config.name", "accounts-server")
        GrailsApp.run(Application, args)
    }
}