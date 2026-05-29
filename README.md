# DSA Practice (Java)

This repository is for learning and practicing:

- Data Structures and Algorithms (DSA) problems
- Modern Java features (latest Java version)
- Stream API and functional-style coding

## Goals

- Build strong problem-solving skills with DSA questions
- Practice writing clean, efficient Java solutions
- Use modern Java features in real examples
- Master Java 8 Stream API concepts and patterns

## Tech Stack

- Java 21
- Maven

---

## Java 8 Stream API Complete Learning Guide

Comprehensive stream examples covering all concepts from basics to advanced real-world problems.

### 📚 Core Concepts (Theory)

**StreamConceptsTheory**
Answers to all key Stream API concepts:
1. What is Stream API?
2. Why was Stream API introduced?
3. Difference between map() and filter()
4. Difference between map() and flatMap()
5. Difference between intermediate and terminal operations
6. What is lazy evaluation in Streams?
7. What is a functional interface?
8. What is a lambda expression?
9. What are default methods in interfaces?
10. What is Optional and why do we use it?

```bash
java -cp target/classes org.learn.StreamConceptsTheory
```

---

### 🔤 String Stream Problems

**StringStreamProblems**
Master string processing with streams:
1. Count occurrence of each word using Stream
2. Count occurrence of each character using Stream
3. Find first non-repeating character using Stream
4. Find first repeated character using Stream
5. Group words by length using Stream
6. Find distinct words starting with # from string array
7. Group anagrams using Stream
8. Word frequency (sorted by count)
9. Character frequency (sorted by count)
10. Count duplicate words

```bash
java -cp target/classes org.learn.StringStreamProblems
```

---

### 🔢 Number Stream Problems

**NumberStreamProblems**
Solve common number-based problems:
1. Find second highest number using Stream
2. Find second highest (handling duplicates)
3. Find second most repeated character using Stream
4. Remove duplicates from list using Stream
5. Find duplicate elements using Stream
6. Find duplicate elements with their count
7. Count common elements between two lists
8. Number frequency
9. Find numbers greater than average
10. Find sum of all squares
11. Partition numbers into even and odd

```bash
java -cp target/classes org.learn.NumberStreamProblems
```

---

### 👥 Employee Stream Problems

**EmployeeStreamProblems**
Real-world HR/Employee processing:
1. Group employees by department
2. Find highest salary employee by department
3. Sort employees by salary, then name
4. Count employees by department
5. Average salary by department
6. Total salary by department
7. Find employees earning more than average
8. Department with highest total salary
9. Get employee names by department
10. Employees with salary in range
11. Highest paid employee
12. Departments with employee count

```bash
java -cp target/classes org.learn.EmployeeStreamProblems
```

---

### 🔄 Data Transformation Stream Problems

**DataTransformationStreamProblems**
Convert, transform, and reshape data:
1. Convert list to map (ID -> Name)
2. Convert list to map (Name -> Age)
3. Convert list to map (ID -> Object)
4. Remove duplicates from list
5. Convert list to array
6. Convert array to list
7. Convert string array to list of integers
8. Extract property from list of objects
9. Filter and transform in one operation
10. Group objects and convert to map
11. Flatten list of lists
12. Convert list to set (remove duplicates)
13. Convert list to comma-separated string
14. Create multiple outputs from single stream

```bash
java -cp target/classes org.learn.DataTransformationStreamProblems
```

---

### 🎁 Optional and Miscellaneous Problems

**OptionalAndMiscStreamProblems**
Handle null-safe operations with Optional:
1. Basic Optional usage
2. Optional with map() and filter()
3. Optional with ifPresent()
4. Optional with ifPresentOrElse()
5. Optional with orElseGet()
6. Optional with orElseThrow()
7. Chaining Optional operations
8. Find product by name using Optional
9. Complex Optional chain
10. Stream to Optional
11. Filter in-stock products
12. Total price calculation
13. Find cheapest in-stock product
14. Product availability status
15. Batch processing with limit()

```bash
java -cp target/classes org.learn.OptionalAndMiscStreamProblems
```

---

## Stream API Examples by Complexity Level

### Beginner Level
- **BasicStreamExamples** - Filter, map, collect fundamentals
- **IntermediateStreamExamples** - Distinct, sorted, limit, skip
- **StringStreamProblems** - Word and character counting

### Intermediate Level
- **TerminalStreamExamples** - Count, max, min, reduce, match operations
- **NumberStreamProblems** - Second highest, duplicates, partitioning
- **DataTransformationStreamProblems** - List/Array conversions, map creation

### Advanced Level
- **AdvancedStreamExamples** - flatMap, groupingBy, partitioningBy, toMap
- **EmployeeStreamProblems** - Real-world grouping and aggregation
- **PracticalStreamExamples** - Product inventory management
- **OptionalAndMiscStreamProblems** - Optional handling patterns

