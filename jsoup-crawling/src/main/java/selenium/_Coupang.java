package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class _Coupang {
    public static void main(String[] args) {

        //세션시작

        ChromeOptions options = new ChromeOptions();
//
//        //페이지가 로드될 때까지 대기
//        //Normal: 로드 이벤트 실행이 반환 될 때 까지 기다린다.
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://search.11st.co.kr/Search.tmall?kwd=cpu");
            List<WebElement> elements = driver.findElements(By.className("c_prd_name"));
            List<WebElement> elementPrices = driver.findElements(By.className("c_prd_price"));


            for (WebElement element : elements) {
                System.out.println("=====");
//                System.out.println(element);
                System.out.println(element.findElement(By.tagName("strong")).getText());
            }

            for (WebElement elementPrice : elementPrices) {
                System.out.println("=====");
                System.out.println(elementPrice.findElement(By.className("value")).getText());
            }

        }finally {
            driver.quit(); //세션 종료도 해줘야 한다.브라우저 세션이 끝나면 닫기 대신 종료를 호출한다.
        }




    }
}
