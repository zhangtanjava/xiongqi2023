package com.example.xiongqi2023.pdf;

import com.example.xiongqi2023.excutor.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SpringBoot线程池的使用
 * 链接：http://events.jianshu.io/p/5bdfda863e43
 */
@RestController
@RequestMapping("/excutor")
@Slf4j
public class PdfController {

    @Autowired
    private PdfService pdfService;

    @GetMapping("/pdf2Word")
    public void pdf2Word(){
        pdfService.pdf2Word("/Users/zhangtan/Downloads/SSLVPN安装程序+使用手册/SSLVPN PC端用户使用手册.pdf","ToWord.docx");
    }

}