## Java Game of Life

A simple implementation of Conway's Game of Life using the Java Swing library.
## Controls

Mouse Click: Create or remove a cell on the field.
Space: Calculate the next iteration (step).

## Usage

To run the program, execute the build script:
```bash
./jmake.sh
```
## Features

You can launch the program with the --predictDies argument to visualize cells that are about to die:
```bash
./jmake.sh --predictDies
```

You can change cell size with the --cellSize argument (default size is 50):
```bash
./jmake.sh --cellSize 50
```
