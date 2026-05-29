# DSA Practice (Java)

This repository is for learning and practicing:

- Data Structures and Algorithms (DSA) problems
- Modern Java features (latest Java version)
- Stream API and functional-style coding

## Goals

- Build strong problem-solving skills with DSA questions
- Practice writing clean, efficient Java solutions
- Use modern Java features in real examples

## Tech Stack

- Java 21
- Maven

## Stream API Learning Examples

Comprehensive stream examples organized by skill level:

### 1. **BasicStreamExamples**
Learn fundamental stream operations:
- `filter()` - Select elements matching a condition
- `map()` - Transform element values
- `collect()` - Gather results into collections

```bash
java -cp target/classes org.learn.BasicStreamExamples
```

### 2. **IntermediateStreamExamples**
Intermediate stream operations:
- `distinct()` - Remove duplicates
- `sorted()` - Sort elements
- `limit()` - Take first N elements
- `skip()` - Skip first N elements
- `peek()` - Debug/inspect during processing

```bash
java -cp target/classes org.learn.IntermediateStreamExamples
```

### 3. **TerminalStreamExamples**
Terminal operations that produce final results:
- `count()` - Count elements
- `max()`, `min()` - Find extreme values
- `reduce()` - Aggregate values
- `forEach()` - Iterate over elements
- `anyMatch()`, `allMatch()`, `noneMatch()` - Matching predicates
- `findFirst()`, `findAny()` - Find specific elements

```bash
java -cp target/classes org.learn.TerminalStreamExamples
```

### 4. **AdvancedStreamExamples**
Advanced stream operations with custom objects:
- `flatMap()` - Flatten nested structures
- `groupingBy()` - Group elements by criteria
- `partitioningBy()` - Partition into true/false groups
- `toMap()` - Convert to Map

```bash
java -cp target/classes org.learn.AdvancedStreamExamples
```

### 5. **PracticalStreamExamples**
Real-world scenarios combining multiple operations:
- Product filtering and searching
- Grouping and aggregation
- Statistical calculations
- Complex filtering chains

```bash
java -cp target/classes org.learn.PracticalStreamExamples
```

## Run All Examples

```bash
# Compile all classes
mvn clean compile

# Run a specific example
java -cp target/classes org.learn.BasicStreamExamples
java -cp target/classes org.learn.IntermediateStreamExamples
java -cp target/classes org.learn.TerminalStreamExamples
java -cp target/classes org.learn.AdvancedStreamExamples
java -cp target/classes org.learn.PracticalStreamExamples

# Original DSA example with streams
java -cp target/classes org.learn.Main
```

## Project Structure

```
src/main/java/org/learn/
├── Main.java                        # Original DSA example with streams
├── BasicStreamExamples.java         # Filter, map, collect basics
├── IntermediateStreamExamples.java  # Distinct, sorted, limit, skip, peek
├── TerminalStreamExamples.java      # Count, max, min, reduce, findFirst, etc.
├── AdvancedStreamExamples.java      # FlatMap, groupingBy, partitioningBy, toMap
└── PracticalStreamExamples.java     # Real-world product management examples
```

## Notes

- All examples are self-contained and runnable
- Each class demonstrates specific stream concepts with clear comments
- Examples progress from basic to advanced complexity
- Practical examples show real-world use cases
- This is a personal practice repo updated while learning from online resources

