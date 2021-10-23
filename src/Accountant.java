import java.util.function.Predicate;
import java.util.stream.*;
import java.util.List;

public class Accountant {

    public Accountant(){}

    public void paySalary(Employee employee){
        System.out.println("работнику:");
        System.out.println("name: " + employee.getName() +"; age: " + employee.getAge() +
               "; dept: " + employee.getDept() + "; role: " + employee.getRole());
        System.out.println("было выдано в качестве зарплаты: " + employee.getRole().salary + " rub." + '\n');
    }

    public void payPremium(Employee employee){
        System.out.println("работнику:");
        System.out.println("name: " + employee.getName() +"; age: " + employee.getAge() +
                "; dept: " + employee.getDept() + "; role: " + employee.getRole());
        System.out.println("было выдано в качестве премии: " +
                (employee.getRole().percent)*(employee.getRole().salary)+" rub." + '\n');
    }

}
