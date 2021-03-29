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
