enum Role {
    STAFF(30000, 0.1),
    MANAGER(50000,0.2),
    EXECUTIVE(65000, 0.3);

    int salary;
    double percent;

    Role(int salary, double percent) {
        this.salary = salary;
        this.percent = percent;
    }
}
