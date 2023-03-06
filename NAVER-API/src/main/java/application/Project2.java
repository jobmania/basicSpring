package application;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.RenderedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Project2 {
    public static void main(String[] args) throws IOException, ParseException {
        //네이버 api 지오코딩을 이용해 주소를 좌표값으로 변환.

        Scanner scanner = new Scanner(System.in);
        System.out.println("주소를 입력 : ");
        String address = scanner.nextLine();
        scanner.close();


        StringBuilder urlBuilder = new StringBuilder("https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query="); // URL

        urlBuilder.append(URLEncoder.encode(address, "UTF-8"));  // 주소를 인코딩

        String set = "129.0756416, 35.1795543";
        urlBuilder.append("&coordinate="); // 부산 위도 경도..
        urlBuilder.append(URLEncoder.encode(set, "UTF-8"));



        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();  // http 연결

        conn.setRequestMethod("GET");
//        conn.setRequestProperty("Content-type","application/json");  // 제이슨으로 줘서 필요 없는듯?
        conn.setRequestProperty("X-NCP-APIGW-API-KEY-ID", "ywu2wqjm9z");
        conn.setRequestProperty("X-NCP-APIGW-API-KEY", "hIAqxfsbM2UVHCBj40JJLJWqfT1MO315FTJl4TQx");
        System.out.println("Response code: " + conn.getResponseCode());


        BufferedReader br;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        } else {
            br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }


        String result = br.readLine();
        br.close();
        conn.disconnect();

//        System.out.println(result);

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
        JSONArray arr = (JSONArray) jsonObject.get("addresses");


        String x = null;
        String y = null;
        String address1 = null;

        for (Object o : arr) {
            JSONObject ob = (JSONObject) o;
            System.out.println(" 주소는 " + ob.get("roadAddress"));
            System.out.println(" 지번주소는 " + ob.get("jibunAddress"));
            List<Object> addressElements = (List<Object>) ob.get("addressElements");
            JSONObject o1 = (JSONObject) addressElements.get(0);
            JSONObject o2 = (JSONObject) addressElements.get(1);
            JSONObject o3 = (JSONObject) addressElements.get(2);
            System.out.println("시도는 " + o1.get("longName") + " 시군은  " + o2.get("longName") + " 동면은 " + o3.get("longName"));
            System.out.println("위도는 " + ob.get("x"));
            System.out.println("경도는 " + ob.get("y"));
            System.out.println("거리는 " + ob.get("distance"));

            x = (String) ob.get("x");
            y = (String) ob.get("y");
            address1 = (String) ob.get("roadAddress");

            mapService(x, y, address1);
        }

    }

    private static void mapService(String x, String y, String address) throws IOException {

        String mapUrl = "https://naveropenapi.apigw.ntruss.com/map-static/v2/raster?";
        String pos = URLEncoder.encode(x + " " + y, "UTF-8");  // 인코딩 하는 이유, 한칸 띄움이 있음!

        mapUrl += "w=700&h=500&level=16&center=";
        mapUrl += x + "," + y;
        mapUrl += "&markers=type:t|size:mid|pos:" + pos + "|label:" + URLEncoder.encode(address, "UTF-8");  // 라벨 이름 입력 ..

        URL url = new URL(mapUrl);


        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("X-NCP-APIGW-API-KEY-ID", "ywu2wqjm9z");
        conn.setRequestProperty("X-NCP-APIGW-API-KEY", "hIAqxfsbM2UVHCBj40JJLJWqfT1MO315FTJl4TQx");



        BufferedReader br;
        int responseCode = conn.getResponseCode();
        if (responseCode == 200) { //OK
            InputStream is = conn.getInputStream();
            Image image = ImageIO.read(is);


            //랜덤한 이름파일 생성..
            String tempName = UUID.randomUUID() + address;
            File f = new File(tempName + ".jpg");
            f.createNewFile();
            ImageIO.write((RenderedImage) image, "jpg", f);
            is.close();
        } else {
            br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            conn.disconnect();
            System.out.println(response.toString());
        }




    }
}
