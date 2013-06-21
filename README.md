gameoflife
==========

Game of life Simulation In Java

Cell is reprented by Cell.java which contains a boolean variable to determine its state.
Board is a structure is represented by a two dimensional array of Cells. 

GameOfLife contains the main method to initiate the simulation, along with the ability to seed the initial pattern. 

BoardProcessor contains three methods

- seedBoard, which initializes pattern of the board
- updateBoard, updates the board to the next stage of mutation based on the comway rules
- serializeBoard, is a viewing utility on the console - private method

Cell contains two methods

- determineNextState, applies Comway's rules and determines its next state
- determineLiveNeighbours, private method to determine the number of live neighbours. Checks for corners/edges and centers.

