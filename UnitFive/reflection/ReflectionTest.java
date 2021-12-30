package UnitFive.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * This program uses reflection to print all features of a class
 * @version 1.1
 * @author Robin Wan
 * @date 2021-12-27
 */
public class ReflectionTest {
    public static void main(String[] args){
        //read class name from command line args or user input
        String name;
        if(args.length > 0){
            name = args[0];
        }else{
            Scanner in = new Scanner(System.in);
            System.out.println("Enter class name (e.g. java.util.Date):");
            name = in.next();
        }
        try{
            //print class name and superClass name (if != object)
            Class c1 = Class.forName(name);
            Class superc1 = c1.getSuperclass();
            String modifiers = Modifier.toString(c1.getModifiers());
            if(modifiers.length()>0){
                System.out.print(modifiers + " ");
            }
            System.out.print("class " + name);
            if(superc1 != null && superc1 != Object.class){
                System.out.print(" extends" + superc1.getName());
            }
            //print constructor method and field
            System.out.print("\n{\n");
            printConstructors(c1);
            System.out.println();
            printMethod(c1);
            System.out.println();
            //printFields(c1);
            System.out.println("}");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        System.exit(0);
    }

    /**
     * Print all constructors of a class
     * @param c1 a class
     */
    public static void printConstructors(Class c1){
        Constructor[] constructors = c1.getDeclaredConstructors();
        for(Constructor c : constructors){
            String name  = c.getName();
            System.out.print(" ");
            String modifiers = Modifier.toString(c.getModifiers());
            if(modifiers.length() > 0 ){
                System.out.print(modifiers + " ");
            }
            System.out.print(name + "(");

            //print parameter types
            Class[] paramTypes = c.getParameterTypes();
            for(int j = 0;j < paramTypes.length;j++){
                if(j > 0){
                    System.out.print(",");
                }
                System.out.print(paramTypes[j].getName());
            }
            System.out.print(");");
        }
    }

    /**
     * Prints all methods of a class
     * @param c1 a class
     */
    public static void printMethod(Class c1){
        Method[] methods = c1.getDeclaredMethods();

        for(Method m : methods){
            Class retType = m.getReturnType();
            String name = m.getName();

            System.out.print(" ");
            //print modifiers,return type and method name
            String modifiers = Modifier.toString(m.getModifiers());
            if(modifiers.length() > 0){
                System.out.print(modifiers + " ");
            }
            System.out.println(retType.getName() + "" + name + "(");
            //print parameter types
            Class[] paramTypes = m.getParameterTypes();
            for(int j = 0; j < paramTypes.length;j++){
                if(j>0){
                    System.out.println(",");
                }
                System.out.print(paramTypes[j].getName());
            }
            System.out.print(");");
            System.out.println("");
        }
    }

    /**
     * Prints all fields of a class
     * @param c1 a class
     */
    public static void printFields(Class c1){
        Field[] fields = c1.getDeclaredFields();

        for(Field f : fields){
            Class type = f.getType();
            String name = f.getName();
            System.out.println(" ");
            String modifiers = Modifier.toString(f.getModifiers());
            if(modifiers.length() > 0){
                System.out.print(modifiers + " ");
            }
            System.out.print(type.getName() + " " + name + ";");
        }
    }
}
