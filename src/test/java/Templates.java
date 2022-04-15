import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Templates {

    public static String templateOutput = "Enter first parameter: \nEnter operation:" +
            " \nEnter second parameter: \n";

    public static DecimalFormat decimalFormatter = new DecimalFormat();

    public static String simpleArithmeticsStringBuilder(double fp, double sp, String operation) {

        double answer = Double.NaN;
        switch(operation){
            case "+": answer = fp + sp;
            break;
            case "-": answer = fp - sp;
            break;
            case "*": answer = fp * sp;
            break;
            case "/": answer = fp / sp;
            break;
            case "%": answer = fp % sp;
            break;
            case "^": answer = Math.pow(fp, sp);
            break;
            case "root": answer = Math.pow(sp, 1.0 / fp);
            break;
            case "log": answer = Math.log(sp)/Math.log(fp);
            break;
        }

        String expectedMessage = templateOutput + decimalFormatter.format(fp) + " " + operation + " " +
                decimalFormatter.format(sp) + " = " + decimalFormatter.format(answer);
        return expectedMessage;
    }
}
