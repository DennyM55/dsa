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

## String and Array Coding Problems

Comprehensive coverage of classic string and array problems with both traditional and Stream-based solutions.

### 📝 String Coding Problems

**StringCodingProblems**
Master core string manipulation:
1. Reverse a string
2. Reverse string without built-in function
3. Check palindrome
4. Longest common prefix in string array
5. Count and index vowels (Stream)
6. Extract first letter of each word → "Java Stream API" → "JSA"
7. First non-repeating character (Stream)
8. First repeating character (Stream)
9. Group anagrams
10. Character frequency (sorted by count)

```bash
java -cp target/classes org.learn.StringCodingProblems
```

---

### 🔢 Array Coding Problems

**ArrayCodingProblems**
Solve fundamental array problems:
1. Find second largest / second highest number
2. Largest element in array
3. Maximum subarray sum (Kadane's Algorithm)
4. Missing number from 1 to n
5. Remove duplicates from sorted array
6. Find pair sum / two sum
7. Product of array except self
8. Join two arrays and remove duplicates
9. Partition equal subset sum
10. Elements greater than adjacent
11. Array sum and average
12. Rotate array by k positions

```bash
java -cp target/classes org.learn.ArrayCodingProblems
```

---

### 🔍 Advanced Array Problems

**AdvancedArrayProblems**
Complex array operations and searching:
1. Binary search
2. Search in rotated sorted array
3. Check if array is rotated
4. Find first and last position of element
5. Integer square root
6. Find peak element
7. Median of two sorted arrays
8. Search for a range (all occurrences)
9. Smallest missing positive
10. Find duplicate number
11. Single number (XOR trick)

```bash
java -cp target/classes org.learn.AdvancedArrayProblems
```

---

### 💧 Stream-Based String and Array Problems

**StreamStringArrayProblems**
Functional programming style solutions using Streams:
1. Reverse string using streams
2. Reverse array using streams
3. Count vowels and positions (Stream)
4. Extract acronyms (first letters)
5. Capitalize words (Stream)
6. Filter and map numbers
7. Remove duplicates (Stream)
8. Convert strings to uppercase
9. Sort strings by length
10. Group strings by first character
11. Find longest string
12. Character frequency (Stream)
13. Average of array (Stream)
14. Min and Max of array (Stream)
15. Extract integers from string
16. Join array elements with separator
17. String to character list
18. Count words starting with character
19. Filter palindromes

```bash
java -cp target/classes org.learn.StreamStringArrayProblems
```

---

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

# Stream Concepts (Theory)
java -cp target/classes org.learn.StreamConceptsTheory

# Basic Stream Operations
java -cp target/classes org.learn.BasicStreamExamples
java -cp target/classes org.learn.IntermediateStreamExamples
java -cp target/classes org.learn.TerminalStreamExamples
java -cp target/classes org.learn.AdvancedStreamExamples

# Stream-based Problems
java -cp target/classes org.learn.StringStreamProblems
java -cp target/classes org.learn.NumberStreamProblems
java -cp target/classes org.learn.EmployeeStreamProblems
java -cp target/classes org.learn.DataTransformationStreamProblems
java -cp target/classes org.learn.OptionalAndMiscStreamProblems

# String and Array Coding Problems
java -cp target/classes org.learn.StringCodingProblems
java -cp target/classes org.learn.ArrayCodingProblems
java -cp target/classes org.learn.AdvancedArrayProblems
java -cp target/classes org.learn.StreamStringArrayProblems

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
├── String & Array Coding:
├── StringCodingProblems.java                    # Reverse, palindrome, longest prefix
├── ArrayCodingProblems.java                     # Second largest, max sum, missing number
├── AdvancedArrayProblems.java                   # Binary search, rotated arrays
├── StreamStringArrayProblems.java               # Stream-based string/array solutions
│
├── Real-world Examples:
└── PracticalStreamExamples.java                 # Product inventory management
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

## Topics Covered

### Stream API Concepts (11 topics)
✓ What is Stream API?
✓ Why was Stream API introduced?
✓ Different between map() and filter()
✓ Difference between map() and flatMap()
✓ Intermediate vs Terminal operations
✓ Lazy evaluation
✓ Functional interfaces
✓ Lambda expressions
✓ Default methods in interfaces
✓ Optional and its usage
✓ All stream operations (filter, map, reduce, collect, etc.)

### String Problems (10 topics)
✓ Reverse a string
✓ Longest common prefix in string array
✓ Check palindrome
✓ Count vowels and index positions (Stream)
✓ Extract first letter of each word (Acronym)
✓ First non-repeating character
✓ First repeating character
✓ Group anagrams
✓ Character frequency
✓ Various string manipulations with Streams

### Array Problems (20+ topics)
✓ Find second largest / second highest number
✓ Missing number from 1 to n
✓ Maximum subarray sum (Kadane's Algorithm)
✓ Remove duplicates from sorted array
✓ Find pair sum / two sum
✓ Product of array except self
✓ Partition equal subset sum
✓ Join two arrays and remove duplicates
✓ Largest element in array
✓ Binary search
✓ Search in rotated sorted array
✓ First and last position of element
✓ Peak element
✓ Median of two sorted arrays
✓ Smallest missing positive
✓ Find duplicate number
✓ Single number (XOR)
✓ Array rotation
✓ Integer square root
✓ And more...

### Stream-Based Solutions (19 topics)
✓ Reverse string/array using Streams
✓ Vowel counting with positions
✓ Extract acronyms
✓ Capitalize words
✓ Filter and map operations
✓ Remove duplicates
✓ String sorting and grouping
✓ Character extraction
✓ Palindrome filtering
✓ And more functional programming patterns

---

## Interview Preparation

This repository covers topics frequently asked in technical interviews:
- LeetCode Easy to Hard problems
- Stream API mastery
- Big O complexity optimization
- Array and String manipulation
- Search algorithms
- Data structure operations
- Functional programming concepts

Perfect for:
- Java developer interviews
- Backend engineering roles
- Data structures & algorithms practice
- Stream API proficiency
- Coding challenge preparation

---

## Notes

- All examples are self-contained and runnable
- Each class demonstrates specific concepts with clear comments
- Examples progress from basic theory to complex real-world scenarios
- Covers all 25+ stream-related topics mentioned in the requirements
- This is a personal practice repo updated while learning from online resources
- Great for interview preparation and understanding Stream API in depth

