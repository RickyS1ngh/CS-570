// CS 570 Homework Assignment 2 Complexities
// Gurjinder Sohal

public class Complexity {

  // O(n)
  public static void method0(int n) {
    int counter = 0;

    for (int i = 0; i < n; i++) {
      System.out.println("Operation " + counter);
      counter++;
    }
  }

  // O(n^2)
  public static void method1(int n) {
    int counter = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.println("Operation " + counter);
        counter++;
      }
    }
  }

  // O(n^3)
  public static void method2(int n) {
    int counter = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          System.out.println("Operation " + counter);
          counter++;
        }
      }
    }
  }

  // O(logn)
  public static void method3(int n) {
    int counter = 0;

    for (int i = n; i > 0; i /= 2) {
      System.out.println("Operation " + counter);
      counter++;
    }
  }

  // O(nlogn)
  public static void method4(int n) {
    int counter = 0;

    for (int i = 0; i < n; i++) {
      for (int j = n; j > 0; j /= 2) {
        System.out.println("Operation " + counter);
        counter++;
      }
    }
  }

  // O(loglogn)
  public static void method5(int n) {
    int counter = 0;

    for (double i = 2; i <= n; i = Math.pow(i, 2)) {
      System.out.println("Operation " + counter);
      counter++;
    }
  }
}
