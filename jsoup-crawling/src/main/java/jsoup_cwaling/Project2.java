package jsoup_cwaling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Iterator;

public class Project2 {

    public static void main(String[] args) {
        //CGV

        String url = "http://www.cgv.co.kr/movies";
        Document doc = null;

        try{
            doc = Jsoup.connect(url).get();
        }catch (IOException e){
            e.printStackTrace();
        }

        Elements elements = doc.select("div.sect-movie-chart");
//        System.out.println(doc);
        System.out.println("=======================");

        //Iterator를 써서 여러개의 element를 순서대로 정렬.
        Iterator<Element> el1 = elements.select("strong.rank").iterator();
        Iterator<Element> el2 = elements.select("strong.title").iterator();

        while(el1.hasNext()){
            System.out.println(el1.next().text() + "    " + el2.next().text());
        }



    }
}
