package app.rakuten.hyurawling.controller;

import app.rakuten.hyurawling.service.CrawlingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CrawlingController {

    private final CrawlingService crawlingService;
}
