package SortingBasic.SelectionSortUsingComparable;

public class Student implements Comparable<Student> {

	private String name;
	private int score;
	
	public Student(String name,int score) {
		this.name = name;
		this.score = score;
	}
	
	// ����Student��compareTo����
    // ���������ȣ��������ֵ���ĸ������
    // ����������ȣ�������ߵĿ�ǰ
	@Override
	public int compareTo(Student s) {
		
		if(this.score < s.score)
			return -1;
		else if(this.score > s.score)
			return 1;
		else
			return this.name.compareTo(s.name);
	}

	//��дtoSring����
	@Override
	public String toString() {
		return "Student: " + this.name + " " + this.score;
	}
}
