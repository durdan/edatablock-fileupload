package com.edatablock;

import com.sun.jna.Pointer;
import net.sourceforge.tess4j.*;
import net.sourceforge.tess4j.util.ImageHelper;
import net.sourceforge.tess4j.util.ImageIOHelper;
import net.sourceforge.tess4j.util.LoggHelper;
import net.sourceforge.tess4j.util.PdfUtilities;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;

import static net.sourceforge.tess4j.ITessAPI.TRUE;

public class GetWordsWithZone {


    public static void getWordWithZone(String fileName, ArrayList<Rectangle> wordZone){
       File imageFile = new File("/Users/durdan/devel/projects/edatablock-ocr/src/main/resources/test-data/image-ravi.png");
        System.out.println("Inside the OCR File Name "+fileName);
      // File imageFile=new File(fileName);
        /**
         * JNA Interface Mapping
         **/

        String TESS4J_FOLDER_PATH="/usr/local/Cellar/tesseract/3.05.02/share/";

        ITesseract instance = new Tesseract();
        ///



        ////////




        /**
         * You either set your own tessdata folder with your custom language pack or
         * use LoadLibs to load the default tessdata folder for you.
         **/
        instance.setDatapath(TESS4J_FOLDER_PATH);
        //In case you don't have your own tessdata, let it also be extracted for you
        //File tessDataFolder = LoadLibs.extractTessResources(TESS4J_FOLDER_PATH);

        //Set the tessdata path
        //instance.setDatapath(tessDataFolder.getAbsolutePath());
        instance.setLanguage("eng");

        // instance.setDatapath(LoadLibs.extractTessResources("tessdata").getParent());
//        instance.//

        try {
            //System.out.println(tessDataFolder.getAbsolutePath());
//            Rectangle rect = new Rectangle(1315, 0, 895, 74);
//            Rectangle rect1 = new Rectangle(136, 154, 491, 274);
//            Rectangle rect2 = new Rectangle(143, 620, 894, 540);
            //Rectangle rect3 = new Rectangle(1321, 16, (2263-1321), 55-16)

            for(Rectangle rectangle:wordZone){
                System.out.println("Inside the OCR");
                System.out.println( instance.doOCR(imageFile,rectangle));
        }

        Rectangle rect1 = new Rectangle(31, 205 , 88, 29);
            Rectangle rect2 = new Rectangle(634, 205, 95, 32);
            Rectangle rect3 = new Rectangle(29, 245, 253, 85);
            Rectangle rect4 = new Rectangle(628, 249, 379, 179);



            String result = instance.doOCR(imageFile,rect1);
            String result2 = instance.doOCR(imageFile,rect2);
            String result3 = instance.doOCR(imageFile,rect3);
            String result4 = instance.doOCR(imageFile,rect4);

            System.out.println("Zone based Result*****"+result);
            System.out.println("Zone based Result*****"+result2);
            System.out.println("Zone based Result*****"+result3);
            System.out.println("Zone based Result*****"+result4);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }

}
