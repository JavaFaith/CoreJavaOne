package Chapter06.innerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class InnerClassTestForMe {
    public static void main(String[] args){
        TalkingClockForMe clock = new TalkingClockForMe(1000,true);
        clock.start();

        JOptionPane.showMessageDialog(null,"Quit program");
        System.exit(0);
    }
}

class TalkingClockForMe{
    private int interval;
    private boolean beep;

    public TalkingClockForMe(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start() {
        ActionListener listener = new TimerClock();
        Timer time = new Timer(interval, listener);
        time.start();
    }

    public class TimerClock implements ActionListener {
        //为实现ActionListener重写actionPerformed(),对象只要被创建就会被执行
        public void actionPerformed(ActionEvent e) {
            System.out.println("At the time,the time is " + new Date());
            if (beep) Toolkit.getDefaultToolkit().beep();
        }

        public void isExecute() {
            System.out.println("IS it must execute");
        }
    }
}


