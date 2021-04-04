// 여기의 클래스들은 ex6_3_2_class_with_method_storing_field 패키지에 포함되는 클래스임을 나타냄
package ex6_3_2_class_with_method_storing_field;

/**
 * [ Hero, HeroMgmt 클래스 ] :
 *       홍길동전 중에서 홍길동의 8세 때의 상황을 나타내는 Java 프로그램
 * 
 *   o 클래스 유형 2: 필드 값 저장 메소드 갖는 클래스
 *     - 필드 값 저장 메소드는 필드 값 초기화 메소드와 setter 메소드가 있음
 *     - 객체 생성 후 필드 값 저장 메소드를 이용하여 편리하게 필드 값 저장 
 *     
 *   o 필드 초기화 메소드
 *     - 객체 생성 직후 매개변수로 주어지는 값들을 필드 값들로 저장하는 메소드
 *     - initialize 또는 initializePerson  등 초기화 나타내는 메소드 이름 사용
 *     - 한 클래스에서 여러 필드 초기화 메소드 작성 가능
 *   
 *   o setter 메소드
 *     - 매개변수로 주어지는 하나의 값을 필드 값으로 저장하는 메소드
 *     - setName, setAge 등과 같이 ≪ set+필드명 ≫의 메소드 이름 사용
 *     - 한편, setter 메소드의 반대 기능인 필드 값 반환하는 getter 메소드도 있음
 *     - 모든 필드에 대해 setter 메소드 작성할 수 도 있으며, 특정 필드에 대해서만
 *       setter 메소드 작성할 수도 있음
 */

class Hero {
   String 	name;    	// 이름을 저장할 필드
   int    	age;		// 나이를 저장할 필드
   String 	gender; 	// 성별을 저장할 필드
   String 	novel; 		// 주인공인 소설을 저장할 필드

   void initializeHero(String name, int age, String gender, String novel) {
      this.name = name; this.age = age; this.gender = gender;
      this.novel = novel;
   }
}

class HeroMgmt {
  public static void main(String[] args) {

     Hero  h = new Hero();
     h.initializeHero("홍길동", 8, "남자", "홍길동전");

     System.out.println("\n  * Hero 객체: 이름=" + h.name + ", 나이=" + h.age
                               + ", 성별=" + h.gender + ", 소설=" + h.novel);
   }
}

