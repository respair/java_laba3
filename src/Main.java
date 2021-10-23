import java.util.function.Predicate;
import java.util.stream.*;
import java.util.List;


public class Main {
    public static void main(String[] args){
        List<Employee> l = Employee.createShortList();
        Accountant acc = new Accountant();

        List<Employee> emp = l.stream()
                .filter(l1 -> l1.getAge() > 30)
                .filter(l1 -> l1.getDept() == 2 || l1.getDept() == 1)
                .collect(Collectors.toList());

        System.out.println("*** премии людям старше 30, работающим в 1 и 2 отделах ***");
        for (Employee e : emp){
            acc.payPremium(e);
        }

        List<Employee> emp2 = l.stream()
                .filter(l1 -> l1.getGender() == Gender.FEMALE)
                .collect(Collectors.toList());

        System.out.println("*** премии женщинам ***");
        for (Employee e : emp2){
            acc.payPremium(e);
        }

        List<Employee> emp3 = l.stream()
                .filter(l1 -> l1.getDept() == 3)
                .collect(Collectors.toList());

        System.out.println("*** зарплата людям из 3 отдела ***");
        for (Employee e : emp3){
            acc.paySalary(e);
        }

        List<Employee> emp4 = l.stream()
                .filter(l1 -> l1.getRole() == Role.MANAGER)
                .collect(Collectors.toList());

        System.out.println("*** зарплата менеджерам ***");
        for (Employee e : emp4){
            acc.paySalary(e);
        }

        List<Employee> emp5 = l.stream()
                .filter(l1 -> l1.getRole() == Role.STAFF)
                .collect(Collectors.toList());

        System.out.println("*** премия стаффу ***");
        for (Employee e : emp5){
            acc.payPremium(e);
        }

    }
}
