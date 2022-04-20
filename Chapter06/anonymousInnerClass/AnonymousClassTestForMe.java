package Chapter06.anonymousInnerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class AnonymousClassTestForMe {
    public static void main(String[] args){
        TalkingClockForMe clockForMe = new TalkingClockForMe();
        clockForMe.start(100,true);
        JOptionPane.showMessageDialog(null,"quit program");
        System.exit(0);
    }

}

class TalkingClockForMe {
   public void start(int interval,boolean beep){
       /*
        * anonymous inner Class
        */
//       ActionListener listener = new ActionListener() {
//           @Override
//           public void actionPerformed(ActionEvent e) {
//               System.out.println("It is time to " + new Date());
//               if(beep) Toolkit.getDefaultToolkit().beep();
//           }
//       };

//       Timer time = new Timer(interval,listener);
//       time.start();
       /*
        lambda expression
        */
       Timer time = new Timer(interval,event ->{
           System.out.println("It is time to " + new Date());
           if(beep) Toolkit.getDefaultToolkit().beep();
       });
       time.start();
   }

}


