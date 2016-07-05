package com.sky

import spock.lang.Specification

/**
 * Created by tm1c14 on 05/07/2016.
 */
class UtilitySpec extends Specification {

    def 'create strings with different content but same string length'() {
        expect:
            Utility.createStringOf(targetLength, firstString).length() == targetLength
            Utility.createStringOf(targetLength, secondString).length() == targetLength

        where:
           firstString =  'First Name:'
           secondString = 'Date of Employment:'
           targetLength = 40
    }

}
