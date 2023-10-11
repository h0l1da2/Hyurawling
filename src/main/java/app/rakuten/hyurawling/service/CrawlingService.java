package app.rakuten.hyurawling.service;

import app.rakuten.hyurawling.vo.ProgramFields;

import java.io.IOException;

public interface CrawlingService {
    void crawling(ProgramFields programFields) throws IOException;
}
