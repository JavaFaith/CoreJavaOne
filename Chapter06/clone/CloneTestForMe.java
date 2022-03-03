package Chapter06.clone;

public class CloneTestForMe {
    public static void main(String[] args){
        try{
            EmployeeForMe employee = new EmployeeForMe("Robin",7000);
            employee.setHireDay(2000,10,1);
            EmployeeForMe copy = employee.clone();
            employee.setHireDay(2022,9,30);

            System.out.println(employee);
            System.out.println(copy);
        } catch(CloneNotSupportedException e){
            e.printStackTrace();
        }

    }
}
