package me.kenshinji.comicapp.controller;

import me.kenshinji.comicapp.dto.ComicDto;
import me.kenshinji.comicapp.service.ComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class ComicController {

    @Autowired
    private ComicService comicService;

    @GetMapping("/comics")
    public List<ComicDto> getComics() throws IOException {
        return comicService.getComics();
    }
}
