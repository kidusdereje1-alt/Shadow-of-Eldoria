import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


class Character {


    private String name;
    private int health;
    private int attackPower;


    public Character(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {

        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setHealth(int health) {

        if (health >= 0) {
            this.health = health;
        }
    }


    public void attack(Character enemy) {

        enemy.setHealth(enemy.getHealth() - attackPower);

        if (enemy.getHealth() < 0) {
            enemy.setHealth(0);
        }

        System.out.println(name + " attacks "
                + enemy.getName()
                + " for " + attackPower + " damage!");
    }


    public void attack(Character enemy, int bonusDamage) {

        int totalDamage = attackPower + bonusDamage;

        enemy.setHealth(enemy.getHealth() - totalDamage);

        if (enemy.getHealth() < 0) {
            enemy.setHealth(0);
        }

        System.out.println(name + " uses a POWER ATTACK on "
                + enemy.getName()
                + " for " + totalDamage + " damage!");
    }


    public void specialMove() {
        System.out.println(name + " performs a special move!");
    }


    public void heal() {

        health += 20;

        if (health > 120) {
            health = 120;
        }

        System.out.println(name + " used a healing potion!");
        System.out.println(name + " restored 20 health.");
    }


    public boolean isAlive() {
        return health > 0;
    }


    public void showStats() {

        System.out.println("Name: " + name);
        System.out.println("Health: " + health);
        System.out.println("Attack Power: " + attackPower);
    }
}


class Warrior extends Character {

    public Warrior(String name) {
        super(name, 120, 20);
    }

    @Override
    public void specialMove() {
        System.out.println(getName()
                + " uses SWORD FURY!");
    }
}


class Mage extends Character {

    public Mage(String name) {
        super(name, 90, 25);
    }

    @Override
    public void specialMove() {
        System.out.println(getName()
                + " casts FIRE STORM!");
    }
}


class Monster extends Character {

    public Monster(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public void specialMove() {
        System.out.println(getName()
                + " uses DARK BITE!");
    }
}


class ShadowOfEldoria {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();


        System.out.println("      SHADOW OF ELDORIA");


        ArrayList<Character> enemies = new ArrayList<>();

        enemies.add(new Monster("Goblin", 50, 10));
        enemies.add(new Monster("Skeleton", 70, 12));
        enemies.add(new Monster("Dark Knight", 100, 18));

        // Player Name
        System.out.print("Enter your hero name: ");
        String playerName = scanner.nextLine();


        int choice = 0;

        while (choice != 1 && choice != 2) {

            try {

                System.out.println("\nChoose Your Class:");
                System.out.println("1. Warrior");
                System.out.println("2. Mage");
                System.out.print("Enter choice: ");

                choice = scanner.nextInt();

                if (choice != 1 && choice != 2) {
                    System.out.println("Invalid choice. Try again.");
                }

            } catch (InputMismatchException e) {

                System.out.println("Please enter a number only.");
                scanner.nextLine();
            }
        }


        Character player;

        if (choice == 1) {
            player = new Warrior(playerName);
        } else {
            player = new Mage(playerName);
        }


        System.out.println("\n===== HERO STATS =====");
        player.showStats();

        System.out.println("\nThe adventure begins...");


        for (Character enemy : enemies) {


            System.out.println("A wild " + enemy.getName() + " appeared!");


            enemy.showStats();


            while (enemy.isAlive() && player.isAlive()) {

                try {

                    System.out.println("\nChoose Action:");
                    System.out.println("1. Normal Attack");
                    System.out.println("2. Power Attack");
                    System.out.println("3. Special Move");
                    System.out.println("4. Heal");
                    System.out.print("Enter action: ");

                    int action = scanner.nextInt();

                    switch (action) {

                        case 1:

                            // Critical Hit Chance
                            int criticalChance = random.nextInt(100);

                            if (criticalChance < 20) {

                                System.out.println("CRITICAL HIT!");
                                player.attack(enemy, 15);

                            } else {

                                player.attack(enemy);
                            }

                            break;

                        case 2:
                            player.attack(enemy, 10);
                            break;

                        case 3:
                            player.specialMove();
                            player.attack(enemy, 20);
                            break;

                        case 4:
                            player.heal();
                            break;

                        default:
                            System.out.println("Invalid action!");
                            continue;
                    }


                    if (enemy.isAlive()) {

                        System.out.println("\nEnemy Turn:");

                        int enemyMove = random.nextInt(3);

                        if (enemyMove == 0) {

                            enemy.specialMove();
                            enemy.attack(player, 5);

                        } else {

                            enemy.attack(player);
                        }
                    }


                    System.out.println("\n===== BATTLE STATUS =====");
                    System.out.println(player.getName()
                            + " Health: "
                            + player.getHealth());

                    System.out.println(enemy.getName()
                            + " Health: "
                            + enemy.getHealth());

                } catch (InputMismatchException e) {

                    System.out.println("Please enter numbers only.");
                    scanner.nextLine();
                }
            }

            if (!player.isAlive()) {


                System.out.println("You were defeated...");
                System.out.println("GAME OVER");


                scanner.close();
                return;
            }

            System.out.println("\nYou defeated the "
                    + enemy.getName() + "!");
        }

        System.out.println("You saved the Kingdom of Eldoria!");
        System.out.println("VICTORY!");


        scanner.close();
    }
}