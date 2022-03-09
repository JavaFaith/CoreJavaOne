package Chapter06.lambda;

import javax.swing.*;
import java.util.Arrays;
import java.util.Date;

public class LambdaTestForMe {
    public static void main(String[] args){
        String[] planets = new String[]{"Mercury","Venus","Earth","Mars",
                "Jupiter","Saturn","Uranus","Neptune"};
        System.out.println(Arrays.toString(planets));
        System.out.println("Sort start!");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));

        System.out.println("Sort by length Start!");
        //Arrays.sort(planets,(String first,String second) -> { return first.length() - second.length();});
        Arrays.sort(planets,(first,second) -> first.length() - second.length());
        System.out.println(Arrays.toString(planets));

        Timer time = new Timer(1000,event -> System.out.println("现在是" + new Date()));
        time.start();

        JOptionPane.showMessageDialog(null,"quit window");
        System.exit(0);
    }
}
