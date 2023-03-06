package jsoup_cwaling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class App {

    public static void main(String[] args) {

        // 자바스크립트는 크롤링 안됨
        String url = "https://search.11st.co.kr/Search.tmall?kwd=CPU";
        Document doc = null;

        try{
             doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Elements select = doc.select("div.l_search_content");
//        System.out.println("select = " + select);

        Elements elements = doc.select(".c_prd_name.c_prd_name_row_1 > a > strong");
//#layBodyWrap > div > div > div.l_search_content > div > section:nth-child(11) > ul > li:nth-child(2) > div > div:nth-child(2) > div.c_card_info_top > div
        System.out.println(elements);


    }
}