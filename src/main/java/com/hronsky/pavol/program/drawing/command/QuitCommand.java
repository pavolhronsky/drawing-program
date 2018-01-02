package com.hronsky.pavol.program.drawing.command;

import com.hronsky.pavol.program.drawing.drawing.DrawingEngine;

public class QuitCommand implements Command {

  @Override
  public void execute(DrawingEngine<Character> engine) {
    System.exit(0);
  }
}