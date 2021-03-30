### 📒Contents

- 자바 문자열
    + `java.lang` 패키지의 `String` 클래스의 인스턴스로 관리
        * 소스상에서 문자열 리터럴은 `String` 객체로 자동 생성
        * `String` 클래스의 다양한 생성자를 이용해서 직접 `String` 객체를 생성

- `String` 생성자
```
String str = new String(byte[] bytes);

String str = new String(byte[] bytes, String charsetName);

String str = new String(byte[] bytes, int offset, int length);

String str = new String(byte[] bytes, int offset, int length, String charsetName);
``` 

- 바이트 배열을 문자열로 변환
```
public class ByteToStringExample {
    public static void main(String[] args){
        byte[] bytes = {72, 101, 108, 108, 111, 32, 74, 97, 118, 97};

        String str1 = new String(bytes);
        System.out.println(str1);

        String str2 = new String(bytes, 6, 4);
        System.out.pritln(str2);
    }
}
```

- `charAt()`
    + 매개값으로 주어진 인덱스의 문자를 리턴

- `equals()`
    + `String` 객체의 문자열만을 비교

- `getBytes()`
    + 바이트 배열로 변환

- 시스템의 기본 문자셋으로 인코딩된 바이트 배열을 리턴
```
byte[] bytes = "문자열".getBytes();
byte[] bytes = "문자열".getBytes(Charset charset);
```

- 사용자가 문자셋을 정하고 바이트 배열 리턴
```
try{
    bytes[] bytes = "문자열".getBytes("EUC-KR");
    bytes[] bytes = "문자열".getBytes("UTF-8");
} catch (UnsupportedEncodingException e){}
```

- 시스템 기본 문자셋과 다른 문자셋으로 인코딩된 바이트 배열일 경우 `String` 생성자를 이용해서 디코딩
`String str = new String(byte[] bytes, String charsetName);`

- `indexOf()`
    + 매개값으로 주어진 문자열이 시작되는 인덱스를 리턴
    + 주어진 문자열이 포함되어 있지 않으면 -1을 리턴
```
String sub = "자바 프로그래밍";
int index = sub.indexOf("프로그래밍");
```

- `length()`
    + 문자열 길이
``` 
String sub = "자바 프로그래밍";
int length = subject.length();
```

- `replace()`
    + 문자열 대치
    + 첫 번째 매개값인 문자열을 찾아 두 번째 매개값인 문자열로 대치한 `새로운 문자열`을 생성하고 리턴
```
String oldStr = "자바 프로그래밍";
String newStr = oldStr.replace("자바", "JAVA");
```

- `substring()`
    + 문자열 잘라내기
    + 주어진 인덱스에서 문자열을 추출
    + `substring(int beginIndex, int endIndex)` -> beginIndex ~ endIndex
    + `substring(int beginIndex)` -> beginIndex ~

- `toLowerCase(), toUpperCase()`
    + 알파벳 소,대문자 변경
    + `toLowerCase()`
        * 문자열을 모두 소문자로 바꿔 새로운 문자열 생성한 후 리턴
    + `toUpperCase()`
        * 문자열을 모두 대문자로 바꿔 새로운 문자열 생성한 후 리턴
```
String data = "kdiiiDsW";
String low = data.toLowerCase();
String up = data.toUpperCase();
```

- `trim()`
    + 문자열 앞뒤 공백을 제거한 새로운 문자열을 생성하고 리턴
```
String data = "kdi iiD s  W";
String str = data.trim();
```

- `valueOf()`
    + 기본 타입의 값을 문자열로 변환하는 기능
        * `valueOf(boolean b)`
        * `valueOf(char c)`
        * `valueOf(int i)`
        * `valueOf(long l)`
        * `valueOf(double d)`
        * `valueOf(float f)`

- `split()`
    + `String`에 속함
    + 정규 표현식으로 구분
```
String[] data = tmp.split("&|,|-");
```

- `StringTokenizer`
    + 문자로 구분
    + `java.util`에 속함

- 문자열을 결합하는 `+` 연산자를 많이 사용하면 할수록 그만큼 `String` 객체의 수가 늘어나서 프로그램의 성능이 느려짐
    + 내부 버퍼에 문자열을 저장해 두고, 그 안에서 추가, 수정, 삭제 작업을 진행하는 클래스 사용
    + 해당 클래스는 새로운 문자열을 만들지 않음
        * `StringBuffer`
            + 멀티 스레드 환경에서 사용할 수 있도록 동기화가 적용되어 있어 스레드에 안전
        * `StringBuilder`
            + 단일 스레드 환경에서만 사용하도록 설계
            + 초기 버퍼의 크기를 유동적으로 바꿀 수 있음

- 정규 표현식   
    + 문자 또는 숫자 기호와 반복 기호가 결합된 문자열
        * `[]` -> 한 개의 문자
        * `\d` -> 한 개의 숫자
        * `\s` -> 공백
        * `\w` -> 한 개의 알파벳 또는 한 개의 숫자
        * `?` -> 없음 또는 한 개
        * `*` -> 없음 또는 한 개 이상
        * `+` -> 한 개 이상
        * `{n}` -> 정확히 n개
        * `{n.}` -> 최소한 n개
        * `{n.m}` -> n개에서부터 m개까지
        * `()` -> 그룹핑
    + 정규 표현식으로 문자열 검증
        * `boolean result = Pattern.matches("정규식", "검증할 문자열")`

- `Arrays`
    + 배열 조작 기능
        * 배열의 복사 -> `copyOf() copyOfRange()`
        * 항목 정렬 -> `sort()`
        * 항목 검색 -> `equals() deepEquals()`

- Arrays 정렬
    + `Arrays.sort()` 메소드의 매개값으로 지정해주면 자동으로 오름차순 정렬
        * 사용자 정의 클래스 타입일 경우, 클래스가 `Comparable` 인터페이스를 구현하고 있어야 정렬
    + `compareTo()`
        * 오름차순일 때 자신이 매개값 보다 낮을 경우 음수, 같은경우 0, 높을 경우 양수
        * 내림차순일 때 자신이 매개값 보다 낮을 경우 양수, 같은경우 0, 높을 경우 음수
```
public class Member implements Comparable<Member> {
	String name;

	Member(String name) {
		this.name = name;
	}
	
	@Override
	public int compareTo(Member o) {
		return name.compareTo(o.name);
	}

}
```

- 배열에서 값이 위치한 index 찾기
    + 먼저 오름차순으로 배열 정렬후 찾기 진행!!
`int index = Arrays.binarySearch(배열명, 찾을데이터);`
