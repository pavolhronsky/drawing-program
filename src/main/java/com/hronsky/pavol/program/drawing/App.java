package com.hronsky.pavol.program.drawing;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Trololo, welcome!");
    String line = in.nextLine();
    System.out.println(line);
    while (!line.toUpperCase().equals("Q")) {
      line = in.nextLine();
      System.out.println(line);
    }
  }
}