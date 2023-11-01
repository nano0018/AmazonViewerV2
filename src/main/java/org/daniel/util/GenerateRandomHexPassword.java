package org.daniel.util;

import javax.xml.bind.DatatypeConverter;
import java.security.SecureRandom;


/**
 * Esta clase genera una contraseña aleatoria en formato hexadecimal y lo imprime en consola.
 * @author dacif
 * @version 1.0
 * @since 2023
 * */
public class GenerateRandomHexPassword {
    /**
     * Método principal de la clase que ejecuta el código para generar la contraseña aleatoria.
     * @param args Argumentos de la línea de comandos.
     * */
    public static void main(String[] args) {
        // Code to generate keys
        SecureRandom secureRandom =  new SecureRandom();
        byte[] values = new byte[32];
        secureRandom.nextBytes(values);
        String hexString =  DatatypeConverter.printHexBinary(values);
        System.out.println(hexString);
    }
}
