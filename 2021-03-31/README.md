### 📒Contents

- 형식 클래스
    + java.text 패키지에 포함
    + `DecimalFormat`
        * 숫자 형식
        * 숫자 데이터를 원하는 형식으로 표현하기 위해서 패턴을 사용
        ```
        DecimalFormat df = new DecimalFormat("#.###.0");
        String result = df.format(1234567.89);
        ```
    + `SimpleDateFormat`
        * 날짜 형식
        ```
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
        String strDate = sdf.format(new Date());
        ```
    + `MessageFormat`
        * 매개 변수화된 문자열 형식
        * 문자열에 데이터가 들어갈 자리를 표시해 두고 프로그램이 실행하면서 동적으로 데이터를 삽입해 문자열을 완성

- `java.time`
    + `LocalDate`
    + `LocalTime`
    + `LocaldateTime`
    + `ZonedDateTime`
    + `Instant`