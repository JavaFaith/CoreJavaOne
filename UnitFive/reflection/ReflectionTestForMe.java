package UnitFive.reflection;

import java.util.Scanner;
import java.lang.reflect.*;
public class ReflectionTestForMe {
    public static void main(String[] args){
        String name;
        if(args.length> 0){
            name = args[0];
        }else{
            Scanner in = new Scanner(System.in);
            System.out.println("Please enter the content you want to inquire");
            name = in.next();
            try{
                Class c1 = Class.forName(name);
                Class superClassC1 = c1.getSuperclass();
                String modifiers = Modifier.toString(c1.getModifiers());
                System.out.print(modifiers + " ");
                if(modifiers.length() > 0){
                    System.out.print("class " + name);
                }
                if(superClassC1 != null && superClassC1 != Object.class){
                    System.out.print("extends " + superClassC1.getName());
                }
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }

        }
    }
}
