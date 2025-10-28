package banking;

import java.util.Scanner;

public class AccountManager {
	
	private Account[] accArray ;
	
	private Scanner scan;
	private int cnt;

	private Object accNumber;  
	
    
	public AccountManager() {
		accArray = new Account[50];
		cnt = 0;
		scan = new Scanner(System.in);
	}
	
	public void makeAccount() {
		System.out.println("[manager]계좌개설을 위한 함수");
		
		System.out.print("계좌번호:");
		String accNumber = scan.nextLine();
		System.out.print("이름:");
		String name = scan.nextLine();
		System.out.print("잔액:");
		int balance = scan.nextInt();
		 scan.nextLine();
		
		 Account acc = new Account(accNumber, name, balance);
		accArray[cnt++] = acc; 
		System.out.println("--계좌 계설 완료--");
		
	}
		
	
	public void depositMoney() {
		
		//Scanner scan = new Scanner(System.in);
		
		System.out.print("계좌번호:");
		String accNumber = scan.nextLine();
		
		System.out.print("입금액:");
		int depositAmount = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < cnt; i++) {
			if (accArray[i].accNumber.equals(accNumber)) {
				
				accArray[i].deposit(depositAmount);
				
	            System.out.println("--입금 완료--");
	            break;
	        }
			
		}
			
	}
	
	
	public void withdrawMoney() {
		
		//Scanner scan = new Scanner(System.in);
		
		System.out.print("출금액: ");
		System.out.println("계좌번호와 출금할 금액을 입력하세요");
		 
		System.out.print("계좌번호:");
		String accNumber = scan.nextLine();
		
		System.out.print("출금액:");

		int withdrawAmount = scan.nextInt();
		scan.nextLine();
		
		for (int i = 0; i < cnt; i++) {
			if (accArray[i].accNumber.equals(accNumber)) {
				
				accArray[i].withdraw(withdrawAmount);
				
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
