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
            //name = in.next();
            name = "java.lang.Double";
            try{
                Class c1 = Class.forName(name);
                Class superClassC1 = c1.getSuperclass();
                String modifiers = Modifier.toString(c1.getModifiers());
                System.out.print(modifiers + " ");
                if(modifiers.length() > 0){
                    System.out.print("class " + name + " ");
                }
                if(superClassC1 != null && superClassC1 != Object.class){
                    System.out.print("extends " + superClassC1.getName());
                }
                System.out.println("");
                System.out.println("");
                printConstructors(c1);
                System.out.println("");
                System.out.println("");
                printMethods(c1);
                System.out.println("");
                System.out.println("");
                printFields(c1);
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }

        }
    }
    public static void printConstructors(Class c1){
        Constructor[] constructors = c1.getDeclaredConstructors();
        for(Constructor c : constructors){
            String modifier = Modifier.toString(c1.getModifiers());
            String name = c.getName();
            System.out.print(modifier + " " + name + "(");
            Class[] parameter = c.getParameterTypes();
            for(Class c2 : parameter){
                if(parameter.length > 1){
                    System.out.print(",");
                }
                System.out.print(c2.getName() + "");
            }
            System.out.print("); ");

        }

    }

    public static void printMethods(Class c1){

        Method[] methods = c1.getDeclaredMethods();
        for(Method m1 : methods){
            String modifier = Modifier.toString(m1.getModifiers());
            Class retType = m1.getReturnType();

            System.out.print(modifier + " " + retType.getName()+ " "+ m1.getName() + " (");
            Class[] parameters = m1.getParameterTypes();
            for(int j = 0;j<parameters.length;j++){
                if(j>0){
                    System.out.print(",");
                }
                System.out.print(parameters[j].getName());
            }
            System.out.print(")");
            System.out.println(" ");
        }

    }
    public static void printFields(Class c1){
        Field[] fields = c1.getDeclaredFields();

        for(Field f : fields){
            String modifiers = Modifier.toString(f.getModifiers());
            System.out.println(modifiers + " " + f.getType() + " " + f.getName());
        }
    }
}
