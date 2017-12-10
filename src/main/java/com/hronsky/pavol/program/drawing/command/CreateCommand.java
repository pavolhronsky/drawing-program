package com.hronsky.pavol.program.drawing.command;

import com.hronsky.pavol.program.drawing.canvas.Canvas;
import com.hronsky.pavol.program.drawing.canvas.CharacterCanvas;
import com.hronsky.pavol.program.drawing.drawing.DrawingEngine;
import com.hronsky.pavol.program.drawing.exception.WrongDimensionException;

public class CreateCommand implements Command {

  private final int width;
  private final int height;

  public CreateCommand(int width, int height) {
    this.width = width;
    this.height = height;
  }

  @Override
  public String execute(DrawingEngine engine) throws WrongDimensionException {
    Canvas canvas = new CharacterCanvas(width, height);
    engine.setCanvas(canvas);
    return engine.displayCanvas();
  }
}
