package ex10_1_class_reference;

/**
 * [ DateUsingFullyQualifiedName 클래스  ]: 
 *       정규화된 이름(fully qualified name)으로 클래스 참조
 * 
 *   o 패키지에 포함되는 클래스 참조하기
 *     1) 정규화된 이름으로 패키지 멤버 참조: 패키지 멤버를 << 패키지이름.클래스이름 >>과 같이 
 *        패키지 이름과 클래스 이름을 도트로 연결시킨 정규화된 이름(fully qualified name)으로 표시하여 참조
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
 *     - 한 패키지 멤버가 여러 번 참조되면 정규화된 이름이 반복적으로 사용되므로 
 *       프로그램 작성도 번거롭고 간결하지 못함  
 */

class Ex10_1_1_Date_UsingFullyQualifiedName {
   public static void main(String[] args) {

      // java.util은 Date 클래스의 패키지이므로 java.util.Date는 정규화된 이름임
      java.util.Date now = new java.util.Date();  	
      System.out.println("\n  * 현재 날짜와 시간: " + now);
      
      
      // 이 부분에 실습과제 1)을 수행하는 프로그램 부분을 작성하라.
            
      // 이 부분에 실습과제 2)을 수행하는 프로그램 부분을 작성하라.  
   }
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 Date 클래스의 객체를 생성하여 now에 저장한 후 now를 출력한다.
 *      o java.util.Date는 Date 클래스가 java.util 패키지의 클래스임을 나타내는 정규화된 이름임
 *      
 *      o << new java.util.Date(); >>에서는 Date 클래스의 객체를 생성하고 
 *        현재 날짜와 시간을 객체 내부에 저장함
 *         
 *      o << java.util.Date now = new java.util.Date(); >>에서는 
 *        생성된 Date 클래스의 객체를 객체 참조변수 now에 저장함
 *         
 *      o System.out.println() 메소드에서 Date 클래스의 객체를 출력하면 
 *        객체에 저장된 날짜와 시간이 출력됨
 *         
 *      o 출력 양식은  << 영어 요일, 영어 월 이름, 일, 시, 분, 초, 표준시, 년도 >>임
 *      
 *   2) 프로그램을 실행하여 출력 결과를 확인하라.
 *      수행할 때마다 시, 분, 초가 변화됨을 반드시 확인하라. 
 *  
 *   
 * [ 실습과제 ]
 *   
 *   1) java.util 패키지에는 Random 클래스가 있으며, 이 클래스의 객체 생성하여 난수를 출력하는 코드는 다음과 같다.
 *   
 *         java.util.Random r = new java.util.Random();   
 *         System.out.println("\n  * r = " + r.nextDouble());
 *       
 *       main() 메소드에 코드를 추가로 작성하여 실행하고 결과 확인하라.
 *       
 *   2) 다음의 패키지에 클래스가 정의되어 있다. 각 클래스의 정규화된 이름을 구하라.
 *      또한 이들 클래스의 객체를 생성하여 객체 참조변수에 저장하고 그 객체를 출력하는 코드를 작성하라.
 *      (객체 생성은 모두 매개변수 없는 객체 생성자 이용하며, 모든 객체는 System.out.println() 
 *       메소드에서 출력 가능 )
 *       
 *      (1) java.util 패키지의 Vector 클래스
 *      (2) java.awt 패키지의 Button 클래스
 *      (3) java.text 패키지의 SimpleDateFormat 클래스
 */
