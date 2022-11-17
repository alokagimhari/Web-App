package com.company.account;


import com.company.user.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class AccountController {
    @Autowired private AccountService service;

    @GetMapping("/account")
    public String showAccountList(Model model)
    {
        List<Account> listAccount = service.listAll();
        model.addAttribute("listAccount",listAccount);
        return "account";
    }

    @GetMapping("/account/new")
    public String showNewForm(Model model)
    {
        model.addAttribute("account",new Account());
        model.addAttribute("pageTitle","Add new Account");
        return "accountForm";
    }

    @PostMapping("/account/save")
    public String saveUser(Account account, RedirectAttributes ra)
    {
    service.save(account);
    ra.addFlashAttribute("message","The account has been saved successfully");
    return "redirect:/account";
    }

    @GetMapping("/account/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id,Model model,RedirectAttributes ra) {
        try {
            Account account = service.get(id);
            model.addAttribute("account",account);
            model.addAttribute("pageTitle", "Edit User (ID: " + id + ")");
            return "accountForm";
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/account";
        }
    }

    @GetMapping("/account/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id,RedirectAttributes ra) {
            service.delete(id);
            ra.addFlashAttribute("message","The account id " + id+ " deleted");
            return "redirect:/account";
        }
    }

