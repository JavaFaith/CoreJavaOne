package Chapter07.stackTrace;

import java.util.Scanner;

// 2022-04-27 自己完成版
public class StackTraceTestForMeIndepent {
    public static int factorial(int n){
        System.out.println("factorial (" + n + ")");
        Throwable t = new Throwable();
        StackTraceElement[]  frames = t.getStackTrace();
        for(StackTraceElement e : frames)
            System.out.println(e);
        int r;
        if(n <= 1) r = 1;
        else r = n * factorial(n-1);
        System.out.println(r);
        return r;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Please input a number");
        int inputNumber = in.nextInt();
        factorial(inputNumber);
    }
}
