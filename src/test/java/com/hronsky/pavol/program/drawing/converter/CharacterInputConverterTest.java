package com.hronsky.pavol.program.drawing.converter;

import com.hronsky.pavol.program.drawing.exception.WrongInputTypeException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CharacterInputConverterTest {

  private InputConverter<Character> converter;

  @Before
  public void before() {
    converter = new CharacterInputConverter();
  }

  @Test
  public void testConvert() throws WrongInputTypeException {
    Assert.assertEquals(Character.valueOf('c'), converter.convert("c"));
  }

  @Test(expected = WrongInputTypeException.class)
  public void testConvertException() throws WrongInputTypeException {
    Assert.assertEquals(Character.valueOf('c'), converter.convert("ca"));
  }
}