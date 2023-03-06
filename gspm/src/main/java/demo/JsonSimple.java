package demo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class JsonSimple {
    public static void main(String[] args) throws IOException {

        int page = 1;
        int perPage = 10;

        String endPoint = "https://api.odcloud.kr/api/15077586/v1/centers";
        String parameter = "?" + "page=" + page + "&perPage=" + perPage;
        String serviceKey = "&serviceKey="+"GIg%2B6cR2BQpwkkfyaCJKV75pwxDbREX6EWbBYftWROxzo6cBJBnT7vmKcNo4hhxUj0JfTeMRg6wfJPwY820CRA%3D%3D";

        // 공공데이터 요청 주소..
//        String uri = endPoint + parameter + serviceKey;

        StringBuilder urlBuilder = new StringBuilder(endPoint); /*URL*/

        urlBuilder.append("?" + URLEncoder.encode("page","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("perPage","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("serviceKey","UTF-8") + "=GIg%2B6cR2BQpwkkfyaCJKV75pwxDbREX6EWbBYftWROxzo6cBJBnT7vmKcNo4hhxUj0JfTeMRg6wfJPwY820CRA%3D%3D"); /*Service Key*/
//        urlBuilder.append("&" + URLEncoder.encode("addr","UTF-8") + "=" + URLEncoder.encode("전라남도 나주시 빛가람동 120", "UTF-8")); /*검색대상 충전소주소*/
//

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
//        System.out.println(sb.toString());
        JSONParser jsonParser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(sb.toString());
            JSONArray array = (JSONArray) jsonObject.get("data");

            for (Object o : array) {
              JSONObject ob = (JSONObject) o;
                System.out.print(ob.get("id") + "\t");
                System.out.print(ob.get("facilityName") + "\t");
                System.out.print(ob.get("address") + "\t");
                System.out.print(ob.get("org") + "\t");
                System.out.print(ob.get("createdAt") + "\t");
                System.out.println(ob.get("phoneNumber"));

            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }




    }
}
