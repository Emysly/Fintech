package com.emysilva.fintech.service.util;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class Utils {

    //Encode:
    public static String encode(String input) {
        return Base64.getEncoder().encodeToString(input.getBytes());
    }

    //Decode:
    public static String decode(String input) {
        byte[] decodedBytes = Base64.getDecoder().decode(input);
        return new String(decodedBytes);
    }

}
