package me.kenshinji.comicapp.service.client;

import me.kenshinji.comicapp.dto.ComicDto;

import java.io.IOException;
import java.util.List;

public interface Client {

    public List<ComicDto> retrieve() throws IOException;
}
