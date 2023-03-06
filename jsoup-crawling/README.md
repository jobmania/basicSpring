## Jsoup 사용방법
태그명 : 태그이름으로 접근
	
select("div") : div 태그를 모두 선택
.이름 : 태그의 속성의 이름이 class 인 것중에서 속성의 값이 이름과 같은것
select(".a") : 태그의 class="a"인 모든 태그를 선택

#값 : 태그의 속성의 이름이 id 인 것중에서 속성의 값이 #뒤의 값과 같은것
select("#a") : 태그의 id="a"인 모든 태그를 선택

a b : a 태그의 자식 태그중에서 b 태그를 모두 선택 (a 태그의 자손 태그까지 모두 선택)
a > b : a 태그의 자식 태그중에서 b 태그를 모두 선택 (a 태그의 바로 밑에 있는 자식만 선택)
select("a b")
select("a > b")
			a
		b		c
	c	d		d	b
select("table > tr td > img.a") : table 밑에 있는 img 클래스 이름이 a 인것 선택 (실제로는 tbody 경로 적어줘야 함)

태그의 속성으로 접근하기
: 태그명[속성명=값]
: 태그명[속성명^=값] : 값으로 시작하는 것
	a[href ^= http]
: 태그명[속성명$=값] : 값으로 끝나는 것
	img[src $= jpg]
: 태그명[속성명*=값] : 값이 포함하는 것
	img[src *= flower]


but Jsoup는 동적스크립트는 크롤링을 못해서!@! 셀레니움으로 크롤링해야함..

---------------------------------------

Selenium 가이드
[https://velog.io/@joyoo1221/%EC%9E%90%EB%B0%94-%EC%85%80%EB%A0%88%EB%8B%88%EC%9B%80selenium%EC%9C%BC%EB%A1%9C-%ED%81%AC%EB%A1%A4%EB%A7%81%ED%95%98%EA%B8%B0-1]
https://www.selenium.dev/documentation/webdriver/elements/finders/