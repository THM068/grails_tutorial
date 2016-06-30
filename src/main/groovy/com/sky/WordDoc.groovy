package com.sky

import org.apache.poi.xwpf.usermodel.XWPFDocument
import org.apache.poi.xwpf.usermodel.XWPFParagraph
import org.apache.poi.xwpf.usermodel.XWPFRun

/**
 * Created by tm1c14 on 30/06/2016.
 */
class WordDoc {

    XWPFDocument document

    public WordDoc() {
        this.document = new XWPFDocument();
    }

    public XWPFDocument createDocument(String filename) {
        clearDocument()
        File f = new File(filename)
        if(f.createNewFile()) {
            FileOutputStream out = new FileOutputStream(f)
            createParagraphFor(document,'It will compile and execute to generate a Word file named createparagraph.docx in your current directory' )
            this.document.write(out)
            out.close()
            println('Document created')
        }
        println('Document created---->')
        return document
    }

    public void createParagraphFor(XWPFDocument document, String text){
        XWPFParagraph paragraph = document.createParagraph()
        XWPFRun run  = paragraph.createRun()
        run.setText(text)
    }
    public void clearDocument() {
        this.document = new XWPFDocument()
    }
}
