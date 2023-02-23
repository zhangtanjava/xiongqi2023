package com.example.xiongqi2023.pdf;

import com.aspose.pdf.Document;
import com.aspose.pdf.SaveFormat;

import java.io.FileOutputStream;
import java.io.IOException;

public class Pdf2Word {
    public static void main(String[] args) throws IOException {
        pdf2doc("/Users/zhangtan/Downloads/运河湾南区租房业主信息/自如租房合同.pdf");
    }

    //pdf转doc
    public static void pdf2doc(String pdfPath) {
        long old = System.currentTimeMillis();
        try {
            //新建一个word文档
            String wordPath=pdfPath.substring(0,pdfPath.lastIndexOf("."))+".docx";
            FileOutputStream os = new FileOutputStream(wordPath);
            //doc是将要被转化的word文档
            Document doc = new Document(pdfPath);
            //全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF 相互转换
            doc.save(os, SaveFormat.DocX);
            os.close();
            //转化用时
            long now = System.currentTimeMillis();
            System.out.println("Pdf 转 Word 共耗时：" + ((now - old) / 1000.0) + "秒");
        } catch (Exception e) {
            System.out.println("Pdf 转 Word 失败...");
            e.printStackTrace();
        }
    }
}

