package com.example.calculator;

import java.util.Scanner;

public class AppLv2Lv3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CalculatorLv2 calc = new CalculatorLv2();

        while (true) {
            System.out.println("명령을 입력하세요 (계산: calc, 결과삭제: remove, 결과조회: show, 조건조회: showgt, 종료: exit): ");
            String cmd = sc.next();

            if (cmd.equals("exit")) break;

            switch (cmd) {
                case "calc":
                    System.out.print("첫 번째 숫자 입력: ");
                    String s1 = sc.next();
                    System.out.print("두 번째 숫자 입력: ");
                    String s2 = sc.next();
                    System.out.print("연산자 입력 (+, -, *, /): ");
                    char op = sc.next().charAt(0);

                    try {
                        double n1 = Double.parseDouble(s1);
                        double n2 = Double.parseDouble(s2);
                        double res = calc.calculate(n1, n2, op);
                        System.out.println("결과: " + res);
                    } catch (NumberFormatException e) {
                        System.out.println("실수 또는 정수를 입력해주세요.");
                    } catch (ArithmeticException | IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "remove":
                    calc.removeOldestResult();
                    break;

                case "show":
                    System.out.println("현재 결과들: " + calc.getResults());
                    break;

                case "showgt":
                    System.out.print("기준값 입력: ");
                    try {
                        double threshold = Double.parseDouble(sc.next());
                        calc.printResultsGreaterThan(threshold);
                    } catch (NumberFormatException e) {
                        System.out.println("숫자를 입력해주세요.");
                    }
                    break;

                default:
                    System.out.println("지원하지 않는 명령입니다.");
            }
        }
        sc.close();
    }
}
