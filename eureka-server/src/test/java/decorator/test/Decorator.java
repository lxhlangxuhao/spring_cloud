package decorator.test;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 10:30 2019/12/18
 */
public class Decorator implements MilkTea {
	private String description = "我只是装饰器，不知道是哪种奶茶";
	@Override
	public String getDescription() {
		return description;
	}
	@Override
	public double getPrice() {
		return 0;       //价格由种类来决定
	}
}
