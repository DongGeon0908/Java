### 📒Contents

- 프로세스 `process`
  
    - 운영체제에서 실행 중인 하나의 애플리케이션
    - 사용자가 애플리케이션을 실행하면 운영체제로부터 실행에 필요한 메모리를 할당받아 애플리케이션의 코드를 실행
    
- 멀티 태스킹 `Multi Tasking`

    - 두 가지 이상의 작업을 동시에 처리하는 것
    - 운영체제는 멀티 태스킹을 위해 `CPU` 및 메모리 자원을 프로세스마다 적절히 할당하고 병렬로 처리
    - 멀티 프로세스
        - 애플리케이션 단위의 멀티 태스킹
        - 운영체제에서 할당받은 자신의 메모리를 가지고 실행되기 때문에 서로 독립적
    - 멀티 스레드
        - 애플리케이션 내부에서의 멀티 태스킹
        - 하나의 프로세스 내부에 생성되기 때문에 하나의 스레드가 예외를 발생시키면 프로세스 자체가 종료될 수 있어 다른 스레드에게 영향을 미침

- 멀티 스레드 `Multi Thread`

    - 한 가지 작업을 실행하기 위해 순차적으로 실행할 코드
    - 하나의 스레드는 하나의 코드 실행 흐름이기 때문에 한 프로세스 내에 스레드가 두 개라면 두 개의 코드 실행 흐림이 생김
    - 사용 분야
        - 대용량 데이터의 처리 시간을 줄이기 ㄷ위해 데이터를 분할해서 별렬로 처리
        - `UI`를 가지고 있는 애플리케이션에서 네트워크 통신을 하기 위해 사용
        - 다수 클라이언트의 요청을 처리하는 서버를 개발할 때에도 사용
        - 애플리케이션을 개발하는데 꼭 필요한 기능

- 메인 스레드 `main thread`

    - 모든 자바 애플리케이션은 메인 스레드가 `main()`를 실행하면서 시작
        - `main()`의 첫 코드부터 아래로 순차적으로 실행

- 싱글 스레드

    - 메인 스레드가 종료하면 프로세스도 종료

- 멀티 스레드

    - 실행 중인 스레드가 하나라도 있다면, 프로세스는 종료되지 않음
    - 서로 다른 작업을 동시에 처리

- 작업 스레드 생성과 실행

    - 먼저, 몇 개의 작업을 병렬로 실행할지 결정하고 각 작업별로 스레드를 생성
        - 메인 작업 이외에 추가적인 병렬 작업의 수만큼 스레드를 생성
        - 작업 스레드로 객체로 생성
        - `java.lang.Thread`클래스 이용
        - `Trhead` 상속

    `Thread thread = new Thread(Runnable target);`

    - `Runnable`

      - 작업 스레드가 실행할 수 있는 코드를 가지고 있는 객체

      - 인터페이스 타입

      - `run()`을 재정의해서 작업 스레드가 실행할 코드를 작성

      - 작업 내용을 가지고 있는 객체 -> 실제 스레드 X

        - `Runnable` 구현 객체를 생성 -> `Thread`의 매개값으로 호출 -> 스레드 생성

          ```java
          Runnable task = new Task();
          Thead thread = new Thread(task);
          ```

        -  `Runnable` 익명 객체를 매개값으로 사용

          ```
          Thread thread = new Thread(new Runnable(){
          	public void run(){
          	
          	}
          });
          ```

        - 람다식을 매개값으로 사용

          ```
          Thread thread = new Thread(()->{
          	
          });
          ```

      - 스레드의 실행

        ```
        thread.start();
        ```

- `Thread` 하위 클래스로붙 생성

    - `Runnable`로 생성하지 않고, `Thread`의 하위 클래스로 작업 스레드를 정의하면서 작업 내용을 포함시킴

        - `Thread` 클래스를 상속한 후, `run` 메소드를 재정의해서 스레드가 실행할 코드를 작성

            ```
            public class WorkerThread extends Thread {
            	@Override
            	public void run(){
            	// 실행 코드
            	}
            }
            Thread thread = new WorkerThread();
            ```

        - `Thread` 익명 객체로 작업 스레드 객체를 생성

            ```
            Thread thread = new Thread() {
            	public void run(){
            	// 실행코드
            	}
            };
            ```

        - 작업 스레드 객체에서 `start()`을 통해 메소드를 실행시킴

- 스레드의 이름

    - 스레드 이름을 변경하고 싶을 경우

        ```
        thread.setName("스레드 이름");
        ```

    - 스레드 이름을 알고 싶을 경우

        ```
        thread.getName();
        ```

    - 현재 스레드를 참조

        ```
        Thread thread = Thread.currentThread();
        ```

