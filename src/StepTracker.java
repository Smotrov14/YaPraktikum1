
import java.util.HashMap;

public class StepTracker {
    private int target = 10000;
    HashMap<String, int[]> monthsCounter;

    public StepTracker() {
        stepTracker();
    }


    private void stepTracker() {
        monthsCounter = new HashMap<>();
        monthsCounter.put("Январь", new int[30]);
        monthsCounter.put("Февраль", new int[30]);
        monthsCounter.put("Март", new int[30]);
        monthsCounter.put("Апрель", new int[30]);
        monthsCounter.put("Май", new int[30]);
        monthsCounter.put("Июнь", new int[30]);
        monthsCounter.put("Июль", new int[30]);
        monthsCounter.put("Август", new int[30]);
        monthsCounter.put("Сентябрь", new int[30]);
        monthsCounter.put("Октябрь", new int[30]);
        monthsCounter.put("Ноябрь", new int[30]);
        monthsCounter.put("Декабрь", new int[30]);
    }

    public HashMap<String, int[]> getMonthsCounter() {
        return monthsCounter;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public void addDaylySteps(String month, int daysNumber, int stepAmount) {
        int[] monthArray = monthsCounter.get(month);
        if (monthArray != null) {
            monthArray[daysNumber] = stepAmount;
        } else {
            System.out.println("Массив для месяца " + month + " не найден.");
        }
    }
    public void getAllSteps(String month){
        int sum = 0;
        int[] stepsArray = monthsCounter.get(month);
        for (int value : stepsArray) {
            sum += value;}
        System.out.println("За "+ month + " вы прошли " + sum + " шагов");
    }
    public void getMaxSteps(String month){
        int max = 0;
        int[] stepsArray = monthsCounter.get(month);
        for (int value : stepsArray) {
            if(max <= value){
            max = value;}
        }
        System.out.println("За "+ month + " в день максимально прошли: " + max + " шагов");
    }
    public void getAverageSteps(String month){
        int average = 0;
        int[] stepsArray = monthsCounter.get(month);
        for (int value : stepsArray) {
            average += value;}
        System.out.println("За "+ month + " в среднем вы проходили по  " + (average / stepsArray.length)+ " шагов в день");
    }
    public void getAllDistance(String month){
        Statistic statistic = new Statistic();
        int distance;
        int sum = 0;
        int[] stepsArray = monthsCounter.get(month);
        for (int value : stepsArray) {
            sum += value;}
        distance = (sum * statistic.getDistancePerStep())/100;
        System.out.println("За "+ month + " вы прошли " + distance + " метров");
    }
    public void getAllCalories(String month){
            Statistic statistic = new Statistic();
            int calories;
            int sum = 0;
            int[] stepsArray = monthsCounter.get(month);
            for (int value : stepsArray) {
                sum += value;}
            calories = (sum * statistic.getCaloriesPerStep()/1000);
            System.out.println("За "+ month + " вы сожгли " + calories + " килокалорий");
        }
    public void getBestSeries(String month){
        int maxDays = 0;
        int counter = 0;
        int target1 = target;
        int[] stepsArray = monthsCounter.get(month);
        for(int value : stepsArray) {
            if (value >= target1) {
                counter +=1;
                if(maxDays < counter){
                    maxDays = counter;}
            }
            else{
                counter = 0;}
        }
        System.out.println("За "+ month + " вы достигали цели " + maxDays + " дней подряд");
    }

}
 