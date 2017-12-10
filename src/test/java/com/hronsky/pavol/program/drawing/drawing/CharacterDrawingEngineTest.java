package com.hronsky.pavol.program.drawing.drawing;

import com.hronsky.pavol.program.drawing.canvas.Canvas;
import com.hronsky.pavol.program.drawing.canvas.CharacterCanvas;
import com.hronsky.pavol.program.drawing.exception.PointOutOfCanvasException;
import com.hronsky.pavol.program.drawing.exception.WrongDimensionException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CharacterDrawingEngineTest {

  private DrawingEngine drawingEngine = new CharacterDrawingEngine();

  @Before
  public void setUp() throws Exception {
    Canvas canvas = new CharacterCanvas(3, 4);
    drawingEngine.setCanvas(canvas);
  }

  @Test
  public void testSetCanvas() {
    String expected = "-----\n|   |\n|   |\n|   |\n|   |\n-----\n";
    Assert.assertEquals(expected, drawingEngine.displayCanvas());
  }

  @Test
  public void testDrawHorizontalLine1() throws PointOutOfCanvasException {
    drawingEngine.drawLine(0, 1, 1, 1);
    String expected = "-----\n|   |\n|xx |\n|   |\n|   |\n-----\n";
    Assert.assertEquals(expected, drawingEngine.displayCanvas());
  }

  @Test
  public void testDrawHorizontalLine2() throws PointOutOfCanvasException {
    drawingEngine.drawLine(1, 1, 0, 1);
    String expected = "-----\n|   |\n|xx |\n|   |\n|   |\n-----\n";
    Assert.assertEquals(expected, drawingEngine.displayCanvas());
  }

  @Test
  public void testDrawVerticalLine1() throws PointOutOfCanvasException {
    drawingEngine.drawLine(1, 1, 1, 3);
    String expected = "-----\n|   |\n| x |\n| x |\n| x |\n-----\n";
    Assert.assertEquals(expected, drawingEngine.displayCanvas());
  }

  @Test
  public void testDrawVerticalLine2() throws PointOutOfCanvasException {
    drawingEngine.drawLine(1, 3, 1, 1);
    String expected = "-----\n|   |\n| x |\n| x |\n| x |\n-----\n";
    Assert.assertEquals(expected, drawingEngine.displayCanvas());
  }

  @Test
  public void testDrawRectangle() throws PointOutOfCanvasException {
    drawingEngine.drawRectangle(0, 0, 2, 3);
    String expected = "-----\n|xxx|\n|x x|\n|x x|\n|xxx|\n-----\n";
    Assert.assertEquals(expected, drawingEngine.displayCanvas());
  }

  @Test
  public void fillEmptyCanvasWithColour() throws PointOutOfCanvasException {
    drawingEngine.fillWithColour(0, 0, 'c');
    String after = "-----\n|ccc|\n|ccc|\n|ccc|\n|ccc|\n-----\n";
    Assert.assertEquals(after, drawingEngine.displayCanvas());
  }

  @Test
  public void testFillInsideFullSizedRectangle() throws PointOutOfCanvasException {
    drawingEngine.drawRectangle(0, 1, 2, 3);
    drawingEngine.fillWithColour(1, 2, 'c');
    String expected = "-----\n|   |\n|xxx|\n|xcx|\n|xxx|\n-----\n";
    Assert.assertEquals(expected, drawingEngine.displayCanvas());
  }

  @Test
  public void testFillBorderFullSizedRectangle() throws PointOutOfCanvasException {
    drawingEngine.drawRectangle(0, 1, 2, 3);
    drawingEngine.fillWithColour(0, 1, 'c');
    String expected = "-----\n|   |\n|ccc|\n|c c|\n|ccc|\n-----\n";
    Assert.assertEquals(expected, drawingEngine.displayCanvas());
  }

  @Test
  public void testFillPartialRectangleInside() throws PointOutOfCanvasException {
    drawingEngine.drawLine(0, 1, 1, 1);
    drawingEngine.drawLine(1, 1, 1, 3);
    drawingEngine.fillWithColour(0, 3, 'c');
    String expected = "-----\n|   |\n|xx |\n|cx |\n|cx |\n-----\n";
    Assert.assertEquals(expected, drawingEngine.displayCanvas());
  }

  @Test
  public void testFillPartialRectangleOutside() throws PointOutOfCanvasException {
    drawingEngine.drawLine(0, 1, 1, 1);
    drawingEngine.drawLine(1, 1, 1, 3);
    drawingEngine.fillWithColour(0, 0, 'c');
    String expected = "-----\n|ccc|\n|xxc|\n| xc|\n| xc|\n-----\n";
    Assert.assertEquals(expected, drawingEngine.displayCanvas());
  }

  @Test
  public void testFillWithHorizontalLine() throws PointOutOfCanvasException {
    drawingEngine.drawLine(0, 1, 1, 1);
    drawingEngine.fillWithColour(0, 0, 'c');
    String expected = "-----\n|ccc|\n|xxc|\n|ccc|\n|ccc|\n-----\n";
    Assert.assertEquals(expected, drawingEngine.displayCanvas());
  }

  @Test
  public void testFillHorizontalLine() throws PointOutOfCanvasException {
    drawingEngine.drawLine(0, 1, 1, 1);
    drawingEngine.fillWithColour(0, 1, 'c');
    String expected = "-----\n|   |\n|cc |\n|   |\n|   |\n-----\n";
    Assert.assertEquals(expected, drawingEngine.displayCanvas());
  }

  @Test
  public void testFillWithVerticalLine() throws PointOutOfCanvasException {
    drawingEngine.drawLine(1, 0, 1, 2);
    drawingEngine.fillWithColour(0, 0, 'c');
    String expected = "-----\n|cxc|\n|cxc|\n|cxc|\n|ccc|\n-----\n";
    Assert.assertEquals(expected, drawingEngine.displayCanvas());
  }

  @Test
  public void testFillVerticalLine() throws PointOutOfCanvasException {
    drawingEngine.drawLine(1, 0, 1, 2);
    drawingEngine.fillWithColour(1, 0, 'c');
    String expected = "-----\n| c |\n| c |\n| c |\n|   |\n-----\n";
    Assert.assertEquals(expected, drawingEngine.displayCanvas());
  }

  @Test
  public void testDisplayCanvas() {
    String expected = "-----\n|   |\n|   |\n|   |\n|   |\n-----\n";
    Assert.assertEquals(expected, drawingEngine.displayCanvas());
  }

  @Test
  public void testSampleIO() throws WrongDimensionException, PointOutOfCanvasException {
    Canvas canvas = new CharacterCanvas(20, 4);
    drawingEngine.setCanvas(canvas);

    String expected = "----------------------\n|                    |\n|                    |\n|                    |\n|                    |\n----------------------\n";
    Assert.assertEquals(expected, drawingEngine.displayCanvas());

    drawingEngine.drawLine(0, 1, 5, 1);
    expected = "----------------------\n|                    |\n|xxxxxx              |\n|                    |\n|                    |\n----------------------\n";
    Assert.assertEquals(expected, drawingEngine.displayCanvas());

    drawingEngine.drawLine(5, 2, 5, 3);
    expected = "----------------------\n|                    |\n|xxxxxx              |\n|     x              |\n|     x              |\n----------------------\n";
    Assert.assertEquals(expected, drawingEngine.displayCanvas());

    drawingEngine.drawRectangle(13, 0, 17, 2);
    expected = "----------------------\n|             xxxxx  |\n|xxxxxx       x   x  |\n|     x       xxxxx  |\n|     x              |\n----------------------\n";
    Assert.assertEquals(expected, drawingEngine.displayCanvas());

    drawingEngine.fillWithColour(9, 2, 'o');
    expected = "----------------------\n|oooooooooooooxxxxxoo|\n|xxxxxxooooooox   xoo|\n|     xoooooooxxxxxoo|\n|     xoooooooooooooo|\n----------------------\n";
    Assert.assertEquals(expected, drawingEngine.displayCanvas());
  }
}