import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_1019_책페이지 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        long[] digitCounts = new long[10];

        int start = 1;
        int position = 1;

        while (start <= n) {
            // 첫 번째 구간: 시작을 10의 배수로 정렬
            while (start % 10 != 0 && start <= n) {
                countDigits(start, digitCounts, position);
                start++;
            }

            // 두 번째 구간: 종료를 9로 정렬
            while (n % 10 != 9 && start <= n) {
                countDigits(n, digitCounts, position);
                n--;
            }

            if (start > n) break;

            // 중간 구간: 자릿수마다 등장하는 숫자 카운팅
            int startDiv = start / 10;
            int endDiv = n / 10;
            for (int i = 0; i < 10; i++) {
                digitCounts[i] += (endDiv - startDiv + 1) * position;
            }

            // 다음 자릿수로 이동
            start /= 10;
            n /= 10;
            position *= 10;
        }

        // 결과 출력
        for (int i = 0; i < 10; i++) {
            System.out.print(digitCounts[i] + " ");
        }
    }

    private static void countDigits(int number, long[] digitCounts, int position) {
        while (number > 0) {
            digitCounts[number % 10] += position;
            number /= 10;
        }
    }
}
