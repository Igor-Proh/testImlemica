package com.prokhnov.Task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class VariantsOfParenthesesPairs {

    // The method of add variants of parentheses placement options to the list
    public static void addParentheses(ArrayList<String> list, int leftAdd, int rightAdd, char[] str, int count) {
        if (leftAdd < 0 || rightAdd < leftAdd) return;

        // Recursive approach to add parentheses
        if (leftAdd == 0 && rightAdd == 0) {
            String s = String.copyValueOf(str);
            list.add(s);
        } else {

            // Add left parentheses
            if (leftAdd > 0) {
                str[count] = '(';
                addParentheses(list, leftAdd - 1, rightAdd, str, count + 1);
            }

            // Add right parentheses
            if (rightAdd > leftAdd) {
                str[count] = ')';
                addParentheses(list, leftAdd, rightAdd - 1, str, count + 1);
            }
        }
    }

    // The method of generate list
    public static ArrayList<String> generateParenthesesList(int count) {
        char[] str = new char[count * 2];
        ArrayList<String> list = new ArrayList<>();
        addParentheses(list, count, count, str, 0);
        return list;
    }

    public static void main(String[] args) throws IOException {

        // Read line from console
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        boolean flag = true;

        // Loop for check input data for correct
        while (flag) {
            System.out.println("Enter num of parentheses pairs (num from 1 - ...):");
            String numStr = reader.readLine();

            try {

                int numInt = Integer.parseInt(numStr);

                if (numInt == 0) {
                    continue;
                }

                List<String> listOfVariants = generateParenthesesList(numInt);

                System.out.println("Number of variants - " + listOfVariants.size());

                for (String res : listOfVariants) {
                    System.out.println(res);
                }

                flag = false;

            } catch (Exception ignored) {
            }
        }

        reader.close();

    }
}