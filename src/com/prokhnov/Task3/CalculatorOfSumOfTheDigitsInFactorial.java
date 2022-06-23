package com.prokhnov.Task3;

import java.math.BigInteger;

public class CalculatorOfSumOfTheDigitsInFactorial {

    // The method of obtaining the factorial of a number
    public static BigInteger getFactorial(int num) {

        BigInteger bigNum = BigInteger.valueOf(num);

        // Recursive approach to finding the factorial
        if (num >= 1) {
            return bigNum.multiply(getFactorial(num - 1));
        } else {
            return BigInteger.valueOf(1);
        }
    }

    // The method to find sum of the digits in factorial
    public static int sumOfTheDigitsInFactorial(int num) {

        // Get factorial
        BigInteger factNum = getFactorial(num);

        String numStr = factNum.toString();
        int sum = 0;

        // Calculate sum of all digits in the number
        for (int i = 0; i < numStr.length(); i++) {
            int as = Integer.parseInt(String.valueOf(numStr.charAt(i)));
            sum = sum + as;
        }

        return sum;
    }

    public static void main(String[] args) {

        int factorial = 100;
        System.out.println(sumOfTheDigitsInFactorial(factorial));


    }
}
