import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Main {
    public static void main(String[] args) {
        try {
            Pattern.compile("(abc");
        } catch (PatternSyntaxException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}
