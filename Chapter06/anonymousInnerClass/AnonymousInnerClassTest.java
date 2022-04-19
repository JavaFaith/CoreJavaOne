package Chapter06.anonymousInnerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * This program demonstrates anonymous inner classes
 * @version 1.11 2022-04-19
 * @author Robin Wan
 */
public class AnonymousInnerClassTest {
    public static void main(String[] args){
        TalkingClock clock = new TalkingClock();
        clock.start(100,true);

        //keep program running util user selects "OK"
        JOptionPane.showMessageDialog(null,"Quit program");
        System.exit(0);
    }

}

/*
* A clock that prints the time in regular intervals
*/
class  TalkingClock{
    /**
     * Start the clock.
     * @param interval the interval between messages (in milliseconds)
     * @param beep true if the clock should beep
     */

    public void start (int interval , boolean beep){
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("At the tone, the time is " + new Date());
                if(beep) Toolkit.getDefaultToolkit().beep();
            }
        };
        Timer time = new Timer(interval,listener);
        time.start();
        // TODO 也可以使用lambda表达式
//        Timer time = new Timer(interval,event -> {
//            System.out.println("At the tone, the time is " + new Date());
//            if(beep) Toolkit.getDefaultToolkit().beep();
//        }
//        time .start();
    }

}
