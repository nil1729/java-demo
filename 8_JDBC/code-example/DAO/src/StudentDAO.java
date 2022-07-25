import java.sql.*; // step 1

public class StudentDAO {
    private final static String DB_URL = "jdbc:mysql://localhost:3333/java_jdbc_example";
    private final static String DB_USERNAME = "root";
    private final static String DB_PASSWORD = "password";
    private Connection conn = null;

    public StudentDAO() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver"); // step 2

        this.conn = DriverManager.getConnection(
                DB_URL,
                DB_USERNAME,
                DB_PASSWORD
        ); // step 3
    }

    public Student getStudentByRollNo(int rollNo)
            throws SQLException
    {
        String query = String.format("select sname from student where rollno=%s", rollNo);

        Statement statement = this.conn.createStatement(); // step 4
        ResultSet resultSet = statement.executeQuery(query); // step 5

        // step 6
        Student requestedStudent = null;
        while (resultSet.next()) {
            String studentName = resultSet.getString("sname");
            requestedStudent = new Student(rollNo, studentName);
        }

        statement.close();

        return requestedStudent;
    }

    public Student addNewStudent(int rollNo, String studentName)
            throws ClassNotFoundException, SQLException
    {
        try {
            String preparedQuery = "insert into student(rollno, sname) values(?, ?)";

            PreparedStatement preparedStatement = conn.prepareStatement(preparedQuery); // step 4
            preparedStatement.setInt(1, rollNo);
            preparedStatement.setString(2, studentName);
            preparedStatement.executeUpdate(); // step 5

            // step 6
            Student newStudent = new Student(rollNo, studentName);

            preparedStatement.close();

            return newStudent;
        } catch (SQLException e) {
            if (e instanceof SQLIntegrityConstraintViolationException) {
                System.out.printf("Roll no %s already taken%n", rollNo);
            } else {
                System.out.println(e.getMessage());
            }
            return null;
        }
    }

    public void closeConnection() throws SQLException {
        this.conn.close();
    }
}
