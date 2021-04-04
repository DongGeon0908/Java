package exercise07;

/**
 * [ 7�� ��������  10]:
 *   
 *   10. ���� Ŭ���� SubC�� ������ ���� �ۼ��Ǿ���. 
 *   
 *     1) SubC Ŭ������ main() �޼ҵ带 �����Ͽ� SuperC Ŭ������ �ۼ��϶�.
 *     
 *     2) �ۼ��� SuperC Ŭ������ �̹� �ۼ��� SubC Ŭ������ ���� main()�� ����� ���϶�.
 */

class SuperC {
	// SubC Ŭ������ main() �޼ҵ带 �����Ͽ� SuperC Ŭ������ �ۼ��϶�.
}

class SubC extends SuperC {
	int f3, f4; 
	
	SubC(double f1, double f2, int f3, int f4) {
		super(f1, f2);
		this.f3 = f3; this.f4 = f4;
	}
	
	double getSum() {
		return super.getSum() + f3 + f4;
	}

	double getLast() {
		return f4;
	}
}


class Exercise7_10_SuperSub {

	public static void main(String[] args) {
		SuperC o = new SubC(1.0, 2.0, 3, 4);

		System.out.println("\n  * first field: " + o.getFirst() + ", last field: " 
				+ o.getLast() + ", ��: " + o.getSum() );
	}
}