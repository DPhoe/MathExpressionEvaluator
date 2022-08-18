import com.fathzer.soft.javaluator.DoubleEvaluator;
import java.sql.ResultSet;

public class execute {
    public static void main(String[] args) throws Exception {
        scanner scanner = new scanner();
        utilityValidation utilityValidation = new utilityValidation();
        dbOperations dbOperations = new dbOperations();
        String input = scanner.scanner.nextLine();
        dbOperations.printAllRecordsFromDataBase();
//        dbOperations.printRecordByExpressionResult(Integer.parseInt(input));
        utilityValidation.checkFirstParentheses(input);
        utilityValidation.checkForExtraMathSigns(input);
        utilityValidation.checkForNumberOfParentheses(input);
        utilityValidation.checkForParenthesesSymmetry(input);
        utilityValidation.checkForEmptyParentheses(input);
        Double result = new DoubleEvaluator().evaluate(input);
        dbOperations.updateRecordById(scanner.scanner.nextInt() , input, result);
        dbOperations.getStatement().executeUpdate(dbOperations.buildInsertQuery(input, result));
        System.out.println(result);
        ResultSet resultSet = dbOperations.getStatement().executeQuery("select * from math_expres");
        while(resultSet.next())
            System.out.println(resultSet.getInt(1)+"  "+resultSet.getString(2)+"  "+resultSet.getDouble(3));
        dbOperations.getConnection().close();
    }
}
