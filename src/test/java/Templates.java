import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Templates {

    public static String templateOutput = "Enter first parameter: \nEnter operation:" +
            " \nEnter second parameter: \n";

    private static DecimalFormat decimalFormatter = new DecimalFormat("###");

    public static String simpleArithmeticsStringBuilder(double fp, double sp, String operation) {

        double answer = switch (operation) {
            case "+" -> fp + sp;
            case "-" -> fp - sp;
            case "*" -> fp * sp;
            case "/" -> fp / sp;
            case "%" -> fp % sp;
            case "^" -> Math.pow(fp, sp);
            case "root" -> Math.pow(sp, 1.0 / fp);
            case "log" -> Math.log(sp) / Math.log(fp);
            default -> Double.NaN;
        };

        String expectedMessage = templateOutput + decimalFormatter.format(fp) + " " + operation + " " +
                decimalFormatter.format(sp) + " = " + decimalFormatter.format(answer);
        return expectedMessage;
    }
}
