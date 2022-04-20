package Chapter06.StaticInnerClass;

/**
 * This program demonstrates the use of static inner class
 * @version 1.02 2022-04-20
 * @author Robin Wan
 */
public class StaticInnerClassTest {
    public static void main(String[] args){
        double[] d =new double[20];
        for(int i = 0;i < d.length;i++){
            d[i] = 100*Math.random();
            System.out.println("This number is " + d[i]);
        }
        ArrayAlg.Pair p = ArrayAlg.minmax(d);
        System.out.println("min = " + p.getFirst());
        System.out.println("max = " + p.getSecond());
    }
}

class ArrayAlg{
    /**
     * A pair of floating-point numbers
     */
    public static class Pair{
        private double first;
        private double second;

        /**
         * Constructs a pair from two floating-point numbers
         * @param f the first number
         * @param s the second number
         */
        public Pair(double f,double s){
            this.first = f;
            this.second = s;
        }

        /**
         * Returns the first number of the pair
         * @return the first number
         */
        public double getFirst(){
            return first;
        }

        /**
         * Returns the second number of the pair
         * @return the second number
         */
        public double getSecond(){
            return second;
        }

    }
    /**
     * Computes both the minimum and the maximum of an array
     * @param values an array of floating-point numbers
     * @return a pair whose first elements is the minimum and whose second
     * elements is the maximum
     */
    /*
     * TODO 为什么POSITIVE_INFINITY表示最小值，POSITIVE_INFINTY不是正无穷么应该是最大值
     *
     */
    //应该是最大值
    public static Pair minmax(double[] values){
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;

        for(double v : values){
            if(min > v) min = v;
            if(max < v) max = v;
        }

        return (new Pair(min,max));
    }
}