- 스레드 우선순위

    - 동시성 `Concurrency`

        - 멀티 작업을 위해 하나의 코어에서 멀티 스레드가 번갈아가며 실행하는 성질

    - 병렬성 `Parallelism`

        - 멀티 작업을 위해 멀티 코어에서 개별 스레드를 동시에 실행하는 성질

    - 스레드 스케줄링

        - 스레드의 개수가 코어의 수보다 많을 경우, 스레드를 어떤 순서에 의해 동시성으로 실행할 것인가를 결정

        -  우선순위 `Priority`

            - 우선순위가 높은 스레드가 실행 상태를 더 많이 가지로록 스케줄링하는 것
            - 스레드 객체에 우선순위 번호를 부여할 수 있음 -> 개발자가 코드로 제어 가능

            ```
            thread.setPriority(우선순위);
            ```

            - `Thread` 클래스의 상수 사용

              ```
              thread.setPriority(Thread.MAX_PRIORITY);
              thread.setPriority(Thread.NORM_PRIORITY);
              thread.setPriority(Thread.MIN_PRIORITY);
              ```

        - 순환 할당 `Round-Robin`

            - 시간 할당량을 정해서 하나의 스레드를 정해진 시간만큼 실행하고 다시 다른 스레드를 실행하는 방식
            - 자바 가상 기계에 의해서 정해짐 -> 코드 제어 불가

-  공유 객체를 사용할 때의 주의할 점

  - 잠시 객체에 대한 사용이 없을 때 다른 스레드가 해당 객체의 값을 변경할 수 있음

  - 스레드가 사용 중인 객체를 다른 스레드가 변경할 수 없도록 하는 방법

    - 스레드 작업이 끝날 때까지 객체에 잠금을 걸어서 다른 스레드가 사용할 수 없도록 함

    - 임계 영역 `critical section`

      - 동기화`synchronized` 메소드와 동기화 블록을 통해 임계 영역 설정

        ```
        public synchronized void method(){
        	// 임계영역
        }
        ```

      - 스레드가 동기화 메소드를 실행하는 즉시 객체 잠금 일어남

      - 스레드가 동기화 메소드를 실행 종료하면 잠금 풀림

- 스레드 상태
  - 실행 대기 상태
    - 아직 스케줄링이 되지 않아서 실행을 기다리고 있는 상태
  - 실행 상태
    - 실행 대기 상태에 있는 스레드 중에서 스레드 스케줄링으로 선택된 스레드가 `CPU`를 점유하고 `RUN()` 메소드를 실행한 상태
  - 종료 상태
    - 더 이상 실행할 코드가 없어서 스레드의 실행이 멈춘 상태
  - 일시 정지 상태
    - 스레드가 실행할 수 없는 상태
    - `WAITING, TIMED_WAITING, BLOCKED`

- 스레드 상태 제어
  - 실행 중인 스레드의 상태를 변경하는 것
  - 스레드를 잘못 사용하면 프로그램의 치명적인 버그가 되기 때문에 스레드를 정확하게 제어하는 방법을 잘 알고 있어야 함
  - `sleep()`
    - 주어진 시간동안 일시 정지
  - `yield()`
    - 다른 스레드에게 실행 양보 
  - `join()`
    - 다른 스레드의 종료를 기다림
  - 스레드 간 협업
    - `notify`
      - `wait()`에 의해 일시 정지된 스레드 중 한 개를 실행 대기 상태로 만듬
    - `notifyAll()`
      - `wait()`에 의해 일시 정지된 모든 스레드들을 실행 대기 상태로 만듬
  - 스레드의 안전한 종료
    - ` stop 플러그`
      - `run()` 메소드가 정상적으로 종료되도록 유도하는 것
    - `interrupt()`
      - 스레드가 일시 정지 상태에 있을 때 `InterruptedException` 예외를 발생시키는 역할
  
- 데몬 스레드 `daemon`

    - 주 스레드의 작업을 돕는 보조적인 역할을 수행하는 스레드
    - 주 스레드가 종료되면 자동적으로 데몬 스레드도 종료됨

- 스레드 그룹 `ThreadGroup`

    - 관련된 스레드를 묶어서 관리할 목적으로 이용
    - 스레드는 반드시 하나의 스레드 그룹에 포함됨
        - 명시적으로 스레드 그룹에 포함시키지 않으면 기본적으로 자신을 생성한 스레드와 같은 스레드 그룹에 속함

    ```
    ThreadGroup tg = new ThreadGroup(String name);
    ThreadGroup tg = new ThreadGroup(ThreadGroup parent, String name);
    ```

