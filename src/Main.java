import java.util.ArrayList;
import java.util.Scanner;

class Character {

    private String name;
    protected int health;
    protected int attackPower;

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

    public void attack(Character enemy) {
        enemy.health -= attackPower;

        if (enemy.health < 0) {
            enemy.health = 0;
        }

        System.out.println(name + " attacks "
                + enemy.getName()
                + " for " + attackPower + " damage!");
    }

    public void attack(Character enemy, int bonusDamage) {

        enemy.health -= (attackPower + bonusDamage);

        if (enemy.health < 0) {
            enemy.health = 0;
        }

        System.out.println(name + " uses a power attack on "
                + enemy.getName()
                + " for " + (attackPower + bonusDamage)
                + " damage!");
    }

    public void specialMove() {
        System.out.println(name + " performs a basic move.");
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
                + " uses Sword Fury!");
    }
}

class Mage extends Character {

    public Mage(String name) {
        super(name, 90, 25);
    }

    @Override
    public void specialMove() {
        System.out.println(getName()
                + " casts Fire Storm!");
    }
}

class Monster extends Character {

    public Monster(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public void specialMove() {
        System.out.println(getName()
                + " uses Dark Bite!");
    }
}

class ShadowOfEldoria {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("      SHADOW OF ELDORIA");
        System.out.println("=================================");

        ArrayList<Character> enemies = new ArrayList<>();

        enemies.add(new Monster("Goblin", 50, 10));
        enemies.add(new Monster("Skeleton", 60, 12));
        enemies.add(new Monster("Dark Knight", 100, 18));

        System.out.print("Enter your hero name: ");
        String playerName = scanner.nextLine();

        System.out.println("\nChoose Your Class:");
        System.out.println("1. Warrior");
        System.out.println("2. Mage");

        int choice = scanner.nextInt();

        Character player;

        if (choice == 1) {
            player = new Warrior(playerName);
        } else {
            player = new Mage(playerName);
        }

        System.out.println("\nYour Hero Stats:");
        player.showStats();

        System.out.println("\nThe adventure begins...\n");

        for (Character enemy : enemies) {

            System.out.println("---------------------------------");
            System.out.println("A wild " + enemy.getName() + " appeared!");
            enemy.showStats();

            while (enemy.isAlive() && player.isAlive()) {

                System.out.println("\nChoose Action:");
                System.out.println("1. Normal Attack");
                System.out.println("2. Power Attack");
                System.out.println("3. Special Move");

                int action = scanner.nextInt();

                switch (action) {

                    case 1:
                        player.attack(enemy);
                        break;

                    case 2:
                        player.attack(enemy, 10);
                        break;

                    case 3:
                        player.specialMove();
                        player.attack(enemy, 15);
                        break;

                    default:
                        System.out.println("Invalid action!");
                        continue;
                }

                if (enemy.isAlive()) {
                    enemy.attack(player);
                }

                System.out.println("\nPlayer Health: " + player.health);
                System.out.println(enemy.getName()
                        + " Health: " + enemy.health);
            }

            if (!player.isAlive()) {

                System.out.println("\nYou were defeated...");
                System.out.println("GAME OVER");

                scanner.close();
                return;
            }

            System.out.println("\nYou defeated the "
                    + enemy.getName() + "!");
        }

        System.out.println("\n=================================");
        System.out.println("You saved the Kingdom of Eldoria!");
        System.out.println("VICTORY!");
        System.out.println("=================================");

        scanner.close();
    }
}