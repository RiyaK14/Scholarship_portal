package com.example.rospl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class PageController {
    @Autowired
    private Sservice service;

    @GetMapping("/")
    public String home() {
        return "index"; // returns index.html
    }

    @GetMapping("/contact")
    public String con() {
        return "contact"; // returns contact.html
    }

    @GetMapping("/about")
    public String about() {
        return "about"; // returns about.html
    }

    @GetMapping("/error")
    public String er() {
        return "notfound"; // returns about.html
    }

    @GetMapping("/p1")
public String p1(HttpSession session, Model model) {
    String username = (String) session.getAttribute("username");
    ProModel user = (ProModel) session.getAttribute("user");
    model.addAttribute("username", username);
    model.addAttribute("info", user.getinfo());
    model.addAttribute("org", user.getorg());
    return "p1"; // Now `username` is available in `p1.html`
    }

    @PostMapping("/job-detail")
    public String jobdetail(@RequestParam String id, Model model) {
        System.out.println(id);
        Optional<OppModel> opportuityOpt = service.getopp(id);
        OppModel opportunity = opportuityOpt.get();
        // System.out.println(opportunity.getTitle());
        model.addAttribute("id", opportunity.getId());
        model.addAttribute("title", opportunity.getTitle());
        model.addAttribute("start", opportunity.getStartd());
        model.addAttribute("end", opportunity.getl_date());
        model.addAttribute("org", opportunity.getOrgname());
        model.addAttribute("criteria", opportunity.getCriteria());
        return "job-detail"; // returns job-detail.html
    }

    @GetMapping("/login-page")
    public String login() {
        return "login-page"; // returns login-page.html
    }

    @GetMapping("/login-page-p")
    public String prolog() {
        return "login-page-p"; // returns login-page.html
    }

    // @GetMapping("/p1")
    // public String pro1() {
    //     return "p1"; // returns login-page.html
    // }

    @GetMapping("/job-list")
    public String joblist(HttpSession session, Model model) {
    String username = (String) session.getAttribute("username");
    model.addAttribute("username", username);
    return "job-list"; // returns job-list.html
    }

    @GetMapping("/notfound")
    public String not() {
        return "notfound"; // returns notfound.html
    }

    @GetMapping("/stud1")
    public String stud(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");
        model.addAttribute("username", username);
        return "stud1"; // returns notfound.html
    }

    @GetMapping("/category")
    public String category() {
        return "category"; // returns category.html
    }

    @GetMapping("/testimonial")
    public String test() {
        return "testimonial"; // returns testimonial.html
    }

    @GetMapping("/applicant")
    public String apply() {
        return "applicant"; // returns applicant.html
    }

    @PostMapping("/applicant")
    public String see(@RequestParam String id, Model model) {
        System.out.println(id);
        model.addAttribute("id", id);
        return "applicant"; // returns applicant.html
    }
}
