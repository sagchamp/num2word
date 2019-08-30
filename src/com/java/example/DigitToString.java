package com.java.example;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Java Class provides the utility to convert given number into word.
 */
public class DigitToString {

  private static final String[] UNITS = { "", " thousand", " million", " billion", " trillion", " quadrillion",
      " quintillion" };

  private static final String[] TENVALS = { "", " ten", " twenty", " thirty", " forty", " fifty", " sixty",
      " seventy", " eighty", " ninety" };

  private static final String[] NUMS = { "", " one", " two", " three", " four", " five", " six", " seven",
      " eight", " nine", " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen", " seventeen",
      " eighteen", " nineteen" };

  /**
   * This method converts the number which are less then thousands
   * @param number
   * @return String -  Converted string
   */
  private String convertThousands(int number) {
    String current;

    if (number % 100 < 20) {
      current = NUMS[number % 100];
      number /= 100;
    } else {
      current = NUMS[number % 10];
      number /= 10;

      current = TENVALS[number % 10] + current;
      number /= 10;
    }
    if (number == 0)
      return current;
    return NUMS[number] + " hundred and" + current;
  }

  /**
   * @param num
   * @return  String - The final converted string
   */
  public String convertDigitToString(int num) {
    if (num == 0) {
      return "zero";
    }

    String prefix = "";

    if (num < 0) {
      num = -num;
      prefix = "minus";
    }

    String current = "";
    int place = 0;

    do {
      int n = num % 1000;
      if (n != 0) {
        String s = convertThousands(n);
        current = s + UNITS[place] + current;
      }
      place++;
      num /= 1000;
    } while (num > 0);

    return (prefix + current).trim();
  }

  public static void main(String[] args) {
    Scanner scanner = null;
    DigitToString myObj = null;
    try {
      myObj = new DigitToString();
      scanner = new Scanner(System.in);
      System.out.print("Please Provide a number : ");
      int num = scanner.nextInt();
      System.out.println("Result  : " + myObj.convertDigitToString(num));
    } catch (InputMismatchException e) {
      System.out.println("Please enter only numbers between the range of -999,999,999 to 999,999,999 ...!!");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (null != scanner) {
        scanner.close();
      }
    }
  }
}