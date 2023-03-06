package jsoup_cwaling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Project1 {
    public static void main(String[] args) {
        String url = "https://sports.news.naver.com/wfootball/index";
        Document doc = null;
        try{
            doc = Jsoup.connect(url).get();
        } catch (IOException e){
            // 연결안됨
            e.printStackTrace();
        }

//        Elements elements = doc.select("div.home_news");
//
//
////        System.out.println("elements = " + elements);
//
//        System.out.println("======================");
//        String title = elements.select("h2").text();
//        System.out.println(title);
//        System.out.println("======================");
//
//
//        //모든 li 리스트의 모든 글자들을 출력
//        for(Element el : elements.select("li") ){
//            System.out.println(el.text());
//        }
//        System.out.println("==============22");




        Elements elements2 = doc.select(".feature_main");
        System.out.println("elements2 = " + elements2);

        System.out.println("==============");
        for(Element el : elements2.select(".nth-child") ){
            System.out.println(el.text());
        }
        System.out.println("==============");

//#content > div > div.home_feature > div.feature_main > div > div > div:nth-child(1) > a:nth-child(2) > div.text_area
//        #content > div > div.home_feature > div.feature_main > div > div > div:nth-child(1)
    }
}
