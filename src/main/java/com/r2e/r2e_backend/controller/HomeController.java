package com.r2e.r2e_backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeController {

    @GetMapping("/")
    public RedirectView redirectToFrontend() {
        return new RedirectView("https://r2e-frontend.netlify.app");
    }

    @GetMapping("/home")
    public RedirectView redirectToFrontendHome() {
        return new RedirectView("https://r2e-frontend.netlify.app");
    }

    @GetMapping("/docs")
    public RedirectView redirectToApiDocs() {
        return new RedirectView("/swagger-ui.html");
    }
}