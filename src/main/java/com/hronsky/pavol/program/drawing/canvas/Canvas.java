package com.hronsky.pavol.program.drawing.canvas;

public interface Canvas<T> {

  int getWidth();

  int getHeight();

  T getPixel(int row, int column);

  void setPixel(int row, int column, T pixel);

  String display();
}
