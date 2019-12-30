package decorator;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 9:59 2019/12/18
 */
public class FlyPersonDecorator extends PersonDecorator {

	public FlyPersonDecorator(Person person) {
		super(person);
	}

	@Override
	public void show() {
		super.show();
		fly();
	}

	public void fly() {
		System.out.println("fly ~");
	}


	public static void main(String[] args) {

		Person person = new Person();
		person = new FlyPersonDecorator(person);
		person = new RunPersonDecorator(person);

		person.show();

	}

}
