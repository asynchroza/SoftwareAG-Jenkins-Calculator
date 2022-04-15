import com.softwareag.App;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.*;

public class TestDriver {

    // testing unsupported formats
    @Test
    // first parameter as a string
    public void unsupportedFormatFirstParameter() {
        String fp = "sdfwierrew";
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(fp.getBytes());
        System.setIn(in);
        System.setOut(new PrintStream(outputStreamCaptor));
        App.Execute();
        String expectedMessage = "Enter first parameter: \nUnsupported format";
        assertEquals(expectedMessage, outputStreamCaptor.toString().trim());
    }


    // operation as an unsupported operation
    @Test
    public void unsupportedOperation() {
        String operation = "sqrt";
        double fp = 2345L;
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
//        ByteArrayInputStream in = new ByteArrayInputStream("15\n15".getBytes());
        ByteArrayInputStream in = new ByteArrayInputStream((fp + "\n" + operation).getBytes());
        System.setIn(in);
        System.setOut(new PrintStream(outputStreamCaptor));
        App.Execute();
        String expectedMessage = "Enter first parameter: \nEnter operation: " +
                "\nUnsupported format";
        assertEquals(expectedMessage, outputStreamCaptor.toString().trim());
    }


    @Test
    public void unsupportedFormatOperation() {
        String operation = "2";
        double fp = 2345L;
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
//        ByteArrayInputStream in = new ByteArrayInputStream("15\n15".getBytes());
        ByteArrayInputStream in = new ByteArrayInputStream((fp + "\n" + operation).getBytes());
        System.setIn(in);
        System.setOut(new PrintStream(outputStreamCaptor));
        App.Execute();
        String expectedMessage = "Enter first parameter: \nEnter operation: " +
                "\nUnsupported format";
        assertEquals(expectedMessage, outputStreamCaptor.toString().trim());
    }

    @Test
    public void unsupportedFormatSecondParameter() {
        String operation = "+";
        double fp = 0L;
        char sp = '?';
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
//        ByteArrayInputStream in = new ByteArrayInputStream("15\n+\nstring".getBytes());
        ByteArrayInputStream in = new ByteArrayInputStream((fp+"\n"+operation+"\n"+sp).getBytes());
        System.setIn(in);
        System.setOut(new PrintStream(outputStreamCaptor));
        App.Execute();
        String expectedMessage = "Enter first parameter: \nEnter operation: " +
                "\nEnter second parameter: \nUnsupported format";
        assertEquals(expectedMessage, outputStreamCaptor.toString().trim());
    }

    @Test
    public void testAddition() {
        String operation = "+";
        double fp = 754430342.3232;
        double sp = 234.59430823;
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream((fp + "\n" + operation + "\n" + sp).getBytes());
        System.setIn(in);
        System.setOut(new PrintStream(outputStreamCaptor));
        App.Execute();
        String expectedMessage = Templates.simpleArithmeticsStringBuilder(fp,sp,operation);
        assertEquals(expectedMessage, outputStreamCaptor.toString().trim());
    }

    @Test
    public void testSubtraction() {
        String operation = "-";
        double fp = 234324298434.3232;
        double sp = 656956930459430823L;
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream((fp + "\n" + operation + "\n" + sp).getBytes());
        System.setIn(in);
        System.setOut(new PrintStream(outputStreamCaptor));
        App.Execute();
        String expectedMessage = Templates.simpleArithmeticsStringBuilder(fp, sp, operation);
        assertEquals(expectedMessage, outputStreamCaptor.toString().trim());
    }

    @Test
    public void testMultiplication(){
        String operation = "*";
        double fp = 2343242.3232;
        double sp = 65695693023443234.2343;
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream((fp + "\n" + operation + "\n" + sp).getBytes());
        System.setIn(in);
        System.setOut(new PrintStream(outputStreamCaptor));
        App.Execute();
        String expectedMessage = Templates.simpleArithmeticsStringBuilder(fp, sp, operation);
        assertEquals(expectedMessage, outputStreamCaptor.toString().trim());
    }

