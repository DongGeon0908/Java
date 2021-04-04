// ������ Ŭ�������� ex6_3_3_class_with_constructor ��Ű���� ���ԵǴ� Ŭ�������� ��Ÿ��
package ex6_3_3_class_with_constructor;

/**
 * [ Hero, HeroMgmt Ŭ���� ] 
 *       ȫ�浿�� �߿��� ȫ�浿�� 8�� �� ��Ȳ�� ��Ÿ���� Java ���α׷�
 * 
 *   o Ŭ���� ���� 3: ��ü ������ ���� Ŭ����
 *     - Ŭ������ ��ü ������ ������, setter �޼ҵ� ����
 *     - ��ü ������: ��ü�� �����ϸ鼭 ����Ǵ� Ư���� �޼ҵ�
 *     - ��ü ������ ��ü �ʵ� �� ������ �� �������� �̷�����Ƿ� ���α׷��� �������� 
 */

class Hero {
   String 	name;    	     	// �̸��� ������ �ʵ�
   int    	age;		     	// ���̸� ������ �ʵ�
   String 	gender; 			// ������ ������ �ʵ�
   String 	novel; 				// ���ΰ��� �Ҽ��� ������ �ʵ�

   Hero(String name, int age, String gender, String novel) {
      this.name = name; this.age = age; this.gender = gender;
      this.novel = novel;
   }
}

class HeroMgmt {
  public static void main(String[] args) {

     Hero  h = new Hero("ȫ�浿", 8, "����", "ȫ�浿��");

     System.out.println("\n  * Hero ��ü: �̸�=" + h.name + ", ����=" + h.age
                               + ", ����=" + h.gender + ", �Ҽ�=" + h.novel);
   }
}
