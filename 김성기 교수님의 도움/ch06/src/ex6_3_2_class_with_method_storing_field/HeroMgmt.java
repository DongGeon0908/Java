// ������ Ŭ�������� ex6_3_2_class_with_method_storing_field ��Ű���� ���ԵǴ� Ŭ�������� ��Ÿ��
package ex6_3_2_class_with_method_storing_field;

/**
 * [ Hero, HeroMgmt Ŭ���� ] :
 *       ȫ�浿�� �߿��� ȫ�浿�� 8�� ���� ��Ȳ�� ��Ÿ���� Java ���α׷�
 * 
 *   o Ŭ���� ���� 2: �ʵ� �� ���� �޼ҵ� ���� Ŭ����
 *     - �ʵ� �� ���� �޼ҵ�� �ʵ� �� �ʱ�ȭ �޼ҵ�� setter �޼ҵ尡 ����
 *     - ��ü ���� �� �ʵ� �� ���� �޼ҵ带 �̿��Ͽ� ���ϰ� �ʵ� �� ���� 
 *     
 *   o �ʵ� �ʱ�ȭ �޼ҵ�
 *     - ��ü ���� ���� �Ű������� �־����� ������ �ʵ� ����� �����ϴ� �޼ҵ�
 *     - initialize �Ǵ� initializePerson  �� �ʱ�ȭ ��Ÿ���� �޼ҵ� �̸� ���
 *     - �� Ŭ�������� ���� �ʵ� �ʱ�ȭ �޼ҵ� �ۼ� ����
 *   
 *   o setter �޼ҵ�
 *     - �Ű������� �־����� �ϳ��� ���� �ʵ� ������ �����ϴ� �޼ҵ�
 *     - setName, setAge ��� ���� �� set+�ʵ�� ���� �޼ҵ� �̸� ���
 *     - ����, setter �޼ҵ��� �ݴ� ����� �ʵ� �� ��ȯ�ϴ� getter �޼ҵ嵵 ����
 *     - ��� �ʵ忡 ���� setter �޼ҵ� �ۼ��� �� �� ������, Ư�� �ʵ忡 ���ؼ���
 *       setter �޼ҵ� �ۼ��� ���� ����
 */

class Hero {
   String 	name;    	// �̸��� ������ �ʵ�
   int    	age;		// ���̸� ������ �ʵ�
   String 	gender; 	// ������ ������ �ʵ�
   String 	novel; 		// ���ΰ��� �Ҽ��� ������ �ʵ�

   void initializeHero(String name, int age, String gender, String novel) {
      this.name = name; this.age = age; this.gender = gender;
      this.novel = novel;
   }
}

class HeroMgmt {
  public static void main(String[] args) {

     Hero  h = new Hero();
     h.initializeHero("ȫ�浿", 8, "����", "ȫ�浿��");

     System.out.println("\n  * Hero ��ü: �̸�=" + h.name + ", ����=" + h.age
                               + ", ����=" + h.gender + ", �Ҽ�=" + h.novel);
   }
}

