package CH13_swing.gui;

import javax.swing.*;

public class Toolbar extends JToolBar {

    private static final long serialVersionUID = 1L;

    public Toolbar(){
        add(new JButton("버튼1"));
        add(new JButton("버튼2"));

    }
}
