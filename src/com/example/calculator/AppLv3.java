package com.example.calculator;

import java.util.Scanner;

public class AppLv3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CalculatorLv3 calculator = new CalculatorLv3();

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요 (exit 입력 시 종료): ");
            String input1 = sc.next();
            if (input1.equalsIgnoreCase("exit")) break;

            System.out.print("두 번째 숫자를 입력하세요: ");
            String input2 = sc.next();
            if (input2.equalsIgnoreCase("exit")) break;

            System.out.print("사칙연산 기호를 입력하세요 (+ - * /): ");
            char operator = sc.next().charAt(0);

            try {
                double num1 = Double.parseDouble(input1);
                double num2 = Double.parseDouble(input2);

                double result = calculator.calculate(num1, num2, operator);
                System.out.println("결과: " + result);
            } catch (Exception e) {
                System.out.println("오류: " + e.getMessage());
            }

            System.out.print("결과 삭제를 원하십니까? (yes / no): ");
            if (sc.next().equalsIgnoreCase("yes")) {
                calculator.removeFirstResult();
                System.out.println("삭제 완료.");
            }

            System.out.print("특정 값보다 큰 결과들을 조회하시겠습니까? (yes / no): ");
            if (sc.next().equalsIgnoreCase("yes")) {
                System.out.print("기준 값을 입력하세요: ");
                double threshold = sc.nextDouble();
                System.out.println("조회 결과:");
                calculator.getResultsGreaterThan(threshold).forEach(System.out::println);
            }
        }

        sc.close();
    }
}
