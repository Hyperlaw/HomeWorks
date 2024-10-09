import java.util.Random;

public class DZ_4N2 {
    public static int bossHealth = 3000;
    public static int bossDamage = 50;
    public static String bossDefence;
    public static int[] heroesHealth = {280, 270, 240, 350, 150, 200, 500, 800};
    public static int[] heroesDamage = {20, 15, 10, 0, 5, 15, 0, 5};
    public static String[] heroesAttackType = {"Physical", "Magical", "Kinetic", "Healer", "Lucky", "Thor", "Witcher", "Golem"};
    public static int roundNumber;

    public static void main(String[] args) {
        printStatistics();

        while (!isGameOver()) {
            playRound();
        }
    }

    public static void playRound() {
        roundNumber++;
        chooseBossDefence();
        bossAttacks();
        heroesAttack();
        printStatistics();
        healing();
        comeBack();
    }

    public static boolean isGameOver() {
        if (bossHealth <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
            return true;
        }
        return false;
    }

    public static void chooseBossDefence() {
        Random random = new Random();
        int randomInd = random.nextInt(2); // 0,1,2
        bossDefence = heroesAttackType[randomInd];
    }
    public static void comeBack() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] == 0 && heroesHealth[6] > 0){
                heroesHealth[i] += heroesHealth[6];
                heroesHealth[6] = 0;
                System.out.println("Witcher revived ---> " + heroesAttackType[i] + " and died himself");
            }

        }
    }


    public static void healing(){
        for (int i = 0; i < heroesAttackType.length; i++) {
            if(i == 3) {
                continue;

            }if (heroesHealth[i] < 100 && heroesHealth[3] > 0){
                heroesHealth[i] = heroesHealth[i] + 80;

                break;
            }

        }
    }

    public static void heroesAttack() {
        for (int i = 0; i < heroesDamage.length; i++) {
            if (heroesHealth[i] > 0 && bossHealth > 0) {
                int damage = heroesDamage[i];
                if (heroesAttackType[i] == bossDefence) {
                    Random random = new Random();
                    int coefficient = random.nextInt(9) + 2; // 2,3,4,5,6,7,8,9,10
                    damage *= coefficient;
                    System.out.println("Critical damage: " + damage);
                }
                if (bossHealth - damage < 0) {
                    bossHealth = 0;
                } else {
                    bossHealth = bossHealth - damage;
                }
            }
        }
    }

    public static void bossAttacks() {
        Random random = new Random();
        boolean stunned = random.nextBoolean();
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0) {
                if (heroesHealth[5] > 0 && stunned){
                    System.out.println("BOSS is stunned!");
                    break;
                }
                if (heroesAttackType[i].equals("Lucky")) {
                    boolean dodged = random.nextBoolean();
                    if (dodged) {
                        System.out.println("Lucky dodged the attack!");
                        continue;
                    }
                }
                int damageToHero = bossDamage;

                if (i != 7 && heroesHealth[7] > 0) {
                    int golemDamageShare = bossDamage / 5;
                    damageToHero -= golemDamageShare;
                    heroesHealth[7] -= golemDamageShare;
                    if (heroesHealth[7] < 0) {
                        heroesHealth[7] = 0;
                    }
                }
                if (heroesHealth[i] - damageToHero < 0) {
                    heroesHealth[i] = 0;
                } else {
                    heroesHealth[i] = heroesHealth[i] - damageToHero;
                }
            }
        }
    }

    public static void printStatistics() {
        System.out.println("ROUND " + roundNumber + " ------------");
        /*String defence;
        if (bossDefence == null) {
            defence = "No Defence";
        } else {
            defence = bossDefence;
        }*/
        System.out.println("BOSS health: " + bossHealth + " damage: " + bossDamage +
                " defence: " + (bossDefence == null ? "No Defence" : bossDefence));
        for (int i = 0; i < heroesHealth.length; i++) {
            System.out.println(heroesAttackType[i] + " health: " + heroesHealth[i]
                    + " damage: " + heroesDamage[i]);
        }
    }
}