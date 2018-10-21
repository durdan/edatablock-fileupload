package com.edatablock.util;

import net.sourceforge.tess4j.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class GetWordsWithZone {


    public static Map<String,ExtractOCRData> getWordWithZone(String fileName, HashMap<String, ExtractOCRData> wordZone) throws IOException {
        // File imageFile = new File("/Users/durdan/devel/projects/edatablock-ocr/src/main/resources/test-data/image-ravi.png");
        System.out.println("Inside the OCR File Name " + fileName);
        URL url = new URL(fileName);
       HashMap<String,ExtractOCRData> words = wordZone ;
        // Image imageFile = ImageIO.read(url);
        BufferedImage imageFile = ImageIO.read(url);
        ;


        // File imageFile=new File(fileName);
        /**
         * JNA Interface Mapping
         **/

        String TESS4J_FOLDER_PATH = "/usr/local/Cellar/tesseract/3.05.02/share/";

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


        System.out.println("OCR Begin............");
        Map<String,ExtractOCRData> extractData=new HashMap<>();

        wordZone.entrySet().forEach(entry -> {
            try {
                URL url1 = new URL(entry.getValue().getFileName());

                // Image imageFile = ImageIO.read(url);
                BufferedImage imageFile1 = ImageIO.read(url1);
                String value=instance.doOCR(imageFile1, entry.getValue().getLocation());

                System.out.println("Extract Data.....from "+entry.getValue().getFileName()+"..."+entry.getKey() + " => " + value);
                ExtractOCRData data= new ExtractOCRData();
                data.setKey(entry.getKey());
                data.setLocation(entry.getValue().getLocation());
                data.setValue(value);
                data.setFileName(entry.getValue().getFileName());
                extractData.put(entry.getKey(),data);

            } catch (TesseractException | IOException e) {
                e.printStackTrace();
            }
        });

        System.out.println("OCR Finished............");

//
//            Rectangle rect1 = new Rectangle(31, 205 , 88, 29);
//            Rectangle rect2 = new Rectangle(634, 205, 95, 32);
//            Rectangle rect3 = new Rectangle(29, 245, 253, 85);
//            Rectangle rect4 = new Rectangle(628, 249, 379, 179);


//            String result = instance.doOCR(imageFile,rect1);
//            String result2 = instance.doOCR(imageFile,rect2);
//            String result3 = instance.doOCR(imageFile,rect3);
//            String result4 = instance.doOCR(imageFile,rect4);
//
//            System.out.println("Zone based Result*****"+result);
//            System.out.println("Zone based Result*****"+result2);
//            System.out.println("Zone based Result*****"+result3);
//            System.out.println("Zone based Result*****"+result4);

        return extractData;
    }

}
