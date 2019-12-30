package decorator;

import lombok.Data;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 9:56 2019/12/18
 */
@Data
public abstract class PersonDecorator extends Person {

	 Person person;

	public PersonDecorator(Person person) {
		this.person = person;
	}

	@Override
	public void show() {
		person.show();
	}
}
