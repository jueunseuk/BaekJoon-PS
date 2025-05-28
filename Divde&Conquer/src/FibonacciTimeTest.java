public class FibonacciTimeTest {
	private static long MOD = 1_000_000_007;
    public static void main(String[] args) {
        long n = 10000000; // 테스트할 피보나치 수의 위치

        // 행렬 분할 정복 방식 테스트
        long startMatrix = System.nanoTime();
        long matrixResult = fibonacciMatrix(n);
        long endMatrix = System.nanoTime();
        System.out.println("행렬 분할 정복 방식:");
        System.out.println("F(" + n + ") = " + matrixResult);
        System.out.println("시간: " + (endMatrix - startMatrix) / 1_000_000 + " ms");
    }

    // 행렬 분할 정복 방식
    public static long fibonacciMatrix(long n) {
        if (n == 0) return 0;
        long[][] base = {{1, 1}, {1, 0}};
        long[][] result = matrixPower(base, n - 1);
        return result[0][0]; // F(n)
    }

    // 행렬 거듭제곱 (분할 정복)
    private static long[][] matrixPower(long[][] matrix, long exp) {
        if (exp == 0) {
            return new long[][]{{1, 0}, {0, 1}}; // 단위 행렬 반환
        }
        if (exp == 1) {
            return matrix;
        }
        long[][] half = matrixPower(matrix, exp / 2);
        long[][] result = multiplyMatrix(half, half);
        if (exp % 2 != 0) { // 홀수라면 추가 곱셈
            result = multiplyMatrix(result, matrix);
        }
        return result;
    }

    // 행렬 곱셈
    private static long[][] multiplyMatrix(long[][] A, long[][] B) {
        long[][] C = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        return C;
    }
}
