package com.hronsky.pavol.program.drawing.command;

import com.hronsky.pavol.program.drawing.drawing.DrawingEngine;
import com.hronsky.pavol.program.drawing.exception.PointOutOfCanvasException;

public class LineCommand implements Command {

  private final int x1;
  private final int y1;
  private final int x2;
  private final int y2;

  public LineCommand(int x1, int y1, int x2, int y2) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
  }

  @Override
  public String execute(DrawingEngine engine) throws PointOutOfCanvasException {
    engine.drawLine(x1, y1, x2, y2);
    return engine.displayCanvas();
  }
}
