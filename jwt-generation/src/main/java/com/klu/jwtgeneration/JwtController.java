package com.klu.jwtgeneration;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class JwtController {

    private final JwtService jwtService;

    public JwtController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping(value = "/generate-token", produces = MediaType.TEXT_PLAIN_VALUE)
    public String generateToken(@RequestBody Map<String, Object> payload) {
        return jwtService.generateToken(payload);
    }
}
