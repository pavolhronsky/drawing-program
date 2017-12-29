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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {

  private static final Logger LOGGER = LogManager.getLogger(App.class);

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
    LOGGER.info("Welcome to this drawing program!");
    String input = "S";

    while (!input.equals("Q")) {
      LOGGER.info("Enter command: ");
      input = scanner.nextLine();

      try {
        Command command = factory.create(input);
        LOGGER.info(command.execute(engine));
      } catch (UndefinedCommandException | PointOutOfCanvasException | InvalidNumberOfParametersException | WrongDimensionException | WrongInputTypeException | PointsNotAlignedException e) {
        LOGGER.info("ERROR: " + e.getMessage());
      }
    }
  }
}