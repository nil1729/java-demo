public record EmployeeRecord(String name, Integer employeeId) {
    /**
     * My Constructor
     */
//    public EmployeeRecord(String name, Integer employeeId) {
//        if (employeeId < 0) {
//            throw new IllegalArgumentException("employeeId cannot be negative [my]");
//        }
//        this.name = name;
//        this.employeeId = employeeId;
//    }

    /**
     * Compact Constructor
     */
    public EmployeeRecord {
        if(employeeId < 0) {
            throw new IllegalArgumentException("employeeId cannot be negative [compact]");
        }
    }

    /**
     * Instance method
     */
    public String nameInUpperCase() {
        return name.toUpperCase();
    }

    /**
     * Static Methods
     */
    public static void someStaticMethod() {
        System.out.println("Something!");
    }
}
