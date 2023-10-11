package com.example.xiongqi2023.pdf;

import com.spire.pdf.FileFormat;
import com.spire.pdf.PdfDocument;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 只能转10页
 */
@Service
@Slf4j
public class PdfServiceImpl implements PdfService {

    @Override
    public void pdf2Word(String pdfPath, String wordName) {
        long old = System.currentTimeMillis();
        try {
            PdfDocument pdf = new PdfDocument();
            //Load a PDF file
            pdf.loadFromFile(pdfPath);
            //Save to .docx file
            pdf.saveToFile(wordName, FileFormat.DOCX);
            //转化用时
            long now = System.currentTimeMillis();
            System.out.println("Pdf 转 Word 共耗时：" + ((now - old) / 1000.0) + "秒");
        } catch (Exception e) {
            System.out.println("Pdf 转 Word 失败...");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        long old = System.currentTimeMillis();
        try {
            PdfDocument pdf = new PdfDocument();
            //Load a PDF file
            pdf.loadFromFile("/Users/zhangtan/Downloads/支付交接/新爱体育直播接口.pdf");
            //Save to .docx file
            pdf.saveToFile("ToExcel.docx", FileFormat.DOCX);
            //转化用时
            long now = System.currentTimeMillis();
            System.out.println("Pdf 转 Word 共耗时：" + ((now - old) / 1000.0) + "秒");
        } catch (Exception e) {
            System.out.println("Pdf 转 Word 失败...");
            e.printStackTrace();
        }
    }
}
