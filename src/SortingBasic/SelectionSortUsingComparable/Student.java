package SortingBasic.SelectionSortUsingComparable;

public class Student implements Comparable<Student> {

	private String name;
	private int score;
	
	public Student(String name,int score) {
		this.name = name;
		this.score = score;
	}
	
	// 定义Student的compareTo函数
    // 如果分数相等，则按照名字的字母序排序
    // 如果分数不等，则分数高的靠前
	@Override
	public int compareTo(Student s) {
		
		if(this.score < s.score)
			return -1;
		else if(this.score > s.score)
			return 1;
		else
			return this.name.compareTo(s.name);
	}

	//重写toSring方法
	@Override
	public String toString() {
		return "Student: " + this.name + " " + this.score;
	}
}
