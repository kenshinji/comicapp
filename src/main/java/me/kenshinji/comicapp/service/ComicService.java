package me.kenshinji.comicapp.service;

import me.kenshinji.comicapp.dto.ComicDto;
import me.kenshinji.comicapp.dto.XkcdDto;
import me.kenshinji.comicapp.service.client.PdlClient;
import me.kenshinji.comicapp.service.client.XkcdClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ComicService {

    @Autowired
    private PdlClient pdlClient;

    @Autowired
    private XkcdClient xkcdClient;

    public List<ComicDto> getComics() throws IOException {
        List<ComicDto> list = new ArrayList<>();
        list.addAll(pdlClient.retrieve(10));
        list.addAll(xkcdClient.retrieve(10));
        list.sort((a, b) -> b.getPublishingDate().compareTo(a.getPublishingDate()));
        return list;
    }
}
