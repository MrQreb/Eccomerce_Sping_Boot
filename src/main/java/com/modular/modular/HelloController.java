package com.modular.modular;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hdssadasdsadadello %s!", name);
    }

    @GetMapping("/hello1")
    public String hello1(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("aaaa %s!", name);
    }

    @GetMapping("/hello2")
    public String hello2(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("aaaa %s!", name);
    }

    @GetMapping("/saludos")
    public String saluydo(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("aaaa %s!", name);
    }

    @GetMapping("/saludos1")
    public String saluydo1(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("aaaa %s!", name);
    }
}
