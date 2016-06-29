package com.sky

import grails.converters.JSON
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by tm1c14 on 27/06/2016.
 */

class PersonController {


    public List<String> list() {
        def names = ['Thando', 'Mafela', 'Mlauzi']
        render names as JSON
    }
}
