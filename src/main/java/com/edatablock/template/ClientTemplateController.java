package com.edatablock.template;

import com.edatablock.GetWordsWithZone;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.w3c.dom.css.Rect;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ClientTemplateController {

    private static List<TemplateFields> fieldLocation = new ArrayList<TemplateFields>();


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
    public String index(Model model) {

        model.addAttribute("message", message);

        return "index";
    }

    @RequestMapping(value = {"/static/template/images","/list"}, method = RequestMethod.GET)
    public String fieldList(Model model) {

        model.addAttribute("selectionList", fieldLocation);


        return "list";
    }

    @RequestMapping(value = {"/static/template/images","addTemplate" }, method = RequestMethod.GET )
    public String showAddTemplateFieldPage(Model model,@RequestParam("fileName") String fileName,@RequestParam("doOCR") String doOCR) {
        System.out.println("filename "+fileName);
        TemplateForm templateForm = new TemplateForm();
        templateForm.setFileName(fileName);
        model.addAttribute("templateForm", templateForm);
        if((doOCR!=null) && doOCR.equalsIgnoreCase("Yes")){

            ArrayList<Rectangle> wordZone=new ArrayList<>();
            for(TemplateFields rectangle:fieldLocation){
                Rectangle wordLocation= new Rectangle(rectangle.getFieldZoneMinX().intValue(),rectangle.getFieldZoneMinY().intValue(),rectangle.getWidth().intValue(),rectangle.getHeight().intValue());
                wordZone.add(wordLocation);

            GetWordsWithZone.getWordWithZone(fileName,wordZone);
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
        String fileName=templateForm.getFileName();
        Double height=templateForm.getHeight();
        Double width=templateForm.getWidth();



        if (maxX != null   //
                && maxY != null ) {
            TemplateFields templateFields = new TemplateFields(fileName,minX,minY,maxX, maxY,width,height);
            fieldLocation.add(templateFields);

            return "redirect:/list";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addTemplate";
    }
}
