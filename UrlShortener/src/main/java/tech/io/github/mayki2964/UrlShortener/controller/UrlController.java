package tech.io.github.mayki2964.UrlShortener.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.io.github.mayki2964.UrlShortener.controller.dto.urlRequestDTO;
import tech.io.github.mayki2964.UrlShortener.controller.dto.urlResponseDTO;
import tech.io.github.mayki2964.UrlShortener.models.UrlEntity;
import tech.io.github.mayki2964.UrlShortener.service.UrlService;

import java.net.URI;

@RestController
public class UrlController {

    @Autowired
    private UrlService service;

    @PostMapping(value = "/shorten-url")
    public ResponseEntity<?> shortenerUrl(@RequestBody urlRequestDTO dto, HttpServletRequest request) {
        urlResponseDTO urlResponseDTO = service.doString(dto, request);
        return ResponseEntity.ok().body(urlResponseDTO);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> redirectUrl(@PathVariable("id") String id) {

        UrlEntity byId = service.getById(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(byId.getUrlName()));
        return ResponseEntity.status(HttpStatus.FOUND.value()).headers(headers).build();
    }
}
