public class Main {
    public static void main(String[] args) {
        EmployeeClass employeeClass = new EmployeeClass("John", 1);
        System.out.println(employeeClass);

        EmployeeRecord employeeRecord = new EmployeeRecord("Nilanjan", 2);
        System.out.println(employeeRecord);
        System.out.println(employeeRecord.nameInUpperCase());
        EmployeeRecord.someStaticMethod();

        try {
            new EmployeeRecord("Alice", -2);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
