package decorator.test;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 10:29 2019/12/18
 */
public class ChocolateMT implements MilkTea {
	private String description = "巧克力奶茶";
	@Override
	public String getDescription() {
		return description;
	}
	@Override
	public double getPrice() {
		return 15;
	}

}
