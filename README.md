Here is the updated README with the mention that `pell_sqrt.java` needs to be compiled first before using the sqrt benchmark:

---

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

### Golden Ratio Calculator (`golden_ratio_pell.java`)

This program calculates the golden ratio using the Pell's equation method.

#### Usage

To run the program, compile it using `javac golden_ratio_pell.java` and then run it using `java golden_ratio_pell [digits]`, where `[digits]` is the number of digits you want in the result.

### Pi Calculator (`chudnovsky_bs_pell.java`)

This program calculates the value of pi using the Chudnovsky algorithm.

#### Usage

To run the program, compile it using `javac chudnovsky_bs_pell.java` and then run it using `java chudnovsky_bs_pell [digits]`, where `[digits]` is the number of digits of pi you want to calculate.

### Exponential Function Calculator (`exp_bs.java`)

This program calculates the value of e raised to a given power using the Taylor series.

#### Usage

To run the program, compile it using `javac exp_bs.java` and then run it using `java exp_bs [x] [digits]`, where `[x]` is the power of e and `[digits]` is the number of digits in the result.

### Square Root Benchmark (`SqrtBenchmark.java`)

This program benchmarks the performance of calculating square roots using BigDecimal's in-built sqrt method and the custom pell_sqrt method. Note that `pell_sqrt.java` needs to be compiled first before using the benchmark.

#### Usage

To run the benchmark, compile it using `javac SqrtBenchmark.java` and then run it using `java SqrtBenchmark`.

---

You can customize this template further to add more details or instructions as needed.