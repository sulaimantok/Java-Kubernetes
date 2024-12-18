package com.apicrud.java.kubernetes.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String sayHello() {
        InetAddress ip = null;
        try {
            ip = InetAddress.getLocalHost();
            System.out.println("Your current host/IP address : " + ip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "Hello " + ip;
    }

}
