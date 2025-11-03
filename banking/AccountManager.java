package banking;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountManager {
	
	//private Account[] accArray ;
	
	//Account타입의 인스턴스를 저장할 수 있는 Set 생성
	//HashSet 컬렉션 사용 선언
	private HashSet<Account> accArray = new HashSet<>();
	
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
		
			Account duplicateAccount = null;
	        for (Account existingAccount : accArray) {
	            if (existingAccount.getAccNumber().equals(accNumber)) {
	                duplicateAccount = existingAccount;
	                break; 
	            }  
	        } 
	        if (duplicateAccount != null) {
	            System.out.println("중복된 계좌가 발견되었습니다.");
	            System.out.print("덮어쓸까요? (Y/N): ");
	            String answer = scan.nextLine().trim().toUpperCase(); // 대소문자 구분 안 함

	            if (answer.equals("Y")) {
	            	 accArray.remove(duplicateAccount);
	            	System.out.println("기존 계좌를 삭제하고 새계좌를 등록합니다.");
	                 
	            } else if (answer.equals("N")) {
	                
	                System.out.println("기존 계좌정보가 유지됩니다.");
	                return; //없으면 이자율이 출력
	            } else {
	                System.out.println("잘못 입력했습니다. 계좌 개설을 취소합니다.");
	                return;
	            }
	        }
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
			System.out.println("--계좌 계설 완료되었습니다.--");		
	    }     
	    catch (InputMismatchException e) {
		// 숫자 입력(잔액)에서 문자열이 들어왔을 때 예외 처리
			System.out.println("메뉴는 1~6로 입력하세요.");
			scan.nextLine();
			return;
		}
	}
	
	public void depositMoney() {
		
		//Scanner scan = new Scanner(System.in);
		System.out.print("계좌번호: ");
		String accNumber = scan.nextLine();		
		
		System.out.print("입금액: ");
	    int money = scan.nextInt();
	    scan.nextLine();
	
		boolean found = false;
		
		for (Account account : accArray)
			if (account.getAccNumber().equals(accNumber)) {
				account.deposit(money);
				System.out.println("--입금 완료되었습니다.--");
				found = true;
		        break;		
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
		
		System.out.print("출금액: ");
	    int money = scan.nextInt();
	    scan.nextLine(); 
	    
	    boolean found = false; //계좌 찾았는지 확인용 변수
		
		for (Account account : accArray) {
			if (account.getAccNumber().equals(accNumber)) {
				
				account.withdraw(money);
				
				System.out.println("--출금 완료되었습니다.--");
				found = true;
				break;
			}    
		}
	}	
	public void accountDelete() {
		System.out.println("삭제 할 계좌번호를 입력하세요");
		String accNumber = scan.nextLine();
		
		
	    boolean found = false; //계좌 찾았는지 확인용 변수
		
		for (Account account : accArray) {
			if (account.getAccNumber().equals(accNumber)) {
				accArray.remove(account); // 실제로 HashSet에서 계좌 삭제
		        System.out.println("-- 삭제 완료되었습니다. --");
		        found = true;
		        break;
			}    
		}
		if (!found) {
		    System.out.println("해당 계좌를 찾을 수 없습니다.");
		}        
	}	
	public void showAccInfo() {
		System.out.println("--- 전체 계좌 정보 목록 ---");  
		if (cnt == 0) {
	        System.out.println("현재 저장된 계좌 정보가 없습니다.");
	    }	
		for (Account account : accArray) {
			account.showAccInfo();
			System.out.println("--------------------"); 
		}
		System.out.println("--전체계좌정보출력 완료--");
	}
	
}
