package cn.zhku.text;

public class MainApp {
	public static void main(String[] args) {
		if(args[0] == null){
			System.out.println("args[0] must be provided");
			return;
		}
		if(args[1] == null){
			System.out.println("args[1] must be provided");
			return;
		}
		Checker c = new Checker(args[0]);
		try {
			c.dump(Integer.parseInt(args[1]), System.currentTimeMillis()+".xls");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
