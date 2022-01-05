package UnitFive.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CopyOfTestForMe {
    public static void main(String[] agrs){
        int[] array ={1,2,3};
        int[] newArray = (int[])goodCopy(array,10);
        System.out.println(Arrays.toString(newArray));
    }

    //通过复制同一个数组的方法，进行扩容
    public static Object goodCopy(Object copyArray,int number){
        Class c1 = copyArray.getClass();
        //不是数组，直接退出
        if(!c1.isArray())  return null;
        //获取类型
        Class type =  c1.getComponentType();
        int length = Array.getLength(copyArray);
        //静态方法newInstance方法生成一个新数组
        Object newArray = Array.newInstance(type,number);
        //arrayCopy复制数组内容，最后一个参数意思是复制多少位，取最大公约数
        System.arraycopy(copyArray,0,newArray,0,Math.min(length,Array.getLength(newArray)));
        return newArray;
    }
}
