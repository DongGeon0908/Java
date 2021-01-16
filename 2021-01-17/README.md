# 📋2021-01-17📋
> 참조 타입

<br>

### ©CopyRight

> Donggeon Kim

> Department of Computer Engineering, Hanshin University

<br>

### 📒Contents

- 배열은 한번 생성하면 크기를 변경할 수 없음

- 배열 생성
	+ `new` 연산자로 배열을 생성할 경우, 배열은 자동적으로 기본값으로 초기화
	+ 기본 값은 데이터 타입별로 다름
```
타입[] 변수 = null;
변수 = new 타입[길이];
```

- 배열의 길이
```
배열변수.length;
```

- 배열 예제
```
public class ArrayExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scores = { 83, 90, 87 };

		int sum = 0;

		for (int i = 0; i < scores.length; i++) {
			sum = sum + scores[i];
		}''
		System.out.println(sum);
	}

}

```

- 커맨드 라인 입력
	+ `String[] args`를 쓰는 이유
		* `main()` 메소드는 `String[] args` 매개 변수를 통해서 커맨드 라인에서 입력된 데이터의 수(배열의 길이)와 입력된 데이터(배열의 항목 값)을 알 수 있게 됨

- `main()` 메소드의 매개 변수 예제
```
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length != 2) {
			System.out.println("프로그램의 사용법");
			System.out.println("java MainStringArrayArgument num1 num2");
			System.exit(1); // 프로그램의 강제 종료
		}

		String strNum1 = args[0];
		String strNum2 = args[1];

		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);

		int result = num1 + num2;
		System.out.println(num1 + " + " + num2 + " = " + result);
	}
}
```

- 문자열을 정수형으로
```
String tmp = "60";
int cnp = Integer.parseInt(tmp);
```

- 2차원 배열
	+ 2차원 배열의 경우에는 int[0]안에 int[0]의 배열과 int[1] 배열을 참조.
	+ 해당 배열은 힙 영역에 생성되며 스택영역을 통해 사용
```
int[][] data = new int[1][2];
```

- 배열 속의 배열 예제
```
public class ArrayInArrayExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mathScores = new int[2][3];
		for (int i = 0; i < mathScores.length; i++) {
			for (int j = 0; j < mathScores[i].length; j++) {
				System.out.println("mathScores[" + i + "][" + j + "] = " + mathScores[i][j]);
			}
		}
		System.out.println();
		int[][] englishScores = new int[2][];
		englishScores[0] = new int[2];
		englishScores[1] = new int[3];
		for (int i = 0; i < englishScores.length; i++) {
			for (int j = 0; j < englishScores[i].length; j++) {
				System.out.println("englishScores[" + i + "][" + j + "]=" + englishScores[i][j]);
			}
		}
		System.out.println();

		int[][] javaScores = { { 95, 80 }, { 92, 96, 80 } };
		for (int i = 0; i < javaScores.length; i++) {
			for (int j = 0; j < javaScores[i].length; j++) {
				System.out.println("javaScores[" + i + "][" + j + "] = " + javaScores[i][j]);
			}
		}
	}
}
```

- `String`이 `==`으로 값을 비교하면 않되는 이유
	+ `String`은 객체를 참조해서 사용하는데 데이터의 값이 같더라도 참조하는 주소가 다른 경우에 `==` 연산은 `false` 값을 가짐
	+ `equals()`은 값이 같은지 검사하는게 아니라 내용이 같은지 검사하는 메서드
	```
	String tmp = "hello";
	String cnp = "hello";

	tmp.equals(cnp); // true
	```

- 반복문을 활용한 배열 복사 예제
```
public class ArrayCopyExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] oldIntArray = { 1, 2, 3 };
		int[] newIntArray = new int[5];

		for (int i = 0; i < oldIntArray.length; i++) {
			newIntArray[i] = oldIntArray[i];
		}

		for (int i = 0; i < newIntArray.length; i++) {
			System.out.println(newIntArray[i]);
		}
	}
}
```

- `System.arraycopy()`를 이용한 배열 복사 예제
```
public class ArrayCopyExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] oldIntArray = { 1, 2, 3 };
		int[] newIntArray = new int[5];

		System.arraycopy(oldIntArray, 0, newIntArray, 0, oldIntArray.length);
		
		for (int i = 0; i < newIntArray.length; i++) {
			System.out.println(newIntArray[i]);
		}
	}
}
```

- 얕은 복사 `shallow copy`
	+ 참조 타입 매열일 경우, 배열 복사가 되면 복사되는 값이 객체의 번지
	+ 새 배열의 항목은 이전 배열의 항목이 참조하는 객체와 동일

- 깊은 복사 `deep copy`
	+ 참조하는 개체도 별도로 생성

- 향상된 for문
```
int[] oldIntArray = { 1, 2, 3 };
for(int tmp : oldIntArray){
	System.out.println(tmp);
}
```

- 열거 타입 `enumeration type`
	+ 한정된 값만을 갖는 데이터 타입
	+ 몇 개의 열거 상수 `enumeration constant` 중에서 하나의 상수를 저장하는 데이터 타입
	+ `name()`
		* 열거 객체가 가지고 있는 문자열을 리턴
		* 리턴되는 문자열은 열거 타입을 정의할 떄 사용한 상수 이름과 동일
	+ `ordinal()`
		* 전체 열거 객체 중 몇 번째 열거 객체인지 알려줌
		* 열거 객체의 순번은 열거 타입을 정의할 때 주어진 순번
	+ `compareTo()`
		* 매개값으로 주어진 열거 객체를 기준으로 전후로 몇 번째 위치하는 비교
		* 열거 객체가 매개값의 열거 객체보다 순번이 빠르면 음수
		* 열거 객체가 매개값의 열거 객체보다 순번이 느리면 양수
	+ `valueOf()`
		* 매개값으로 주어진 문자열과 동일한 문자열을 가진 열거 객체 리턴
	+ `values()`
		* 열거 타입의 모든 열거 객체들을 배열로 만들어 리턴`
