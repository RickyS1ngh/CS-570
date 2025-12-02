// CS 570 Homework Assignment 1 (little-endian format)
// Gurjinder Sohal

public class BinaryNumber {

  private int[] data;
  boolean overflow;

  public BinaryNumber() {}

  public BinaryNumber(int length) {
    this.data = new int[length];
    this.overflow = false;
  }

  public BinaryNumber(String str) {
    this.overflow = false;
    this.data = new int[str.length()];
    char ch;
    for (int i = 0; i < str.length(); i++) {
      ch = str.charAt(i);
      this.data[i] = Character.getNumericValue(ch);
    }
  }

  public int getLength() {
    return this.data.length;
  }

  public int getDigit(int index) {
    if (index >= this.data.length) {
      System.out.println(
        "Index " +
        index +
        " out of bounds for the binary number of length " +
        this.data.length
      );
      return -1; //
    } else {
      return this.data[index];
    }
  }

  public int toDecimal() {
    int decimal = 0;

    for (int i = 0; i < data.length; i++) {
      decimal += this.data[i] * Math.pow(2, i);
    }

    return decimal;
  }

  public void shiftR(int amount) {
    reallocate(amount);
  }

  private void reallocate(int amount) {
    int[] temp = new int[this.data.length + amount]; //creates a new array

    for (int i = 0; i < temp.length; i++) {
      temp[i + amount] = this.data[i];
    }
    this.data = temp;
  }

  public void add(BinaryNumber aBinaryNumber) {
    if (this.data.length != aBinaryNumber.data.length) {
      System.out.println("Length of the binary numbers do not coincide");
    } else {
      int[] result = new int[this.data.length];
      int carry = 0;

      for (int i = 0; i < this.data.length; i++) {
        int sum = carry;
        sum = this.data[i] + aBinaryNumber.data[i] + sum; // sum of the digits and carry
        result[i] = sum % 2; // sum is assigned to the array
        carry = sum / 2;
      }

      if (carry != 0) {
        this.overflow = true;
      }
      this.data = result;
    }
  }

  public void clearOverflow() {
    this.overflow = false;
  }

  public String toString() {
    if (this.overflow) {
      return "Overflow";
    }
    String str = "";

    for (int i = 0; i < this.data.length; i++) {
      str += String.valueOf(this.data[i]);
    }
    return str;
  }
}
