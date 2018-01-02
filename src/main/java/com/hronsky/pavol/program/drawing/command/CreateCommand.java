package com.hronsky.pavol.program.drawing.command;

import com.hronsky.pavol.program.drawing.canvas.Canvas;
import com.hronsky.pavol.program.drawing.canvas.CharacterCanvas;
import com.hronsky.pavol.program.drawing.drawing.DrawingEngine;
import com.hronsky.pavol.program.drawing.exception.WrongDimensionException;
import java.util.Objects;

public class CreateCommand<T> implements Command<T> {

  private final int width;
  private final int height;

  public CreateCommand(int width, int height) {
    this.width = width;
    this.height = height;
  }

  @Override
  public String execute(DrawingEngine<T> engine) throws WrongDimensionException {
    Canvas canvas = new CharacterCanvas(width, height);
    engine.setCanvas(canvas);
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
    CreateCommand that = (CreateCommand) o;
    return width == that.width &&
        height == that.height;
  }

  @Override
  public int hashCode() {

    return Objects.hash(width, height);
  }
}
