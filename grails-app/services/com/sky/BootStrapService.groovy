package com.sky

import grails.transaction.Transactional

import javax.servlet.ServletContext

@Transactional
class BootStrapService {

    public void init(ServletContext servletContext) {
        def adminRole = Role.findByAuthority('ROLE_ADMIN')?: new Role(authority: 'ROLE_ADMIN').save(flush:true)
        def user = User.findByUsername("admin")

        if(!user) {
            user = new User()
            user.username = "admin"
            user.password = "mzingwane"
            user.validate()
            user.save()
        }

        Set<Role> authorities = getAuthorities(user)
        if(!authorities.contains(adminRole)) {
            UserRole.create(user, adminRole)
        }
    }

    private Set<Role> getAuthorities(User user) {
        UserRole.findAllByUser(user).collect{ it.role} as Set<Role>
    }
}
