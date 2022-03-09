package Chapter06.lambda;

import javax.swing.*;
import java.util.Arrays;
import java.util.Date;


/**
 * This program demonstrates the use of lambda expression
 * @version 1.0 2022-03-09
 * @author Robin Wan
 */
public class LambdaTest {
    public static void main(String[] args){
        String[] planets = new String[]{"Mercury","Venus","Earth","Mars",
                "Jupiter","Saturn","Uranus","Neptune"};
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted in dictionary order:");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted bt length");
        Arrays.sort(planets,(first,second) -> first.length() - second.length());
        System.out.println(Arrays.toString(planets));

        Timer t = new Timer(1000, event -> System.out.println("The time is " + new Date()));
        t.start();

        //keep program running util user select "ok"
        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }
}