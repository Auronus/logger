import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Logger logger = Logger.getInstance();

        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");
        System.out.println("Введите размер списка:");
        int listSize = readValueFromUser(scanner);

        System.out.println("Введите верхнюю границу для значений:");
        int maxValue = readValueFromUser(scanner);

        logger.log("Создаём и наполняем список");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            list.add(random.nextInt(maxValue));
        }
        System.out.println("Вот случайный список: " + list);

        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.println("Введите порог для фильтра:");
        int maxFilterValue = readValueFromUser(scanner);

        Filter filter = new Filter(maxFilterValue);
        List<Integer> result = filter.filterOut(list);

        logger.log("Выводим результат на экран");
        System.out.println("Отфильтрованный список: " + result.toString());

        logger.log("Завершаем программу");
    }

    private static int readValueFromUser(Scanner scanner) {
        Logger logger = Logger.getInstance();

        String value = scanner.next();
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            logger.log("Было введено некорректное значение - " + value);
            System.out.println("Введенное значение не является числом поддерживаемого формата (челочисленное значение); Повторите ввод");
            return readValueFromUser(scanner);
        }
    }
}