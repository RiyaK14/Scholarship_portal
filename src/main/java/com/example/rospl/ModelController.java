package com.example.rospl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@RestController
public class ModelController {
    @Autowired
    private Sservice service;

    @PostMapping("/upload")
    public Modell upload(
        @RequestParam("file1") MultipartFile file1,
        @RequestParam("file2") MultipartFile file2,
        @RequestParam("file3") MultipartFile file3,
        @RequestParam("file4") MultipartFile file4,
        @RequestParam("name") String name,
        @RequestParam("contact") String contact,
        @RequestParam("course") String course,
        @RequestParam("email") String email,
        @RequestParam("oppId") String oppId, HttpSession session) throws IOException {
            System.out.println(oppId);
            String studid = (String) session.getAttribute("uid");
        return service.saveModel(file1, file2, file3, file4, name, contact, email, course, oppId, studid);
    }

    @PostMapping("/upod")
    public ModelAndView opp(@ModelAttribute OppModel opportunity,  HttpSession session) throws IOException {
        // ProModel user = (ProModel) session.getAttribute("user");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/p1");
        String org = (String) session.getAttribute("org");
        String proid = (String) session.getAttribute("proid");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
        LocalDateTime now = LocalDateTime.now(); 
        opportunity.setStartd(dtf.format(now));
        opportunity.setOrgname(org);
        opportunity.setProviderId(proid);
        service.saveOpportunity(opportunity);
        return modelAndView;
    }

    @GetMapping("/opp_pro")
    public List<OppModel> getproModels(  HttpSession session) {
        String id = (String) session.getAttribute("proid");
        // System.out.println(id);
        return service.getproModels(id);
    }

    

    

    // @GetMapping("/userdata/{id}")
    // public Modell getUserData(@PathVariable String id) {
    //     return service.getFile(id);
    // }

    // @GetMapping("/userdata")
    // public List<ModelProjection> getAllUserData() {
    //     return service.getAllModels();
    // }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable String id) {
    Modell model = service.getFile(id);
    if (model == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
   
    return ResponseEntity.ok()
            .contentType(MediaType.valueOf("application/pdf")) // Set the content type
            .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + model.getName() + "\"") // Use inline
            .body(model.getAdhar());
}

@GetMapping("/{id}/College")
public ResponseEntity<byte[]> getCollege(@PathVariable String id) {
    Modell model = service.getFile(id);
    if (model == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
   
    return ResponseEntity.ok()
            .contentType(MediaType.valueOf("application/pdf")) // Set the content type
            .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + model.getName() + "\"") // Use inline
            .body(model.getCollege());
}

@GetMapping("/{id}/Adhar")
public ResponseEntity<byte[]> getAdhar(@PathVariable String id) {
    Modell model = service.getFile(id);
    if (model == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
   
    return ResponseEntity.ok()
            .contentType(MediaType.valueOf("application/pdf")) // Set the content type
            .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + model.getName() + "\"") // Use inline
            .body(model.getAdhar());
}

@GetMapping("/{id}/Income")
public ResponseEntity<byte[]> getIncome(@PathVariable String id) {
    Modell model = service.getFile(id);
    if (model == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
   
    return ResponseEntity.ok()
            .contentType(MediaType.valueOf("application/pdf")) // Set the content type
            .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + model.getName() + "\"") // Use inline
            .body(model.getIncome());
}

@GetMapping("/{id}/Mark")
public ResponseEntity<byte[]> getMark(@PathVariable String id) {
    Modell model = service.getFile(id);
    if (model == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
   
    return ResponseEntity.ok()
            .contentType(MediaType.valueOf("application/pdf")) // Set the content type
            .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + model.getName() + "\"") // Use inline
            .body(model.getMark());
}

//***************************Student*****************************/
    // @PostMapping
    // public Student createModel(@RequestBody Student model) {
    //     return service.saveStud(model);
    // }

    @PostMapping("/signup")
public ModelAndView registerUser(@RequestParam("username") String name,
                                  @RequestParam("password") String pass) {
    ModelAndView modelAndView = new ModelAndView();
    try {
        service.registerUser(name, pass);
        modelAndView.setViewName("redirect:/login-page"); // Redirect to login page
    } catch (Exception e) {
        modelAndView.setViewName("register"); // Go back to registration page
        modelAndView.addObject("error", e.getMessage()); // Add error message
    }
    return modelAndView;
}

    @PostMapping("/login")
    public ModelAndView loginUser(@RequestParam String username, @RequestParam String password,  HttpSession session) {
    ModelAndView modelAndView = new ModelAndView();
    Optional<Student> userOpt = service.authenticateUser(username, password);
    Student stud = userOpt.get();
        if (service.authenticateUser(username, password).isPresent()) {
            System.out.println(stud.getId());
        session.setAttribute("username", username);
        session.setAttribute("uid", stud.getId());
        // System.out.println(session.getAttribute("uid"));
        // session.setAttribute("username", username);
        modelAndView.setViewName("redirect:/stud1"); // Redirect to login page
        } else {
            modelAndView.addObject("error", "Invalid username or password");  // return to login with error message
        }
    return modelAndView;

    }

    @PostMapping("/signupp")
public ModelAndView register(@RequestParam("username") String name,
                                  @RequestParam("password") String pass,
                                  @RequestParam("email") String email,
                                  @RequestParam("info") String info,
                                  @RequestParam("org") String org) {
    ModelAndView modelAndView = new ModelAndView();
    try {
        service.register(name, org, info, email, pass);
        modelAndView.setViewName("redirect:/login-page-p"); // Redirect to login page
    } catch (Exception e) {
        modelAndView.setViewName("register"); // Go back to registration page
        modelAndView.addObject("error", e.getMessage()); // Add error message
    }
    return modelAndView;
}

@PostMapping("/loginp")
public ModelAndView login(@RequestParam String username, 
                          @RequestParam String password, 
                          HttpSession session) {
    ModelAndView modelAndView = new ModelAndView();
    Optional<ProModel> userOpt = service.authenticate(username, password);
    ProModel user = userOpt.get();

    if (service.authenticate(username, password).isPresent()) {
        session.setAttribute("username", username);
        session.setAttribute("org", user.getorg());
        session.setAttribute("proid", user.getId());
        session.setAttribute("user", user);
        // System.out.println(user.getId());
        modelAndView.setViewName("redirect:/p1");
    } else {
        modelAndView.addObject("error", "Invalid username or password");
        modelAndView.setViewName("login");
    }
    return modelAndView;
}







}
