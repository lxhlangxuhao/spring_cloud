package decorator;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 10:05 2019/12/18
 */
public class RunPersonDecorator extends PersonDecorator {

	public RunPersonDecorator(Person person) {
		super(person);
	}

	@Override
	public void show() {
		super.show();
		run();
	}

	public void run() {
		System.out.println("run ~");
	}

}
