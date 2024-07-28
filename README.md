# Java Math Utils

Welcome to the Java Math Utils repository, a comprehensive collection of Java programs designed for mathematical computations. This repository includes a variety of tools and algorithms aimed at solving numerical tasks, from calculating square roots and solving Pell's equation to finding Catalan numbers and computing Fibonacci sequences. Whether you're a student, educator, or programming enthusiast, these utilities offer a practical exploration into the application of mathematical principles through programming.

Each program within this collection is crafted to demonstrate specific mathematical concepts and algorithms, making use of Java's powerful computational capabilities. The repository is structured to provide clear usage instructions for compiling and running each program, ensuring that users can easily navigate and utilize the tools provided.

Whether you're interested in the intricacies of number theory, the elegance of mathematical sequences, or the application of encryption algorithms, the Java Math Utils repository serves as a valuable resource for enhancing your understanding and skills in mathematical computing.

## Programs

### `sqrt` Class

This class provides functionality for calculating square roots using the continued fraction representation. It is a prerequisite for running other programs that require square root calculations.

#### Usage

```bash
javac sqrt.java
```

### Pell's Equation Solver (`pell_equation_solver.java`)

Solves the Pell's equation **x² - Dy² = 1** for a given value of **D** and finds the first **n** solutions.

#### Usage

```bash
javac pell_equation_solver.java
java pell_equation_solver [D] [n]
```

### Square Root Calculator (`pell_sqrt.java`)

Calculates the square root of a number using the Pell's equation method.

#### Usage

```bash
javac pell_sqrt.java
java pell_sqrt [number] [digits]
```

### Golden Ratio Calculator (`golden_ratio_pell.java`)

Calculates the golden ratio using the Pell's equation method.

#### Usage

```bash
javac golden_ratio_pell.java
java golden_ratio_pell [digits]
```

### Pi Calculator (`chudnovsky_bs_pell.java`)

Calculates the value of **π** using the Chudnovsky algorithm.

#### Usage

```bash
javac chudnovsky_bs_pell.java
java chudnovsky_bs_pell [digits]
```

### Exponential Function Calculator (`exp_bs.java`)

Calculates the value of **e** raised to a given power using the Taylor series.

#### Usage

```bash
javac exp_bs.java
java exp_bs [x] [digits]
```

### Square Root Benchmark (`SqrtBenchmark.java`)

Benchmarks the performance of calculating square roots using BigDecimal's in-built sqrt method and the custom `pell_sqrt` method.

#### Usage

```bash
javac SqrtBenchmark.java
java SqrtBenchmark
```

### Catalan Number Calculator (`CatalanNumber.java`)

Finds the first **n** Catalan numbers.

#### Usage

```bash
javac CatalanNumber.java
java CatalanNumber
```

### Fibonacci Calculator (`Fibonacci.java`)

Computes the **n**-th Fibonacci number.

#### Usage

```bash
javac Fibonacci.java
java Fibonacci
```

### RSA Cryptography (`RSA.java`)

A straightforward implementation of RSA encryption, demonstrating the generation of keys, encryption of messages, and decryption back to the original text.

#### Usage

```bash
javac RSA.java
java RSA
```

### Arccotangent Calculator (`acot.java`)

Calculates the arccotangent (acot) of a given integer `x` to a specified number of digits `n`.

#### Usage

```bash
javac acot.java
java acot
```

### Primitive Pythagorean Triples (`PrimitivePythagoreanTriples.java`)

Finds and prints all primitive Pythagorean triples with values between `n1` and `n2`.

#### Usage

```bash
javac PrimitivePythagoreanTriples.java
java PrimitivePythagoreanTriples
```

## Getting Started

To use these utilities, clone the repository to your local machine and navigate to the desired program's directory. Compile each program using the Java compiler (`javac`) followed by the program's filename. Run the compiled program using `java` followed by the program's name and any required arguments as shown in the usage section for each program.

## Prerequisites

- Java Development Kit (JDK) 8 or higher.

## Contributing

Contributions to the **[Java Math Utils](https://github.com/Abhrankan-Chakrabarti/java-math-utils)** repository are welcome. Please feel free to fork the repository, make your changes, and submit a pull request.