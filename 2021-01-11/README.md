# 📋2021-01-11📋
> 연산자와 연산식

<br>

### ©CopyRight

> Donggeon Kim

> Department of Computer Engineering, Hanshin University

<br>

### 📒Contents

- 흐름 제어문 == 제어문
    + 실행 흐름을 개발자가 원하는 방향으로 바꿀 수 있도록 해주는 것
    + 조건식과 중괄호 `{}` 블록으로 구성
    + 조건식의 연산 결과에 따라 블록 내부의 실행 여부 결정
    + 조건문   
        * `if, switch`
    + 반목문
        * `for, while, do-while`
    + 루핑(looping)
        * 제어문 처음으로 다시 되돌아가 반복 실행
    + 제어문 내부에 제어문 가능
- `if`
    + 조건식의 결과에 따라 블록 실행 여부 결정
    + 조건식
        * `true of false`, `boolean`
- `if-else`
    + `true`
        * `if` 블록 실행
    + `false`
        * `else` 블록 실행
- `if-else if-else`
    + `else-if`문의 수는 제한이 없음
    + 여러개의 조건식 중 `ture`가 되는 블록만 실행
```
public class Main {
	public static void main(String[] args) {
		int num = (int) (Math.random() * 6) + 1;

		if (num == 1) {
			System.out.println("1번");
		} else if (num == 2) {
			System.out.println("2번");
		} else if (num == 3) {
			System.out.println("3번");
		} else if (num == 4) {
			System.out.println("4번");
		} else if (num == 5) {
			System.out.println("5번");
		} else {
			System.out.println("6번");
		}

	}
}
```
- 중첩 if문
    + if문의 블록 내부에는 또 다른 if문 사용 가능
- `switch`
    + 변수가 어떤 값을 갖느냐에 따라 실행문이 선택
- 정수형 `switch`
```
public class Main {
	public static void main(String[] args) {
		int num = (int) (Math.random() * 6) + 1;

		switch (num) {
		case 1:
			System.out.println("1");
			break;
		case 2:
			System.out.println("2");
			break;
		case 3:
			System.out.println("3");
			break;
		case 4:
			System.out.println("4");
			break;
		case 5:
			System.out.println("5");
			break;
		default:
			System.out.println("6");
			break;

		}

	}
}
```
- `char형 switch`
```
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String position = "과장";

		switch (position) {
		case "부장":
			System.out.println("700");
			break;
		case "과장":
			System.out.println("500");
			break;
		default:
			System.out.println("300");

		}
	}
}

```