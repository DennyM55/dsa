package org.learn;

/**
 * ═══════════════════════════════════════════════════════════════════════════
 * DSA LEARNING PATH - COMPLETE STUDY GUIDE
 * ═══════════════════════════════════════════════════════════════════════════
 * 
 * This file documents the recommended order to study all DSA and Stream API
 * topics in this repository. Classes are organized by complexity and 
 * prerequisite knowledge.
 * 
 * ═══════════════════════════════════════════════════════════════════════════
 * PHASE 1: STREAM API FOUNDATIONS (Learn Sequential Order)
 * ═══════════════════════════════════════════════════════════════════════════
 * 
 * 01. P01_StreamConceptsTheory (org.learn.streams.concepts)
 *     └─ Topics: Stream basics, map vs filter, lazy evaluation, Optional
 *     └─ Run: java -cp target/classes org.learn.streams.concepts.P01_StreamConceptsTheory
 * 
 * 02. P02_BasicStreamExamples (org.learn.streams.basics)
 *     └─ Topics: filter(), map(), collect()
 *     └─ Run: java -cp target/classes org.learn.streams.basics.P02_BasicStreamExamples
 * 
 * 03. P03_IntermediateStreamExamples (org.learn.streams.intermediate)
 *     └─ Topics: distinct(), sorted(), limit(), skip(), peek()
 *     └─ Run: java -cp target/classes org.learn.streams.intermediate.P03_IntermediateStreamExamples
 * 
 * 04. P04_TerminalStreamExamples (org.learn.streams.intermediate)
 *     └─ Topics: count(), max(), min(), reduce(), forEach(), findFirst()
 *     └─ Run: java -cp target/classes org.learn.streams.intermediate.P04_TerminalStreamExamples
 * 
 * 05. P05_AdvancedStreamExamples (org.learn.streams.advanced)
 *     └─ Topics: flatMap(), groupingBy(), partitioningBy(), toMap()
 *     └─ Run: java -cp target/classes org.learn.streams.advanced.P05_AdvancedStreamExamples
 * 
 * ═══════════════════════════════════════════════════════════════════════════
 * PHASE 2: PRACTICAL STREAM PROBLEMS (Real-World Scenarios)
 * ═══════════════════════════════════════════════════════════════════════════
 * 
 * 06. P06_PracticalStreamExamples (org.learn.streams.advanced)
 *     └─ Topics: Product inventory, filtering, aggregation, statistics
 *     └─ Run: java -cp target/classes org.learn.streams.advanced.P06_PracticalStreamExamples
 * 
 * 07. P07_StringStreamProblems (org.learn.streams.advanced)
 *     └─ Topics: Word counting, character counting, anagrams, grouping
 *     └─ Run: java -cp target/classes org.learn.streams.advanced.P07_StringStreamProblems
 * 
 * 08. P08_NumberStreamProblems (org.learn.streams.advanced)
 *     └─ Topics: Second highest, duplicates, common elements, partitioning
 *     └─ Run: java -cp target/classes org.learn.streams.advanced.P08_NumberStreamProblems
 * 
 * 09. P09_EmployeeStreamProblems (org.learn.streams.advanced)
 *     └─ Topics: Grouping by department, salary stats, sorting
 *     └─ Run: java -cp target/classes org.learn.streams.advanced.P09_EmployeeStreamProblems
 * 
 * 10. P10_DataTransformationStreamProblems (org.learn.streams.advanced)
 *     └─ Topics: List↔Map conversion, flattening, transformations
 *     └─ Run: java -cp target/classes org.learn.streams.advanced.P10_DataTransformationStreamProblems
 * 
 * 11. P11_OptionalAndMiscStreamProblems (org.learn.streams.advanced)
 *     └─ Topics: Optional handling, searching, filtering, pagination
 *     └─ Run: java -cp target/classes org.learn.streams.advanced.P11_OptionalAndMiscStreamProblems
 * 
 * ═══════════════════════════════════════════════════════════════════════════
 * PHASE 3: STRING CODING PROBLEMS
 * ═══════════════════════════════════════════════════════════════════════════
 * 
 * 12. P12_StringCodingProblems (org.learn.strings)
 *     └─ Topics: Reverse, palindrome, longest prefix, vowels, acronyms, anagrams
 *     └─ Run: java -cp target/classes org.learn.strings.P12_StringCodingProblems
 * 
 * ═══════════════════════════════════════════════════════════════════════════
 * PHASE 4: ARRAY CODING PROBLEMS
 * ═══════════════════════════════════════════════════════════════════════════
 * 
 * 13. P13_ArrayCodingProblems (org.learn.arrays)
 *     └─ Topics: Second largest, max subarray, missing number, two sum, duplicates
 *     └─ Run: java -cp target/classes org.learn.arrays.P13_ArrayCodingProblems
 * 
 * 14. P14_AdvancedArrayProblems (org.learn.arrays)
 *     └─ Topics: Binary search, rotated arrays, peak element, median, single number
 *     └─ Run: java -cp target/classes org.learn.arrays.P14_AdvancedArrayProblems
 * 
 * ═══════════════════════════════════════════════════════════════════════════
 * PHASE 5: STREAM-BASED STRING & ARRAY SOLUTIONS
 * ═══════════════════════════════════════════════════════════════════════════
 * 
 * 15. P15_StreamStringArrayProblems (org.learn.strings)
 *     └─ Topics: Stream solutions for strings/arrays, functional programming patterns
 *     └─ Run: java -cp target/classes org.learn.strings.P15_StreamStringArrayProblems
 * 
 * ═══════════════════════════════════════════════════════════════════════════
 * QUICK REFERENCE - STUDY PATHS BY GOAL
 * ═══════════════════════════════════════════════════════════════════════════
 * 
 * Goal: Master Stream API
 * Path: 01 → 02 → 03 → 04 → 05 → 06 → 07-11
 * Time: 2-3 hours
 * 
 * Goal: Interview Preparation
 * Path: 01-02 → 12 → 13-14 → 15
 * Time: 1.5-2 hours (focus on problem-solving)
 * 
 * Goal: Complete DSA + Streams
 * Path: 01 → 02 → 03 → 04 → 05 → 06-11 → 12-15
 * Time: 4-5 hours (comprehensive)
 * 
 * Goal: Quick Streams Overview
 * Path: 01 → 02 → 03 → 05 → 06
 * Time: 45 minutes
 * 
 * ═══════════════════════════════════════════════════════════════════════════
 * PACKAGE STRUCTURE
 * ═══════════════════════════════════════════════════════════════════════════
 * 
 * org.learn/
 * ├── Main.java (original starter example)
 * ├── LEARNING_PATH.java (this file)
 * │
 * ├── streams/
 * │   ├── concepts/
 * │   │   └── P01_StreamConceptsTheory.java
 * │   ├── basics/
 * │   │   └── P02_BasicStreamExamples.java
 * │   ├── intermediate/
 * │   │   ├── P03_IntermediateStreamExamples.java
 * │   │   └── P04_TerminalStreamExamples.java
 * │   └── advanced/
 * │       ├── P05_AdvancedStreamExamples.java
 * │       ├── P06_PracticalStreamExamples.java
 * │       ├── P07_StringStreamProblems.java
 * │       ├── P08_NumberStreamProblems.java
 * │       ├── P09_EmployeeStreamProblems.java
 * │       ├── P10_DataTransformationStreamProblems.java
 * │       └── P11_OptionalAndMiscStreamProblems.java
 * │
 * ├── strings/
 * │   ├── P12_StringCodingProblems.java
 * │   └── P15_StreamStringArrayProblems.java
 * │
 * └── arrays/
 *     ├── P13_ArrayCodingProblems.java
 *     └── P14_AdvancedArrayProblems.java
 * 
 * ═══════════════════════════════════════════════════════════════════════════
 * KEY TOPICS COVERED
 * ═══════════════════════════════════════════════════════════════════════════
 * 
 * Stream API Concepts (11 topics)
 *  ✓ What is Stream API & why introduced?
 *  ✓ map() vs filter() vs flatMap()
 *  ✓ Intermediate vs Terminal operations
 *  ✓ Lazy evaluation
 *  ✓ Functional interfaces & Lambda expressions
 *  ✓ Default methods in interfaces
 *  ✓ Optional and its methods
 *  ✓ groupingBy() & partitioningBy()
 *  ✓ reduce() & collect()
 *  ... and more
 * 
 * String Problems (10 topics)
 *  ✓ Reverse string
 *  ✓ Palindrome checking
 *  ✓ Longest common prefix
 *  ✓ Count vowels
 *  ✓ Extract acronyms
 *  ✓ Non-repeating/repeating characters
 *  ✓ Group anagrams
 *  ✓ Character frequency
 *  ... and more
 * 
 * Array Problems (20+ topics)
 *  ✓ Second largest/highest number
 *  ✓ Maximum subarray sum
 *  ✓ Missing number
 *  ✓ Two Sum / Pair sum
 *  ✓ Remove duplicates
 *  ✓ Product of array except self
 *  ✓ Binary search
 *  ✓ Search in rotated arrays
 *  ✓ Peak element
 *  ✓ Median of sorted arrays
 *  ... and more
 * 
 * ═══════════════════════════════════════════════════════════════════════════
 * HOW TO USE THIS GUIDE
 * ═══════════════════════════════════════════════════════════════════════════
 * 
 * 1. Start with 01 - Stream Concepts and understand the fundamentals
 * 2. Follow the numbered sequence (02, 03, 04, etc.) in order
 * 3. Each class builds on concepts from previous classes
 * 4. Run each class to see examples and output
 * 5. Modify examples to experiment and deepen understanding
 * 6. Use Quick Reference section to jump to specific goals
 * 
 * ═══════════════════════════════════════════════════════════════════════════
 */
