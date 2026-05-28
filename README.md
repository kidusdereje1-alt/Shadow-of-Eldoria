Shadow of Eldoria is a text-based RPG game developed in Java as a Minimum Viable Product (MVP) project for Object-Oriented Programming (OOP).

The project demonstrates the core OOP principles learned in:
 V1.0: Introduction to OOP in Java
 V2.0: Core OOP Concepts
 V3.0: Java Inheritance
 V4.0: Java Polymorphism
The player selects a hero class and battles multiple enemies to save the Kingdom of Eldoria.

Features
 Text-based RPG gameplay
 Warrior and Mage hero classes
 Multiple enemy battles
 Normal attacks, power attacks, and special moves
 Health and combat system
 Victory and game over conditions
 User interaction through console input
 
OOP Concepts Demonstrated
 1. Classes and Objects
Classes used in the project:
 Character
 Warrior
 Mage
 Monster
ShadowOfEldoria
Objects are created using:
new Warrior(playerName);
new Monster("Goblin", 50, 10);

3. Encapsulation
Private and protected variables are used:
private String name;
protected int health;
Getter and setter methods are implemented:
public String getName()
public void setName(String name)

3. Inheritance
Inheritance is implemented using `extends`.
Examples:
class Warrior extends Character
class Mage extends Character
class Monster extends Character
The subclasses inherit:

 attack()
 showStats()
 isAlive()
from the Character superclass.

4. Polymorphism
Method Overriding
each subclass overrides the `specialMove()` method.
Example:
@Override
public void specialMove()
Method Overloading
The `attack()` method is overloaded:
attack(Character enemy)
attack(Character enemy, int bonusDamage)
Runtime Polymorphism
Superclass references are used:
Character player;
which can store:
new Warrior(playerName)
new Mage(playerName)

5.ArrayList Usage
The project uses an ArrayList to store enemies dynamically.
ArrayList<Character> enemies = new ArrayList<>();

How to Compile and Run
Compile
avac ShadowOfEldoria.java
java ShadowOfEldoria
 Technologies Used
 Java
 Object-Oriented Programming (OOP)
 Java Collections Framework
 Scanner for user input

 Project Structure

