package com.hronsky.pavol.program.drawing.converter;

import com.hronsky.pavol.program.drawing.exception.WrongInputTypeException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IntegerInputConverterTest {

  private InputConverter<Integer> converter;

  @Before
  public void before() {
    converter = new IntegerInputConverter();
  }

  @Test
  public void testConvert() throws WrongInputTypeException {
    Assert.assertEquals(Integer.valueOf(3), converter.convert("3"));
  }

  @Test(expected = WrongInputTypeException.class)
  public void testConvertException() throws WrongInputTypeException {
    Assert.assertEquals(Integer.valueOf(3), converter.convert("3a"));
  }
}