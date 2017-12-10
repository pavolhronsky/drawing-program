package com.hronsky.pavol.program.drawing.drawing;

import com.hronsky.pavol.program.drawing.canvas.Canvas;
import com.hronsky.pavol.program.drawing.exception.PointOutOfCanvasException;

public interface DrawingEngine {

  void setCanvas(Canvas canvas);

  void drawLine(int x1, int y1, int x2, int y2) throws PointOutOfCanvasException;

  void drawRectangle(int x1, int y1, int x2, int y2) throws PointOutOfCanvasException;

  void fillWithColour(int x, int y, char colour) throws PointOutOfCanvasException;

  String displayCanvas();
}
