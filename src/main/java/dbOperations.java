import java.sql.*;

public class dbOperations {

    public Connection getConnection () throws SQLException {
        Connection con = null;
        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testtask", "root", "Password");
            return con;
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    public Statement getStatement () {
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            statement = getConnection().createStatement();
            return statement;
        } catch (Exception e) {
            System.out.println(e);
        }
        return statement;
    }

    public String buildInsertQuery(String expression, double result) {
        String finalString = "INSERT INTO math_expres (Expression, Result) values ('" + expression +  "', " + result + ")";
        return finalString;
    }
}
