package com.hronsky.pavol.program.drawing.canvas;

public interface Canvas {

  int getWidth();

  int getHeight();

  char getPixel(int row, int column);

  void setPixel(int row, int column, char pixel);

  String display();
}
