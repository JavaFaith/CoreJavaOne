package UnitFive.methods;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodTableTestForAgain {
    public static void main(String[] args) throws NoSuchMethodException {
        Method square = MethodTableTestForAgain.class.getMethod("square",double.class);
        Method sqrt = Math.class.getMethod("sqrt", double.class);

        printTable(5,25,10,square);
        printTable(5,25,10,sqrt);
    }

    public static void printTable(double from,double to,int n,Method f){
        //先打印表头
        System.out.println(f.getName());
        /*
         * 这就是等差数列求公差，这个DX就是公差，时隔多年居然会用到等差数列，泪目
         * 通项公式an=a1+(n-1)*d，d=(an-a1)/(n-1)
         */
        //TODO 这个算数优先级问题，一定要加括号，不然会出现诡异值，暂不清楚不加括号是如何运算的
        //TODO 要后续重点研究下这个运算优先级的问题
        double dx = (to-from) / (n - 1);
        for(double x = from;x <= to;x += dx){
            try{
                double y = (Double)f.invoke(null,x);
                System.out.printf("%10.4f | %10.4f%n",x,y);
            }catch (Exception e){
                e.printStackTrace();
            }


        }

    }


    public static double square(double x){
        return x*x;
    }
}