- 스레드 그룹의 일괄 `interrupt()`

    - 그룹 내에 포함된 모든 스레드들을 일괄 `interrupt`할 수 있음
    - 스레드 그룹의 `interrupy()` 메소드는 포함된 모든 스레드의 `interrupt()` 메소드를 내부적으로 호출해줌
    - 스레드를 안정적으로 종료시킬 수 있음
    
    ```
    public class WorkThread extends Thread {
    	public WorkThread(ThreadGroup threadGroup, String threadName){
    		super(threadGroup, threadName);
    	}
    	
    	@Override
    	public void run(){
    		while(true){
    			try{
    				Thread.sleep(1000);
    			} catch (InterruptedException e){
    				System.out.println(getName() + " interrupted");
    				break;
    			}
    		}
    		System.out.println(getName() + " 종료됨 ");
    	}
    }
    ```



- 스레드 풀 `ThreadPool`
  - 갑작스런 병렬 작업의 폭증으로 인한 스레드의 폭증을 막음
  - 작업 처리에 사용되는 스레드를 제한된 개수만큼 정해 놓고 작업 큐에 들어오는 작업들을 하나씩 스레드가 맡아서 처리
  - 작업 처리 요청이 폭증되어도 스레드의 전체 개수가 늘어나지 않으므로 애플리케이션의 성능이 급격히 저하되지 않음

- 초기 스레드 수

  - `ExecutorService` 객체가 생성될 때 기본적으로 생성되는 스레드 수

- 코어 스레드 수

  - 스레드 수가 증가된 후 사용되지 않는 스레드를 스레드풀에서 제거할 때 최소한 유지해야 할 스레드 수

- 최대 스레드 수

  - 스레드풀에서 관리하는 최대 스레드 수

- `shutdown()`

  - 남아있는 작업을 마무리하고 스레드풀을 종료

- `shutdownNow()`

  - 남아있는 작업과는 상관없이 강제로 종료

- 작업 생성

  - `Runnable`

    ```
    Runnable task = new Runnable() {
    	@Override
    	public void run() {
    		
    	}
    }
    ```

  - `Collable`

    ```
    Callable<T> task = new Callable<T>(){
    	@Override
    	public T call() throws Exception {
    		return T;
    	}
    }
    ```

- 작업 처리 요청

  - `ExecutorService`의 작업 큐에 `Runnable` 또는 `Callable` 객체를 넣는 행위
  - `execute()`
    - 작업 처리 결과를 받지 못함
    - 작업 처리 도중 예외가 발생하면 스레드가 종료되고 해당 스레드는 스레드풀에서 제거
      - 스레드풀은 다른 작업 처리를 위해 새로운 스레드를 생성
  - `submit()`
    - 작업 처리 결과를 받을 수 있도록 `Future`를 리턴
      - 작업 처리 도중 예외가 발생하더라도 스레드는 종료되지 않고, 다음 작업을 위해 재사용
      - 스레드의 생성 오버헤더를 줄이기 위해서 `submit()`을 사용하는 것이 좋음

- 블로킹 방식의 작업 완료 통보

  - `Future`
    - 지연 완료 객체
    - 작업을 처리하는 스레드가 작업을 완료하기 전까지는 `get()` 메소드가 블로킹되므로 다른 코드를 실행할 수 없음

- 리턴값이 없는 작업 완료 통보

  - `Runnable` 객체로 생성하면 됨
  - `Future` 객체를 리턴하는 이유
    - 스레드가 작업처리를 정상적으로 완료했는지, 아니면 작업 처리 도중에 예외가 발생했는지 확인하기 위함

- 리턴값이 있는 작업 완료 통보

  - 작업 객체를 `Callable`로 생성

    - `call()`의 반환값에 리턴타입을 설정해야함!!

  - 작업 처리 결과를 외부 객체에 저장

    - 스레드가 작업 처리를 완료하고 외부 `Result` 객체에 작업 결과를 저장하면, 애플리케이션이 `Result` 객체를 사용해서 어떤 작업을 진행할 수 있음

      ```
      class Task implements Runnable {
      	Result result;
      	Task(Result result) {
      		this.result = result;
      	}
      	@Override
      	public void run() {
      	
      	}
      }
      ```

  - 작업 완료 순으로 통보

    - 스레드풀에서 이용할 필요가 없다면 작업 처리가 완료된 것부터 결과를 얻어 이용!!

    - `CompletionService`를 이용

      ```
      CompletionService<V> completionService = new ExecutorCompletionService<V>(executorService);
      ```

- 콜백 방식의 작업 완료 통보

  - 콜백?
    - 애플리케이션이 스레드에게 작업 처리를 요청한 후, 스레드가 작업을 완료하면 특정 메소드를 자동 실행하는 기법
    - 콜백 메소드
      - 자동 실행되는 메소드
    - 작업 처리를 요청한 후 결과를 기다릴 필요 없이 다른 기능을 수행할 수 있음





























