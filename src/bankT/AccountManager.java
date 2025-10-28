package bankT;

import java.util.Scanner;

public class AccountManager {
	
	Account[] accArray ;
	int cnt;
	public AccountManager() {
		accArray = new Account[50];
		cnt = 0; //0번째 배열 시작
	}

	public void makeAccount() {
		System.out.println("[manager]계좌개설을 위한 함수");
		Scanner scan = new Scanner(System.in);
		System.out.print("계좌번호:");
		String accNumber = scan.nextLine();
		System.out.print("이름:");
		String name = scan.nextLine();
		System.out.print("잔액:");
		int balance = scan.nextInt();
		
		Account acc = new Account(accNumber, name, balance);
		accArray[cnt++] = acc; //순차적으로 배열에 저장
	}
	public void depositMoney() {
		System.out.println("[manager]입    금");
	}
	public void withdrawMoney() {
		System.out.println("[manager]출    금");
	}
	public void showAccInfo() {
		System.out.println("[manager]전체계좌정보출력");
	}

}
