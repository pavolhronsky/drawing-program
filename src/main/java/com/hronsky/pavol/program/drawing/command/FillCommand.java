package com.hronsky.pavol.program.drawing.command;

import com.hronsky.pavol.program.drawing.drawing.DrawingEngine;
import com.hronsky.pavol.program.drawing.exception.PointOutOfCanvasException;
import java.util.Objects;

public class FillCommand implements Command {

  private final int x;
  private final int y;
  private final char c;

  FillCommand(int x, int y, char c) {
    this.x = x;
    this.y = y;
    this.c = c;
  }

  @Override
  public String execute(DrawingEngine engine) throws PointOutOfCanvasException {
    engine.fillWithColour(x, y, c);
    return engine.displayCanvas();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FillCommand that = (FillCommand) o;
    return x == that.x &&
        y == that.y &&
        c == that.c;
  }

  @Override
  public int hashCode() {

    return Objects.hash(x, y, c);
  }
}
