package tech.io.github.mayki2964.UrlShortener.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tech.io.github.mayki2964.UrlShortener.models.UrlEntity;

import java.util.Date;

@Repository
public interface urlRepository extends MongoRepository<UrlEntity, String> {

    void deleteByDateExpiresBefore(Date now);
}
