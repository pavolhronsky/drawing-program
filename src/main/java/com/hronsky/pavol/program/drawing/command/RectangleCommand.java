package com.hronsky.pavol.program.drawing.command;

import com.hronsky.pavol.program.drawing.drawing.DrawingEngine;
import com.hronsky.pavol.program.drawing.exception.PointOutOfCanvasException;
import com.hronsky.pavol.program.drawing.exception.PointsNotAlignedException;
import java.util.Objects;

public class RectangleCommand implements Command {

  private final int x1;
  private final int y1;
  private final int x2;
  private final int y2;

  RectangleCommand(int x1, int y1, int x2, int y2) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
  }

  @Override
  public void execute(DrawingEngine<Character> engine) throws PointOutOfCanvasException, PointsNotAlignedException {
    engine.drawRectangle(x1, y1, x2, y2);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RectangleCommand that = (RectangleCommand) o;
    return x1 == that.x1 &&
        y1 == that.y1 &&
        x2 == that.x2 &&
        y2 == that.y2;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x1, y1, x2, y2);
  }
}