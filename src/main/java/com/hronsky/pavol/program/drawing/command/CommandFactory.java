package com.hronsky.pavol.program.drawing.command;

import com.hronsky.pavol.program.drawing.exception.InvalidNumberOfParametersException;
import com.hronsky.pavol.program.drawing.exception.UndefinedCommandException;

public class CommandFactory {

  private CommandFactory() {
    //
  }

  public static Command create(String rawInput) throws InvalidNumberOfParametersException, NumberFormatException, UndefinedCommandException {
    String[] inputToArray = rawInput.trim().split(" ");

    switch (inputToArray[0]) {
      case "C":
        return createCreateCommand(inputToArray);
      case "L":
        return createLineCommand(inputToArray);
      case "R":
        return createRectangleCommand(inputToArray);
      case "B":
        return createFillCommand(inputToArray);
      case "Q":
        return createQuitCommand();
      default:
        throw new UndefinedCommandException("No such command as \'" + rawInput + "\'.");
    }
  }

  private static Command createCreateCommand(String[] inputToArray) throws InvalidNumberOfParametersException {
    if (inputToArray.length < 3) {
      throw new InvalidNumberOfParametersException("Command C requires 2 integer inputs.");
    }

    int width = Integer.parseInt(inputToArray[1]);
    int height = Integer.parseInt(inputToArray[2]);

    return new CreateCommand(width, height);
  }

  private static Command createLineCommand(String[] inputToArray) throws InvalidNumberOfParametersException {
    if (inputToArray.length < 5) {
      throw new InvalidNumberOfParametersException("Command L requires 4 integer inputs.");
    }

    int x1 = Integer.parseInt(inputToArray[1]);
    int y1 = Integer.parseInt(inputToArray[2]);
    int x2 = Integer.parseInt(inputToArray[3]);
    int y2 = Integer.parseInt(inputToArray[4]);

    return new LineCommand(x1, y1, x2, y2);
  }

  private static Command createRectangleCommand(String[] inputToArray) throws InvalidNumberOfParametersException {
    if (inputToArray.length < 5) {
      throw new InvalidNumberOfParametersException("Command R requires 4 integer inputs.");
    }

    int x1 = Integer.parseInt(inputToArray[1]);
    int y1 = Integer.parseInt(inputToArray[2]);
    int x2 = Integer.parseInt(inputToArray[3]);
    int y2 = Integer.parseInt(inputToArray[4]);

    return new RectangleCommand(x1, y1, x2, y2);
  }

  private static Command createFillCommand(String[] inputToArray) throws InvalidNumberOfParametersException {
    if (inputToArray.length < 4) {
      throw new InvalidNumberOfParametersException("Command B requires 2 integer inputs and 1 colour character.");
    }

    int x = Integer.parseInt(inputToArray[1]);
    int y = Integer.parseInt(inputToArray[2]);
    char c = inputToArray[3].charAt(0);

    return new FillCommand(x, y, c);
  }

  private static QuitCommand createQuitCommand() {
    return new QuitCommand();
  }
}