/**
 * [ Statements ]: 여러 종류의 문장들을 보여주는 프로그램
 *  
 *   o 문장은 크게 변수 선언문과 실행문으로 나누어짐
 *     - 변수 선언문: 단순변수 선언문, 배열변수선언문, 객체 참조변수 선언문
 *     - 실행문: 단순문(수식문(대입문, 증감문, 메소드 호출문, 객체 생성문), 반환문, 공백문),
 *              복합문(블록, 선택문(if 문, switch 문), 반복문(for 문, while 문, do-wile 문))
 *      
 *   o 여러 점수들을 입력하여 평균을 구하여 출력하는 프로그램을 통해 문장 종류들을 소개 
 */

class Ex4_1_Statements {
  public static void main(String[] args) {   
     int scores[];            // 배열변수 선언문
     scores = new int[100];   // 대입문(실행문, 단순문, 수식문)

     int cntScores;           // 단순변수 선언문

     System.out.print("  o 점수들 입력(중단하려면 -1 입력) > "); // 메소드 호출문(실행문, 단순문) 

     cntScores = 0;          // 대입문(실행문, 단순문, 수식문)
       
     while ((scores[cntScores] = SkScanner.getInt()) != -1)  // while 문(실행문, 복합문, 반복문)
    	cntScores++;         // 증가문(실행문, 단순문, 수식문) 

     int sum = 0;            // 초기화된 단순변수 선언문
     
     for ( int i = 0;  i < cntScores; i++)    // for 문(실행문, 복합문, 반복문) 
     {                                        // 블록 시작(실행문, 복합문)          	  
          if (scores[i] > 100)                //   if 문(실행문, 복합문, 선택문)
              scores[i] = 100;                //     대입문(실행문, 단순문, 수식문)   
          sum += scores[i];                   //   대입문(실행문, 단순문, 수식문)                    	 
     }                                        // 블록 끝(실행문, 복합문) 

     double avg = sum / (double) cntScores;   // 초기화가 수행된 단순변수 선언문
     System.out.println("\n  * 입력된 점수 개수 = " + cntScores);   // 메소드 호출문(실행문, 단순문)
     System.out.println("  * 입력된 점수 합 = " + sum);            // 메소드 호출문(실행문, 단순문)
     System.out.println("  * 입력된 점수 평균 = " + avg);          // 메소드 호출문(실행문, 단순문)
     
     if (avg >= 80)                                             // if 문(실행문, 복합문, 선택문)
        System.out.println("  * 점수 평균이 80 이상임");           //    메소드 호출문(실행문, 단순문)
     else
        System.out.println("  * 점수 평균이 80 미만임");           //    메소드 호출문(실행문, 단순문)
   }
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 주어진 프로그램 살펴보고 프로그램의 내용 파악하라.     
 *     
 *   2) 점수 55, 59, 60, 93, -1 입력하여 결과 확인하라
 *   
 *
 * [ 실습과제 ]
 * 
 *   1) 문장의 종류를 스스로 파악해보라.
 *   
 *   2) 이 프로그램에서 빈도가 가장 많은 문장 종류 3가지를 차례대로 나열해보라.     
 */
