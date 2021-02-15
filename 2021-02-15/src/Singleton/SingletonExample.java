package Singleton;

public class SingletonExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();

		if (obj1 == obj2) {
			System.out.print("같은 싱글톤");
		} else {
			System.out.println("다른 싱글톤");
		}
	}

}
