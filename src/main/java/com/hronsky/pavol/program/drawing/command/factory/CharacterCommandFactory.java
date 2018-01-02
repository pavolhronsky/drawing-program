package com.hronsky.pavol.program.drawing.command.factory;

import com.hronsky.pavol.program.drawing.command.Command;
import com.hronsky.pavol.program.drawing.command.CreateCommand;
import com.hronsky.pavol.program.drawing.command.FillCommand;
import com.hronsky.pavol.program.drawing.command.LineCommand;
import com.hronsky.pavol.program.drawing.command.QuitCommand;
import com.hronsky.pavol.program.drawing.command.RectangleCommand;
import com.hronsky.pavol.program.drawing.converter.CharacterInputConverter;
import com.hronsky.pavol.program.drawing.converter.InputConverter;
import com.hronsky.pavol.program.drawing.converter.IntegerInputConverter;
import com.hronsky.pavol.program.drawing.exception.InvalidNumberOfParametersException;
import com.hronsky.pavol.program.drawing.exception.UndefinedCommandException;
import com.hronsky.pavol.program.drawing.exception.WrongInputTypeException;

public class CharacterCommandFactory {

  private InputConverter<Integer> integerConverter;
  private InputConverter<Character> characterConverter;

  public CharacterCommandFactory() {
    integerConverter = new IntegerInputConverter();
    characterConverter = new CharacterInputConverter();
  }

  public Command<Character> create(String rawInput) throws InvalidNumberOfParametersException, UndefinedCommandException, WrongInputTypeException {
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

  private Command<Character> createCreateCommand(String[] inputToArray) throws InvalidNumberOfParametersException, WrongInputTypeException {
    if (inputToArray.length < 3) {
      throw new InvalidNumberOfParametersException("Command C requires 2 integer inputs.");
    }

    int width = integerConverter.convert(inputToArray[1]);
    int height = integerConverter.convert(inputToArray[2]);

    return new CreateCommand<>(width, height);
  }

  private Command<Character> createLineCommand(String[] inputToArray) throws InvalidNumberOfParametersException, WrongInputTypeException {
    if (inputToArray.length < 5) {
      throw new InvalidNumberOfParametersException("Command L requires 4 integer inputs.");
    }

    int x1 = integerConverter.convert(inputToArray[1]);
    int y1 = integerConverter.convert(inputToArray[2]);
    int x2 = integerConverter.convert(inputToArray[3]);
    int y2 = integerConverter.convert(inputToArray[4]);

    return new LineCommand<>(x1, y1, x2, y2);
  }

  private Command<Character> createRectangleCommand(String[] inputToArray) throws InvalidNumberOfParametersException, WrongInputTypeException {
    if (inputToArray.length < 5) {
      throw new InvalidNumberOfParametersException("Command R requires 4 integer inputs.");
    }

    int x1 = integerConverter.convert(inputToArray[1]);
    int y1 = integerConverter.convert(inputToArray[2]);
    int x2 = integerConverter.convert(inputToArray[3]);
    int y2 = integerConverter.convert(inputToArray[4]);

    return new RectangleCommand<>(x1, y1, x2, y2);
  }

  private Command<Character> createFillCommand(String[] inputToArray) throws InvalidNumberOfParametersException, WrongInputTypeException {
    if (inputToArray.length < 4) {
      throw new InvalidNumberOfParametersException("Command B requires 2 integer inputs and 1 colour character.");
    }

    int x = integerConverter.convert(inputToArray[1]);
    int y = integerConverter.convert(inputToArray[2]);
    char c = characterConverter.convert(inputToArray[3]);

    return new FillCommand<>(x, y, c);
  }

  private Command<Character> createQuitCommand() {
    return new QuitCommand<>();
  }
}