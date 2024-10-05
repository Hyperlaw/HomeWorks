import java.util.Random;
public class DZ_2 {
    public static void main(String[] args) {
        System.out.println(permission(17, 22));
        System.out.println(permission(55, -12));
        System.out.println(permission(33, -28));
        System.out.println(permission(12, 3));
        System.out.println(permission(19, -4));

        System.out.println(permission(generateRandomAge(), 10));

    }
    public static String permission(int age, int temperature){
        if (age > 20 && age < 45 && temperature > -20 && temperature < 30
                || age < 20 && temperature > 0 && temperature < 28 ||
                age >45 && temperature > -10 && temperature < 25){
            return "Можно идти гулять";
        }else {
            return "Оставайтесь дома";
        }

    }
    public static int generateRandomAge() {
        // Задаем минимальный и максимальный возраст
        int minAge = 1;
        int maxAge = 120;

        // Создаем объект Random для генерации случайных чисел
        Random random = new Random();

        // Генерируем случайное число в заданном диапазоне и возвращаем его
        return random.nextInt(maxAge - minAge + 1) + minAge;
    }

}
