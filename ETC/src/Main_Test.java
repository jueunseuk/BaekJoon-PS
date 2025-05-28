import java.util.Random;

public class Main_Test {
    public static void main(String[] args) {
        int rows = 50;
        int cols = 1000;
        char[][] matrix = new char[rows][cols];
        Random random = new Random();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // 1000x1000 랜덤 알파벳 채우기
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = alphabet.charAt(random.nextInt(alphabet.length()));
            }
        }

        // 결과 출력 (예시로 상위 5x5만 출력)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
