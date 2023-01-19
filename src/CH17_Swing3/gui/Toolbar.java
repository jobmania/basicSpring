package CH17_Swing3.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JToolBar {


    private static final long serialVersionUID = 1L;

    public Toolbar(MainPanel mainPanel){
        final JButton redButton = new JButton("RED");
        final JButton blueButton = new JButton("BLUE");

//        redButton.addActionListener(new ColorButtonListener(mainPanel, Color.YELLOW));
//        blueButton.addActionListener(new ColorButtonListener(mainPanel, Color.BLUE));




        /**
         * 익명 클래스
         * */
        redButton.addActionListener(new ActionListener( ) {
            public void actionPerformed(ActionEvent e) {
                mainPanel.setBackground(Color.RED);
            }
        });


        blueButton.addActionListener(new ActionListener( ) {
            public void actionPerformed(ActionEvent e) {
                mainPanel.setBackground(Color.BLUE);
            }
        });


        add(redButton);
        add(blueButton);
    }
}
