import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class GPT_학생성적관리 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			st = new StringTokenizer(br.readLine(), " ");
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		int studentN = Integer.parseInt(st.nextToken());
		int classN = Integer.parseInt(st.nextToken());
		
		List<Student> student = new ArrayList<>();
		
		for(int i = 0 ; i < studentN; i++) {
			try {
				st = new StringTokenizer(br.readLine(), " ");
			} catch (IOException e) {
				e.printStackTrace();
				return;
			} catch (NoSuchElementException e) {
				e.printStackTrace();
			}
			int classNo = Integer.parseInt(st.nextToken());
			int studentNo = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			int mathScore = Integer.parseInt(st.nextToken());
			int engScore = Integer.parseInt(st.nextToken());
			int scienceScore = Integer.parseInt(st.nextToken());
			
			student.add(new Student(classNo, studentNo, name, mathScore, engScore, scienceScore));
		}
		
		Comparator<Student> comparator = new Comparator<>() {
			@Override
			public int compare(Student o1, Student o2) {
				if(o1.sumScore != o2.sumScore) {
					return o2.sumScore-o1.sumScore;
				} else {
					if(o1.engScore != o2.engScore) {
						return o2.engScore-o1.engScore;
					} else {
						if(o1.mathScore != o2.mathScore) {
							return o2.mathScore-o1.mathScore;
						} else {
							return o1.name.compareTo(o2.name);
						}}}}};
		
		Collections.sort(student, comparator);
		
		StringBuilder sb = new StringBuilder();
		for(Student out : student) {
			if(out.mathScore >= 50 && out.scienceScore >= 70)
			sb.append(out.studentNo).append(" ").append(out.name).append("\n");
		}
		
		System.out.println(sb.toString());
		
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

// 객체 저장
class Student implements Comparable<Student>{
	
	int classNo;
	int studentNo;
	String name;
	int mathScore;
	int engScore;
	int scienceScore;
	int sumScore;
	
	public Student(int classNo, int studentNo, String name, int mathScore, int engScore, int scienceScore) {
		super();
		this.classNo = classNo;
		this.studentNo = studentNo;
		this.name = name;
		this.mathScore = mathScore;
		this.engScore = engScore;
		this.scienceScore = scienceScore;
		this.sumScore = mathScore + engScore + scienceScore;
	}

	@Override
	public int compareTo(Student other) {
		return this.classNo-other.classNo;
	}
}