package tech.io.github.mayki2964.UrlShortener.controller.dto;

import java.util.Date;

public record urlResponseDTO(String url, Date expiresAt) {
}
