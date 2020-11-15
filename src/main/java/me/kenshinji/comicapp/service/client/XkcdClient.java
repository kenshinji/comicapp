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
    private final static String CURRENT_URL = "https://xkcd.com/info.0.json";
    private final static String NUMBER_URL = "https://xkcd.com/NUMBER/info.0.json";

    @Value("${strip.count}")
    private int STRIP_COUNT;

    @Override
    public List<ComicDto> retrieve() throws IOException {

        List<ComicDto> comicDtos = new ArrayList<>();
        JSONObject json = new JSONObject(IOUtils.toString(new URL(CURRENT_URL), StandardCharsets.UTF_8));
        int currentNumber = json.getInt("num");
        comicDtos.add(mapToComicDto(json));

        for (int i = 1; i < STRIP_COUNT; i++) {
            JSONObject rep = new JSONObject(IOUtils.toString(URI.create(NUMBER_URL.replace("NUMBER", String.valueOf(currentNumber - i))), StandardCharsets.UTF_8));
           comicDtos.add(mapToComicDto(rep));
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
