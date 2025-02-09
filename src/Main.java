
import java.util.Scanner;

public class Main {

    public static void printMenu() {
        System.out.println("\nВвести шаги за день - 1\nНапечатать статистику за определенный месяц - 2\nИзменить Цель по количеству шагов - 3\nВыйти из приложения - 4");
    }
    public static void main(String[] args) {
        StepTracker stepTracker = new StepTracker();
        printMenu();
        int action = 0;
        while (action != 4) {
            action = new Scanner(System.in).nextInt();
            if (action == 1) {
                System.out.println("Введите месяц, день и количество пройденных шагов");
                String month = new Scanner(System.in).nextLine();
                int daysNumber = new Scanner(System.in).nextInt();
                int stepAmount = new Scanner(System.in).nextInt();
                stepTracker.addDaylySteps(month, (daysNumber - 1), stepAmount);
                printMenu();
            } else if (action == 2) {
                System.out.println("Введите месяц для получения информации");
                String month = new Scanner(System.in).nextLine();
                stepTracker.getAllSteps(month);
                stepTracker.getMaxSteps(month);
                stepTracker.getAverageSteps(month);
                stepTracker.getAllDistance(month);
                stepTracker.getAllCalories(month);
                stepTracker.getBestSeries(month);
                printMenu();
            } else if (action == 3) {
                System.out.println("Введите новую дневную цель");
                int target = new Scanner(System.in).nextInt();
                if (target >= 0) {
                    stepTracker.setTarget(target);

                } else {
                    System.out.println("не может быть отрицательное количество шагов");
                }
                printMenu();
            } else if (action == 4) {
                System.out.println("Программа завершена");
            } else {
                System.out.println("Ошибка. Не верный ввод");
            }
        }

    }

}