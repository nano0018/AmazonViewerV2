package com.anncode.util;

import javax.xml.bind.DatatypeConverter;
import java.security.SecureRandom;

public class GenerateRandomHexPassword {
    public static void main(String[] args) {
        // Code to generate keys
        SecureRandom secureRandom =  new SecureRandom();
        byte[] values = new byte[32];
        secureRandom.nextBytes(values);
        String hexString =  DatatypeConverter.printHexBinary(values);
        System.out.println(hexString);
    }
}
