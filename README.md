---

# Aquarium Multithreading Simulation in Java

## ⚠️ **If you have an extra 15 minutes, I highly recommend reading this.** ⚠️

### Overview

In **Java** programming, multithreading is widely used. 

**Why?**

**Because multithreading can fundamentally improve the efficiency of your application.**

### How?

- **What is a thread?**
- **Is it specific to Java?**
- **Why is it called multithreading?**

If you have similar questions, don't worry—I will explain everything.

In simple terms, a **thread** is a sequence of instructions that can be executed concurrently with other threads. In a multithreaded program, multiple threads work together to perform tasks simultaneously, improving performance. For example, if one thread can complete a task in 10 minutes, using multiple threads could complete it in 1 minute.

**The difference?**  
You gain time efficiency—like hiring multiple workers to finish a job much faster.

### Are threads exclusive to Java?

No, threads are available in many programming languages.

---

## Aquarium Simulation Task

This project simulates an aquarium where multiple fish (each represented by a thread) live, interact, and reproduce based on random events. You will implement a multithreaded Java application that tracks these fish and their activities.

### Task Description

Teshaboy gifted his younger brother Boltaboy an aquarium with fish for his birthday. After a few days, Teshaboy himself became interested in the fish and bought his own aquarium. However, he didn’t have enough time to take care of them. So, he decided to write a program to monitor the activities in the aquarium and sought our help to build it.

### Requirements:

1. Random values should determine all fish characteristics.
2. Use **Collections**.
3. Each fish should run in a separate **Thread**.
4. Every event in the aquarium should be logged to the **Console**.

### Additional Notes:

- There are `N` male and `M` female fish in the aquarium, both determined randomly.
- Each fish has a lifespan, also determined randomly.
- If male and female fish meet, they can reproduce, with the gender of the newborn being randomly assigned.

---

## Class Breakdown

### 1. **Fish Class**

This class is responsible for creating individual fish.

**Core Variables:**
- `fishGender` - Gender of the fish.
- `fishLifeSpan` - The lifespan of the fish.
- `aquarium` - The aquarium the fish belongs to.

Values are assigned through the **constructor**.

**Core Methods:**
- `getFishGender()` - Returns the fish's gender.
- `run()` - Overridden method for thread execution. Fish actions occur here.

### 2. **Aquarium Class**

The `Aquarium` class handles the collection, creation, and deletion of fish, as well as simulating their interactions.

**Core Variables:**
- `listOfFish` - A list of fish stored using **CopyOnWriteArrayList** for thread safety.
- `random` - Used to generate random values for fish characteristics.

**Core Methods:**
- `addFish()` - Adds a new fish to the aquarium.
- `removeFish()` - Removes a fish once it dies.
- `checkForMate()` - Checks if two fish can meet and reproduce.
- `createNewFish()` - Creates a new fish.

### 3. **Main Class**

This class initializes and runs the simulation by creating fish and aquariums and starts the program.

---

## Why CopyOnWriteArrayList?

The `CopyOnWriteArrayList` was chosen for thread safety when managing fish in the aquarium. While there are other thread-safe collections like **Vector**, `CopyOnWriteArrayList` is more suitable here because:

- **For more reading and less writing** operations, `CopyOnWriteArrayList` is more efficient and safer.
- **For equal or more writing** operations, `Vector` may be preferable since it writes without creating a copy.

---

## How the Simulation Works

- Randomly generate the number of male and female fish.
- Each fish is a separate thread.
- Fish can meet, reproduce, and die, with all actions logged to the console.
- The simulation continues until all fish have died.

---

Thank you for exploring this project! If you are curious about how the classes work, I encourage you to analyze the code carefully. 😊

---
