package me.kenshinji.comicapp.service.client;

import me.kenshinji.comicapp.dto.ComicDto;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class XkcdClientTest {


    @Test
    void testRetrieve() {
        // WHEN AND THEN
        XkcdClient xkcdClient = new XkcdClient();
        xkcdClient.setCURRENT_URL("BROKEN_URL");
        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> xkcdClient.retrieve()
        );
    }

    @Test
    void testRetrieveHappyCase() {
        // GIVEN
        XkcdClient xkcdClient = new XkcdClient();
        xkcdClient.setCURRENT_URL("https://xkcd.com/info.0.json");
        xkcdClient.setNUMBER_URL("https://xkcd.com/NUMBER/info.0.json");
        xkcdClient.setSTRIP_COUNT(10);

        // WHEN
        List<ComicDto> result = xkcdClient.retrieve();

        // THEN
        assertThat(result.size()).isEqualTo(10);
    }

}