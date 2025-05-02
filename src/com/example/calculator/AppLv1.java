package com.example.calculator;

import java.util.Scanner;

public class AppLv1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("계산을 종료하려면 'exit'을 입력하세요.");
            System.out.print("첫 번째 숫자를 입력하세요: ");
            String input1 = sc.next();
            if (input1.equals("exit")) break;

            System.out.print("두 번째 숫자를 입력하세요: ");
            String input2 = sc.next();
            if (input2.equals("exit")) break;

            System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /): ");
            String op = sc.next();
            if (op.equals("exit")) break;

            int num1, num2;
            try {
                num1 = Integer.parseInt(input1);
                num2 = Integer.parseInt(input2);
                if (num1 < 0 || num2 < 0) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("양의 정수(0 포함)를 입력해야 합니다.");
                continue;
            }

            int result = 0;
            boolean valid = true;
            switch (op.charAt(0)) {
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
                    System.out.println("잘못된 연산자입니다.");
                    valid = false;
            }

            if (valid) System.out.println("결과: " + result);
        }
        sc.close();
    }
}