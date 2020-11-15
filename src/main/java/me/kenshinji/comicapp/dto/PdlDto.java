package me.kenshinji.comicapp.dto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Locale;
import java.util.Optional;

public class PdlDto {
    String title, link, guid;
    String publishedDate;

    public PdlDto(String title, String link, String guid,
                  String publishedDate) {

        this.title = title;
        this.link = link;
        this.guid = guid;
        this.publishedDate = publishedDate;

    }

    public PdlDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public ComicDto toComicDTO() {
        ComicDto ret = new ComicDto();
        ret.setBrowserURL(this.guid);
        ret.setPictureURL(this.link);
        ret.setTitle(this.title);

        DateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", Locale.US);

        try {
            ret.setDate(dateFormat.parse(this.publishedDate).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ret;
    }
}
