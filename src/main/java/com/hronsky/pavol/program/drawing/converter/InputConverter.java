package com.hronsky.pavol.program.drawing.converter;

import com.hronsky.pavol.program.drawing.exception.WrongInputTypeException;

public interface InputConverter<T> {

  T convert(String input) throws WrongInputTypeException;
}