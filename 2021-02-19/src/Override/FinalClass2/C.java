package Override.FinalClass2;

import Override.FinalClass.A;

public class C {

	public void method() {
		A a = new A();
		a.field = "value";
		a.method();
	}
}
