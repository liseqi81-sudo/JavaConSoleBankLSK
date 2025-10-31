package banking;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountManager {
	
	//private Account[] accArray ;
	
	//Account타입의 인스턴스를 저장할 수 있는 Set 생성
	private HashSet<Account> accArray;
	
	private Scanner scan;
	private int cnt;

	//private Object accNumber;
	public AccountManager() {
		//accArray = new Account[50];
		//cnt = 0;
		
		//Set 인스턴스 생성
		//컬렉션은 자동 인덱싱이 되므로 카운트용 변수 필요없음 
		accArray = new HashSet<Account>();
		
		scan = new Scanner(System.in);
	}
	public void makeAccount(int gubun) {
		System.out.println("=====================");

		try {			
			//공통사항 입력
			System.out.print("계좌번호:");
			String accNumber = scan.nextLine();
			System.out.print("이름:");
			String name = scan.nextLine();
			System.out.print("잔액:");
			int balance = scan.nextInt();
			scan.nextLine();
		
			if(gubun==1) {
				//보통계좌 생성
				System.out.print("이자율:");
				int interest = scan.nextInt();
				scan.nextLine();
				
				//인스턴스형 배열 사용
				//accArray[cnt++] = new NormalAccount(accNumber, name, balance, interest);
				
				//Set 컬렉션 사용 
				accArray.add(new NormalAccount(accNumber, name, balance, interest));
			}
			else if(gubun==2) {
				//신용신뢰계좌 생성
				System.out.print("이자율:");
				int interest = scan.nextInt();
				scan.nextLine();
				System.out.print("회원등급:");
				String grade = scan.nextLine();
				
				//accArray[cnt++] = new HighCreditAccount(accNumber, name, balance, interest, grade);
				HighCreditAccount hca = new HighCreditAccount(accNumber, name, balance, interest, grade);
				accArray.add(hca);
			}
			System.out.println("--계좌 계설 완료--");		
		} 
		catch (InputMismatchException e) {
		// 숫자 입력(잔액)에서 문자열이 들어왔을 때 예외 처리
			System.out.println("메뉴는 1~5로 입력하세요.");
			scan.nextLine();
			return;
		}
	}
	
	public void depositMoney() {
		
		//Scanner scan = new Scanner(System.in);
		System.out.print("계좌번호: ");
		String accNumber = scan.nextLine();		
		
		boolean found = false;
		
		for (int i = 0; i < cnt; i++) {
			if (accArray[i].accNumber.equals(accNumber)) {				
				accArray[i].deposit(0);				
	            System.out.println("--입금 완료--");
	            found = true;
	            break;
	        }			
		}
		if (!found) {
	        System.out.println("해당 계좌를 찾을 수 없습니다.");
		}    
	}
	public void withdrawMoney() {
		
		//Scanner scan = new Scanner(System.in);
		System.out.println("계좌번호와 출금할 금액을 입력하세요");
		 
		System.out.print("계좌번호:");
		String accNumber = scan.nextLine();
		
		
		for (int i = 0; i < cnt; i++) {
			if (accArray[i].accNumber.equals(accNumber)) {
				
				accArray[i].withdraw(0);
				
				System.out.println("--출금 완료--");
				break;
			}    
		}
	}	
	public void showAccInfo() {
		System.out.println("--- 전체 계좌 정보 목록 ---");  
		if (cnt == 0) {
	        System.out.println("현재 저장된 계좌 정보가 없습니다.");
	    }	
		for (int i = 0; i < cnt; i++) {
			accArray[i].showAccInfo();
			System.out.println("--------------------"); 
		}
		System.out.println("--전체계좌정보출력 완료--");
	}	
}
