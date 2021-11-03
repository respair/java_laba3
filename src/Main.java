import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.List;


public class Main {
    public static void main(String[] args){
        List<Employee> l = Employee.createShortList();
        Accountant acc = new Accountant();

        System.out.println("*** премии людям старше 30, работающим в 1 и 2 отделах ***");
        l.stream()
                .filter(l1 -> l1.getAge() > 30)
                .filter(l1 -> l1.getDept() == 2 || l1.getDept() == 1)
                .forEach(p -> acc.payPremium(p));


        System.out.println("*** премии женщинам ***");
        l.stream()
                .filter(l1 -> l1.getGender().equals(Gender.FEMALE))
                .forEach(p -> acc.payPremium(p));

        System.out.println("*** зарплата людям из 3 отдела ***");
        l.stream()
                .filter(l1 -> l1.getDept() == 3)
                .forEach(p -> acc.paySalary(p));


        System.out.println("*** зарплата менеджерам ***");
        l.stream()
                .filter(l1 -> l1.getRole().equals(Role.MANAGER))
                .forEach(p -> acc.paySalary(p));


        System.out.println("*** премия стаффу ***");
        l.stream()
                .filter(l1 -> l1.getRole().equals(Role.STAFF))
                .forEach(p -> acc.payPremium(p));

        // HOMEWORK for lab 3

        System.out.println("CONSUMER: " + "\n");

        Consumer<Employee> print_something = p -> System.out.println("name: " + p.getName());
        print_something.accept(l.get(0));

        System.out.println("\n");
        System.out.println("all: ");
        l.stream().forEach(print_something);

        System.out.println("\n");
        System.out.println("PREDICATE: " + "\n");

        Predicate<Employee> predicate = p -> p.getAge()>30 && p.getCity().equals("Domodedovo");
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


        // for lab 4

        System.out.println("\n");
        System.out.println("почты сотрудников:");  //map
        l.stream()
                .map(Employee::getMail)
                .forEach(System.out::println);

        System.out.println("\n");
        System.out.println("вывести удвоенную зарплату сотрудников:");  //map
        l.stream()
                .map(l1 -> l1.getSalary()*2)
                .forEach(System.out::println);

        System.out.println("\n");
        System.out.println("работники старше 30 из 1 департамента:"); //peek
        l.stream()
                .filter(e -> e.getAge() > 30)
                .peek(e -> System.out.println(">30: " + e))
                .filter(e -> e.getDept() == 1)
                .peek(e -> System.out.println("+ only 1 dept: " + e))
                .forEach(System.out::println);

        System.out.println("\n");
        System.out.println("изменение номера Антона Котлова:"); //peek
        l.stream()
                .filter(e -> e.getName().equals("Anton Kotlov"))
                .peek(e -> e.setPhone("+7-953-807-90-67"))
                .forEach(System.out::println);

        System.out.println("\n");
        System.out.println("1ый сотрудник старше 20:"); //findFirst
        Employee emp = l.stream()
                .filter(e -> e.getAge() > 20)
                .findFirst().get();
        System.out.println(emp);

        System.out.println("\n");
        System.out.println("1ый сотрудник женщина:"); //findFirst
        Employee emp2 = l.stream()
                .filter(e -> e.getGender().equals(Gender.FEMALE))
                .findFirst().get();
        System.out.println(emp2);

        System.out.println("\n");
        System.out.println("максимальная зарплата y:"); //max
        Employee max_salary = l.stream()
                .max(Comparator.comparing(Employee::getSalary)).get();

        System.out.println(max_salary);

        System.out.println("\n");
        System.out.println("максимальный возраст y:"); //max
        Employee max_age = l.stream()
                .max(Comparator.comparing(Employee::getAge)).get();

        System.out.println(max_age);

        System.out.println("\n");
        System.out.println("минимальный возраст y:"); //min
        Employee min_age = l.stream()
                .min(Comparator.comparing(Employee::getAge)).get();

        System.out.println(min_age);

        System.out.println("\n");
        System.out.println("самая маленькая зарплата y:"); //min
        Employee min_salary = l.stream()
                .min(Comparator.comparing(Employee::getSalary)).get();

        System.out.println(min_salary);

        System.out.println("\n");
        System.out.println("средний возраст:"); //average

        Double age_ = l.stream()
                .mapToInt(Employee::getAge)
                .average().getAsDouble();


        System.out.println(age_);

        System.out.println("\n");
        System.out.println("средняя зарплата:"); //average

        Double salary_ = l.stream()
                .mapToInt(Employee::getSalary)
                .average().getAsDouble();


        System.out.println(salary_);

        System.out.println("\n");
        System.out.println("общий возраст:"); //sum

        Integer age_sum = l.stream()
                .mapToInt(Employee::getAge)
                .sum();


        System.out.println(age_sum);

        System.out.println("\n");
        System.out.println("сколько нужно потратить на всех работников (выплата зарплаты):"); //sum

        Integer salary_sum = l.stream()
                .mapToInt(Employee::getSalary)
                .sum();


        System.out.println(salary_sum);



    }
}
