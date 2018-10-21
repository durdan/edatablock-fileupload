package com.edatablock.imageutil;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.awt.image.BufferedImage;
import java.io.File;

public class Pdf2Image {

    private static final Logger logger = LoggerFactory.getLogger(Pdf2Image.class);

    public static void PdfToImage(String PDFFILE) {
        try {
            File file = new ClassPathResource(PDFFILE).getFile();
            logger.info(file.getAbsolutePath());
            PDDocument document = PDDocument.load(file);
            PDPage pd;

            PDFRenderer pdfRenderer = new PDFRenderer(document);
            File directory = new File("output");
            if (! directory.exists()){
                directory.mkdir();
                // If you require it to make the entire directory path including parents,
                // use directory.mkdirs(); here instead.
            }
            for (int page = 0; page < document.getNumberOfPages(); ++page) {


                pd = document.getPage(page);
                //pd.setCropBox(new PDRectangle(100, 100,100,100));
                BufferedImage bim = pdfRenderer.renderImageWithDPI(page, 300, ImageType.RGB);
               // ImageIOUtil.writeImage(bim, "/Users/durdan/devel/projects/edatablock-ocr/target/" + "test" + ".png", 300);
                ImageIOUtil.writeImage(bim, directory+"/"+ file.getName() + ".png", 300);
                logger.info("File name is created ", (page + 1) + ".png");
            }
            document.close();
        } catch (Exception ex) {
            logger.info("Exception", ex);
        }
    }
}
