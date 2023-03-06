package CH26_Stream.ex_1;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.w3c.dom.css.CSSValue;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Quiz1 {

    private List<String[]> readCsvLines() throws IOException, CsvException {
        CSVReader csvReader = new CSVReader(new FileReader("user.csv"));
        csvReader.readNext(); // 제목줄 읽기
        return csvReader.readAll();
    }

    public static void main(String[] args) throws IOException, CsvException {
        Quiz1 q1 = new Quiz1();
        q1.readCsvLines().forEach(arr -> System.out.println(String.join(",", arr)));
        System.out.println("================");
        System.out.println(q1.quiz1());
        System.out.println("=============");
        System.out.println(q1.quiz2());
        System.out.println("=============");
        System.out.println(q1.quiz3());


    }

    // 1.1 각 취미를 선호하는 인원이 몇 명인지 계산하여라.
    public Map<String, Integer> quiz1() throws IOException, CsvException {
        List<String[]> csvLines = readCsvLines();
        return csvLines.stream()
                .map(line -> line[1].replaceAll("\\s", ""))  // 공백 제거
                .flatMap(hobbies -> Arrays.stream(hobbies.split(":")))// 개발:축구:농구: -> 개발 /  하나씩 분리하여 스트림으로
                .collect(Collectors.toMap(hobby -> hobby, hobby -> 1, (oldValue, newValue) -> newValue += oldValue));  // 중복된 값은 이전 값을 더해줌 //
        // Map 변환중 중복키가 발생할 경우 ..
        // 기존 값을 유지할 경우
        // .collect(Collectors.toMap(vo->vo, vo->vo, (oldValue, newValue) -> oldValue));
        // 새로운 값을 유지할 경우
        // .collect(Collectors.toMap(vo->vo, vo->vo, (oldValue, newValue) -> newValue));
        //https://osc131.tistory.com/148
    }




//    1.2 위와 같은 데이터를 조회하여 각 취미를 선호하는 정씨 성을 갖는 인원이 몇 명인지 계산하여라.

    public Map<String, Integer> quiz2() throws IOException, CsvException {
        List<String[]> csvLines = readCsvLines();
        return csvLines.stream()
                .filter(line -> line[0].startsWith("정"))
                .map(line -> line[1].replaceAll("\\s", ""))
                .flatMap(hobbies -> Arrays.stream(hobbies.split(":")))
                .collect(Collectors.toMap(hobby -> hobby, hobby -> 1, (oldValue, newValue) -> ++newValue));
    }

//1.3 위와 같은 데이터를 조회하여 소개 내용에 '좋'가 몇번 등장하는지 계산하여라.

	public int quiz3() throws IOException, CsvException {
		List<String[]> csvLines = readCsvLines();
		return csvLines.stream()
				.map(line -> countContains(line[2], 0))
                .reduce(0, Integer::sum);   //  Stream에서 전달되는 요소들의 숫자를 모두 합
	}

    private int countContains(String src, int fromIndex) {
        int index = src.indexOf("좋", fromIndex);  // index =  -1은 값이 없음을 의미
        if (index >= 0) {
            return 1 + countContains(src, index + "좋".length());
        }
        return 0;
    }




}