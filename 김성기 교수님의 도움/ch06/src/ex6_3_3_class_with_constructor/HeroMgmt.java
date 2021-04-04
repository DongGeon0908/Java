// 여기의 클래스들은 ex6_3_3_class_with_constructor 패키지에 포함되는 클래스임을 나타냄
package ex6_3_3_class_with_constructor;

/**
 * [ Hero, HeroMgmt 클래스 ] 
 *       홍길동전 중에서 홍길동의 8세 때 상황을 나타내는 Java 프로그램
 * 
 *   o 클래스 유형 3: 객체 생성자 갖는 클래스
 *     - 클래스는 객체 생성자 가지며, setter 메소드 있음
 *     - 객체 생성자: 객체를 생성하면서 수행되는 특별한 메소드
 *     - 객체 생성과 객체 필드 값 저장이 한 문장으로 이루어지므로 프로그램이 간결해짐 
 */

class Hero {
   String 	name;    	     	// 이름을 저장할 필드
   int    	age;		     	// 나이를 저장할 필드
   String 	gender; 			// 성별을 저장할 필드
   String 	novel; 				// 주인공인 소설을 저장할 필드

   Hero(String name, int age, String gender, String novel) {
      this.name = name; this.age = age; this.gender = gender;
      this.novel = novel;
   }
}

class HeroMgmt {
  public static void main(String[] args) {

     Hero  h = new Hero("홍길동", 8, "남자", "홍길동전");

     System.out.println("\n  * Hero 객체: 이름=" + h.name + ", 나이=" + h.age
                               + ", 성별=" + h.gender + ", 소설=" + h.novel);
   }
}
