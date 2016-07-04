package com.sky

import org.apache.poi.xwpf.usermodel.XWPFDocument
import org.apache.poi.xwpf.usermodel.XWPFParagraph
import org.apache.poi.xwpf.usermodel.XWPFRun
import org.apache.poi.xwpf.usermodel.XWPFTable
import org.apache.poi.xwpf.usermodel.XWPFTableCell
import org.apache.poi.xwpf.usermodel.XWPFTableRow

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
        run.addBreak()

        XWPFTable table = document.createTable(2,2)

        //table.getCTTbl().getTblPr().unsetTblBorders()
        table.getCTTbl().addNewTblGrid().addNewGridCol().setW(BigInteger.valueOf(12000));
        table.getCTTbl().getTblGrid().addNewGridCol().setW(BigInteger.valueOf(12000));

        XWPFTableRow tableRowOne = table.getRow(0);
        //tableRowOne.getCtRow().addNewTrPr().addNewTrHeight().setVal(1)
        //tableRowOne.setHeight((int)(1440 * 0.05))
        XWPFTableCell cell = tableRowOne.getCell(0);
        XWPFParagraph ansParagraph = cell.getParagraphs().get(0);
        ansParagraph.setSpacingBeforeLines(0)
        cell.addParagraph(ansParagraph);
        tableRowOne.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(8000));
        tableRowOne.getCell(0).setText("one");
        tableRowOne.getCell(1).setText("two");


        XWPFTableRow tableRowTwo = table.createRow();
        //tableRowTwo.setHeight((int)(1440 * 0.05)) //getCtRow().addNewTrPr().addNewTrHeight().setVal(1)
        XWPFTableCell cell1 = tableRowTwo.getCell(0);
        XWPFParagraph ansParagraph1 = cell1.getParagraphs().get(0);
        cell1.addParagraph(ansParagraph1);
        ansParagraph1.setSpacingBeforeLines(0)
        tableRowTwo.getCell(0).setText("four");
        tableRowTwo.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(8000));
        tableRowTwo.getCell(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(8000));
        tableRowTwo.getCell(1).setText("five");

        XWPFTableCell colspanCell = createCellThatSpansRow(table, 0, 2)
        colspanCell.setText("I span two columns")


       // WPFTable filingTable = document.createTable()
    }

    private XWPFTableCell  createCellThatSpansRow(XWPFTable table, int colNum, int span) {
        XWPFTableRow row = table.createRow()
        XWPFTableCell colspanCell = row.getCell(0)
        if (colspanCell.getCTTc().getTcPr() == null){
            colspanCell.getCTTc().addNewTcPr();
        }
        colspanCell.getCTTc().getTcPr().addNewGridSpan()
        colspanCell.getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf(span));
        return colspanCell
    }

    private XWPFTableCell createCellThatSpansRowFromExistingRow(XWPFTable table, int rowNum, int colNum, int span){
        XWPFTableCell  colspanCell = table.getRow(rowNum).getCell(colNum);

        if (colspanCell.getCTTc().getTcPr() == null){
            colspanCell.getCTTc().addNewTcPr();
        }
        colspanCell.getCTTc().getTcPr().addNewGridSpan()
        colspanCell.getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf(span));
        return colspanCell
    }
    public void clearDocument() {
        this.document = new XWPFDocument()
    }
}
