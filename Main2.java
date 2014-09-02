import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    private static final int SIZE = 12;

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
        boolean[][] doek = new boolean[SIZE][SIZE];
        Scanner s = new Scanner(INPUT).useDelimiter(",");
        int i = 0;
        while (s.hasNext()) {
            doek[i % SIZE][i / SIZE] = s.next().equals("X");
            i++;
        }

        int[] best = null;
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                int[] result = new int[SIZE * SIZE + 1];
                zoek(doek, x, y, result);
                if (result[0] > 0) {
                    if (best == null || result[0] < best[0]) {
                        best = result;
                    }
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

    private static void zoek(boolean[][] doek, int x, int y, int[] result) {
        if (x >= 0 && y >= 0 && x < SIZE && y < SIZE && doek[x][y]) {
            result[++result[0]] = x + SIZE * y;

            doek[x][y] = false;

            zoek(doek, x + 1, y, result); // rechts
            zoek(doek, x, y + 1, result); // onder
            zoek(doek, x + 1, y + 1, result); // rechtsonder
            zoek(doek, x - 1, y + 1, result); // linksonder
        }
    }

}
