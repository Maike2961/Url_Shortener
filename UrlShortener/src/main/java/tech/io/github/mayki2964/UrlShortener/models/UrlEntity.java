package tech.io.github.mayki2964.UrlShortener.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "urls")
public class UrlEntity {

    @Id
    private String id;

    private String urlName;

    private Date dateExpires;

    public UrlEntity() {
    }

    public UrlEntity(String id, String urlName, Date dateExpires) {
        this.id = id;
        this.urlName = urlName;
        this.dateExpires = dateExpires;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName;
    }

    public Date getDateExpires() {
        return dateExpires;
    }

    public void setDateExpires(Date dateExpires) {
        this.dateExpires = dateExpires;
    }

    @Override
    public String toString() {
        return "UrlEntity{" +
                "id='" + id + '\'' +
                ", urlName='" + urlName + '\'' +
                ", dateExpires=" + dateExpires +
                '}';
    }
}
