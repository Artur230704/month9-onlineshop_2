package com.example.mont9onlineshop.controllers;

import com.example.mont9onlineshop.DTO.customer.ChangePasswordDTO;
import com.example.mont9onlineshop.DTO.customer.CustomerDTO;
import com.example.mont9onlineshop.DTO.customer.CustomerRegisterDTO;
import com.example.mont9onlineshop.DTO.customer.RecoverPasswordDTO;
import com.example.mont9onlineshop.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    @GetMapping("/login")
    public String getLoginPage(@RequestParam(required = false, defaultValue = "false") Boolean error, Model model) {
        model.addAttribute("error", error);
        return "login";
    }

    @GetMapping("/signup")
    public String getRegistrationPage(Model model){
        model.addAttribute("dto", new CustomerRegisterDTO());
        return "registration";
    }

    @PostMapping(value = "/signup")
    public String register(@Valid CustomerRegisterDTO customer,
                           BindingResult validationResult,
                           RedirectAttributes attributes){

        if (validationResult.hasFieldErrors()) {
            attributes.addFlashAttribute("errors", validationResult.getFieldErrors());
            return "redirect:/signup";
        }

        customerService.register(customer);
        return "redirect:/login";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/login";
    }

    @GetMapping("/profile")
    public String getProfile(Model model, Principal principal) {
        String message = "Welcome " + principal.getName();
        model.addAttribute("message", message);
        return "profile";
    }

    @GetMapping(value = "/api/customers")
    public ResponseEntity<List<CustomerDTO>> findAll(){
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/api/customers/name/{username}")
    public ResponseEntity<List<CustomerDTO>> findByName(@PathVariable String username){
        return new ResponseEntity<>(customerService.findByName(username), HttpStatus.OK);
    }

    @GetMapping(value = "/api/customers/email/{email}")
    public ResponseEntity<CustomerDTO> findByEmail(@PathVariable String email){
        CustomerDTO customer = customerService.findByEmail(email);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping(value = "/api/customers/existence/{email}")
    public ResponseEntity<Boolean> checkExistence(@PathVariable String email){
        return new ResponseEntity<>(customerService.existsByEmail(email), HttpStatus.OK);
    }

    @PostMapping(value = "/api/customers/password-management/change")
    public ResponseEntity<String> changePassword(@Valid @RequestBody ChangePasswordDTO changePasswordDTO,
                                                  Principal principal,
                                                  Model model,
                                                  BindingResult validationResult){
        if (validationResult.hasFieldErrors()) {
            model.addAttribute("errors", validationResult.getFieldErrors());
        }

        String email = principal.getName();
        String response = customerService.changePassword(changePasswordDTO, email);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/password-recover")
    public String getRecoverPage(Model model){
        model.addAttribute("dto", new RecoverPasswordDTO());
        return "password-recover";
    }

    @PostMapping(value = "/api/customers/password-management/recover")
    public String recoverPassword(@Valid RecoverPasswordDTO recoverPasswordDTO,
                                                  BindingResult validationResult,
                                                  RedirectAttributes attributes){
        if (validationResult.hasFieldErrors()) {
            attributes.addFlashAttribute("errors", validationResult.getFieldErrors());
            return "redirect:/password-recover";
        }

        try {
            String password = customerService.recoverPassword(recoverPasswordDTO);
            attributes.addFlashAttribute("password", password);
            return "redirect:/login";
        } catch (UsernameNotFoundException e) {
            attributes.addFlashAttribute("customerError", e.getMessage());
            return "redirect:/password-recover";
        }
    }
}
