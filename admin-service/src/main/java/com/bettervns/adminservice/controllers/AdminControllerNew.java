package com.bettervns.adminservice.controllers;

import com.bettervns.adminservice.dao.AdminDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminControllerNew {

    @Autowired
    private AdminDAO adminDao;

    @GetMapping("/{id}")
    public String homePage(@PathVariable("id") int id, Model model) {
        model.addAttribute("admin", adminDao.show(id));
        return adminDao.show(id).toString();
    }


}