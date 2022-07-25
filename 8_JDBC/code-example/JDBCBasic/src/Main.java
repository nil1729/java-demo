import java.sql.*; // 1st step

// Java Database Connectivity

/**
 * 1. import the package --------------> java.sql
 * 2. load and register the driver ----> com.mysql.jdbc.Driver
 * 3. Create a Connection -------------> Connection interface
 * 4. Create a Statement --------------> Statement interface
 * 5. execute the query ---------------> DDL | DML (executeUpdate -> int) | DQL (executeQuery -> ResultSet)
 * 6. process the results
 * 7. close
 */

public class Main {
    public static void main(String[] args)
            throws ClassNotFoundException, SQLException {

        String DB_URL = "jdbc:mysql://localhost:3333/java_jdbc_example";
        String DB_USERNAME = "root";
        String DB_PASSWORD = "password";

        Class.forName("com.mysql.cj.jdbc.Driver"); // 2nd step

        Connection conn = DriverManager
                .getConnection(
                        DB_URL,
                        DB_USERNAME,
                        DB_PASSWORD
                ); // 3rd step

        // Queries
        String query_1 = "select username from users where userId=3";
        String query_2 = "select * from users";
        String query_3 = "insert into users(username) values('Akshay')";
        String preparedStatementQuery = "insert into users(username) values(?)";

        // Creating Statements (4th Step)
        Statement statement_1 = conn.createStatement();
        Statement statement_2 = conn.createStatement();
        Statement statement_3 = conn.createStatement();
        PreparedStatement preparedStatement_1 = conn.prepareStatement(preparedStatementQuery);



        // Executing the Query (5th Step)
        ResultSet rs_1 = statement_1.executeQuery(query_1);
        ResultSet rs_2 = statement_2.executeQuery(query_2);
        int rowsAffectedCount = statement_3.executeUpdate(query_3);

        // Prepared Statement
        String variableUsername = "Divyank";
        preparedStatement_1.setString(1, variableUsername);
        int rowsAffectedCountForPreparedStatement = preparedStatement_1.executeUpdate();

        // Processing the Result (6th Step)
        rs_1.next();
        String name = rs_1.getString("username");
        System.out.printf("Username: %s%n", name);

        while (rs_2.next()) {
            String userData = rs_2.getInt(1) + " : " + rs_2.getString(2);
            System.out.println(userData);
        }

        System.out.printf("%s rows affected%n", rowsAffectedCount);
        System.out.printf("%s rows affected by prepared statement%n", rowsAffectedCountForPreparedStatement);


        statement_1.close();
        statement_2.close();
        statement_3.close();
        preparedStatement_1.close();
        conn.close();
    }
}
