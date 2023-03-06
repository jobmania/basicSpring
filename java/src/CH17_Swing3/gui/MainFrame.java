package CH17_Swing3.gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame(String title){
        super(title);
        final MainPanel mainPanel = new MainPanel();


        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);
        add(new Toolbar(mainPanel), BorderLayout.NORTH);


//        mainPanel.setBackground(Color.PINK);
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


        add(mainPanel, BorderLayout.CENTER);
    }
}
