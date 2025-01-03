package com.practice.catsgram.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
    private static final Logger log = LoggerFactory.getLogger(SimpleController.class);

    //@RequestMapping(value = "/home", method = RequestMethod.GET)
    @GetMapping("/home")
    public String homePage() {
        log.info("Получен запрос.");
        return "Котограм";
    }
}
