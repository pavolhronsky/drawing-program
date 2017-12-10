package com.hronsky.pavol.program.drawing.command;

import com.hronsky.pavol.program.drawing.drawing.DrawingEngine;
import com.hronsky.pavol.program.drawing.exception.PointOutOfCanvasException;
import com.hronsky.pavol.program.drawing.exception.WrongDimensionException;

public interface Command {

  String execute(DrawingEngine engine) throws WrongDimensionException, PointOutOfCanvasException;
}
