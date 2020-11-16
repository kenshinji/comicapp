package me.kenshinji.comicapp.service.client;

import me.kenshinji.comicapp.dto.ComicDto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.apptastic.rssreader.Item;
import com.apptastic.rssreader.RssReader;
import me.kenshinji.comicapp.dto.PdlDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class PdlClient implements Client{

    public void setFEED_URL(String FEED_URL) {
        this.FEED_URL = FEED_URL;
    }

    @Value("${feed.url}")
    private String FEED_URL;

    public void setSTRIP_COUNT(int STRIP_COUNT) {
        this.STRIP_COUNT = STRIP_COUNT;
    }

    @Value("${strip.count}")
    private int STRIP_COUNT;

    @Override
    public List<ComicDto> retrieve() {
        List<ComicDto> listToReturn = new ArrayList<ComicDto>();

        Stream<Item> rssFeed = null;
        RssReader rssreader = new RssReader();
        try {
            rssFeed = rssreader.read(FEED_URL);
            List<Item> articles = rssFeed.limit(STRIP_COUNT).collect(Collectors.toList());

            for (Item item : articles) {
                PdlDto PDLComic = new PdlDto(item.getTitle(), item.getLink(), item.getGuid(), item.getPubDate());
                ComicDto comicObject = PDLComic.toComicDTO();
                listToReturn.add(comicObject);
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return listToReturn;
    }
}
