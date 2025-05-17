package tech.io.github.mayki2964.UrlShortener.service;

import java.util.Random;


public class generateRandom {

    public static String randomString(int tamanho){
        Random random = new Random();
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < tamanho; i++){
            int index = random.nextInt(caracteres.length());
            stringBuilder.append(caracteres.charAt(index));
        }
        return stringBuilder.toString();
    }

}
