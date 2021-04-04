package ex7_6_3_salesman_abstract_class;

/** 
 *  �� ��Ű���� Ŭ������ ���� �ּ��� �ǵ������� �ּ��� �ۼ��Ǿ���
 * 
 *  ���α׷��� ���캸�鼭 abstract Ŭ������ abstract �޼ҵ忡 ����
 *  �����ϵ��� ����� �� 
 * 
 */

abstract class Salesman { 
    String name; int  age; String  addr; String hiredDate; int totalSale;

    Salesman(String name, int age, String  addr, String hiredDate) {
         this.name = name;  this.age = age;    this.addr = addr; 
         this.hiredDate = hiredDate;
    }

    abstract int getSalary();  // abstract �޼ҵ�� ���� Ŭ�������� �ݵ�� �����ؾ� ��


    void sale(int amount) {    // �ǸŸ� �ϸ� �� �Ǹž��� ������Ű�� �޼ҵ�
         totalSale += amount;
    }

    public String toString() {  
         return "�̸�: " + name + ", ����: " + age + ", �Ի���: " + hiredDate
		   + ", �Ǹ��Ѿ�: " + totalSale + ", ����: " + getSalary();
    }
    
    void output(String msg) {
         System.out.print(msg + this.toString());
    }
}

    
class RegularSalesman extends Salesman { 
	
	// ����, ����, ���� ���ʽ���, ���� ������ �����ϴ� �ʵ�
    String position; int  basicPay; int  bonus; int  extraPay;;
    
    RegularSalesman(String name, int age, String  addr, String hiredDate, 
                                   String position, int basicPay, int  bonus, int extraPay) {
        super(name, age, addr, hiredDate); 
        this.position = position; this.basicPay = basicPay; this.bonus = bonus; 
        this.extraPay = extraPay;
    }
    
    int getSalary() {      // abstract �޼ҵ� ����
        return (basicPay + bonus + extraPay) / 12;
    } 

    public String toString() {  
         return super.toString() + ", ����: " + position + ", ����: " + basicPay + ", ���� ���ʽ�: " + bonus
                                            + ", ���� ����: "+extraPay;
    }
    
    void output(String msg) {
            System.out.print(msg + this.toString());
    }
}

class ParttimeSalesman extends Salesman { 
	
	// �ð��� �ӱ�, �ٹ��ð��� �����ϴ� �ʵ�
    int  payPerHour; int  workingHours;
    
    ParttimeSalesman (String name, int age, String  addr, String hiredDate, 
                                                                    int payPerHour, int  workingHours) {
        super(name, age, addr, hiredDate); 
        this.payPerHour = payPerHour; this.workingHours = workingHours;
    }
    
    int getSalary() {     // abstract �޼ҵ� ����
        return payPerHour * workingHours;
    } 
    
    public String toString() {  
        return super.toString() + ", �ð��� �ӱ�: " + payPerHour+", �ٹ��ð�: " + workingHours;
    }
    
    void output(String msg) {
        System.out.print(msg + this.toString());
    }
}

class Ex7_6_3_SalesmanMgmt { 		 
    public static void main(String[] args) {
        Salesman s1 = new RegularSalesman("ȫ�浿", 29, "Seoul", "2010.3.2",  "�Ǹ�����", 35500000, 12000000, 5000000);

        s1.sale(520000);   
        s1.sale(7340000);   
        s1.sale(2834000);   
        
        s1.output ("\n  * ȫ�浿 �Ǹſ� - ");			
		
        Salesman s2 = new ParttimeSalesman("��û", 21, "Soowon", "2015.11.3",   8000, 200);
        
        s2.sale(1230000);   
        s2.sale(4391000);  
        s2.sale(5348000);  
        
        s2.output("\n\n  * ��û �Ǹſ� - ");		   
    }
}