### Concepts & Theory
- **StreamConceptsTheory** - All foundational concepts explained

---

## Run All Examples

```bash
# Compile all classes
mvn clean compile

# Run Stream Concepts (Theory)
java -cp target/classes org.learn.StreamConceptsTheory

# Basic Stream Operations
java -cp target/classes org.learn.BasicStreamExamples
java -cp target/classes org.learn.IntermediateStreamExamples
java -cp target/classes org.learn.TerminalStreamExamples
java -cp target/classes org.learn.AdvancedStreamExamples

# Practical Stream Problems
java -cp target/classes org.learn.StringStreamProblems
java -cp target/classes org.learn.NumberStreamProblems
java -cp target/classes org.learn.EmployeeStreamProblems
java -cp target/classes org.learn.DataTransformationStreamProblems
java -cp target/classes org.learn.OptionalAndMiscStreamProblems

# Real-world Examples
java -cp target/classes org.learn.PracticalStreamExamples

# Original DSA example
java -cp target/classes org.learn.Main
```

---

## Project Structure

```
src/main/java/org/learn/
├── Main.java                                    # Original DSA example
│
├── Stream Concepts & Theory:
├── StreamConceptsTheory.java                    # Core Stream API concepts
│
├── Basic Stream Operations:
├── BasicStreamExamples.java                     # Filter, map, collect
├── IntermediateStreamExamples.java              # Distinct, sorted, limit, skip
├── TerminalStreamExamples.java                  # Count, max, min, reduce, find
├── AdvancedStreamExamples.java                  # flatMap, groupingBy, partitioningBy
│
├── Stream Problems (Practical):
├── StringStreamProblems.java                    # Word/char counting, anagrams
├── NumberStreamProblems.java                    # Second highest, duplicates
├── EmployeeStreamProblems.java                  # Department grouping, salary stats
├── DataTransformationStreamProblems.java        # List-Map conversions, flattening
├── OptionalAndMiscStreamProblems.java           # Optional handling, searches
│
└── Real-world Examples:
    └── PracticalStreamExamples.java             # Product inventory management
```

---

## Stream API Quick Reference

### Intermediate Operations (Return Stream)
- `filter(Predicate)` - Select elements matching condition
- `map(Function)` - Transform each element
- `flatMap(Function)` - Map to stream, then flatten
- `distinct()` - Remove duplicates
- `sorted()` - Sort elements
- `limit(long)` - Take first N elements
- `skip(long)` - Skip first N elements
- `peek(Consumer)` - Debug/inspect elements

### Terminal Operations (Return Final Result)
- `collect(Collector)` - Gather into collection
- `forEach(Consumer)` - Iterate over elements
- `count()` - Count elements
- `max(Comparator)` - Find maximum
- `min(Comparator)` - Find minimum
- `reduce(BinaryOperator)` - Aggregate values
- `findFirst()` - Get first element
- `findAny()` - Get any element
- `anyMatch(Predicate)` - Check if any matches
- `allMatch(Predicate)` - Check if all match
- `noneMatch(Predicate)` - Check if none match

### Common Collectors
- `toList()` - Collect to List
- `toSet()` - Collect to Set
- `toMap()` - Convert to Map
- `joining()` - Join to String
- `groupingBy()` - Group by criteria
- `partitioningBy()` - Partition into true/false
- `counting()` - Count elements
- `summingDouble()` - Sum double values
- `averagingDouble()` - Average of double values
- `maxBy()` - Find max element

### Optional Methods
- `isPresent()` - Check if value exists
- `get()` - Get the value
- `orElse(T)` - Get or default value
- `orElseGet(Supplier)` - Get or compute value
- `orElseThrow()` - Get or throw exception
- `ifPresent(Consumer)` - Execute if present
- `ifPresentOrElse()` - Do something or else
- `map(Function)` - Transform if present
- `flatMap(Function)` - Chain optionals
- `filter(Predicate)` - Filter if present

---

## Key Learnings

✅ **Streams are lazy** - Operations don't execute until a terminal operation is called

✅ **Functional style** - Write what you want to do, not how to do it

✅ **Immutability** - Original data is never modified

✅ **Composability** - Chain multiple operations together

✅ **Parallel friendly** - parallel() for easy parallelization

✅ **Type safe** - Full static type checking

---

## Notes

- All examples are self-contained and runnable
- Each class demonstrates specific concepts with clear comments
- Examples progress from basic theory to complex real-world scenarios
- Covers all 25+ stream-related topics mentioned in the requirements
- This is a personal practice repo updated while learning from online resources
- Great for interview preparation and understanding Stream API in depth

