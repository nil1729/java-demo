// DAO (Data Access Object) Example

import java.sql.SQLException;

public class Main {
    public static void main(String[] args)
            throws SQLException, ClassNotFoundException
    {
        StudentDAO studentDAO = new StudentDAO();

        Student s1 = studentDAO.getStudentByRollNo(1);
        System.out.println(s1);

        Student s12 = studentDAO.getStudentByRollNo(12);
        System.out.println(s12);

        Student s13 = studentDAO.addNewStudent(16, "Gaurav");
        System.out.println(s13);

        studentDAO.closeConnection();
    }
}

