package CH15_Swing2.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JToolBar {


    private static final long serialVersionUID = 1L;

    public Toolbar(MainPanel mainPanel){
        final JButton redButton = new JButton("RED");
        final JButton blueButton = new JButton("BLUE");

        redButton.addActionListener(new ColorButtonListener(mainPanel, Color.YELLOW));
        blueButton.addActionListener(new ColorButtonListener(mainPanel, Color.BLUE));

        add(redButton);
        add(blueButton);
    }
}

class ColorButtonListener implements ActionListener{

    MainPanel mainPanel;
    Color color;

    public ColorButtonListener(MainPanel mainPanel, Color color) {
        this.mainPanel = mainPanel;
        this.color = color;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        mainPanel.setBackground(color);
    }
}
















//class RedListener implements ActionListener{
//
//    MainPanel mainPanel;
//    public RedListener(MainPanel mainPanel) {
//       this.mainPanel = mainPanel;
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("빨");
//        mainPanel.setBackground(Color.RED);
//
//    }
//}
//
//
//class BlueListener implements ActionListener{
//    MainPanel mainPanel;
//    public BlueListener(MainPanel mainPanel) {
//        this.mainPanel = mainPanel;
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("파");
//        mainPanel.setBackground(Color.BLUE);
//    }
//}