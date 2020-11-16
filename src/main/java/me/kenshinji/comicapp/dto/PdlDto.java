package me.kenshinji.comicapp.dto;

import lombok.Data;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Locale;

@Data
public class PdlDto {
    private String title;
    private String link;
    private String guid;
    private String publishedDate;

    public PdlDto(String title, String link, String guid,
                  String publishedDate) {

        this.title = title;
        this.link = link;
        this.guid = guid;
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
            e.printStackTrace();
        }

        return ret;
    }
}
