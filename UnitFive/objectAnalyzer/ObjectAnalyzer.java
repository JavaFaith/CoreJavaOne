package UnitFive.objectAnalyzer;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
// TODO 2022-01-04 等有时间自己在写一遍
public class ObjectAnalyzer {
    private ArrayList<Object> visted = new ArrayList<>();

    /**
     * Converts an object to a String representation that lists all field
     * @param obj an object
     * @return a string with the object's class name and all field name
     * and values
     * @date 2022-01-04
     */
    public String toString(Object obj){
        //check isnull
        if(obj == null) return "null";
        if(visted.contains(obj)) return "...";
        visted.add(obj);
        Class c1 = obj.getClass();
        //check isString
        if(c1 == String.class) return (String)obj;
        //check isArray
        if(c1.isArray()){
            String r = c1.getComponentType() + "[]{";
            for(int i = 0;i < Array.getLength(obj);i++){
                if(i > 0) r += ",";
                Object val = Array.get(obj,i);
                if(c1.getComponentType().isPrimitive()) r += val;
                // 非基本值，递归重新进来判断
                else r += toString(val);
            }
            return r + "}";
        }

        String r = c1.getName();
        //inspect the fields of this class and all superClasses
        do{
            r += "[";
            Field[] fields = c1.getDeclaredFields();
            //让私有域可以被访问,必须使用JDK1.8以下的SDK，否则报错，java9引入了强封装，简单来说就是无法调用private的field
            //只能更换JDK版本，https://www.cnblogs.com/stcweb/articles/15114266.html可参考(没看懂)
            AccessibleObject.setAccessible(fields,true);

            //get the names and values of all fields
            for(Field f : fields){

                if(!Modifier.isStatic(f.getModifiers())){
                    if(!r.endsWith("[")) r += ",";
                    r += f.getName() + "=";
                    try{
                        Class t = f.getType();
                        Object val = f.get(obj);
                        if(t.isPrimitive()) r += val;
                        //继续递归
                        else r += toString(val);
                    }catch(Exception e){
                        e.printStackTrace();
                    }

                }
            }
            r += "]";
            c1 = c1.getSuperclass();
        }while(c1 != null);
        return r;
    }
}
