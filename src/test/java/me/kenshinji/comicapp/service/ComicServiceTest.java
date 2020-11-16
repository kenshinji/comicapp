package me.kenshinji.comicapp.service;

import com.apptastic.rssreader.RssReader;
import me.kenshinji.comicapp.dto.ComicDto;
import me.kenshinji.comicapp.service.client.PdlClient;
import me.kenshinji.comicapp.service.client.XkcdClient;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ComicServiceTest {
    @Mock
    private PdlClient pdlClient;

    @Mock
    private XkcdClient xkcdClient;

    @InjectMocks
    private ComicService comicService;

    @Test
    void testGetComics() {
        // GIVEN
        List<ComicDto> comicDtos1 = new ArrayList<>();
        comicDtos1.add(new ComicDto("", "", "", LocalDate.of(2020, 1, 1)));
        comicDtos1.add(new ComicDto("", "", "", LocalDate.of(2020, 2, 1)));
        comicDtos1.add(new ComicDto("", "", "", LocalDate.of(2020, 3, 1)));
        comicDtos1.add(new ComicDto("", "", "", LocalDate.of(2020, 4, 1)));
        comicDtos1.add(new ComicDto("", "", "", LocalDate.of(2020, 5, 1)));
        comicDtos1.add(new ComicDto("", "", "", LocalDate.of(2020, 6, 1)));
        comicDtos1.add(new ComicDto("", "", "", LocalDate.of(2020, 7, 1)));
        comicDtos1.add(new ComicDto("", "", "", LocalDate.of(2020, 8, 1)));
        comicDtos1.add(new ComicDto("", "", "", LocalDate.of(2020, 9, 1)));
        comicDtos1.add(new ComicDto("", "", "", LocalDate.of(2020, 10, 1)));

        List<ComicDto> comicDtos2 = new ArrayList<>();
        comicDtos2.add(new ComicDto("", "", "", LocalDate.of(2021, 1, 1)));
        comicDtos2.add(new ComicDto("", "", "", LocalDate.of(2021, 2, 1)));
        comicDtos2.add(new ComicDto("", "", "", LocalDate.of(2021, 3, 1)));
        comicDtos2.add(new ComicDto("", "", "", LocalDate.of(2021, 4, 1)));
        comicDtos2.add(new ComicDto("", "", "", LocalDate.of(2021, 5, 1)));
        comicDtos2.add(new ComicDto("", "", "", LocalDate.of(2021, 6, 1)));
        comicDtos2.add(new ComicDto("", "", "", LocalDate.of(2021, 7, 1)));
        comicDtos2.add(new ComicDto("", "", "", LocalDate.of(2021, 8, 1)));
        comicDtos2.add(new ComicDto("", "", "", LocalDate.of(2021, 9, 1)));
        comicDtos2.add(new ComicDto("", "", "", LocalDate.of(2021, 10, 1)));
        when(pdlClient.retrieve()).thenReturn(comicDtos1);
        when(xkcdClient.retrieve()).thenReturn(comicDtos2);

        // WHEN
        List<ComicDto> result = comicService.getComics();

        // THEN
        assertThat(result.size()).isEqualTo(20);
        assertThat(result.get(0).getPublishingDate()).isEqualTo("2021-10-01");
        assertThat(result.get(19).getPublishingDate()).isEqualTo("2020-01-01");
    }



}