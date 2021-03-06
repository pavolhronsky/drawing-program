package com.hronsky.pavol.program.drawing.command;

import com.hronsky.pavol.program.drawing.drawing.DrawingEngine;
import com.hronsky.pavol.program.drawing.exception.PointOutOfCanvasException;
import com.hronsky.pavol.program.drawing.exception.PointsNotAlignedException;
import com.hronsky.pavol.program.drawing.exception.WrongDimensionException;

public interface Command {

  void execute(DrawingEngine<Character> engine) throws WrongDimensionException, PointOutOfCanvasException, PointsNotAlignedException;
}
