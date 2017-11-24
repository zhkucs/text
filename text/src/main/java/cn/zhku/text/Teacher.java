package cn.zhku.text;


public class Teacher {
	public Teacher(String string) {
		this.setName(string);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String name;
}
