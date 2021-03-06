package Chapter06.StaticInnerClass;

public class StaticInnerClassTestForMe {
    public static void main(String[] args){
        double[] sortDouble = new double[20];
        for(int i = 0;i<sortDouble.length;i++){
            sortDouble[i] = 100*Math.random();
            //System.out.println("The number is " + sortDouble[i]);
        }
        ArrayAlgForMe.Pair  p = ArrayAlgForMe.minmax(sortDouble);
        System.out.println("The minimum is " + p.getFirst());
        System.out.println("The maximum is " + p.getSecond());
    }
}

class ArrayAlgForMe{
    static class  Pair {
        private double first;
        private double second;

        public Pair(double first,double second){
            this.first = first;
            this.second = second;
        }

        public double getFirst(){
            return first;
        }
        public double getSecond(){
            return second;
        }
    }

    public static Pair minmax(double[] values){
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
        for(double value : values){
            if(min > value) min = value;
            if(max < value) max = value;
        }
        return (new Pair(min,max));

    }
}
