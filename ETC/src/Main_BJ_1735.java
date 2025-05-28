import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main_BJ_1735 {
public static void main(String[] args) throws IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st = new StringTokenizer(br.readLine(), " ");
int x1 = Integer.parseInt(st.nextToken());
int x2 = Integer.parseInt(st.nextToken());
st = new StringTokenizer(br.readLine(), " ");
int y1 = Integer.parseInt(st.nextToken());
int y2 = Integer.parseInt(st.nextToken());
int denominator = x2 * y2;
int numerator = x1 * y2 + y1 * x2;
int gcd = GCD(numerator, denominator);
numerator /= gcd;
denominator /= gcd;
System.out.println(numerator + " " + denominator);
}
private static int GCD(int a, int b) {
if(b==0) return a;
return GCD(b, a%b);
}
}
