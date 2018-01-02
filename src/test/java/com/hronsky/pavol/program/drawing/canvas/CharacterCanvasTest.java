package com.hronsky.pavol.program.drawing.canvas;

import com.hronsky.pavol.program.drawing.exception.WrongDimensionException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CharacterCanvasTest {

  private static final int WIDTH = 1;
  private static final int HEIGHT = 2;
  private static final Character COLORED_PIXEL = 'c';

  private Canvas<Character> canvas;

  @Before
  public void setUp() throws WrongDimensionException {
    canvas = new CharacterCanvas(WIDTH, HEIGHT);
  }

  @Test(expected = WrongDimensionException.class)
  public void testWrongWidthInput() throws WrongDimensionException {
    canvas = new CharacterCanvas(0, HEIGHT);
  }

  @Test(expected = WrongDimensionException.class)
  public void testWrongHeightInput() throws WrongDimensionException {
    canvas = new CharacterCanvas(WIDTH, -1);
  }

  @Test
  public void testGetWidth() {
    Assert.assertEquals(WIDTH, canvas.getWidth());
  }

  @Test
  public void testGetHeight() {
    Assert.assertEquals(HEIGHT, canvas.getHeight());
  }

  @Test
  public void testGetPixel() {
    Assert.assertEquals(CharacterCanvas.EMPTY_PIXEL, canvas.getPixel(0, 0));
  }

  @Test
  public void testSetPixel() {
    canvas.setPixel(HEIGHT - 1, WIDTH - 1, COLORED_PIXEL);
    Assert.assertEquals(COLORED_PIXEL, canvas.getPixel(HEIGHT - 1, WIDTH - 1));
  }

  @Test(expected = ArrayIndexOutOfBoundsException.class)
  public void testSetPixelWrongRow() {
    canvas.setPixel(-1, WIDTH - 1, COLORED_PIXEL);
  }

  @Test(expected = ArrayIndexOutOfBoundsException.class)
  public void testSetPixelWrongColumn() {
    canvas.setPixel(HEIGHT - 1, -1, COLORED_PIXEL);
  }

  @Test
  public void testDisplay() {
    String expected = "\n---\n| |\n| |\n---";
    Assert.assertEquals(expected, canvas.display());
  }
}