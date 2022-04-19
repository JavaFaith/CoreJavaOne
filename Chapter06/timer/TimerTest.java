package Chapter06.timer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @version 1.01 2022-02-24
 * @author  Robin Wan
 */
public class TimerTest {
    public static void main(String[] args){
        ActionListener listener = new TimePrinter();

        // constrct a timer that calls the listener
        // once every 10 seconds
        Timer t = new Timer(10000,listener);
        t.start();
        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }
}

class TimePrinter implements ActionListener{
    public void actionPerformed(ActionEvent event){
        System.out.println("At the one , the time is " + new Date());
        Toolkit.getDefaultToolkit().beep();
    }
}
