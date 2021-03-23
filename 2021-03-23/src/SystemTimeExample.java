
public class SystemTimeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long time1 = System.nanoTime();

		int sum = 0;
		for (int i = 0; i <= 1000000; i++) {
			sum = sum + i;
		}

		long time2 = System.nanoTime();

		System.out.println("1 ~ 1000000 : " + sum);
		System.out.println("소요시간 : " + (time2 - time1));
	}

}
