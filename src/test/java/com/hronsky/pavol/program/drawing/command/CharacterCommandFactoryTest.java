package com.hronsky.pavol.program.drawing.command;

import com.hronsky.pavol.program.drawing.command.factory.CharacterCommandFactory;
import com.hronsky.pavol.program.drawing.exception.InvalidNumberOfParametersException;
import com.hronsky.pavol.program.drawing.exception.UndefinedCommandException;
import com.hronsky.pavol.program.drawing.exception.WrongInputTypeException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CharacterCommandFactoryTest {

  private CharacterCommandFactory factory;

  @Before
  public void before() {
    factory = new CharacterCommandFactory();
  }

  @Test(expected = InvalidNumberOfParametersException.class)
  public void testCreateCommandInvalidNumberOfParametersException() throws WrongInputTypeException, InvalidNumberOfParametersException, UndefinedCommandException {
    factory.create("C 1");
  }

  @Test(expected = InvalidNumberOfParametersException.class)
  public void testLineCommandInvalidNumberOfParametersException() throws WrongInputTypeException, InvalidNumberOfParametersException, UndefinedCommandException {
    factory.create("L 1 1 2");
  }

  @Test(expected = InvalidNumberOfParametersException.class)
  public void testRectangleCommandInvalidNumberOfParametersException() throws WrongInputTypeException, InvalidNumberOfParametersException, UndefinedCommandException {
    factory.create("R 1 3");
  }

  @Test(expected = InvalidNumberOfParametersException.class)
  public void testFillCommandInvalidNumberOfParametersException() throws WrongInputTypeException, InvalidNumberOfParametersException, UndefinedCommandException {
    factory.create("B 1 1");
  }

  @Test(expected = UndefinedCommandException.class)
  public void testCreateUndefinedCommandException() throws WrongInputTypeException, InvalidNumberOfParametersException, UndefinedCommandException {
    factory.create("A");
  }

  @Test(expected = WrongInputTypeException.class)
  public void testWrongInputTypeException() throws WrongInputTypeException, InvalidNumberOfParametersException, UndefinedCommandException {
    factory.create("B 1 1 11");
  }

  @Test
  public void testCreateCreateCommand() throws WrongInputTypeException, InvalidNumberOfParametersException, UndefinedCommandException {
    Command<Character> expected = new CreateCommand<>(1, 1);
    Command<Character> actual = factory.create("C 1 1");
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testCreateLineCommand() throws WrongInputTypeException, InvalidNumberOfParametersException, UndefinedCommandException {
    Command<Character> expected = new LineCommand<>(1, 1, 2, 2);
    Command<Character> actual = factory.create("L 1 1 2 2");
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testCreateRectangleCommand() throws WrongInputTypeException, InvalidNumberOfParametersException, UndefinedCommandException {
    Command<Character> expected = new RectangleCommand<>(1, 1, 2, 2);
    Command<Character> actual = factory.create("R 1 1 2 2");
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testCreateFillCommand() throws WrongInputTypeException, InvalidNumberOfParametersException, UndefinedCommandException {
    Command<Character> expected = new FillCommand<>(1, 1, 'c');
    Command<Character> actual = factory.create("B 1 1 c");
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testCreateQuitCommand() throws WrongInputTypeException, InvalidNumberOfParametersException, UndefinedCommandException {
    Command<Character> actual = factory.create("Q");
    Assert.assertTrue(actual instanceof QuitCommand);
  }
}