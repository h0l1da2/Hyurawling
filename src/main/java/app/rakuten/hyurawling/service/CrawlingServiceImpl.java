package app.rakuten.hyurawling.service;

import app.rakuten.hyurawling.vo.Brand;
import app.rakuten.hyurawling.vo.ProgramFields;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Locale;

@Service
public class CrawlingServiceImpl implements CrawlingService {
    @Override
    public void crawling(ProgramFields programFields) throws IOException {
        Document main = Jsoup.connect(programFields.getUrl()).get();

        Element body = main.body();

        Elements div = body.select("div.image-wrapper--1ROeD");
        Elements aTag = div.select("a");
        aTag.stream().forEach(a -> {
            String targetLink = a.attr("href");

            // 새로운 사이트 들어가기
            Document targetPage = null;
            try {
                targetPage = Jsoup.connect(targetLink).get();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Elements metaElement = targetPage.select("meta");

            // 아이템 종류
            Elements metaCategory = metaElement.select("meta[property=og:type]");
            String itemCategory = metaCategory.attr("content");

            // 아이템 이름
            Elements metaTitle = metaElement.select("meta[property=og:title]");
            String itemName = metaCategory.attr("content");

            // 브랜드
            targetLink = targetLink.toUpperCase(Locale.ROOT);

            String brandName = "";

            if (targetLink.contains(Brand.ADIDAS.name())) {
                brandName = Brand.ADIDAS.name();
            } else if (targetLink.contains(Brand.NIKE.name())) {
                brandName = Brand.NIKE.name();
            } else {
                brandName = "보세";
            }
            // 제조사 (브랜드명은 제조사와 같다.)
            String madeName = brandName;

            // 옵션
            Elements table = targetPage.select("div.spacer--xFAdr block--2PK_L padding-all-small--24bWt");
        });



    }
}
