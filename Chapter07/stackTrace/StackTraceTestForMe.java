package Chapter07.stackTrace;

import java.util.Scanner;

public class StackTraceTestForMe {
    public static int factorial(int n){
        // 只能写在最前面，因为会用到递归
        System.out.println("factorial (" + n + ")");
        Throwable t = new Throwable();
        StackTraceElement[] frames = t.getStackTrace();
        for(StackTraceElement e : frames)
            System.out.println(e);
        int result;
        if( n <= 1) result = 1;
        else result = n*factorial(n-1);
        System.out.println(result);
        return result;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter r: ");
        //接受值
        int input = in.nextInt();
        factorial(input);
    }
}
