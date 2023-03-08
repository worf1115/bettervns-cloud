package com.bettervns.adminservice.controllers;

import com.bettervns.adminservice.dao.AdminDAO;
import com.bettervns.adminservice.requests.NewUserRequest;
import com.google.gson.GsonBuilder;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private static final String QUEUE_FOR_STUDENTS_NAME = "adminToStudents";
    private final AmqpTemplate template;
    private final AdminDAO adminDao;

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

    @GetMapping("/students")
    public String getStudentsList(){
        return "not yet implemented";
    }

    @GetMapping("/groups")
    public String getGroupsList(){
        return "not yet implemented";
    }

    @GetMapping("/student/{id}")
    public String getStudent(@PathVariable("id") int id){
        return "not yet implemented";
    }

    @GetMapping("/group/{id}")
    public String getGroup(@PathVariable("id") int id){
        return "not yet implemented";
    }

    @PostMapping("/student")
    public String createStudent(@RequestBody NewUserRequest requestObject){
        String message = "create " + 0 + " " + new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(requestObject);
        System.out.println(message);
        template.convertAndSend(QUEUE_FOR_STUDENTS_NAME, message);
        return "redirect:/admin/1";
    }

    @DeleteMapping ("/student/{id}")
    public String deleteStudent(@PathVariable("id") int id){
        String message = new String("delete " + id);
        template.convertAndSend(QUEUE_FOR_STUDENTS_NAME, message);
        return "redirect:/admin/1";
    }

    @PatchMapping("/student/{id}")
    public String updateStudent(@RequestBody NewUserRequest requestObject, @PathVariable("id") int id){
        String message = "update " + id + " " + new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(requestObject);
        System.out.println(message);
        template.convertAndSend(QUEUE_FOR_STUDENTS_NAME, message);
        return "redirect:/admin/1";
    }

    @PostMapping("/group")
    public String createGroup(@RequestBody NewUserRequest requestObject){
        return "not yet implemented";
    }

    @DeleteMapping ("/group/{id}")
    public String deleteGroup(@PathVariable("id") int id){
        return "not yet implemented";
    }

    @PatchMapping("/group/{id}")
    public String updateGroup(@RequestBody NewUserRequest requestObject, @PathVariable("id") int id){
        return "not yet implemented";
    }
}