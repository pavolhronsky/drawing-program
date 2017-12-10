package com.hronsky.pavol.program.drawing.converter;

import com.hronsky.pavol.program.drawing.exception.WrongInputTypeException;

public class CharacterInputConverter implements InputConverter<Character> {

  @Override
  public Character convert(String input) throws WrongInputTypeException {
    if (input.length() > 1) {
      throw new WrongInputTypeException("Input \'" + input + "\' cannot be converted to type <Character>.");
    }
    return input.charAt(0);
  }
}