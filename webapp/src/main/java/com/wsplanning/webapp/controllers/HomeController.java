package com.wsplanning.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.wsplanning.webapp.utils.ColorPicker;;

/**
 * Created by ThuyetLV
 */
@Controller
public class HomeController {

    public HomeController() {
        
    }

    private ColorPicker colorpicker = new ColorPicker();

    @GetMapping("/")
    public String index(Model model) {
        // colorpicker.jsonFileColorThemes(obj);
        return "redirect:/mechanic";
    }

    @GetMapping("/403")
    public String accessDenied() {
        return "errors/403";
    }
}
