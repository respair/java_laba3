import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
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

        // HOMEWORK

        System.out.println("CONSUMER: " + "\n");

        Consumer<Employee> print_something = p -> System.out.println("name: " + p.getName());
        print_something.accept(l.get(0));

        System.out.println("\n");
        System.out.println("all: ");
        l.stream().forEach(print_something);

        System.out.println("\n");
        System.out.println("PREDICATE: " + "\n");

        Predicate<Employee> predicate = p -> p.getAge()>30 && p.getCity() == "Domodedovo";
        l.stream()
                .filter(predicate)
                .forEach(System.out::println);

        System.out.println("\n");
        System.out.println("SUPPLIER: " + "\n");

        Supplier<Employee> s =
                () -> new Employee.Builder()
                        .setGivenName("Alex")
                        .setSurName("Tihonov")
                        .setAge(32)
                        .setGender(Gender.MALE)
                        .setRole(Role.EXECUTIVE)
                        .setDept(3)
                        .setCity("Kazan")
                        .setCode(4)
                        .build();

        l.add(s.get());

        l.stream()
                .forEach(System.out::println);

        System.out.println("\n");
        System.out.println("BiPREDICATE: " + "\n");
        int dept_n = 2;

        System.out.println("1 работник в списке из 2 отдела?");
        BiPredicate<Employee, Integer> bp = (t,i) -> t.getDept() == i;
        System.out.println(bp.test(l.get(0), dept_n));

    }
}
