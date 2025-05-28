import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Java_Exception_Prac {

    private static final Logger logger = Logger.getLogger(Java_Exception_Prac.class.getName());

    public static void main(String[] args) {
        try {
            readFile("nonexistentfile.txt");
        } catch (IOException e) {
            // 예외 메시지 출력
            System.out.println("예외 메시지: " + e.getMessage());

            // 스택 트레이스 출력
            e.printStackTrace();

            // 예외를 로그에 기록
            logger.log(Level.SEVERE, "파일을 읽는 중 예외 발생", e);

            // 예외의 원인 출력
            Throwable cause = e.getCause();
            if (cause != null) {
                System.out.println("원인 예외: " + cause.getMessage());
            }

            // 대체 작업 수행
            fallbackOperation();
        }
    }

    public static void readFile(String fileName) throws IOException {
        File file = new File(fileName);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            // 파일에서 데이터를 읽는 작업 수행
        } catch (IOException e) {
            // 예외의 원인을 설정
            throw new IOException("파일을 읽는 중 문제가 발생했습니다.", e);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    // 자원 해제 중 발생한 예외 무시 또는 로그
                    logger.log(Level.WARNING, "파일 스트림을 닫는 중 예외 발생", e);
                }
            }
        }
    }

    public static void fallbackOperation() {
        System.out.println("대체 작업 수행: 기본 파일을 생성합니다.");
        // 기본 파일 생성 또는 대체 로직 구현
    }
}
