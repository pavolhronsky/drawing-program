package com.hronsky.pavol.program.drawing.canvas;

import com.hronsky.pavol.program.drawing.exception.WrongDimensionException;

public class CharacterCanvas implements Canvas<Character> {

  public static final Character EMPTY_PIXEL = ' ';

  private static final Character TOP_BOTTOM = '-';
  private static final Character LEFT_RIGHT = '|';
  private static final Character EOL = '\n';

  private char[][] pixelField;

  public CharacterCanvas(int width, int height) throws WrongDimensionException {
    if (width <= 0) {
      throw new WrongDimensionException("Canvas width must be a positive number.");
    }
    if (height <= 0) {
      throw new WrongDimensionException("Canvas height must be a positive number.");
    }

    this.pixelField = new char[height][width];

    for (int row = 0; row < height; row++) {
      for (int column = 0; column < width; column++) {
        pixelField[row][column] = EMPTY_PIXEL;
      }
    }
  }

  @Override
  public int getWidth() {
    return pixelField[0].length;
  }

  @Override
  public int getHeight() {
    return pixelField.length;
  }

  @Override
  public Character getPixel(int row, int column) {
    return pixelField[row][column];
  }

  @Override
  public void setPixel(int row, int column, Character pixel) {
    pixelField[row][column] = pixel;
  }

  @Override
  public String display() {
    StringBuilder builder = new StringBuilder();

    builder.append(EOL);
    for (int top = 0; top < getWidth() + 2; top++) {
      builder.append(TOP_BOTTOM);
    }
    builder.append(EOL);

    for (int row = 0; row < getHeight(); row++) {
      builder.append(LEFT_RIGHT);
      for (int column = 0; column < getWidth(); column++) {
        builder.append(pixelField[row][column]);
      }
      builder.append(LEFT_RIGHT).append(EOL);
    }

    for (int top = 0; top < getWidth() + 2; top++) {
      builder.append(TOP_BOTTOM);
    }

    return builder.toString();
  }
}