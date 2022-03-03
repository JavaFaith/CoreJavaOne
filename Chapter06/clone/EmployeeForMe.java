package Chapter06.clone;

import java.util.Date;
import java.util.GregorianCalendar;

public class EmployeeForMe implements  Cloneable{
    private String name;
    private double salary;
    private Date hireDay;

    public EmployeeForMe(String name,double salary){
        this.name = name;
        this.salary = salary;
        hireDay = new Date();
    }

    public EmployeeForMe clone() throws CloneNotSupportedException{
        /*Object.clone()有特殊的语义，他就是能把当前对象的整个结构完全浅拷贝
         *每层clone()都顺着 super.clone() 的链向上调用的话最终就会来到Object.clone()
         */
        EmployeeForMe cloned = (EmployeeForMe)super.clone();
        cloned.hireDay = (Date)hireDay.clone();
        return cloned;
    }

    public double raiseSalary(double byPercent){
        double raisedSalary = salary * byPercent / 100;
        return salary += raisedSalary;
    }

    public void setHireDay(int year,int month,int day){
        Date newHireDay = new GregorianCalendar(year,month-1,day).getTime();
        hireDay.setTime(newHireDay.getTime());

    }

    public String toString(){
        return "Employee [name = "+ name + ",salary = "+ salary + ",hireDay = " + hireDay + "]";
    }
}
