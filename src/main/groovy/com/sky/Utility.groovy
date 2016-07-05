package com.sky
import org.apache.commons.lang.StringUtils
/**
 * Created by tm1c14 on 05/07/2016.
 */
class Utility {

    public static String createStringOf(int targetLength, String content) throws IllegalArgumentException{
        if(!content) {
            throw new IllegalArgumentException('The entered string can not be null or empty')
        }

        if(targetLength < content.length()) {
            throw new IllegalArgumentException('The desired lenth should be greater than content length')
        }

        char [] array = new char[targetLength]
        char [] contentArray = content.toCharArray()
        for(int x=0; x <  content.length(); x++ ) {
            array[x] = contentArray[x]
        }
        for(int x=content.length()-1; x < array.length; x++ ) {
            String c = ' '
            array[x] = c.toCharArray()[0]
        }
        String result = new String(array);
        println "'${result}'"
        return result
    }
}
