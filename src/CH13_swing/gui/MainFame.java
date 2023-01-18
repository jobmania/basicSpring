package CH13_swing.gui;

import javax.swing.*;
import java.awt.*;

public class MainFame extends JFrame {
    public MainFame(String name){
        super(name);

        setLayout(new BorderLayout()); // 창에 화면배치를 위한 레이아웃설정.. 컴포넌트 버튼을 붙이기 위함..
        add(new Toolbar(), BorderLayout.NORTH);
        add(new MainPanel(),BorderLayout.CENTER); // 메인프레임에 붙이기 (가운데)


        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
