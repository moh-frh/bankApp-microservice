package org.frh.customerservice.web;

import org.frh.customerservice.config.GlobalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ConfigTestController {
    @Value("${global.params.p1}")
    private int p1;

    @Value("${global.params.p2}")
    private int p2;

    @Autowired
    private GlobalConfig globalConfig;

    @GetMapping("/testConfig")
    public Map<String, Integer> configTest(){
        return Map.of("p1", p1, "p2", p2);
    }

    @GetMapping("/globalconfig")
    public GlobalConfig globalConfig(){
        return globalConfig;
    }
}
