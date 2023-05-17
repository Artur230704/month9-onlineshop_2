package com.example.mont9onlineshop.controllers;

import com.example.mont9onlineshop.DTO.customer.CustomerDTO;
import com.example.mont9onlineshop.DTO.customer.CustomerRegisterDTO;
import com.example.mont9onlineshop.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<String> getProfile(Model model, Principal principal) {
        String response = "Hello " + principal.getName();
        return new ResponseEntity<>(response, HttpStatus.OK);
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
}
