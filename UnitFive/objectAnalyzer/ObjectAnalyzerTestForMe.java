package UnitFive.objectAnalyzer;



import java.util.ArrayList;

public class ObjectAnalyzerTestForMe {
    public static void main(String[] args){
        ArrayList<Integer> array = new ArrayList<>();
        for(int i = 1;i <= 5;i++){
            array.add(i*i);
        }
        System.out.println(new ObjectAnalyzerForMe().toString(array));
    }
}
