package com.sky

import grails.rest.Resource

/**
 * Created by tm1c14 on 30/06/2016.
 */
@Resource(uri = '/person', formats = ['json', 'xml'] )
class Person {
    String name
    String surname

    static constraints = {

    }
}
