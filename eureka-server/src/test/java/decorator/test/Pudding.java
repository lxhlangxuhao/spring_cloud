package decorator.test;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 10:31 2019/12/18
 */
public class Pudding extends Decorator{
	private String description = "加了布丁！";
	private MilkTea milkTea = null;

	public Pudding(MilkTea milkTea){
		this.milkTea = milkTea;
	}
	public String getDescription(){
		return milkTea.getDescription()+"\n"+description;
	}
	public double getPrice(){
		return milkTea.getPrice()+5;    //5表示布丁的价格
	}


	public static void main(String[] args) {
		MilkTea milkTea = new ChocolateMT();    //选择了巧克力奶茶
		milkTea = new Pudding(milkTea);     //为巧克力奶茶添加布丁
		milkTea = new Coconut(milkTea);     //为巧克力奶茶添加椰果
		System.out.println(milkTea.getDescription()+"\n加了布丁和椰果的巧克力奶茶价格："+milkTea.getPrice());

	}
}
