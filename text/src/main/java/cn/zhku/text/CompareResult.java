package cn.zhku.text;


import java.util.List;

public class CompareResult  implements Comparable<CompareResult>{
	PaperInfo source;
	PaperInfo target;
	double simularity;// ���ƶ�
	
	
	public CompareResult(PaperInfo source, PaperInfo target, double simularity) {
		super();
		this.source = source;
		this.target = target;
		this.simularity = simularity;
	}
	public PaperInfo getSource() {
		return source;
	}
	public void setSource(PaperInfo source) {
		this.source = source;
	}
	public PaperInfo getTarget() {
		return target;
	}
	public void setTarget(PaperInfo target) {
		this.target = target;
	}
	public double getSimularity() {
		return simularity;
	}
	public void setSimularity(double simularity) {
		this.simularity = simularity;
	}
	
	
	public void display(){
		System.out.println(source.getAuthor().getName() +":"+source.getTitle() + "---"+target.getAuthor().getName() +":"+ target.getTitle() +"  -------"+ + this.simularity);
	}
	@Override
	public int compareTo(CompareResult o) {
		// TODO Auto-generated method stub
		return (int) (this.simularity - o.getSimularity());
	}
	
	
	public Object[] toArray(){
		Object[]  o = {"",this.getSource().getAuthor().clzNo,this.getSource().getAuthor().name,this.getSource().getTitle(),this.target.getAuthor().name,this.target.getTitle(),this.simularity};
		return o;
	}
	
	
}
