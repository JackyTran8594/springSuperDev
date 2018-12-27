package com.wsplanning.webapp.controllers;

import com.wsplanning.webapp.clients.MechanicClient;
import com.wsplanning.webapp.clients.SiteClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.Patch;

@Controller
public class LoginController {

    @Autowired
    protected SiteClient siteClient;

    @GetMapping("/login")
    public String login(HttpServletRequest request) {
        String listSite = siteClient.getSites();
        // jsonFileColorThemes(request.);
        // String referrer = request.getHeader("Referer");
        // request.getSession().setAttribute("url_prior_login", referrer);

        return "login";
    }

  
}
