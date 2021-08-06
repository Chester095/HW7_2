public class Main_1{

    public static void main(String[] args) {
        int a = 5, b = 5; // кол-во строк и столбцов
        int randomMax = 10;
        int[][] mass = new int[a + 1][b + 1];
        System.out.println(mass.length);

        randomFull(mass, randomMax);                    // проверка конструктора
        massInfo(mass);                                 // проверка вывода массива
        System.out.println(massSumm(mass));             // проверка суммы массива
        System.out.println(massSummMax(mass, 5));   // проверка суммы массива больше заданного
        System.out.println(massMin(mass));              // проверка поиска минимума
        System.out.println(massMax(mass));              // проверка поиска максимума
        System.out.println(massMaxInfoStringV1(mass));  // проверка поиска максимума и координат В1
        massMaxXY.soutMassMaxXY(massMaxInfoV2(mass));   // проверка поиска максимума и координат В2
    }

    public static void randomFull(int[][] mass, int randomMax) {    // конструктор, заполняющий массив случайными числами
        for (int i = 0; i < mass.length - 1; i++) {
            for (int j = 0; j < mass[j].length - 1; j++)
                mass[i][j] = (int) (Math.random() * randomMax);
        }
    }

    public static void massInfo(int[][] mass) {                     // вывод массива
        for (int i = 0; i < mass.length - 1; i++) {
            for (int j = 0; j < mass[j].length - 1; j++) System.out.print(mass[i][j] + "\t");
            System.out.println();
        }
    }

    public static int massSumm(int[][] mass) {                    // возвращают сумму всех элементов массива
        int summ = 0;
        for (int i = 0; i < mass.length - 1; i++) {
            for (int j = 0; j < mass[j].length - 1; j++)
                summ += mass[i][j];
        }
        return summ;
    }

    public static int massSummMax(int[][] mass, int max) {        // возвращают сумму всех элементов массива больше заданного
        int summ = 0;
        for (int i = 0; i < mass.length - 1; i++) {
            for (int j = 0; j < mass[j].length - 1; j++)
                if (mass[i][j] > max) summ += mass[i][j];
        }
        return summ;
    }

    public static int massMin(int[][] mass) {                       // возвращают минимальное значение элемента массива
        int min = mass[0][0];
        for (int i = 0; i < mass.length - 1; i++) {
            for (int j = 0; j < mass[j].length - 1; j++)
                if (min > mass[i][j]) min = mass[i][j];
        }
        return min;
    }

    public static int massMax(int[][] mass) {                       // возвращают максимальное значение элемента массива
        int max = mass[0][0];
        for (int i = 0; i < mass.length - 1; i++) {
            for (int j = 0; j < mass[j].length - 1; j++)
                if (max < mass[i][j]) max = mass[i][j];
        }
        return max;
    }

    public static String massMaxInfoStringV1(int[][] mass) {          // возвращают максимальное значение элемента массива и координаты
        int a=0, b=0, max = mass[a][b];
        for (int i = 0; i < mass.length - 1; i++) {
            for (int j = 0; j < mass[j].length - 1; j++)
                if (max < mass[i][j]) {max = mass[i][j]; a=i+1; b=j+1;}
        }
        return "Максимальное значение = "+max+"\tСтрока "+a+"\tстолбец "+b;
    }

    public static massMaxXY massMaxInfoV2(int[][] mass) {               // возвращают максимальное значение элемента массива и координаты
        int a=0, b=0, max = mass[a][b];
        for (int i = 0; i < mass.length - 1; i++) {
            for (int j = 0; j < mass[j].length - 1; j++)
                if (max < mass[i][j]) {max = mass[i][j]; a=i+1; b=j+1;}
        }
        return new massMaxXY(max, a, b);
    }
}

class massMaxXY{
    int max, x, y;
    public massMaxXY(int max, int x, int y) {
        this.max = max; this.x = x; this.y = y;
    }

    public static void soutMassMaxXY(massMaxXY mass){
        System.out.println("Максимальное значение = "+mass.max+"\tСтрока "+mass.x+"\tстолбец "+mass.y);
    }
}


