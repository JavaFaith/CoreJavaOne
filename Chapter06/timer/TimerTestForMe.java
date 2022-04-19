package Chapter06.timer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TimerTestForMe {
    public static void main(String[] agrs) {
        ActionListener actionListener = new TimePrinterForMe();
        Timer timer = new Timer(1000, actionListener);
        timer.start();
        JOptionPane.showMessageDialog(null, "Quit program");
        System.exit(0);
    }
}

    class TimePrinterForMe implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.out.println("当前时间是 " + new Date());
            Toolkit.getDefaultToolkit().beep();
        }
    }

