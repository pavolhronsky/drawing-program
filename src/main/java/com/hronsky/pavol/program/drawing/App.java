package com.hronsky.pavol.program.drawing;

import com.hronsky.pavol.program.drawing.command.Command;
import com.hronsky.pavol.program.drawing.command.CommandFactory;
import com.hronsky.pavol.program.drawing.drawing.CharacterDrawingEngine;
import com.hronsky.pavol.program.drawing.drawing.DrawingEngine;
import com.hronsky.pavol.program.drawing.exception.InvalidNumberOfParametersException;
import com.hronsky.pavol.program.drawing.exception.PointOutOfCanvasException;
import com.hronsky.pavol.program.drawing.exception.PointsNotAlignedException;
import com.hronsky.pavol.program.drawing.exception.UndefinedCommandException;
import com.hronsky.pavol.program.drawing.exception.WrongDimensionException;
import com.hronsky.pavol.program.drawing.exception.WrongInputTypeException;
import java.util.Scanner;

public class App {

  private Scanner scanner;
  private CommandFactory factory;
  private DrawingEngine engine;

  public App() {
    scanner = new Scanner(System.in);
    factory = new CommandFactory();
    engine = new CharacterDrawingEngine();
  }

  public static void main(String[] args) {
    App app = new App();
    app.run();
  }

  private void run() {
    System.out.println("Welcome to this drawing program!");
    String input = "S";

    while (!input.equals("Q")) {
      System.out.print("Enter command: ");
      input = scanner.nextLine();

      try {
        Command command = factory.create(input);
        System.out.println(command.execute(engine));
      } catch (UndefinedCommandException | PointOutOfCanvasException | InvalidNumberOfParametersException | WrongDimensionException | WrongInputTypeException | PointsNotAlignedException e) {
        System.out.println("ERROR: " + e.getMessage());
      }
    }
  }
}