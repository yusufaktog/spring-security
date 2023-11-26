package com.aktog.yusuf.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class HelloController {

    @GetMapping("/v1")
    public String welcome() {
        return "You dont need to authanticate to see this :)";
    }

    @GetMapping("/engineer")
    @PreAuthorize("hasAuthority('ENGINEER')")
    public String welcome2() {
        return "You need to be an engineer to see this :)";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/admin")
    public String welcome3() {
        return "This one can only be seen by admins :)";
    }
    @GetMapping("/v4")
    @PreAuthorize("hasAnyAuthority('ADMIN','ENGINEER','USER')")
    public String welcome4() {
        return "You need to authenticate with any of the authorities to see this :)";
    }
}
