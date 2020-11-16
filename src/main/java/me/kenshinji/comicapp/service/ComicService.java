package me.kenshinji.comicapp.service;

import me.kenshinji.comicapp.dto.ComicDto;
import me.kenshinji.comicapp.service.client.PdlClient;
import me.kenshinji.comicapp.service.client.XkcdClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ComicService {

    @Autowired
    private PdlClient pdlClient;

    @Autowired
    private XkcdClient xkcdClient;

    public List<ComicDto> getComics(){
        List<ComicDto> list = new ArrayList<>();
        list.addAll(pdlClient.retrieve());
        list.addAll(xkcdClient.retrieve());
        list.sort((a, b) -> b.getPublishingDate().compareTo(a.getPublishingDate()));
        return list;
    }
}
