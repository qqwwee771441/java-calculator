package com.example.calculator;

import java.util.Scanner;

public class AppLv1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요 (exit 입력 시 종료): ");
            String input1 = sc.next();
            if (input1.equalsIgnoreCase("exit")) break;

            System.out.print("두 번째 숫자를 입력하세요: ");
            String input2 = sc.next();
            if (input2.equalsIgnoreCase("exit")) break;

            System.out.print("사칙연산 기호를 입력하세요 (+ - * /): ");
            char operator = sc.next().charAt(0);

            int num1, num2;
            try {
                num1 = Integer.parseInt(input1);
                num2 = Integer.parseInt(input2);
                if (num1 < 0 || num2 < 0) {
                    System.out.println("0 이상의 정수만 입력할 수 있습니다.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자를 올바르게 입력하세요.");
                continue;
            }

            int result = 0;
            boolean valid = true;

            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/':
                    if (num2 == 0) {
                        System.out.println("나눗셈 연산에서 분모(두 번째 정수)에 0이 입력될 수 없습니다.");
                        valid = false;
                    } else {
                        result = num1 / num2;
                    }
                    break;
                default:
                    System.out.println("올바른 연산 기호를 입력하세요.");
                    valid = false;
            }

            if (valid) {
                System.out.println("결과: " + result);
            }
        }

        sc.close();
    }
}
