package practice11;

/**
 * [ 11장 실습과제 6의 소스 프로그램 ]
 * 
 *   6. 배열 이용하는 프로그램을 Vector 이용하는 프로그램으로 변경
 *   
 *      다음의 배열을 이용하는 프로그램을 Vector를 이용하는 프로그램으로 변경하라.
 *      
 *      (배열에서 최대 저장 개수보다 많은 원소를 저장하면 예외가 발생하므로 예외 처리해야 하지만 
 *       Vector에서 예외 처리할 필요 없음)
 */
class Practice11_6 {
	public static void main(String[] args) {

		String[] names = new String[10];    // 원소 최대 10개를 저장할 배열변수

		int no = SkScanner.getInt("  o 저장할 이름의 개수 입력 > ");
		
		if ( no > 10)
			System.out.println("  ??? 저장할 수 있는 최대 개수는 10개임 "); 
		else {
			for (int i = 0; i < no; i++) {
				String name = SkScanner.getString("  o "+(i+1)+"번째 이름 > ");
				names[i] = name;
			}

			System.out.println("  * 저장된 " + no + "개 이름: ");  
			
			for ( String name : names)
				System.out.println(name + " "); 
		}  
	}
}