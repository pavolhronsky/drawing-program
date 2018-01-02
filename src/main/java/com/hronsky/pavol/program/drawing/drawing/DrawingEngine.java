package com.hronsky.pavol.program.drawing.drawing;

import com.hronsky.pavol.program.drawing.canvas.Canvas;
import com.hronsky.pavol.program.drawing.exception.PointOutOfCanvasException;
import com.hronsky.pavol.program.drawing.exception.PointsNotAlignedException;

public interface DrawingEngine<T> {

  void setCanvas(Canvas<T> canvas);

  void drawLine(int x1, int y1, int x2, int y2) throws PointOutOfCanvasException, PointsNotAlignedException;

  void drawRectangle(int x1, int y1, int x2, int y2) throws PointOutOfCanvasException, PointsNotAlignedException;

  void fillWithColour(int x, int y, T colour) throws PointOutOfCanvasException;

  String displayCanvas();
}
