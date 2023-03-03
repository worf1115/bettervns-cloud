package com.bettervns.adminservice.controllers;

import com.bettervns.adminservice.dao.StudentDAO;
import com.bettervns.adminservice.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@Controller
@RequestMapping("/students")
public class AdminController {

    @Autowired
    private StudentDAO studentDAO;

    @GetMapping()
    public String index(Model model){
        model.addAttribute("students", studentDAO.index());
        return "index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        if (studentDAO.show(id) != null) {
            model.addAttribute("student", studentDAO.show(id));
            return "show";
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
        }
    }

    @GetMapping("/new")
    public String newStudent(Model model){
        model.addAttribute("student", new Student());
        return "new";
    }

    @PostMapping()
    public String newStudent(@ModelAttribute("student") @Valid Student student, BindingResult bindingResult){
        if (bindingResult.hasErrors()) return "students/new";
        studentDAO.addStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model){
        model.addAttribute("student", studentDAO.show(id));
        return "edit";
    }

    @PatchMapping ("/{id}")
    public String update(@ModelAttribute("student") @Valid Student student, BindingResult bindingResult, @PathVariable("id") int id){
        if (bindingResult.hasErrors()) return "edit";
        studentDAO.update(id, student);
        return "redirect:/students";
    }

    @DeleteMapping ("/{id}")
    public String delete(@PathVariable("id") int id){
        studentDAO.delete(id);
        return "redirect:/students";
    }
}