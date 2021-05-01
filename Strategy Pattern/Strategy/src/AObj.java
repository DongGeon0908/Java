
public class AObj {

	Ainterface ainterface;

	public void funcAA() {

		// 어떤 기능을 다른 객체에게 위임
		ainterface.funcA();
		ainterface.funcA();
	}
}
