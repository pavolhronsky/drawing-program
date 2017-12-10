package com.hronsky.pavol.program.drawing.command;

import com.hronsky.pavol.program.drawing.drawing.DrawingEngine;

public class QuitCommand implements Command {

  @Override
  public String execute(DrawingEngine engine) {
    return "Drawing program is quiting.";
  }
}