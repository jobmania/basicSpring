package gui;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.RenderedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.UUID;

public class MainFrame extends JFrame {
    public static final long serialVersionUID = 1L;

    public JTextField address;
    public JLabel resAddress, resX, resY, jibunAddress, imageLabel;

    public MainFrame(String title) {
        super(title);

        //주소입력창, 클릭버튼
        JPanel pan = new JPanel();
        JLabel addressLbl = new JLabel("주소 입력");
        address = new JTextField(40);  // 입력창
        JButton btn = new JButton("클릭");
        pan.add(addressLbl); // 제목
        pan.add(address);  //입력창
        pan.add(btn);  // 버튼

        //버튼 클릭시
        btn.addActionListener(e -> {
            try {
                new NaverMap(this);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
        });

        //가운데 정렬

        JPanel pan1 = new JPanel();
        imageLabel = new JLabel("지도");
        resAddress = new JLabel("도로명");
        jibunAddress = new JLabel("지번");
        resX = new JLabel("위도");
        resY = new JLabel("경도");




        pan1.add(resAddress);
        pan1.add(jibunAddress);
        pan1.add(resX);
        pan1.add(resY);

        setLayout(new BorderLayout());
        add(BorderLayout.NORTH, pan);
        add(BorderLayout.CENTER, imageLabel);
        add(BorderLayout.SOUTH, pan1);




        setSize(730,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


    }





    private static void mapService(String x, String y, String address) throws IOException, ParseException {

        String mapUrl = "https://naveropenapi.apigw.ntruss.com/map-static/v2/raster?";
        String pos = URLEncoder.encode(x + " " + y, "UTF-8");  // 인코딩 하는 이유, 한칸 띄움이 있음!

        mapUrl += "w=700&h=500&level=16&center=";
        mapUrl += x + "," + y;
        mapUrl += "&markers=type:t|size:mid|pos:" + pos + "|label:" + URLEncoder.encode(address, "UTF-8");  // 라벨 이름 입력 ..

        URL url = new URL(mapUrl);


        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("X-NCP-APIGW-API-KEY-ID", "ywu2wqjm9z");
        Reader reader = new FileReader("C:\\Users\\admin\\IdeaProjects\\NAVER-API\\src\\main\\java\\application\\secretKey.json");
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
        String secretKey = (String) jsonObject.get("secretKey");
        conn.setRequestProperty("X-NCP-APIGW-API-KEY", secretKey);


        BufferedReader br;
        int responseCode = conn.getResponseCode();
        if (responseCode == 200) { //OK
            InputStream is = conn.getInputStream();
            Image image = ImageIO.read(is);        // 이미지 상태로


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
