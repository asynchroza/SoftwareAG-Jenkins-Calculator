package com.softwareag;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Scanner;

public class App {

    private static HashSet<String> operation_set = new HashSet<>(){{add("+"); add("-"); add("*"); add("/"); add("root"); add("log"); add("^"); add("%");}};

    public static double getAnswer(double first_param, String operation, double second_param){
        return switch (operation) {
            case "+" -> first_param + second_param;
            case "-" -> first_param - second_param;
            case "*" -> first_param * second_param;
            case "/" -> first_param / second_param;
            case "%" -> first_param % second_param;
            case "^" -> Math.pow(first_param, second_param);
            case "root" -> Math.pow(second_param, 1.0 / first_param);
            case "log" -> Math.log(second_param) / Math.log(first_param);
            default -> 0;
        };
    }

    public static void Execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter first parameter: ");
            double first_param = scanner.nextDouble();
            System.out.println("Enter operation: ");
            String operation = scanner.next();
            if (!operation_set.contains(operation)) throw new Exception();
            System.out.println("Enter second parameter: ");
            double second_param = scanner.nextDouble();
            scanner.close();

            double answer = getAnswer(first_param, operation, second_param);
            DecimalFormat decimalFormatter = new DecimalFormat("###");
            if(operation.equals("root")){
                System.out.println("The " + decimalFormatter.format(first_param) +" root of " + decimalFormatter.format(second_param) + " = " + decimalFormatter.format(answer));
            } else if(operation.equals("log")){
                System.out.println("log"+ decimalFormatter.format(first_param) + "(" + decimalFormatter.format(second_param) +") = " + decimalFormatter.format(answer));
            } else {
                System.out.println(decimalFormatter.format(first_param) + " " + operation + " " + decimalFormatter.format(second_param) + " = " + decimalFormatter.format(answer));
            }

        } catch (Exception e){
            System.out.println("Unsupported format");
//            Execute();
        }

    }

    public static void main(String[] args){ // Driver
        Execute();
    }
}
