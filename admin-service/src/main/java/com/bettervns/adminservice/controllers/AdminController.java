package com.bettervns.adminservice.controllers;

import com.bettervns.adminservice.dao.AdminDAO;
import com.bettervns.studentsservice.requests.NewUserRequest;
import com.google.gson.GsonBuilder;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AmqpTemplate template;
    private AdminDAO adminDao;

    @Autowired
    public AdminController(AmqpTemplate template, AdminDAO adminDao) {
        this.template = template;
        this.adminDao = adminDao;
    }

    @GetMapping("/{id}")
    public String homePage(@PathVariable("id") int id, Model model) {
        model.addAttribute("admin", adminDao.show(id));
        return adminDao.show(id).toString();
    }

    @PostMapping("/student")
    public String createStudent(@RequestBody NewUserRequest requestObject){
        String message = "create " + 0 + " " + new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(requestObject);
        System.out.println(message);
        template.convertAndSend("myQueue", message);
        return "redirect:/admin/1";
    }

    @DeleteMapping ("/student/{id}")
    public String deleteStudent(@PathVariable("id") int id){
        String message = new String("delete " + id);
        template.convertAndSend("myQueue", message);
        return "redirect:/admin/1";
    }

    @PatchMapping("/student/{id}")
    public String updateStudent(@RequestBody NewUserRequest requestObject, @PathVariable("id") int id){
        String message = "update " + id + " " + new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(requestObject);
        System.out.println(message);
        template.convertAndSend("myQueue", message);
        return "redirect:/admin/1";
    }
}