package me.kenshinji.comicapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class ComicDto {

    @Getter
    @Setter
    private String pictureURL;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String browserURL;

    private LocalDate publishingDate;

    public String getPublishingDate() {
        return publishingDate.format(DateTimeFormatter.ISO_DATE);
    }

    void setDate(LocalDate parsedDate) {
        this.publishingDate = parsedDate;
    }

}
