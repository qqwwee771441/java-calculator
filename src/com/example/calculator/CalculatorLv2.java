package com.example.calculator;

import java.util.LinkedList;
import java.util.Queue;

public class CalculatorLv2 {
    private final Queue<Double> results = new LinkedList<>();

    public double calculate(double a, double b, char op) throws ArithmeticException {
        double result;
        switch (op) {
            case '+': result = a + b; break;
            case '-': result = a - b; break;
            case '*': result = a * b; break;
            case '/':
                if (b == 0) throw new ArithmeticException("분모는 0이 될 수 없습니다.");
                result = a / b;
                break;
            default:
                throw new IllegalArgumentException("지원하지 않는 연산자입니다: " + op);
        }
        results.add(result);
        return result;
    }

    public void removeOldestResult() {
        if (!results.isEmpty()) {
            System.out.println("삭제된 결과: " + results.poll());
        } else {
            System.out.println("삭제할 결과가 없습니다.");
        }
    }

    public Queue<Double> getResults() {
        return new LinkedList<>(results);
    }

    public void printResultsGreaterThan(double threshold) {
        boolean found = false;
        for (double r : results) {
            if (r > threshold) {
                System.out.println(r);
                found = true;
            }
        }
        if (!found) System.out.println("조건을 만족하는 결과가 없습니다.");
    }
}
