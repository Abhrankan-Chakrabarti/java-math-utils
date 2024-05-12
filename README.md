# Java Math Utils

Collection of Java programs for mathematical computations, including tools for calculating square roots, solving Pell's equation, and other numerical tasks.

## Programs

### `sqrt` Class

This class provides functionality for calculating square roots using the continued fraction representation. It needs to be compiled before running other programs.

#### Usage

To compile the `sqrt` class, use `javac sqrt.java`.

### Pell's Equation Solver (`pell_equation_solver.java`)

This program solves the Pell's equation x² - Dy² = 1 for a given value of D and finds the first n solutions.

#### Usage

To run the program, compile it using `javac pell_equation_solver.java` and then run it using `java pell_equation_solver [D] [n]`, where `[D]` is the value of D and `[n]` is the number of solutions you want to find.

### Square Root Calculator (`pell_sqrt.java`)

This program calculates the square root of a number using the Pell's equation method.

#### Usage

To run the program, compile it using `javac pell_sqrt.java` and then run it using `java pell_sqrt [number] [digits]`, where `[number]` is the number you want to find the square root of and `[digits]` is the number of digits you want in the result.
