package me.kenshinji.comicapp.service.client;

import me.kenshinji.comicapp.dto.ComicDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PdlClientTest {

    @Test
    public void testRetrieve() {
        // WHEN AND THEN
        PdlClient pdlClient = new PdlClient();
        pdlClient.setFEED_URL("BROKEN_URL");
        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> pdlClient.retrieve()
        );
    }

    @Test
    void testRetrieveHappyCase() {
        // GIVEN
        PdlClient pdlClient = new PdlClient();
        pdlClient.setFEED_URL("http://feeds.feedburner.com/PoorlyDrawnLines");
        pdlClient.setSTRIP_COUNT(10);

        // WHEN
        List<ComicDto> result = pdlClient.retrieve();

        // THEN
        assertThat(result.size()).isEqualTo(10);
    }

}