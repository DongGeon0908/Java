package ex02_persons;


/*
 * [ Ex4_2_Persons_Mgmt_Better ]: 신상정보 추가, 전체 보기, 위치 이동, 나이 변경, 신상정보 삭제 등의 신상정보 관리업무 수행(배열, if, For 문장을 이용)
 *
 *
 *   o 프로그래밍 스타일
 *     1) main() 메소드로만 클래스 구성
 *     2) 배열변수 선언, For 문장을 이용하여 신상정보 추가, 전체 보기, 위치 이동, 나이 변경, 삭제 등의 신상정보 관리업무를 수행 
 *
 *   o 프롬프트 메시지 출력 후 타입별로 값을 입력하는 메소드인 SkScanner 클래스의 getXxxWithPrompt()
 *     - getStringWithPrompt(문자열메시지): 	메시지 출력 후 문자열 입력
 *     - getIntWithPrompt(문자열메시지):     메시지 출력 후 정수 입력
 *     - getDoubleWithPrompt(문자열메시지):  메시지 출력 후 실수 입력
 */

class Ex4_2_Persons_Mgmt_Better {
	public static void main(String[] args) {

		// 신상정보 항목(이름, 나이, 현위치)을 저장하기 위한 배열변수 선언, 최대 100명의 신상정보 저장 가능함
		String names[] = new String[100];		
		int ages[]= new int[100];
		String currentLocations[] = new String[100];
		
   		// 처음에 4명의 신상정보를 미리 저장함  
		names[0] = "홍길동"; names[1] = "박문수"; names[2] = "이몽룡"; names[3] = "성춘향"; // 4명 이름을 초기화함 		
		ages[0] = 18; ages[1] = 35; ages[2] = 16; ages[3] = 14;
		currentLocations[0] = "금강산"; currentLocations[1] = "한양";  // 4명 나이를 초기화함
		currentLocations[2] = "남원";   currentLocations[3] = "남원" ; // 4명 현위치을 초기화함

		// noPersons: 신상정보 추가된 사람의 인원수를 저장하는 변수, 이 변수를 신상정보 항목을 저장하는 배열변수의 인덱스로 사용함
		int noPersons = 4;   // 처음에 4명의 신상정보를 미리 저장하였으므로 4로 초기화해야 함 


		// menuNames: 신상정보 관리 메뉴 명칭을 저장하는 배열변수 
		String menuNames[] = { "신상정보 추가", "신상정보 전체 보기", "위치 이동", "나이 1 증가", "신상정보 삭제", "종료하기" };

		int cntMenus = menuNames.length;  // .length는 배열의 원소 개수를 구하는 것으로, 이는 업무 개수를 구하는 방법임 

		/*
		 *   신상정보 관리업무를 종료 업무를 선택할 때까지 반복하여 수행함 
		 *   신상정보 관리업무는 신상정보 추가, 보기, 위치 이동, 나이 1 증가, 신상정보 삭제 등으로 구성됨
		 *   여러 업무 중 한 업무를 선택하여 업무의 내용을 수행하도록 업무별 코드를 작성함
		 */ 

		int menu;
		int i; 

		while(true) { // 종료 메뉴를 선택할 때까지 반복함 
			/*
			 * 신상정보 관리업무를 위한 메뉴 출력 및 메뉴 선택 
			 */

			while(true) { // 종료 메뉴를 선택할 때까지 반복함 
				/*
				 * 신상정보 관리업무를 위한 메뉴 출력 및 메뉴 선택 
				 */

				while (true) { // 올바른 업무에 대한 메뉴가 선택될 때까지 반복하여 업무 메뉴를 선택함 
					System.out.println("\n\n");
					System.out.println("  **************************************");
					System.out.println("  **        신상정보 관리업무         **");
					System.out.println("  **************************************\n");


					for (i = 0; i < cntMenus; i++) {                    // 신상정보 관리 메뉴 명칭을 이용하여 차례대로 메뉴 순서번호와 메뉴 내용을 출력함 
						System.out.println("     " + (i+1) + ") " + menuNames[i]);  //     배열 인덱스는 0부터 시작하며, 순번은 1부터 시작하므로 순번을 위해 인덱스 + 1 
					}	

					menu = SkScanner.getIntWithPrompt("\n   o 업무를 선택하시오 > ");

					if (menu >=1 && menu < 6) { // 정상적 메뉴 순번을 선택하면 메뉴 선택이 완료되므로 
						break;		                   //     break 문을 이용하여 무한 반복 while(1)을 벗어나게 함
					}
					else if (menu == 6) {     // 종료 메뉴를 선택하면  종료 메세지 출력 후 프로그램을 종료함 
						System.out.println("\n\n  !!!  신상정보 관리업무를 종료합니다.");

						System.out.println("\n\n  ^^ Well done! Have a good time!!! ^^"); // 이 문장은 프로그램의 종료를 나타내는 문장임

						return;  // main()에서의 return 문장은  프로그램을 종료시킴 
					}
					else { // 잘못된 메뉴 순번을 선택하면 다시 메뉴 순번을 입력하도록 함 
						System.out.println("\n\n  ??? 업무가 잘못 선택되었습니다. 다시 올바른 업무를 선택하시오!!!");	
					}
				}



				/*
				 * 선택한 메뉴에 따라 신상정보 관리업무를 수행 
				 */
				if (menu == 1)  { // 신상정보 추가 업무 처리 

					// 신상정보 항목 값을 입력하여 배열변수들의 인덱스 noPersons 위치에 원소 저장
					System.out.println("\n\n  *** 신상정보 추가: 이름, 나이, 현위치 입력하여 신상정보에 추가 ** \n");

					names[noPersons] = SkScanner.getStringWithPrompt("   o 이름 > ");
					ages[noPersons] = SkScanner.getIntWithPrompt("   o 나이 > ");
					currentLocations[noPersons] = SkScanner.getStringWithPrompt("   o 현위치 > ");

					System.out.println("\n  [ 신상정보 추가 완료 ] " + names[noPersons] + "의 신상정보가 추가되었습니다.");

					noPersons++; // 새로운 신상정보 추가되었으므로 noPersons를 1 증가시킴     	
				}
				else  if (menu == 2)  { // 신상정보 전체 보기 업무를 처리함 

					if (noPersons == 0) {
						System.out.println("\n\n  ??? 신상정보가 하나도 없습니다. 신상정보 추가 후 수행하십시오.");
					}
					else { // 배열에 저장된 noPersons 명의 신상정보 항목들을 모두 출력
						System.out.println("\n\n  *** 신상정보 전체 보기: 이름, 나이, 현위치 출력 ***\n");

						for (i = 0; i < noPersons; i++) {	
							System.out.println("   " + (i + 1) + ") " + names[i] + "의 신상정보 - 나이: " + ages[i] + "세, 현위치: " + currentLocations[i]);
						}

						System.out.println("\n  [ 신상정보 보기 완료 ] 모두 " + noPersons + "명의 신상정보가 있습니다.");

					}
				}
				else  if (menu == 3)  { // 위치 이동 업무를 처리함 

					if (noPersons == 0) {
						System.out.println("\n\n  ??? 신상정보가 하나도 없습니다. 신상정보 추가 후 수행하십시오.");
					}
					else { // 배열에 저장된 noPersons 명의 신상정보 항목들을 출력 후 특정인 선택하여 선택된 사람의 이동 위치 입력하여 현위치 변경 
						System.out.println("\n\n  *** 위치 이동: 선택된 특정인의 현위치 변경하기 ***\n");

						System.out.println("  ** 저장된 신상정보 **\n");

						for (i = 0; i < noPersons; i++) {	
							System.out.println("   " + (i + 1) + ") " + names[i] + "의 신상정보 - 나이: " + ages[i] + "세, 현위치: " + currentLocations[i]);
						}

						int no; // 현 위치 이동할 사람의 순서번호를 저장할 변수 

						while(true) {	// 무한 반복 while(1)을 이용하여 특정인의 올바른 순번을 선택할 때까지 반복하여 순번을 선택하게 함
							no = SkScanner.getIntWithPrompt("\n   o 위치 이동할 사람의 순번 선택 > ");

							if (no <= 0 || no > noPersons) { // 잘못된 순번을 선택하면 오류 메세지 출력 후 다시 순번 선택하게 함 
								System.out.println("\n   ??? 순번 잘못 선택되었습니다. 1부터 " + noPersons + " 사이의 순번을 선택하시오!!!");	
							}
							else                            // 정상적 순번을 선택하면 
								break;                      //   break 문을 이용하여 무한 반복 while(1)을 벗어나게 함 
						}

						int index = no - 1;  // 신상정보를 저장하는 배열에서의 인덱스는 순번보다 1 작으므로 no - 1 


						System.out.println("\n  ** " + names[index] + "의 위치 이동하기 ** \n");
						System.out.println("   * " + names[index] + "의 현위치: " + currentLocations[index]);

						String location = SkScanner.getStringWithPrompt("   o 이동 위치 > ");

						System.out.println("\n  [ 위치 이동 완료 ] " + names[index] + "의 현위치가 " + currentLocations[index] + "에서 " + location + "(으)로 변경되었습니다.");

						currentLocations[index] = location;  // no번째 신상정보의 현위치를 입력한 이동 위치로 변경시킴 

					}
				}
				else  if (menu == 4)  { // 나이 1 증가 업무를 처리함 

					if (noPersons == 0) {
						System.out.println("\n\n  ??? 신상정보가 하나도 없습니다. 신상정보 추가 후 수행하십시오.");
					}
					else { 
						// 모든 나이를 1 증가하는 것에 대한 예 또는 아니오를 확인한 후 예이면 모든 나이를 1 증가시킴

						System.out.println("\n\n  *** 모든 나이 1 증가: 나이 증가 확인 후 나이 1 증가하기 ***\n");

						System.out.println("  ** 저장된 신상정보 **\n");

						for (i = 0; i < noPersons; i++) {	
							System.out.println("    " + (i + 1) + ") " + names[i] + "의 신상정보 - 나이: " + ages[i] + "세, 현위치: " + currentLocations[i]);
						}

						int YesOrNo; // 예 또는 아니오에 대한 정수값을 저장할 변수 

						YesOrNo = SkScanner.getIntWithPrompt("\n   o 모든 신상정보의 나이를 1 나이를 1 증가하겠습니까? (예:1, 아니오:0) > ");

						if (YesOrNo == 1) {
							for (i = 0; i < noPersons; i++) {	
								ages[i]++;
							}
						}

						System.out.println("\n\n  ** 나이 1 증가된 신상정보 **\n");

						for (i = 0; i < noPersons; i++) {	
							System.out.println("   " + (i + 1) + ") " + names[i] + "의 신상정보 - 나이: " + ages[i] + "세, 현위치: " + currentLocations[i]);
						}

						System.out.println("\n  [ 나이 1 증가 완료 ] 모두 " + noPersons + "명의 나이가 1 증가되었습니다. ");

					}
				}
				else  if (menu == 5)  { // 신상정보 삭제 업무를 처리함 

					if (noPersons == 0) {
						System.out.println("\n\n  ??? 신상정보가 하나도 없습니다. 신상정보 추가 후 수행하십시오.");
					}
					else { 
						// 배열에 저장된 noPersons 명의 신상정보 항목들을 출력 후 특정 신상정보 선택하여 선택된 신상정보를 신상정보 항목 배열에서 삭제
						System.out.println("\n\n  *** 신상정보 삭제:  선택된 신상정보를 삭제 ***\n");

						System.out.println("  ** 저장된 신상정보 **\n");

						for (i = 0; i < noPersons; i++) {	
							System.out.println("   " + (i + 1) + ") " + names[i] + "의 신상정보 - 나이: " + ages[i] + "세, 현위치: " + currentLocations[i]);
						}

						int no; // 삭제할 신상정보의 순서번호를 저장할 변수 

						while(true) {	// 무한 반복 while(1)을 이용하여 올바른 순번을 선택할 때까지 반복하여 순번을 선택하게 함
							no = SkScanner.getIntWithPrompt("\n   o 삭제할 신상정보의 순번 선택 > ");

							if (no <= 0 || no > noPersons) { // 잘못된 순번을 선택하면 오류 메세지 출력 후 다시 순번 선택하게 함 
								System.out.println("\n   ??? 순번 잘못 선택하였습니다. 1부터 " + noPersons + " 사이의 순번을 선택하시오!!!\n");	
							}
							else                            // 정상적 순번을 선택하면 
								break;                      //   break 문을 이용하여 무한 반복 while(1)을 벗어나게 함 
						}

						int index = no - 1;  // 신상정보를 저장하는 배열에서의 인덱스는 순번보다 1 작으므로 no - 1 

						String nameTodelete =  names[index];   // 삭제할 신상정보의 이름 항목을 nameToDelete에 저장 

						// index 위치의 신상정보 항목을 삭제하기 위해서는 index 이후의 모든 신상정보 항목들을 한 위치 앞으로 이동시키면 됨 
						for (i = index; i < noPersons; i++) {	
							names[i] = names[i + 1];          // 다음 위치의 신상정보 이름을 이전 위치로 차례대로 저장하여  index 위치의 신상정보 이름 항목 삭제 
							ages[i] = ages[i + 1];            // 신상정보 나이에 대해 동일하게 수행 
							currentLocations[i] = currentLocations[i + 1];  // 신상정보 현위치에 대해 동일하게 수행 
						}

						noPersons--; // no번째 신상정보를 삭제하였으므로 저장된 신상정보 인원수는 1 감소함 

						System.out.println("\n  [ 신상정보 삭제 완료 ] " + no + "번째 " + nameTodelete + "의 신상정보를 삭제하였습니다. ");

						System.out.println("\n  ** 삭제한 후의 신상정보 **\n");

						for (i = 0; i < noPersons; i++) {	
							System.out.println("   " + (i + 1) + ") " + names[i] + "의 신상정보 - 나이: " + ages[i] + "세, 현위치: " + currentLocations[i]);
						}
					}
				}
			}
		}
	}
}


