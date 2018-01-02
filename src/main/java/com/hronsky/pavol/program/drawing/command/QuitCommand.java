package com.hronsky.pavol.program.drawing.command;

import com.hronsky.pavol.program.drawing.drawing.DrawingEngine;

public class QuitCommand<T> implements Command<T> {

  @Override
  public String execute(DrawingEngine engine) {
    return "Drawing program is quiting.";
  }
}