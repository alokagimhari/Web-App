package com.company.transfer;

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
public class PaymentController {
    @Autowired private PaymentService service;

    @GetMapping("/payment")
    public String showPaymentList(Model model)
    {
        List<Payment> listPayment = service.listAll();
        model.addAttribute("listPayment",listPayment);
        return "payment";
    }

    @GetMapping("/payment/new")
    public String showNewForm(Model model)
    {
        model.addAttribute("payment", new Payment());
        model.addAttribute("pageTitle", "Make new Payment");
        return "payment_form";
    }

    @PostMapping("/payment/save")
    public String saveUser(Payment payment, RedirectAttributes ra)
    {
        service.save(payment);
        ra.addFlashAttribute("message","The payment has been saved successfully");
        return "redirect:/payment";
    }

    @GetMapping("/payment/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Payment payment = service.get(id);
            model.addAttribute("payment",payment);
            model.addAttribute("pageTitle", "Edit payment (ID: " + id + ")");
            return "payment_form";
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/payment";
        }
    }

    @GetMapping("/payment/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id,RedirectAttributes ra) {
        service.delete(id);
        ra.addFlashAttribute("message","The payment id " + id+ " deleted");
        return "redirect:/payment";
    }
}
