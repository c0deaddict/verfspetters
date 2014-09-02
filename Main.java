import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final int SIZE = 12;
    private static final int SIZE2 = SIZE * SIZE;

    private static final String INPUT =
            "O,X,O,O,O,O,O,O,O,O,O,O,\n" +
                    "X,X,O,O,O,X,X,X,O,O,O,O,\n" +
                    "X,X,X,O,X,O,X,X,O,O,O,O,\n" +
                    "O,O,O,O,O,O,O,O,O,O,O,X,\n" +
                    "O,O,O,X,X,O,O,O,O,O,X,O,\n" +
                    "O,O,O,O,O,O,O,O,O,O,O,O,\n" +
                    "O,O,O,O,O,O,O,O,O,O,O,O,\n" +
                    "O,O,X,X,X,X,X,X,O,O,O,O,\n" +
                    "O,O,O,O,X,X,O,O,O,O,O,O,\n" +
                    "X,O,O,O,O,X,O,O,O,X,X,X,\n" +
                    "X,O,O,O,O,O,X,X,O,X,X,X,\n" +
                    "X,X,X,X,O,O,O,X,O,O,O,O";

    public static void main(String[] args) {
        boolean[] doek = new boolean[SIZE2];
        Scanner s = new Scanner(INPUT).useDelimiter(",");
        int i = 0;
        while (s.hasNext()) {
            doek[i++] = s.next().equals("X");
        }

        int[] best = null;
        for (i = 0; i < SIZE2; i++) {
            int[] result = new int[SIZE2 + 1];
            zoek(doek, i, result);
            if (result[0] != 0) {
                if (best == null || result[0] < best[0]) {
                    best = result;
                }
            }
        }

        if (best != null) {
            System.out.print(best[0] + " => ");
            Arrays.sort(best, 1, 1 + best[0]);
            for (int j = 1; j <= best[0]; j++) {
                System.out.print("(" + best[j] % SIZE + ", " + best[j] / SIZE + "), ");
            }
            System.out.println();
        }
    }

    private static void zoek(boolean[] doek, int i, int[] result) {
        if (i < SIZE2 && doek[i]) {
            result[++result[0]] = i;
            doek[i] = false;

            if ((i + 1) % SIZE != 0) {
                zoek(doek, i + 1, result); // rechts
                zoek(doek, i + 1 + SIZE, result); // rechtsonder
            }
            if (i % SIZE != 0) {
                zoek(doek, i - 1 + SIZE, result); // linksonder
            }
            zoek(doek, i + SIZE, result); // onder
        }
    }

}