/*
 * [ 프로그램의 이해 및 실행 ]
 *
 *   1) 주어진 프로그램을 살펴보고 프로그램의 구조를 파악하라.
 *
 *      - main() 메소드는 배열변수 선언 및 배열 원소 저장, if 문, for 문장 등을 이용하여 
 *        5가지 신상정보 관리업무를 수행한다.
 *
 *      - main() 메소드에 모든 업무 처리 작업이 이루어지므로 
 *        프로그램이 길고 복잡하고 한 눈에 파악하기 어렵다.
 *		 
 *	   - 다음에 배울 메소드를 이용하여 프로그램을 재작성하면 프로그램이 훨씬 단순해지며 파악도 쉽게 된다. 
 *
 *   2) 프로그램을 실행하여 메뉴를 선택하고 필요한 업무를 수행하여 결과를 확인하라.
 *
 *
 * [ 실습과제 ]
 * 
 *   1) 신상정보 항목에 키와 전화번호를 추가하도록 프로그램을 변경하라. 
 *
 *   2) 최고령자와 최연소자와 최고령자의 이름과 나이를 출력하는 메뉴를 새로운 메뉴 6)으로 추가하려 한다.
 *      이를 위해 "최고령자 및 최연소자 정보보기" 메뉴를 추가하도록 프로그램을 수정하라. 
 *       (참고사항:  nameOldest, ageOldest, nameYoungest, ageYoungest 변수를 선언하고 
 *          모든 나이 중에서 가장 큰 값과 작은 값을 찾고 그 때의 이름을 nameOldest와 nameYoungest에 
 *          저장한다.) 
 *          
 *   3) 이 프로그램을 메소드를 이용하는 프로그램으로 변경하여보라.
 */
