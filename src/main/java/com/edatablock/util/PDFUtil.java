package com.edatablock.util;

import net.sourceforge.tess4j.util.LoggHelper;
import net.sourceforge.tess4j.util.PdfUtilities;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final  class PDFUtil {

    private static final Logger logger = LoggerFactory.getLogger(new LoggHelper().toString());
    private static final String TEST_RESOURCES_DATA_PATH = "src/test/resources/test-data/";
    private static final String TEST_RESOURCES_RESULTS_PATH = "src/test/resources/test-results/";


    public PDFUtil() {
       //System.setProperty(PdfUtilities.PDF_LIBRARY, PdfUtilities.PDFBOX);    // Note: comment out to test Ghostscript
    }

    /**
     *  convertPdf2Tiff method, of class PdfUtilities.
     *
     * @throws Exception
     */

    public static File ConvertPdf2Tiff(File fileName) throws Exception {
        logger.info("convertPdf2Tiff");
        //File inputPdfFile = new File(TEST_RESOURCES_DATA_PATH, "eurotext.pdf");
        File result = PdfUtilities.convertPdf2Tiff(fileName);
        return result;

    }

    /**
     *   convertPdf2Png method, of class PdfUtilities.
     *
     * @throws IOException
     */

    public static File []  ConvertPdf2Png(File filename) throws IOException {
        logger.info("convertPdf2Png");

        File[] results = PdfUtilities.convertPdf2Png(filename);


        return results;
    }

    /**
     * Test of splitPdf method, of class PdfUtilities.
     */

    public void SplitPdf() {
        logger.info("splitPdf");
        File inputPdfFile = new File(String.format("%s/%s", TEST_RESOURCES_DATA_PATH, "multipage-pdf.pdf"));
        File outputPdfFile = new File(String.format("%s/%s", TEST_RESOURCES_RESULTS_PATH, "multipage-pdf_splitted.pdf"));
        int startPage = 2;
        int endPage = 3;
        int expResult = 2;
        PdfUtilities.splitPdf(inputPdfFile, outputPdfFile, startPage, endPage);
        int pageCount = PdfUtilities.getPdfPageCount(outputPdfFile);

    }

    /**
     * Test of getPdfPageCount method, of class PdfUtilities.
     */

    public void testGetPdfPageCount() {
        logger.info("getPdfPageCount");
        File inputPdfFile = new File(TEST_RESOURCES_DATA_PATH, "multipage-pdf.pdf");
        int expResult = 5;
        int result = PdfUtilities.getPdfPageCount(inputPdfFile);
        //assertEquals(expResult, result);
    }

    public static List<String> generateImageFromPDF(MultipartFile file, String extension) throws IOException {

        PDDocument document = PDDocument.load(file.getInputStream());
        PDFRenderer pdfRenderer = new PDFRenderer(document);
        List<String> imageFiles=new ArrayList<>();
        for (int page = 0; page < document.getNumberOfPages(); ++page) {
            BufferedImage bim = pdfRenderer.renderImageWithDPI(
                    page, 300, ImageType.RGB);
            String fileName =String.format("upload-dir/"+file.getOriginalFilename()+"-%d.%s", page + 1, extension);

            ImageIOUtil.writeImage(
                    bim, fileName, 300);
            imageFiles.add(fileName);
        }
        document.close();
        return imageFiles;
    }



}
