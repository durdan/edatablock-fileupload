package com.edatablock.imageutil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Pdf2ImageTest {

    @Test
    public void shouldCreateFile() throws Exception {
       // File file = new ClassPathResource("input/50564326 INVAFI.PDF").getFile();

        Pdf2Image.PdfToImage("input/50564326 INVAFI.PDF");

    }

}
