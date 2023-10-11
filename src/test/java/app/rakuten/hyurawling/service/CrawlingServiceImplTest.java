package app.rakuten.hyurawling.service;

import app.rakuten.hyurawling.vo.ProgramFields;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CrawlingServiceImplTest {

    private CrawlingService crawlingService = new CrawlingServiceImpl();

    @Test
    void crawling() throws IOException {

        ProgramFields programFields = ProgramFields.builder()
                .url("https://search.rakuten.co.jp/search/mall/shoes/")
                .build();

        crawlingService.crawling(programFields);

    }
}