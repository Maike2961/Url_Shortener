package tech.io.github.mayki2964.UrlShortener.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tech.io.github.mayki2964.UrlShortener.controller.dto.urlRequestDTO;
import tech.io.github.mayki2964.UrlShortener.controller.dto.urlResponseDTO;
import tech.io.github.mayki2964.UrlShortener.models.UrlEntity;
import tech.io.github.mayki2964.UrlShortener.repository.urlRepository;
import org.springframework.http.HttpHeaders;

import java.net.URI;
import java.time.LocalDateTime;

import java.time.ZoneOffset;
import java.util.Date;

@Service
public class UrlService {

    @Autowired
    private urlRepository repository;

    public urlResponseDTO doString(urlRequestDTO dto, HttpServletRequest request){

        String randomString = generateRandom.randomString(10);

        UrlEntity save = repository.save(
                new UrlEntity(randomString, dto.url(), Date.from(LocalDateTime
                        .now()
                        .plusMinutes(1)
                        .atZone(ZoneOffset.UTC).toInstant())));
        String replaced = request
                .getRequestURL()
                .toString()
                .replace("shorten-url", randomString);
        
        return new urlResponseDTO(replaced, save.getDateExpires());
    }

    public UrlEntity getById(String id){
       return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("URl no found"));
    }

    @Scheduled(fixedRate = 60000)
    public void deleteExpiredUrl(){
        Date date = new Date();
        repository.deleteByDateExpiresBefore(date);
    }
}
