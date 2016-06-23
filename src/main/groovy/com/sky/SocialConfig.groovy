package com.sky

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.encrypt.Encryptors
import org.springframework.social.UserIdSource
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer
import org.springframework.social.config.annotation.EnableSocial
import org.springframework.social.config.annotation.SocialConfigurer
import org.springframework.social.connect.ConnectionFactoryLocator
import org.springframework.social.connect.ConnectionRepository
import org.springframework.social.connect.UsersConnectionRepository
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository
import org.springframework.social.connect.web.ConnectController
import org.springframework.social.twitter.connect.TwitterConnectionFactory

import javax.inject.Inject
import javax.sql.DataSource

/**
 * Created by tm1c14 on 23/06/2016.
 */
@Configuration
@EnableSocial
class SocialConfig implements SocialConfigurer{

    @Value('${twitter.consumerKey}')
    private String key;
    @Value('${twitter.consumerSecret}')
    private  String secret;

    @Inject
    private DataSource dataSource;

    @Override
    void addConnectionFactories(ConnectionFactoryConfigurer cfConfig, Environment environment) {
        cfConfig.addConnectionFactory(new TwitterConnectionFactory(key,secret));
    }

    @Override
    UserIdSource getUserIdSource() {
        return new UserIdSource() {
            @Override
            String getUserId() {
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication()
                if (authentication == null) {
                    throw new IllegalStateException("Unable to get a ConnectionRepository: no user signed in");
                }
                return authentication.getName();
            }
        }
    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        return new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, Encryptors.noOpText());
    }

    @Bean
    public ConnectController connectController(
            ConnectionFactoryLocator connectionFactoryLocator,
            ConnectionRepository connectionRepository) {
        return new ConnectController(connectionFactoryLocator, connectionRepository);
    }
}
