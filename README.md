-Shadow Of Eldoria is a text-based RPG game developed in Java as a Minimum Viable Product (MVP) to demonstrate core Object-Oriented Programming (OOP) principles.
The player chooses a hero class and battles multiple enemies using attacks, special abilities, healing, and strategy until all enemies are defeated.
-This project was created to demonstrate concepts learned from:
 V1.0: Introduction to OOP in Java
 V2.0: Core OOP Concepts
 V3.0: Java Inheritance
 V4.0: Java Polymorphism
 -Game Features
 Warrior and Mage character classes
 Multiple enemies
 Normal attacks and power attacks
 Special moves
 Healing system
 Critical hit system
 Turn-based combat
 Victory and Game Over conditions
 User input handling
 Random enemy behavior
-Technologies Used
 Java
 Object-Oriented Programming (OOP)
 Java Collections (ArrayList)
 Exception Handling
 Random Number Generation
-How to Compile and Run
Step 1: Open Terminal / Command Prompt
Navigate to the project folder.
Step 2: Compile the Program
Step 3: Run the Program
-OOP Concepts Demonstrated
1. Classes and Objects (V1.0 & V2.0)
Classes Used
 Character
  Warrior
  Mage
  Monster
  ShadowOfEldoria
2. Encapsulation (V1.0 & V2.0)
Encapsulation is implemented using private variables and public getters/setters.
Getters and Setters
public int getHealth()
public void setHealth(int health)
3. Inheritance (V3.0)
Inheritance is implemented using the extends keyword.
Reused Features from Parent Class
attack()
heal()
showStats()
isAlive()
Use of super()
super(name, 120, 20);
4. Polymorphism (V4.0)
Method Overriding (Runtime Polymorphism)
Each subclass overrides the specialMove() method.
-Method Overloading (Compile-Time Polymorphism)
The attack() method is overloaded.
Upcasting / Dynamic Polymorphism
Superclass references are used to store subclass objects.
Exception Handling
The game uses try-catch blocks to prevent invalid input crashes.
-Learning Outcomes
This project demonstrates understanding of:
-Classes and Objects
 Encapsulation
 Constructors
 Inheritance
 Method Overriding
 Method Overloading
 Runtime Polymorphism
 Exception Handling
 Arrays and Collections
 User Input Handling


