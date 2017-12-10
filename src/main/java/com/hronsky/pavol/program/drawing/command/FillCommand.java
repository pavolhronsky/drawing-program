package com.hronsky.pavol.program.drawing.command;

import com.hronsky.pavol.program.drawing.drawing.DrawingEngine;
import com.hronsky.pavol.program.drawing.exception.PointOutOfCanvasException;

public class FillCommand implements Command {

  private final int x;
  private final int y;
  private final char c;

  public FillCommand(int x, int y, char c) {
    this.x = x;
    this.y = y;
    this.c = c;
  }

  @Override
  public String execute(DrawingEngine engine) throws PointOutOfCanvasException {
    engine.fillWithColour(x, y, c);
    return engine.displayCanvas();
  }
}
