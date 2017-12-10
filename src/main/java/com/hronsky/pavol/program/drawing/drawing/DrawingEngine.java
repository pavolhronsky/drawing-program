package com.hronsky.pavol.program.drawing.drawing;

import com.hronsky.pavol.program.drawing.canvas.Canvas;

public interface DrawingEngine {

  void setCanvas(Canvas canvas);

  void drawLine(int x1, int y1, int x2, int y2);

  void drawRectangle(int x1, int y1, int x2, int y2);

  void fillWithColour(int x, int y, char colour);

  String displayCanvas();
}
