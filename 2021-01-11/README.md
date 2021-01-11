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
- `정수형 switch`
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

- 반목문
    + `for, while, do-while`
    + 어떤 작업이 반복적으로 실행되도록 할 때 사용
    + `for`
        * 반복 횟수를 알고 있을 때
    + `while`
        * 조건에 따라 반복할 때
    + `do-while`
        * 조건을 먼저 검사할 때

- `for`
    + 주어진 횟수만큼 실행문을 반복 실행할 때 적합한 반복 제어문
```
public class Main {
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println("김동건은 천재이다.");
		}
	}
}
```

- `while`
    + 조건식이 `true`일 경우에 계속 반복
    + 조건식이 `false`인 경우 반복 행위 멈추고 종료됨
    + `break`를 통해 반복 종료 가능
```
public class Main {
	public static void main(String[] args) {
		int i = 1;
		while (i <= 10) {
			System.out.println(i);
			i++;
		}
	}
}
```

- `while` 키보드 제어
```
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		boolean run = true;
		int speed = 0;
		int keyCode = 0;

		while (run) {
			if (keyCode != 13 && keyCode != 10) {
				System.out.println("1.증속 | 2.감속 | 3.중지");
				System.out.println("선택");
			}
			keyCode = System.in.read();

			if (keyCode == 49) {
				speed++;
				System.out.println("현재 속도 = " + speed);
			} else if (keyCode == 50) {
				speed--;
				System.out.println("현재 속도 = " + speed);
			} else if (keyCode == 51) {
				run = false;
			}
		}
		System.out.println("종료");
	}
}
```
- `do-while`
    + 블록 내부의 실행문을 우선 실행시키고 실행 결과에 따라서 반복 실행을 계속할지 결정
```
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("입력");
		System.out.println("종료시 q");

		Scanner scan = new Scanner(System.in);
		String inputString;

		do {
			System.out.print(">");
			inputString = scan.nextLine();
			System.out.println(inputString);
		} while (!inputString.equals("q"));

		System.out.println("프로그램 종료");
	}
}
```

- `break`
    + `for, while, do-while`
    + `switch`

- `break 이름;`
    + 중첩된 반복문에서 해당 이름이 있는 반복문을 멈춤
```
public class Main {
	public static void main(String[] args) {

		int check = 50;

		Outter: for (int i = 0; i < 100; i++) {
			System.out.println(i);
			check = check + i;
			if (check > 100) {
				break Outter;
			}
		}
	}
}
```

- `continue`
    + `for, while, do-while`
    + 특정 조건을 만족하는 경우, 그 이후의 문장을 실행하지 않고 다음 반복 진행
```
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			if (i % 2 != 0) {
				continue;
			}
			System.out.println(i);
		}
	}
}
```