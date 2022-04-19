package Chapter06.innerClass;
/**
 * @author Robin Wan
 * @date 2022-04-19
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class InnerClassTestForMe {
    public static void main(String[] args){
        TalkingClockForMe clock = new TalkingClockForMe(true,1000);
        clock.start();
        JOptionPane.showMessageDialog(null,"quit program");
        //退出
        System.exit(0);

    }
}

class TalkingClockForMe{
   private boolean beep;
   private int interval;

   public TalkingClockForMe(boolean beep,int interval){
       this.beep = beep;
       this.interval = interval;
   }
   public void start(){
        ActionListener listener = new TimerPrinterForMe();
        Timer time = new Timer(interval,listener);
        time.start();
   }

   public class TimerPrinterForMe implements ActionListener{
       public void actionPerformed(ActionEvent e) {
           System.out.println("It is time " + new Date());
           if(beep) Toolkit.getDefaultToolkit().beep();
       }
   }
}


