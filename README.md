# The Assignment
You are given a task of writing a simple console version of a drawing program.

At this time, the functionality of the program is quite limited but this might change in the future. In a nutshell, the program should work as follow:
1. Create a new canvas
2. Start drawing on the canvas by issuing various commands
3. Quit

|Command&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|Description|
|:--------------|:------------|
|C w h        | Should create a new canvas of width w and height h.|
|L x<sub>1</sub> y<sub>1</sub> x<sub>2</sub> y<sub>2</sub>| Should create a new line from (x<sub>1</sub>, y<sub>1</sub>) to (x<sub>2</sub>, y<sub>2</sub>). Currently only horizontal or vertical lines will be drawn using the 'x' character.|
|R x<sub>1</sub> y<sub>1</sub> x<sub>2</sub> y<sub>2</sub>| Should create a new rectangle, whose upper left corner is (x<sub>1</sub>, y<sub>1</sub>) and lower right corner is (x<sub>2</sub>, y<sub>2</sub>). Horizontal and vertical lines will be drawn using the 'x' character.|
|B x y c      | Should fill the entire area connected to (x, y) with "colour" c. The behavious of this is the same as that of the "bucket fill" tool in paint programs.|
|Q            | Should quit the program.|

## How to run the program
Unzip the source code and enter the application folder.
### Unix-based system
```
./gradlew clean build jar
java -jar build/libs/drawing-program-1.0.jar
```

### Windows
```
gradlew clean build jar
java -jar build/libs/drawing-program-1.0.jar
```

## Assumptions
* The minimal value of canvas' length or width is 1. The maximal value is `Integer.MAX_VALUE`.
* A line must be either horizontal or vertical.It can also be a single point.
* A rectangle can also be a single point.
* Any character can be used as colour.
* A bucket fill tool can change colour of line ('x') as well.
* A bucket fill tool fills area that is fully surrounded by a different colour (character) in all 8 directions.
