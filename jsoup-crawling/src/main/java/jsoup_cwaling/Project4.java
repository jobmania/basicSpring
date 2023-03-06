package jsoup_cwaling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Iterator;

public class Project4 {
    public static void main(String[] args) {

        String url = "https://www.inflearn.com/courses/it-programming";
        Document doc = null;

        //강의 컨텐츠 (제목, 가격, 평점)
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();

        }

        Elements cardContents = doc.select("div.card-content");

        System.out.println(cardContents);

        //Iterator를 이용 하나씩 들고오기 ..
        Iterator<Element> title = cardContents.select("div.course_title").iterator(); // Iterator는 넥스트를 통해 다음게 나온다.
        Iterator<Element> price = cardContents.select("div.price").iterator(); // Iterator는 넥스트를 통해 다음게 나온다.




        // 강의 링크
        Elements courseLinks = doc.select("a.course_card_front");
        Iterator<Element> linkUrl = courseLinks.iterator();
        while(title.hasNext()) {
            System.out.println("============================");
            System.out.println("강의 제목: " + title.next().text());
            System.out.println("가격: " + getPrice(price.next().text()));
            System.out.println("강의링크: " + linkUrl.next().attr("abs:href"));
        }


    }

    private static String getPrice(String text) {
        //가격에  원을 붙여준다거나,, 할인된 가격이 디스플레이되어야함..
        String[] prices = text.split(" ");
        String result = prices[0].substring(1) + "원 ";
        if(prices.length > 1){
            result += "할인가격 :" + prices[1].substring(1) + "원";
        }

        return result;
    }
}
