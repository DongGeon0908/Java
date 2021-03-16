### 📒Contents

- 중첩 클래스에서 바깥 클래스 참조 얻기
    + 클래스 내부에서 `this`는 객체 자신의 참조
    + 중첩 클래스에서 `this` 키워드를 사용하면 바깥 클래스의 객체 참조가 아님
        * 중첩 클래스의 객체 참조
```
public class Outter {
    String field = "Outter-field";
    void method(){
        System.out.println("Outter-method");
    }

    class Nested {
        String field = "Nested-field";
        void method(){
            System.out.println("Nested-method");
        }
        void print(){
            // 중첩 객체 참조
            System.out.println(this.field);
            this.method();

            // 바깥 객체 참조
            System.out.println(Outter.this.field);
            Outter.this.method();
        }
    }
}
```

- 중첩 인터페이스
    + 클래스의 멤버로 선언된 인터페이스
        * 해당 클래스와 긴밀한 관계를 맺는 구현 클래스를 만들기 위함

- 익명 객체
    + 이름이 없는 객체
    + 단독 생성 불가능
        * 클래스를 상속하거나 인터페이스를 구현해야만 생성할 수 있음
    + 필드의 초기값, 로컬 변수의 초기값, 매개 변수의 매개값으로 주로 대입
```
class A {
    Parent field = new Parent(){
        int childField;
        void childMethod(){}
        @Override
        void parentMethod(){}
    };
}
```

- 익명 구현 객체 생성
    + 구현 클래스가 재사용되지 않고, 오로지 해당 필드와 변수의 초기값으로만 사용하는 경우에 활용
    + 익명 객체 내부에서는 바깥 클래스의 필드나 메소드는 제한 없이 사용 가능
        * 메소드의 매개 변수나 로컬 변수를 익명 객체서 사용
        * 메모리상 문제 발생 -> `final`로 해결 가능