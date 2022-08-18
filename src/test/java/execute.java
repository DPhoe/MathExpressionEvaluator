import com.fathzer.soft.javaluator.DoubleEvaluator;

public class execute {
    public static void main(String[] args) throws Exception {
        scanner scanner = new scanner();
        utilityValidation utilityValidation = new utilityValidation();
        String input = scanner.scanner.nextLine();
        utilityValidation.checkFirstParentheses(input);
        utilityValidation.checkForExtraMathSigns(input);
        utilityValidation.checkForNumberOfParentheses(input);
        utilityValidation.checkForEmptyParentheses(input);
        Double result = new DoubleEvaluator().evaluate(input);
        System.out.println(result);
    }
}
