package com.example.calculator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class CalculatorLv3 {
    private Queue<Double> results;

    public CalculatorLv3() {
        results = new LinkedList<>();
    }

    public double calculate(double num1, double num2, char operator) {
        double result = 0;

        switch (operator) {
            case '+': result = num1 + num2; break;
            case '-': result = num1 - num2; break;
            case '*': result = num1 * num2; break;
            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException("나눗셈 연산에서 분모에 0이 입력될 수 없습니다.");
                }
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("올바른 연산 기호를 입력하세요.");
        }

        results.add(result);
        return result;
    }

    public void removeFirstResult() {
        if (!results.isEmpty()) {
            results.poll();
        }
    }

    public List<Double> getResultsGreaterThan(double threshold) {
        return results.stream()
                .filter(r -> r > threshold)
                .collect(Collectors.toList());
    }

    public Queue<Double> getAllResults() {
        return new LinkedList<>(results); // read-only view
    }
}
