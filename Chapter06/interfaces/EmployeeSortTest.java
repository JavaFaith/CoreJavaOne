package Chapter06.interfaces;

/**
 * This program demonstrates the use of the Comparable interface
 * @version 1.30 2022-02-16
 * @author Robin Wan
 */

import java.util.Arrays;

public class EmployeeSortTest {
    public static void main(String[] args){
        /*
         * 以下是劣质写法
         */
//        Employee jack = new Employee("Jack",20000);
//        Employee faker = new Employee("Faker",35000);
//        Employee robin = new Employee("Robin",7777);
//        Employee[] sortedSalary = {jack,faker,robin};

        //这样是原书写法
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Jack",20000);
        staff[1] = new Employee("Faker",35000);
        staff[2] = new Employee("Robin",7777);

        Arrays.sort(staff);
        for(Employee e : staff){
            System.out.println("工资由低到高依次姓名是 " + e.getName() +" 工资是 " + e.getSalary());
        }
    }
}
