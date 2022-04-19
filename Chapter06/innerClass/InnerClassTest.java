package Chapter06.innerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * This program demonstrates the use of inner class.
 * @version 1.11 2022-04-14
 * @author Robin Wan
 */
public class InnerClassTest {
    public static void main(String[] args){
        TalkingClock clock = new TalkingClock(1000,true);
        clock.start();

        //keep program running util user select "OK"
        JOptionPane.showMessageDialog(null,"Quit program");
        System.exit(0);
    }
}

/**
 * A clock that prints the time in regular intervals.
 */

class TalkingClock {
    private int interval;
    private boolean beep;

    /**
     * Constructs a talking clock
     * @param interval the interval between messages(in milliseconds)
     * @param beep true if the clock should beep
     */
    public TalkingClock(int interval,boolean beep){
        this.interval = interval;
        this.beep = beep;
    }

    /**
     * Starts the clock
     */
    public void start(){
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(interval,listener);
        t.start();
    }

    //timePrinter类变成了listener，timer调用start方法会执行监听器,
    //简单来说actionPerForemer 已经不是一个单独的方法，只是实现类里面一个必要的方法
    //如果是单独的方法是需要调用才可以执行
    //Robin Wan 2022-04-19
    public class TimePrinter implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent event) {
            System.out.println("At the time, the time is " + new Date());
            if(beep) Toolkit.getDefaultToolkit().beep();
        }
    }
}