public class LEARNING_PATH {
    
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════════════════════════════════════════");
        System.out.println("DSA & STREAM API LEARNING PATH GUIDE");
        System.out.println("═══════════════════════════════════════════════════════════════════════════\n");
        
        System.out.println("This repository contains a complete learning path for:");
        System.out.println("  • Java Stream API (comprehensive coverage)");
        System.out.println("  • Data Structures & Algorithms (string & array problems)");
        System.out.println("  • Functional Programming in Java");
        System.out.println("  • Interview Preparation (LeetCode-style problems)\n");
        
        System.out.println("Available Study Paths:");
        System.out.println("  1. Stream API Mastery (Phases 1-2): 15 classes covering all Stream concepts");
        System.out.println("  2. String Problems (Phase 3): 10+ string manipulation problems");
        System.out.println("  3. Array Problems (Phase 4): 20+ array algorithm problems");
        System.out.println("  4. Stream Solutions (Phase 5): Functional programming approaches\n");
        
        System.out.println("Quick Start Commands:");
        System.out.println("  # See this guide:");
        System.out.println("  java -cp target/classes org.learn.LEARNING_PATH\n");
        
        System.out.println("  # Start Phase 1 - Stream Concepts:");
        System.out.println("  java -cp target/classes org.learn.streams.concepts.P01_StreamConceptsTheory\n");
        
        System.out.println("  # Continue with Basic Streams:");
        System.out.println("  java -cp target/classes org.learn.streams.basics.P02_BasicStreamExamples\n");
        
        System.out.println("  # String Coding Problems:");
        System.out.println("  java -cp target/classes org.learn.strings.P12_StringCodingProblems\n");
        
        System.out.println("  # Array Coding Problems:");
        System.out.println("  java -cp target/classes org.learn.arrays.P13_ArrayCodingProblems\n");
        
        System.out.println("Total Content:");
        System.out.println("  • 15 organized classes");
        System.out.println("  • 140+ runnable examples");
        System.out.println("  • 50+ DSA problems");
        System.out.println("  • 5 main study phases\n");
        
        System.out.println("Recommended Order:");
        System.out.println("  For Stream API: P01 → P02 → P03 → P04 → P05 → P06-P11");
        System.out.println("  For Interviews: P01-P02 → P12 → P13-P14 → P15");
        System.out.println("  Complete Path: P01 → P02 → ... → P15\n");
        
        System.out.println("═══════════════════════════════════════════════════════════════════════════");
    }
}

