package com.hronsky.pavol.program.drawing.converter;

import com.hronsky.pavol.program.drawing.exception.WrongInputTypeException;

public class IntegerInputConverter implements InputConverter<Integer> {

  @Override
  public Integer convert(String input) throws WrongInputTypeException {
    try {
      return Integer.parseInt(input);
    } catch (NumberFormatException e) {
      throw new WrongInputTypeException("Input \'" + input + "\' cannot be converted to type <Integer>.");
    }
  }
}
