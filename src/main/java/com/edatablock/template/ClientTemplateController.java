package com.edatablock.template;

import com.edatablock.fileupload.StorageService;
import com.edatablock.util.ExtractOCRData;
import com.edatablock.util.GetWordsWithZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ClientTemplateController {

    private  List<TemplateFields> fieldLocation = new ArrayList<TemplateFields>();
    private HashMap<String, ExtractOCRData> wordZoneWithKey=new HashMap<String,ExtractOCRData>();

    @Autowired
    StorageService storageService;

//    static {
//        fieldLocation.add(new TemplateFields("Invoice",163.0,122.0,12.0,12.0,12.0,12.0));
//         ;
//    }

    // Inject via application.properties
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(value = {"/static/template/images", "/index" }, method = RequestMethod.GET)
    public String index(Model model, HttpSession session) {

        model.addAttribute("message", message);
        session.setAttribute("captureDate",fieldLocation);

        return "index";
    }

    @RequestMapping(value = {"/static/template/images","/list"}, method = RequestMethod.GET)
    public String fieldList(Model model,HttpSession session) {

        model.addAttribute("selectionList", fieldLocation);



        return "list";
    }

    @RequestMapping(value = {"/static/template/images","/destroy"}, method = RequestMethod.GET)
    public String destroyFiles(Model model,HttpSession session) {



        storageService.deleteAll();
        storageService.init();
        fieldLocation.clear();
        wordZoneWithKey.clear();


        return "index";
    }

    @RequestMapping(value = {"/static/template/images","addTemplate" }, method = RequestMethod.GET )
    public String showAddTemplateFieldPage(Model model,@RequestParam("fileName") String fileName,@RequestParam("doOCR") String doOCR) {
        System.out.println("filename "+fileName);
        TemplateForm templateForm = new TemplateForm();
        templateForm.setFileName(fileName);
        model.addAttribute("templateForm", templateForm);
        if((doOCR!=null) && doOCR.equalsIgnoreCase("Yes")){

//            ArrayList<Rectangle> wordZone=new ArrayList<>();

            for(TemplateFields templateFields:fieldLocation) {
                Rectangle wordLocation = new Rectangle(templateFields.getFieldZoneMinX().intValue(), templateFields.getFieldZoneMinY().intValue(), templateFields.getWidth().intValue(), templateFields.getHeight().intValue());
//                wordZone.add(wordLocation);
                ExtractOCRData data = new ExtractOCRData();
                data.setKey(templateFields.getKey());
                data.setLocation(wordLocation);
                data.setFileName(templateFields.getFileName());
                System.out.println("Setting Data with Key ......"+templateFields.toString());
                wordZoneWithKey.put(templateFields.getKey(),data);
            }
            System.out.println("Number of Entries ......"+wordZoneWithKey.size());
                try {
                   Map<String, ExtractOCRData> extractData= GetWordsWithZone.getWordWithZone(fileName,wordZoneWithKey);
                   model.addAttribute("ocrData",extractData);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        return "addTemplate";
    }

    @RequestMapping(value = {"/static/template/images","/addTemplate" }, method = RequestMethod.POST)
    public String saveTemplateFields(Model model, //
                             @ModelAttribute("templateForm") TemplateForm templateForm) {

        Double maxX = templateForm.getFieldZoneMaxX();
        Double maxY = templateForm.getFieldZoneMaxY();
        Double minX = templateForm.getFieldZoneMinX();
        Double minY = templateForm.getFieldZoneMinY();
        String key= templateForm.getKey();
        String fileName=templateForm.getFileName();
        Double height=templateForm.getHeight();
        Double width=templateForm.getWidth();



        if (maxX != null   //
                && maxY != null ) {
            TemplateFields templateFields = new TemplateFields(key,fileName,minX,minY,maxX, maxY,width,height);

            fieldLocation.add(templateFields);

            return "redirect:/list";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addTemplate";
    }
}
