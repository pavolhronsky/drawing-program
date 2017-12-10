package com.hronsky.pavol.program.drawing.drawing;

import com.hronsky.pavol.program.drawing.canvas.Canvas;
import com.hronsky.pavol.program.drawing.canvas.CharacterCanvas;
import com.hronsky.pavol.program.drawing.exception.PointOutOfCanvasException;
import com.hronsky.pavol.program.drawing.exception.PointsNotAlignedException;
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
  public void testDrawHorizontalLine1() throws PointOutOfCanvasException, PointsNotAlignedException {
    drawingEngine.drawLine(1, 2, 2, 2);
    String expected = "-----\n|   |\n|xx |\n|   |\n|   |\n-----\n";
    Assert.assertEquals(expected, drawingEngine.displayCanvas());
  }

  @Test
  public void testDrawHorizontalLine2() throws PointOutOfCanvasException, PointsNotAlignedException {
    drawingEngine.drawLine(2, 2, 1, 2);
    String expected = "-----\n|   |\n|xx |\n|   |\n|   |\n-----\n";
    Assert.assertEquals(expected, drawingEngine.displayCanvas());
  }

  @Test
  public void testDrawVerticalLine1() throws PointOutOfCanvasException, PointsNotAlignedException {
    drawingEngine.drawLine(2, 2, 2, 4);
    String expected = "-----\n|   |\n| x |\n| x |\n| x |\n-----\n";
    Assert.assertEquals(expected, drawingEngine.displayCanvas());
  }

  @Test
  public void testDrawVerticalLine2() throws PointOutOfCanvasException, PointsNotAlignedException {
    drawingEngine.drawLine(2, 4, 2, 2);
    String expected = "-----\n|   |\n| x |\n| x |\n| x |\n-----\n";
    Assert.assertEquals(expected, drawingEngine.displayCanvas());
  }

  @Test(expected = PointsNotAlignedException.class)
  public void testPointsNotAlignedException() throws PointsNotAlignedException, PointOutOfCanvasException {
    drawingEngine.drawLine(1, 2, 3, 4);
  }

  @Test
  public void testDrawRectangle() throws PointOutOfCanvasException, PointsNotAlignedException {
    drawingEngine.drawRectangle(1, 1, 3, 4);
    String expected = "-----\n|xxx|\n|x x|\n|x x|\n|xxx|\n-----\n";
    Assert.assertEquals(expected, drawingEngine.displayCanvas());
  }

  @Test
  public void fillEmptyCanvasWithColour() throws PointOutOfCanvasException {
    drawingEngine.fillWithColour(1, 1, 'c');
    String after = "-----\n|ccc|\n|ccc|\n|ccc|\n|ccc|\n-----\n";
    Assert.assertEquals(after, drawingEngine.displayCanvas());
  }

  @Test
  public void testFillInsideFullSizedRectangle() throws PointOutOfCanvasException, PointsNotAlignedException {
    drawingEngine.drawRectangle(1, 2, 3, 4);
    drawingEngine.fillWithColour(2, 3, 'c');
    String expected = "-----\n|   |\n|xxx|\n|xcx|\n|xxx|\n-----\n";
    Assert.assertEquals(expected, drawingEngine.displayCanvas());
  }

  @Test
  public void testFillBorderFullSizedRectangle() throws PointOutOfCanvasException, PointsNotAlignedException {
    drawingEngine.drawRectangle(1, 2, 3, 4);
    drawingEngine.fillWithColour(1, 2, 'c');
    String expected = "-----\n|   |\n|ccc|\n|c c|\n|ccc|\n-----\n";
    Assert.assertEquals(expected, drawingEngine.displayCanvas());
  }

  @Test
  public void testFillPartialRectangleInside() throws PointOutOfCanvasException, PointsNotAlignedException {
    drawingEngine.drawLine(1, 2, 2, 2);
    drawingEngine.drawLine(2, 2, 2, 4);
    drawingEngine.fillWithColour(1, 4, 'c');
    String expected = "-----\n|   |\n|xx |\n|cx |\n|cx |\n-----\n";
    Assert.assertEquals(expected, drawingEngine.displayCanvas());
  }

  @Test
  public void testFillPartialRectangleOutside() throws PointOutOfCanvasException, PointsNotAlignedException {
    drawingEngine.drawLine(1, 2, 2, 2);
    drawingEngine.drawLine(2, 2, 2, 4);
    drawingEngine.fillWithColour(1, 1, 'c');
    String expected = "-----\n|ccc|\n|xxc|\n| xc|\n| xc|\n-----\n";
    Assert.assertEquals(expected, drawingEngine.displayCanvas());
  }

  @Test
  public void testFillWithHorizontalLine() throws PointOutOfCanvasException, PointsNotAlignedException {
    drawingEngine.drawLine(1, 2, 2, 2);
    drawingEngine.fillWithColour(1, 1, 'c');
    String expected = "-----\n|ccc|\n|xxc|\n|ccc|\n|ccc|\n-----\n";
    Assert.assertEquals(expected, drawingEngine.displayCanvas());
  }

  @Test
  public void testFillHorizontalLine() throws PointOutOfCanvasException, PointsNotAlignedException {
    drawingEngine.drawLine(1, 2, 2, 2);
    drawingEngine.fillWithColour(1, 2, 'c');
    String expected = "-----\n|   |\n|cc |\n|   |\n|   |\n-----\n";
    Assert.assertEquals(expected, drawingEngine.displayCanvas());
  }

  @Test
  public void testFillWithVerticalLine() throws PointOutOfCanvasException, PointsNotAlignedException {
    drawingEngine.drawLine(2, 1, 2, 3);
    drawingEngine.fillWithColour(1, 1, 'c');
    String expected = "-----\n|cxc|\n|cxc|\n|cxc|\n|ccc|\n-----\n";
    Assert.assertEquals(expected, drawingEngine.displayCanvas());
  }

  @Test
  public void testFillVerticalLine() throws PointOutOfCanvasException, PointsNotAlignedException {
    drawingEngine.drawLine(2, 1, 2, 3);
    drawingEngine.fillWithColour(2, 1, 'c');
    String expected = "-----\n| c |\n| c |\n| c |\n|   |\n-----\n";
    Assert.assertEquals(expected, drawingEngine.displayCanvas());
  }

  @Test
  public void testDisplayCanvas() {
    String expected = "-----\n|   |\n|   |\n|   |\n|   |\n-----\n";
    Assert.assertEquals(expected, drawingEngine.displayCanvas());
  }

  @Test(expected = PointOutOfCanvasException.class)
  public void testPointOutOfCanvasException() throws PointOutOfCanvasException {
    drawingEngine.fillWithColour(0, 0, 'c');
  }

  @Test
  public void testSampleIO() throws WrongDimensionException, PointOutOfCanvasException, PointsNotAlignedException {
    Canvas canvas = new CharacterCanvas(20, 4);
    drawingEngine.setCanvas(canvas);

    String expected = "----------------------\n|                    |\n|                    |\n|                    |\n|                    |\n----------------------\n";
    Assert.assertEquals(expected, drawingEngine.displayCanvas());

    drawingEngine.drawLine(1, 2, 6, 2);
    expected = "----------------------\n|                    |\n|xxxxxx              |\n|                    |\n|                    |\n----------------------\n";
    Assert.assertEquals(expected, drawingEngine.displayCanvas());

    drawingEngine.drawLine(6, 3, 6, 4);
    expected = "----------------------\n|                    |\n|xxxxxx              |\n|     x              |\n|     x              |\n----------------------\n";
    Assert.assertEquals(expected, drawingEngine.displayCanvas());

    drawingEngine.drawRectangle(14, 1, 18, 3);
    expected = "----------------------\n|             xxxxx  |\n|xxxxxx       x   x  |\n|     x       xxxxx  |\n|     x              |\n----------------------\n";
    Assert.assertEquals(expected, drawingEngine.displayCanvas());

    drawingEngine.fillWithColour(10, 3, 'o');
    expected = "----------------------\n|oooooooooooooxxxxxoo|\n|xxxxxxooooooox   xoo|\n|     xoooooooxxxxxoo|\n|     xoooooooooooooo|\n----------------------\n";
    Assert.assertEquals(expected, drawingEngine.displayCanvas());
  }
}