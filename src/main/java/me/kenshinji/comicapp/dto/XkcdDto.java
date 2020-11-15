package me.kenshinji.comicapp.dto;


import lombok.Data;

import java.time.LocalDate;

@Data
public class XkcdDto {

    public XkcdDto(String img, String title, int num, String month, String day, String year) {
        this.img = img;
        this.title = title;
        this.num = num;
        this.month = month;
        this.day = day;
        this.year = year;
    }

    private static final String XKCD_BASE_URL = "https://xkcd.com/";
    private String img;
    private String title;
    private int num;
    private String month;
    private String day;
    private String year;

    public ComicDto toComicDto() {
        ComicDto ret = new ComicDto();
        ret.setBrowserURL(XKCD_BASE_URL + this.num);
        ret.setPictureURL(this.img);
        ret.setTitle(this.title);

        ret.setDate(LocalDate.of(Integer.valueOf(this.year), Integer.valueOf(this.month),
                Integer.valueOf(this.day)));

        return ret;
    }

}
