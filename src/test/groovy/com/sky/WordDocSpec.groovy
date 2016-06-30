package com.sky

import org.apache.poi.xwpf.usermodel.XWPFDocument
import spock.lang.Specification

/**
 * Created by tm1c14 on 30/06/2016.
 */
class WordDocSpec extends Specification
{

    WordDoc wordDoc
    def setup() {
        wordDoc = new WordDoc()
    }
    void 'An empty document can be created'() {
        when:
            def result = wordDoc.createDocument('C:\\workspace_tm\\test.docx')
        then:
            result != null
            result instanceof XWPFDocument
    }
}
