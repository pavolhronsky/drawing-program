package com.hronsky.pavol.program.drawing;

import com.hronsky.pavol.program.drawing.command.Command;
import com.hronsky.pavol.program.drawing.command.CommandFactory;
import com.hronsky.pavol.program.drawing.drawing.CharacterDrawingEngine;
import com.hronsky.pavol.program.drawing.drawing.DrawingEngine;
import com.hronsky.pavol.program.drawing.exception.InvalidNumberOfParametersException;
import com.hronsky.pavol.program.drawing.exception.PointOutOfCanvasException;
import com.hronsky.pavol.program.drawing.exception.UndefinedCommandException;
import com.hronsky.pavol.program.drawing.exception.WrongDimensionException;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    DrawingEngine engine = new CharacterDrawingEngine();

    System.out.println("Welcome to this drawing program!");
    String input = "S";

    while (!input.equals("Q")) {
      System.out.print("Enter command: ");
      input = in.nextLine();

      try {
        Command command = CommandFactory.create(input);
        String result = command.execute(engine);
        System.out.println(result);
      } catch (UndefinedCommandException | PointOutOfCanvasException | InvalidNumberOfParametersException | WrongDimensionException e) {
        System.out.println("ERROR: " + e.getMessage());
      }
    }
  }
}