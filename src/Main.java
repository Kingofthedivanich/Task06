import java.util.Scanner;

public class Main {

    public static final String PRINT_MESSAGE = "Введите целое положительное число:";

    public static int scanN() {
        int N = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println(PRINT_MESSAGE);
            while (!scanner.hasNextInt()) {
                System.out.println(PRINT_MESSAGE);
                scanner.next();
            }
            N = scanner.nextInt();
        } while (N <= 0);
        return N;
    }

    public static double scanX() {
        double x = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Введите x в диапазоне от -1 до 1: ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Введите x в диапазоне от -1 до 1: ");
                scanner.next();
            }
            x = scanner.nextDouble();
        } while ((x < -1) || (x > 1));
        return x;
    }

    public static double scanE() {
        double e = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число e: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Введите число e: ");
            scanner.next();
        }
        e = scanner.nextDouble();
        return e;
    }

    public static double f(int n, double aPred, double x){
        if (n == 1){
            return x;
        }
        return aPred * x * x * (n - 2) / n;
    }

    public static void prog(double x,double e, int n){
        double fun = 0;
        double sum1 = 0;
        double sum2 = 0;
        double sum3 = 0;
        double x1 = 0;
        double x2 = 1;

        for (int i = 1; i < n; i += 2){
            x1 = f(i, x2, x);
            sum1 = sum1 + x1; // 1 пункт

            if (Math.abs(x1) > e){ // 2 пункт
                sum2 = sum2 + x1;
            }

            if (Math.abs(x1) > (e / 10)){ // 3 пункт
                sum3 = sum3 + x1;
            }

            // 4 пункт
            x2 = x1;
        }
        fun = Math.log((1 + x) / (1 - x));
        System.out.println("Пункт 1: " + sum1);
        System.out.println("Пункт 2: " + sum2);
        System.out.println("Пункт 3: " + sum3);
        System.out.println("Пункт 4: " + fun);
    }

    public static void main(String[] args) {
        double x = scanX();
        int n = scanN();
        double e = scanE();

        prog(x, e, n);
    }
}