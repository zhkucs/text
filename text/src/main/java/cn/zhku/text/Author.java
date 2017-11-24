package cn.zhku.text;


public class Author {
	String spec;
	String clzNo;
	String name;
	String phone;
	
	
	public Author(String spec, String clzNo, String name, String phone) {
		super();
		this.spec = spec;
		this.clzNo = clzNo;
		this.name = name;
		this.phone = phone;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public String getClzNo() {
		return clzNo;
	}
	public void setClzNo(String clzNo) {
		this.clzNo = clzNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
