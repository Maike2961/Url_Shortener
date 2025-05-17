package tech.io.github.mayki2964.UrlShortener.service;

import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.stream.Collectors;


public class generateRandom {

    public static String randomString(int tamanho){
        Random random = new Random();
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        return random.ints(tamanho, 0, caracteres.length())
                .mapToObj(caracteres::charAt)// Converte cada número inteiro da stream em um caractere usando o índice correspondente.
                .map(String::valueOf)// Converte cada Character em uma String.
                .collect(Collectors.joining()); // Junta todos os elementos da stream agora Stream<String> em uma única String
    }

}
