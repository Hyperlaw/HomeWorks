import java.util.Scanner;

public class DZ_1 {
    public static void main(String[] args) {
        String myLastName;
        final int NUM = 5;
        String word = "apple";
        myLastName = NUM + word;
        System.out.println(NUM);
        System.out.println(word);
        System.out.println(myLastName);

        if (NUM < 0) {
            System.out.println("Вы сохранили отрицательное число");
        }else if (NUM > 0) {
            System.out.println("Вы сохранили положительное число");
        }else {
            System.out.println("Вы сохранили ноль");
        }

        String userName;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ваше имя: ");
        System.out.println();
        userName = scanner.nextLine();
        System.out.println("Привет, " + userName + '!');
    }
}
