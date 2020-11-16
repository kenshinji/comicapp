package me.kenshinji.comicapp.service.client;

import me.kenshinji.comicapp.dto.ComicDto;
import me.kenshinji.comicapp.dto.XkcdDto;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


@Component
public class XkcdClient implements Client {

    public void setCURRENT_URL(String CURRENT_URL) {
        this.CURRENT_URL = CURRENT_URL;
    }

    @Value("${current.url}")
    private String CURRENT_URL;

    public void setNUMBER_URL(String NUMBER_URL) {
        this.NUMBER_URL = NUMBER_URL;
    }

    @Value("${number.url}")
    private String NUMBER_URL;

    public void setSTRIP_COUNT(int STRIP_COUNT) {
        this.STRIP_COUNT = STRIP_COUNT;
    }

    @Value("${strip.count}")
    private int STRIP_COUNT;

    @Override
    public List<ComicDto> retrieve(){

        List<ComicDto> comicDtos = new ArrayList<>();
        JSONObject json = null;
        try {
            json = new JSONObject(IOUtils.toString(new URL(CURRENT_URL), StandardCharsets.UTF_8));
            int currentNumber = json.getInt("num");
            comicDtos.add(mapToComicDto(json));

            for (int i = 1; i < STRIP_COUNT; i++) {
                JSONObject rep = new JSONObject(IOUtils.toString(URI.create(NUMBER_URL.replace("NUMBER", String.valueOf(currentNumber - i))), StandardCharsets.UTF_8));
                comicDtos.add(mapToComicDto(rep));
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        return comicDtos;

    }


    private ComicDto mapToComicDto(JSONObject jsonObject) {
        XkcdDto xkcdDto = new XkcdDto(jsonObject.getString("img"), jsonObject.getString("title"),
                jsonObject.getInt("num"), jsonObject.getString("month"),
                jsonObject.getString("day"), jsonObject.getString("year"));
        return xkcdDto.toComicDto();
    }
}
