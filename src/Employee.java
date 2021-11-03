import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String givenName;
    private String surName;
    private int age;
    private Gender gender; //MALE, FEMALE
    private Role role;     //STAFF, MANAGER, EXECUTIVE
    private int dept;      //департамент
    private String eMail;
    private String phone;
    private String address;
    private String city;
    private String state;  //область
    private int code = -1;      //код области
    private int salary = 0;

    private Employee() {}

    @Override
    public String toString(){
        return "Employee: {" + "givenName: " + givenName + "; surName: " + surName +
                "; age: " + age + "; gender: " + gender + "; role: " + role +
                "; dept: " + dept + "; eMail: " + eMail + "; phone:" + phone +
                "; address: " + address + "; city: " + city + "; state: " + state +
                "; code: " + code + "}";
    }

    public static class Builder{
        private String givenName;
        private String surName;
        private int age;
        private Gender gender; //MALE, FEMALE
        private Role role;     //STAFF, MANAGER, EXECUTIVE
        private int dept;      //департамент
        private String eMail;
        private String phone;
        private String address;
        private String city;
        private String state;  //область
        private int code = -1;      //код области
        private int salary = 0;

        public Builder setGivenName(String givenName){
            this.givenName = givenName;
            return this;
        }

        public Builder setSurName(String surName){
            this.surName = surName;
            return this;
        }

        public Builder setAge(int age){
            this.age = age;
            return this;
        }

        public Builder setGender(Gender gender){
            this.gender = gender;
            return this;
        }

        public Builder setRole(Role role){
            this.role = role;
            return this;
        }

        public Builder setDept(int dept){
            this.dept = dept;
            return this;
        }

        public Builder setEMail(String eMail){
            this.eMail = eMail;
            return this;
        }

        public Builder setPhone(String phone){
            this.phone = phone;
            return this;
        }

        public Builder setAddress(String address){
            this.address = address;
            return this;
        }

        public Builder setCity(String city){
            this.city = city;
            return this;
        }

        public Builder setState(String state){
            this.state = state;
            return this;
        }

        public Builder setCode(int code){
            this.code = code;
            return this;
        }

        public Builder setSalary(int salary_){
            this.salary = salary_;
            return this;
        }

        public Employee build(){
            Employee employee = new Employee();
            employee.givenName=this.givenName;
            employee.surName=this.surName;
            employee.age=this.age;
            employee.gender=this.gender; //MALE, FEMALE
            employee.role=this.role;     //STAFF, MANAGER, EXECUTIVE
            employee.dept=this.dept;      //департамент
            employee.eMail=this.eMail;
            employee.phone=this.phone;
            employee.address=this.address;
            employee.city=this.city;
            employee.state=this.state;  //область
            employee.code=this.code;      //код области
            employee.salary=this.salary;
            return employee;
        }
    }

    public static List<Employee> createShortList(){
        List<Employee> list = new ArrayList<>();

        list.add(new Builder()
                .setGivenName("Anna")
                .setSurName("Ivanova")
                .setAge(25)
                .setGender(Gender.FEMALE)
                .setEMail("a.ivanova@gmail.com")
                .setDept(3)
                .setRole(Role.MANAGER)
                .setSalary(100000)
                .build());

        list.add(new Builder()
                .setGivenName("Andrey")
                .setSurName("Leronov")
                .setAge(30)
                .setGender(Gender.MALE)
                .setEMail("leronov@gmail.com")
                .setDept(2)
                .setPhone("8-903-783-90-93")
                .setRole(Role.MANAGER)
                .setSalary(120000)
                .build());

        list.add(new Builder()
                .setGivenName("Ivan")
                .setSurName("Frolov")
                .setAge(29)
                .setGender(Gender.MALE)
                .setEMail("ivan_frolovv@gmail.com")
                .setDept(3)
                .setState("Moscow")
                .setCity("Moscow")
                .setCode(0)
                .setPhone("8-966-690-90-96")
                .setRole(Role.MANAGER)
                .setSalary(120000)
                .build());

        list.add(new Builder()
                .setGivenName("Jilia")
                .setSurName("Kotlova")
                .setAge(21)
                .setGender(Gender.FEMALE)
                .setEMail("kotlova2000@gmail.com")
                .setDept(1)
                .setState("Moscow")
                .setCity("Domodedovo")
                .setCode(1)
                .setAddress("Svetlaya street, 3/2")
                .setRole(Role.STAFF)
                .setSalary(60000)
                .build());

        list.add(new Builder()
                .setGivenName("Anton")
                .setSurName("Kotlov")
                .setAge(31)
                .setGender(Gender.MALE)
                .setEMail("anton_kotlov@gmail.com")
                .setDept(1)
                .setState("Moscow")
                .setCity("Domodedovo")
                .setCode(1)
                .setAddress("Svetlaya street, 3/2")
                .setRole(Role.MANAGER)
                .setSalary(130000)
                .build());

        list.add(new Builder()
                .setGivenName("Tim")
                .setSurName("Garnovin")
                .setAge(35)
                .setGender(Gender.MALE)
                .setEMail("garnovin@gmail.com")
                .setDept(1)
                .setState("Moscow")
                .setCity("Domodedovo")
                .setCode(1)
                .setAddress("Temnaya street, 2/3")
                .setRole(Role.EXECUTIVE)
                .setSalary(200000)
                .build());

        list.add(new Builder()
                .setGivenName("Pavel")
                .setSurName("Morozov")
                .setAge(33)
                .setGender(Gender.MALE)
                .setEMail("moroz_pavel@gmail.com")
                .setDept(2)
                .setState("Moscow")
                .setCity("Moscow")
                .setCode(0)
                .setRole(Role.STAFF)
                .setSalary(70000)
                .build());

        list.add(new Builder()
                .setGivenName("Nina")
                .setSurName("Loginova")
                .setAge(18)
                .setGender(Gender.FEMALE)
                .setEMail("loginovaaa@gmail.com")
                .setDept(3)
                .setState("Moscow")
                .setCity("Moscow")
                .setAddress("Novaya street, 1")
                .setCode(0)
                .setRole(Role.STAFF)
                .setSalary(50000)
                .build());

        list.add(new Builder()
                .setGivenName("Lia")
                .setSurName("Novikova")
                .setAge(19)
                .setGender(Gender.FEMALE)
                .setEMail("novicova_@gmail.com")
                .setDept(2)
                .setState("Moscow")
                .setCity("Zelenograd")
                .setCode(2)
                .setRole(Role.STAFF)
                .setSalary(55000)
                .build());
        return list;
    }

    public Role getRole(){
        return this.role;
    }

    public Gender getGender(){
        return this.gender;
    }

    public int getAge(){
        return this.age;
    }

    public String getName(){
        return this.givenName + " " + this.surName;
    }

    public int getDept() { return this.dept;}

    public int getSalary() { return this.salary;}

    public String getCity() {return this.city;}

    public String getMail() {return this.eMail;}

    public void setPhone(String phone){
        this.phone = phone;
    }
}
