// package com.example.rospl;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.mail.SimpleMailMessage;
// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.web.bind.annotation.*;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api")
// public class EmailController {

//     @Autowired
//     private EmailService emailService;

//     @PostMapping("/send-email")
//     public String sendEmail(@RequestParam String to, 
//                             @RequestParam String subject, 
//                             @RequestParam String text) {
//         emailService.sendEmail(to, subject, text);
//         return "Email sent successfully!";
//     }
// }
