package com.edatablock.template;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ClientTemplateController {

    private static List<TemplateFields> fieldLocation = new ArrayList<TemplateFields>();


    static {
        fieldLocation.add(new TemplateFields("Invoice",163.0,122.0,12.0,12.0));
         ;
    }

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
    public String showAddTemplateFieldPage(Model model,@RequestParam("fileName") String fileName) {
        System.out.println("filename "+fileName);
        TemplateForm templateForm = new TemplateForm();
        templateForm.setFileName(fileName);
        model.addAttribute("templateForm", templateForm);

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


        if (maxX != null   //
                && maxY != null ) {
            TemplateFields templateFields = new TemplateFields(fileName,maxX, maxY,minX,minY);
            fieldLocation.add(templateFields);

            return "redirect:/list";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addTemplate";
    }
}