    @Test
    public void testDivision(){
        String operation = "/";
        double fp = 23432423467554432.3232;
        double sp = 6569234.2343;
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream((fp + "\n" + operation + "\n" + sp).getBytes());
        System.setIn(in);
        System.setOut(new PrintStream(outputStreamCaptor));
        App.Execute();
        String expectedMessage = Templates.simpleArithmeticsStringBuilder(fp, sp, operation);
        assertEquals(expectedMessage, outputStreamCaptor.toString().trim());
    }

    @Test
    public void testPower(){
        String operation = "^";
        double fp = 234324254432.3232;
        double sp = 6569234.2343;
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream((fp + "\n" + operation + "\n" + sp).getBytes());
        System.setIn(in);
        System.setOut(new PrintStream(outputStreamCaptor));
        App.Execute();
        String expectedMessage = Templates.simpleArithmeticsStringBuilder(fp, sp, operation);
        assertEquals(expectedMessage, outputStreamCaptor.toString().trim());
    }

    @Test
    public void testModulus(){
        String operation = "%";
        double fp = 2343432.3232;
        double sp = 6569234.2323443;
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream((fp + "\n" + operation + "\n" + sp).getBytes());
        System.setIn(in);
        System.setOut(new PrintStream(outputStreamCaptor));
        App.Execute();
        String expectedMessage = Templates.simpleArithmeticsStringBuilder(fp, sp, operation);
        assertEquals(expectedMessage, outputStreamCaptor.toString().trim());
    }

    @Test
    public void testRoot(){
        String operation = "root";
        double fp = 234324254432.3232;
        double sp = 6569234.2343;
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream((fp + "\n" + operation + "\n" + sp).getBytes());
        System.setIn(in);
        System.setOut(new PrintStream(outputStreamCaptor));
        App.Execute();
        String expectedMessage = Templates.templateOutput + "The " + Templates.decimalFormatter.format(fp) +" root of " + Templates.decimalFormatter.format(sp) +
                " = " + Templates.decimalFormatter.format(Math.pow(sp,1.0/fp));
        assertEquals(expectedMessage, outputStreamCaptor.toString().trim());
    }

    @Test
    public void testLog(){
        String operation = "log";
        double fp = 2432.3232;
        double sp = 6569234.2343;
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream((fp + "\n" + operation + "\n" + sp).getBytes());
        System.setIn(in);
        System.setOut(new PrintStream(outputStreamCaptor));
        App.Execute();
        String expectedMessage = Templates.templateOutput + "log" + Templates.decimalFormatter.format(fp) +"(" + Templates.decimalFormatter.format(sp) +
                ") = " + Templates.decimalFormatter.format(Math.log(sp)/Math.log(fp));
        assertEquals(expectedMessage, outputStreamCaptor.toString().trim());
    }

    @Test
    public void testSwitchDefault(){
        double expected = 0;
        double actual = App.getAnswer(2348320L, "?",7555435L );
        assertEquals(expected, actual);
    }

    @Test
    public void testAppGoodInput(){
        String operation = "log";
        double fp = 2432.3232;
        double sp = 6569234.2343;
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream((fp + "\n" + operation + "\n" + sp).getBytes());
        System.setIn(in);
        System.setOut(new PrintStream(outputStreamCaptor));

        App.main(new String[]{"arg1", "arg2"});
        String expectedMessage = Templates.templateOutput + "log" + Templates.decimalFormatter.format(fp) +"(" + Templates.decimalFormatter.format(sp) +
                ") = " + Templates.decimalFormatter.format(Math.log(sp)/Math.log(fp));
        assertEquals(expectedMessage, outputStreamCaptor.toString().trim());
    }

    @Test
    public void testAppBadInput(){
        String operation = "log";
        double fp = 2432.3232;
        String sp = "string";
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream((fp + "\n" + operation + "\n" + sp).getBytes());
        System.setIn(in);
        System.setOut(new PrintStream(outputStreamCaptor));

        App.main(new String[]{"arg1", "arg2"});
        String expectedMessage = Templates.templateOutput + "Unsupported format";
        assertEquals(expectedMessage, outputStreamCaptor.toString().trim());
    }


}