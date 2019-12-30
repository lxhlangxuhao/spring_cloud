package decorator.test;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 10:31 2019/12/18
 */
public class Coconut extends Decorator{
	private String description = "加了椰果！";
	private MilkTea milkTea = null;

	public Coconut(MilkTea milkTea){
		this.milkTea = milkTea;
	}
	public String getDescription(){
		return milkTea.getDescription()+"\n"+description;
	}
	public double getPrice(){
		return milkTea.getPrice()+3;    //3表示椰果的价格
	}
}
