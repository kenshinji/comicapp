package me.kenshinji.comicapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
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
