package cn.zhku.text;


public class PaperInfo {
	private Author author;
	private String title;
	private int grade;	
	private Teacher teacher;
	
	final String[] WATER_WORDS = {"基于","设计与实现","设计和实现","实现与设计","实现与设计","设计","的"};
	private final String title2;	
	
	private String filter(String title) {
		for(String w  : WATER_WORDS){
			title = title.replace(w, "");
		}
		return title;
	}
	
	public PaperInfo(Author author, String title, int grade, Teacher teacher) {
		super();
		this.author = author;
		this.title = title;
		this.grade = grade;
		this.teacher = teacher;
		this.title2 = filter(title);
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public String getTitle2() {
		return title2;
	}
	
	
	
}
