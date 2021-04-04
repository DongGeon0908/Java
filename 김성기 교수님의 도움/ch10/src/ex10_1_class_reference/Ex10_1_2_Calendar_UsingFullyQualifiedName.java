package ex10_1_class_reference;

/**
 * [ CalendarUsingFullyQualifiedName 클래스 ]: 
 *       정규화된 이름(fully qualified name)으로 클래스 참조할 때의 문제점 보이는 예제
 * 
 *   o 패키지에 포함되는 클래스 참조하기
 *     1) 정규화된 이름으로 패키지 멤버 참조: 패키지 멤버를 << 패키지이름.클래스이름 >>과 같이 패키지 이름과 클래스 이름을 
 *        도트로 연결시킨 정규화된 이름(fully qualified name)으로 표시하여 참조
 *     2) 패키지 멤버 import하고 클래스 이름으로 참조: 패키지 멤버를 정규화된 이름으로 import하고 
 *        클래스 이름만 표시하여 참조
 *     3) 패키지 전체 import하고 클래스 이름으로 참조: 패키지 멤버가 포함된 패키지 전체를 import하고 
 *        클래스 이름만 표시하여 참조
 *        
 *   o 정규화된 이름으로 패키지 멤버 참조    
 *     - 클래스가 참조될 때마다 패키지이름.클래스이름 형식으로 클래스 표시
 *     - java.util 패키지의 Date 클래스 ==> java.util.Date
 *     - java.util 패키지의 Calendar 클래스 ==> java.util.Calendar   
 *    
 *     - 정규화된 이름을 사용하면 개별 클래스나  패키지의 클래스 전체를 import할 필요가 없음    
 *    
 *     - 한 패키지 멤버가 여러 번 참조되면 정규화된 이름이 반복적으로 사용되므로 
 *       프로그램 작성도 번거롭고 간결하지 못함    
 *    
 *   o Date와 Calendar 클래스 이용하여 현재 날짜와 시간 출력
 *     - java.util 패키지의 Date 클래스와 Calendar 클래스는 날짜와 시간 다루기 위한 클래스
 *     - 날짜와 시간 다루기 위해 Calendar 클래스가 Date 클래스보다 더 많은 메소드 제공
 *     - 최근에는 Date 클래스는 사용하지 않은 추세
 */

class Ex10_1_2_Calendar_UsingFullyQualifiedName  {  
	public static void main(String[] args) {

		// Calendar 클래스는 java.util의 멤버임
		// Calendar 클래스의 객체는 getInstance() 메소드를 이용하여 생성함
		java.util.Calendar now = java.util.Calendar.getInstance();  // Calendar 객체 생성하여 now에 저장

		System.out.println("\n  * 현재 날짜와 시간: "
				+ now.get(java.util.Calendar.YEAR) + "년 " 
				+ (now.get(java.util.Calendar.MONTH) + 1) + "월 " // 저장된 월은 실제 월보다 1 작은 값임
				+ now.get(java.util.Calendar.DATE) + "일 " 
				+ now.get(java.util.Calendar.HOUR_OF_DAY) + "시 " 
				+ now.get(java.util.Calendar.MINUTE) + "분 "
				+ now.get(java.util.Calendar.SECOND) + "초 " );
	}
}


/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 Calendar 객체를 생성하여 now에 저장한 후 now의 년도, 월, 일, 시, 분, 초를 출력한다.
 *   
 *      o java.util.Calendar는 Calendar 클래스가 java.util 패키지의 클래스임을 나타내는 정규화된 이름 
 *      
 *      o << java.util.Calendar.getInstance(); >>에서는 Calendar 클래스의 객체를 생성하고 
 *         현재 날짜와 시간을 객체 내부에 저장
 *         
 *      o << java.util.Calendar now = java.util.Calendar.getInstance(); >>에서는 
 *         생성된 Calendar 클래스의 객체를 객체 참조변수 now에 저장
 *         
 *   2) System.out.println() 메소드에서 Calendar 객체 내에 
 *      저장된 년도, 월, 일, 시, 분, 초를 get() 메소드로 구하여 출력한다.
 *      
 *   3) Calendar 클래스가 모두 8번 참조되어 java.util.Calendar가 반복적으로 표시되어졌다. 
 *      그 결과 프로그램이 간결하지 못함
 *      
 *      ==> 예제 10-1-3에서 import 문을 이용하여 클래스의 패키지 이름을 생략할 수 있게 함
 *      
  *  4) 프로그램을 실행하여 출력 결과를 확인하라.
 *      수행할 때마다 시, 분, 초가 변화됨을 반드시 확인하라. 
 *      
 *   
 * [ 실습 과제 ]
 * 
 *   1) 대한민국의 광복절 날짜와 시간인 1945년 8월 15일 오후 12시 0분 0초를 저장하고 이를 출력하려 한다.
 *   
 *      o Calendar 클래스의 객체에 날짜와 시간을 저장하기 위한 메소드는 set()
 *      
 *        - 다음의 set() 메소드는  Calendar 객체  now에 월과 일을 8과 15로 저장     
 *           now.set(java.util.Calendar.MONTH, 8-1); // 월은 실제 월보다 1 작은 값을 저장
 *           now.set(java.util.Calendar.DATE, 15);   // 일은 실제 일의 값을 저장
 *        
 *        - 월, 일뿐 아니라 년, 시, 분, 초도 set() 메소드를 이용하여 저장 가능
 *      
 *      o Calendar 클래스의 객체에서 날짜와 시간을 가져오기 위한 메소드는 get()
 *      
 *        - 다음의 get() 메소드는  Calendar 객체  now에 저장된 월과 일을 가져옴
 *           int month = now.get(java.util.Calendar.MONTH); // 월은 실제 월보다 1 작은 값이 저장되어 있음
 *           int date = now.get(java.util.Calendar.DATE);   // 일은 실제 일의 값을 저장
 *                  
 *        -  월, 일뿐 아니라 년, 시, 분, 초도 get() 메소드를 이용하여 가져올 수 있음
 *      
 *      (1) 광복절 날짜와 시간을 저장하기 위한 Calendar 객체를 생성하고 
 *         이를 Calendar 객체참조변수 independenceDate에 저장하라.
 *          
 *      (2) independenceDate에 독립 날짜와 독립 시간을 저장한 후 이를 출력하는 코드를 추가로 작성하라. 
 *      
 *     
 *   2) java.util 패키지에는 난수(random number)를 생성할 수 있는 Random 클래스가  있다.
 *   
 *      Random 클래스의 Random()은 객체 생성자이며, 객체 메소드 double nextDouble()은 
 *      0과 1 사이의 실수 난수를 반환하는 메소드이다.
 *       
 *      (1) Random 클래스의 객체를 생성하여 객체참조변수 rd에 저장하는 문장을 작성하라.
 *        
 *      (2) for 문을 이용하여 rd 객체에서 20개의 0과 1 사이의 난수를 생성하여 출력하는 코드를 작성하라.      
 */