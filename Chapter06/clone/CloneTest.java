package Chapter06.clone;

/**
 * This program demonstrates cloning.
 * @version 1.10 2022-03-03
 * @author Robin Wan
 */
public class CloneTest {
    public static void main(String[] args){
        try{
            Employee original = new Employee("john Q. Public",50000);
            original.setHireDay(2000,1,1);
            Employee copy = original.clone();
            //copy.raiseSalary(10);
            copy.setHireDay(2022,3,3);
            System.out.println("original=" + original);
            System.out.println("copy=" + copy);
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }


    }
}
