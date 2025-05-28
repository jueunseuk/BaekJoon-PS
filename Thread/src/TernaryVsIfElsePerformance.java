public class TernaryVsIfElsePerformance {
    public static void main(String[] args) {
        int iterations = 100_000_000;  // 반복 횟수를 높여 차이를 감지
        int a = 5;
        int b = 10;
        int result;

        // 삼항 연산자 성능 측정
        long ternaryStart = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            result = (a > b) ? a : b;  // 삼항 연산자
        }
        long ternaryEnd = System.nanoTime();
        long ternaryDuration = ternaryEnd - ternaryStart;
        System.out.println("Ternary operator duration: " + ternaryDuration + " nanoseconds");

        // if-else 문 성능 측정
        long ifElseStart = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            if (a > b) {
                result = a;
            } else {
                result = b;
            }
        }
        long ifElseEnd = System.nanoTime();
        long ifElseDuration = ifElseEnd - ifElseStart;
        System.out.println("If-else duration: " + ifElseDuration + " nanoseconds");

        // 성능 차이 출력
        if (ternaryDuration < ifElseDuration) {
            System.out.println("Ternary operator is faster by " + (ifElseDuration - ternaryDuration) + " nanoseconds");
        } else {
            System.out.println("If-else is faster by " + (ternaryDuration - ifElseDuration) + " nanoseconds");
        }
    }
}
