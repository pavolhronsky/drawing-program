package com.hronsky.pavol.program.drawing.validator;

public class CreateCommandValidator implements CommandValidator {

  private static final int NUMBER_OF_PARAMETERS = 3;

  @Override
  public boolean validate(String command) {
    String[] paramters = command.split(" ");
    if (paramters.length != NUMBER_OF_PARAMETERS) {
      return false;
    }

    return true;
  }
}
