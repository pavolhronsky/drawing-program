package com.hronsky.pavol.program.drawing.drawing;

import com.hronsky.pavol.program.drawing.canvas.Canvas;
import com.hronsky.pavol.program.drawing.exception.PointOutOfCanvasException;

public class CharacterDrawingEngine implements DrawingEngine {

  private static final char LINE_CHARACTER = 'x';
  private static final int OFFSET = 1;

  private Canvas canvas;

  @Override
  public void setCanvas(Canvas canvas) {
    this.canvas = canvas;
  }

  @Override
  public void drawLine(int x1, int y1, int x2, int y2) throws PointOutOfCanvasException {
    validatePoint(x1, y1);
    validatePoint(x2, y2);

    if (x1 == x2) {
      drawVerticalLine(x1 - OFFSET, y1 - OFFSET, y2 - OFFSET);
    } else if (y1 == y2) {
      drawHorizontalLine(x1 - OFFSET, x2 - OFFSET, y1 - OFFSET);
    }
  }

  private void validatePoint(int x, int y) throws PointOutOfCanvasException {
    if (x < 1 || x > canvas.getWidth() || y < 1 || y > canvas.getHeight()) {
      throw new PointOutOfCanvasException("Point (" + x + ", " + y + ") does not lie inside canvas.");
    }
  }

  private void drawVerticalLine(int x, int y1, int y2) {
    if (y1 < y2) {
      for (int y = y1; y <= y2; y++) {
        canvas.setPixel(y, x, LINE_CHARACTER);
      }
    } else {
      for (int y = y1; y >= y2; y--) {
        canvas.setPixel(y, x, LINE_CHARACTER);
      }
    }
  }

  private void drawHorizontalLine(int x1, int x2, int y) {
    if (x1 < x2) {
      for (int x = x1; x <= x2; x++) {
        canvas.setPixel(y, x, LINE_CHARACTER);
      }
    } else {
      for (int x = x1; x >= x2; x--) {
        canvas.setPixel(y, x, LINE_CHARACTER);
      }
    }
  }

  @Override
  public void drawRectangle(int x1, int y1, int x2, int y2) throws PointOutOfCanvasException {
    drawLine(x1, y1, x1, y2);
    drawLine(x1, y1, x2, y1);
    drawLine(x2, y1, x2, y2);
    drawLine(x1, y2, x2, y2);
  }

  @Override
  public void fillWithColour(int x, int y, char newColour) throws PointOutOfCanvasException {
    validatePoint(x, y);

    char oldColour = canvas.getPixel(y - OFFSET, x - OFFSET);
    fillWithColour(oldColour, x - OFFSET, y - OFFSET, newColour);
  }

  private void fillWithColour(char oldColour, int x, int y, char newColour) {
    char currentColour = canvas.getPixel(y, x);

    if (currentColour != oldColour) {
      return;
    }

    canvas.setPixel(y, x, newColour);

    fillWithColour(oldColour, Math.max(0, x - 1), y, newColour);
    fillWithColour(oldColour, x, Math.max(0, y - 1), newColour);
    fillWithColour(oldColour, Math.min(canvas.getWidth() - 1, x + 1), y, newColour);
    fillWithColour(oldColour, x, Math.min(canvas.getHeight() - 1, y + 1), newColour);

    fillWithColour(oldColour, Math.max(0, x - 1), Math.max(0, y - 1), newColour);
    fillWithColour(oldColour, Math.min(canvas.getWidth() - 1, x + 1), Math.max(0, y - 1), newColour);
    fillWithColour(oldColour, Math.min(canvas.getWidth() - 1, x + 1), Math.min(canvas.getHeight() - 1, y + 1), newColour);
    fillWithColour(oldColour, Math.max(0, x - 1), Math.min(canvas.getHeight() - 1, y + 1), newColour);
  }

  @Override
  public String displayCanvas() {
    return canvas.display();
  }
}
