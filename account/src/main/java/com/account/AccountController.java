package com.account;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/accounts")
public class AccountController {

    @GetMapping("/status/check")
    public String status() {
        return "Accounts Works!!!";
    }
}
