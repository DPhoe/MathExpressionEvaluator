import com.fathzer.soft.javaluator.DoubleEvaluator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class execute {
    public static void main(String[] args) throws Exception {
        scanner scanner = new scanner();
        utilityValidation utilityValidation = new utilityValidation();
        dbOperations dbOperations = new dbOperations();
        System.out.println("Greeting, here you can enter yor mathematics expression to be calculated and saved \r\n" +
                "Enter your expression or type Help for more option \r\n" +
                "Type Exit to close program");
        String input = scanner.scanner.nextLine();
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher check = pattern.matcher(input);
        if (check.find()){
            utilityValidation.checkForEmptyParentheses(input);
            utilityValidation.checkForExtraMathSigns(input);
            utilityValidation.checkForParenthesesSymmetry(input);
            utilityValidation.checkForNumberOfParentheses(input);
            Double result = new DoubleEvaluator().evaluate(input);
            dbOperations.executeInsertQuery(input, result);
            System.out.println("Result is: " + result + "\r\n" +
                    "Your expression and result were added to data base");
        }
        else if (input.equals("Exit")) {
            System.exit(0);
        }
        else if (input.equals("Help")) {
            System.out.println("To get all record from data base type Get \r\n" +
                    "To get records by result type Result \r\n" +
                    "To update record in table type Update \r\n" +
                    "Type Exit to close program");
            String ifInput = scanner.scanner.nextLine();
            if (ifInput.contains("Exit")) {
                System.exit(0);
            }
            else if (ifInput.contains("Get")){
                dbOperations.printAllRecordsFromDataBase();
            }
            else if (ifInput.contains("Result")) {
                System.out.println("Enter result to search of, only numeric values");
                double result = Double.parseDouble(scanner.scanner.nextLine());
                dbOperations.printRecordByExpressionResult(result);
            }
            else if (input.contains("Update")) {
                System.out.println("Enter ID of record you want to update, press Enter button and then enter new expression \r\n" +
                        "If new expression will pass all validations record will be updated");
                int recordId = scanner.scanner.nextInt();
                String newExpression = scanner.scanner.nextLine();
                utilityValidation.checkForEmptyParentheses(newExpression);
                utilityValidation.checkForExtraMathSigns(newExpression);
                utilityValidation.checkForParenthesesSymmetry(newExpression);
                utilityValidation.checkForNumberOfParentheses(newExpression);
                Double newResult = new DoubleEvaluator().evaluate(newExpression);
                dbOperations.updateRecordById(recordId, newExpression, newResult);

            }
        }
        else if (input.contains("Get")) {
            dbOperations.printAllRecordsFromDataBase();
        }
        else if (input.contains("Result")) {
            System.out.println("Enter result to search of, only numeric values");
            double result = Double.parseDouble(scanner.scanner.nextLine());
            dbOperations.printRecordByExpressionResult(result);
        }
        else if (input.contains("Update")) {
            System.out.println("Enter new expression, press enter and then enter ID of record you want to update \r\n" +
                    "If new expression will pass all validations record will be updated");
            String newExpression = scanner.scanner.nextLine();
            int recordId = scanner.scanner.nextInt();
            utilityValidation.checkForEmptyParentheses(newExpression);
            utilityValidation.checkForExtraMathSigns(newExpression);
            utilityValidation.checkForParenthesesSymmetry(newExpression);
            utilityValidation.checkForNumberOfParentheses(newExpression);
            Double newResult = new DoubleEvaluator().evaluate(newExpression);
            dbOperations.updateRecordById(recordId, newExpression, newResult);
            System.out.println("Record with ID: " + "\'" + recordId + "\'" +
                    " Was updated with expression: " + "\'" + newExpression + "\'" +
                    " And result: " + "\'" + newResult + "\'");

        }
    }

}