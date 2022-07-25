public class Student {
    private final int rollNo;
    private final String sName;

    public Student(int rollNo, String sName) {
        this.rollNo = rollNo;
        this.sName = sName;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getsName() {
        return sName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", sName='" + sName + '\'' +
                '}';
    }
}
