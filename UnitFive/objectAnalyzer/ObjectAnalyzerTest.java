package UnitFive.objectAnalyzer;
/**
 * This program uses reflection to spy on objects
 * @date 2021-12-30
 * @author Robin Wan
 */

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ObjectAnalyzerTest {
    public static void main(String[] args){
        ArrayList<Integer> squares = new ArrayList<>();
        for(int i = 1;i <= 5;i++){
            squares.add(i*i);
        }
        System.out.println(new ObjectAnalyzer().toString(squares));
    }

}
