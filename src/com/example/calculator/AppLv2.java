package com.example.calculator;

import java.util.Scanner;

public class AppLv2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CalculatorLv2 calculator = new CalculatorLv2();

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
                int num1 = Integer.parseInt(input1);
                int num2 = Integer.parseInt(input2);
                if (num1 < 0 || num2 < 0) {
                    System.out.println("0 이상의 정수만 입력 가능합니다.");
                    continue;
                }

                int result = calculator.calculate(num1, num2, operator);
                System.out.println("결과: " + result);
            } catch (Exception e) {
                System.out.println("오류: " + e.getMessage());
            }

            System.out.print("연산 결과 중 가장 오래된 것을 삭제하시겠습니까? (yes / no): ");
            if (sc.next().equalsIgnoreCase("yes")) {
                calculator.removeFirstResult();
                System.out.println("삭제 완료.");
            }
        }

        sc.close();
    }
}
