package ex7_6_3_salesman_abstract_class;

/** 
 *  이 패키지의 클래스에 대한 주석은 의도적으로 최소한 작성되었음
 * 
 *  프로그램을 살펴보면서 abstract 클래스와 abstract 메소드에 대해
 *  이해하도록 노력할 것 
 * 
 */

abstract class Salesman { 
    String name; int  age; String  addr; String hiredDate; int totalSale;

    Salesman(String name, int age, String  addr, String hiredDate) {
         this.name = name;  this.age = age;    this.addr = addr; 
         this.hiredDate = hiredDate;
    }

    abstract int getSalary();  // abstract 메소드로 하위 클래스에서 반드시 구현해야 함


    void sale(int amount) {    // 판매를 하면 총 판매액을 증가시키는 메소드
         totalSale += amount;
    }

    public String toString() {  
         return "이름: " + name + ", 나이: " + age + ", 입사일: " + hiredDate
		   + ", 판매총액: " + totalSale + ", 월급: " + getSalary();
    }
    
    void output(String msg) {
         System.out.print(msg + this.toString());
    }
}

    
class RegularSalesman extends Salesman { 
	
	// 직위, 연봉, 연간 보너스액, 연간 수당을 저장하는 필드
    String position; int  basicPay; int  bonus; int  extraPay;;
    
    RegularSalesman(String name, int age, String  addr, String hiredDate, 
                                   String position, int basicPay, int  bonus, int extraPay) {
        super(name, age, addr, hiredDate); 
        this.position = position; this.basicPay = basicPay; this.bonus = bonus; 
        this.extraPay = extraPay;
    }
    
    int getSalary() {      // abstract 메소드 구현
        return (basicPay + bonus + extraPay) / 12;
    } 

    public String toString() {  
         return super.toString() + ", 직위: " + position + ", 연봉: " + basicPay + ", 연간 보너스: " + bonus
                                            + ", 연간 수당: "+extraPay;
    }
    
    void output(String msg) {
            System.out.print(msg + this.toString());
    }
}

class ParttimeSalesman extends Salesman { 
	
	// 시간당 임금, 근무시간을 저장하는 필드
    int  payPerHour; int  workingHours;
    
    ParttimeSalesman (String name, int age, String  addr, String hiredDate, 
                                                                    int payPerHour, int  workingHours) {
        super(name, age, addr, hiredDate); 
        this.payPerHour = payPerHour; this.workingHours = workingHours;
    }
    
    int getSalary() {     // abstract 메소드 구현
        return payPerHour * workingHours;
    } 
    
    public String toString() {  
        return super.toString() + ", 시간당 임금: " + payPerHour+", 근무시간: " + workingHours;
    }
    
    void output(String msg) {
        System.out.print(msg + this.toString());
    }
}

class Ex7_6_3_SalesmanMgmt { 		 
    public static void main(String[] args) {
        Salesman s1 = new RegularSalesman("홍길동", 29, "Seoul", "2010.3.2",  "판매팀장", 35500000, 12000000, 5000000);

        s1.sale(520000);   
        s1.sale(7340000);   
        s1.sale(2834000);   
        
        s1.output ("\n  * 홍길동 판매원 - ");			
		
        Salesman s2 = new ParttimeSalesman("심청", 21, "Soowon", "2015.11.3",   8000, 200);
        
        s2.sale(1230000);   
        s2.sale(4391000);  
        s2.sale(5348000);  
        
        s2.output("\n\n  * 심청 판매원 - ");		   
    }
}
