package org.example;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // 最初の数値を入力
    double num1 = getValidatedNumber(scanner, "１番目の数値を入力してください: ");

    // 演算子を入力
    System.out.print("演算子 (+, -, *, /) を入力してください: ");
    char operator = scanner.next().charAt(0);

    // 次の数値を入力
    double num2 = getValidatedNumber(scanner, "２番目の数値を入力してください: ");

    double result;

    // 演算の処理
    switch (operator) {
      case '+':
        result = num1 + num2;
        break;
      case '-':
        result = num1 - num2;
        break;
      case '*':
        result = num1 * num2;
        break;
      case '/':
        // 0で割ることを防止するためのチェック
        if (num2 != 0) {
          result = num1 / num2;
        } else {
          System.out.println("エラー: 0で割ることはできません。");
          return;
        }
        break;
      default:
        System.out.println("エラー: 無効な演算子です。");
        return;
    }

    // 結果を表示
    System.out.println("結果: " + result);
  }

  // ユーザー入力を受け取り、数字かどうか判定するメソッド
  public static double getValidatedNumber(Scanner scanner, String prompt) {
    String input;
    while (true) {
      System.out.print(prompt);
      input = scanner.next();
      if (isNumeric(input)) {
        return Double.parseDouble(input);
      } else {
        System.out.println("エラー: 数字を入力してください。");
      }
    }
  }

  // 数字かどうかを判定するメソッド
  public static boolean isNumeric(String str) {
    // 正規表現を使用して数字かどうかを判定
    return str.matches("-?\\d+(\\.\\d+)?");
  }
}
