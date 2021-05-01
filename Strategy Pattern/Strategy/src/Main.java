
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ainterface ainterface = new AinterfaceImpl();

		// 기능을 사용할 수 있는 통로를 제공
		ainterface.funcA();

		GameCharacter character = new GameCharacter();

		character.attack();

		character.setWeapon(new Knife());
		character.attack();

		character.setWeapon(new Sword());
		character.attack();
		
		character.setWeapon(new Ax());
		character.attack();
	}

}
