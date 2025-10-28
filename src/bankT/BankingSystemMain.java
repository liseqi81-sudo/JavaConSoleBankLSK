package bankT;

import java.util.Scanner;


public class BankingSystemMain {
		
	public static void showMenu() {
		System.out.println("1.계좌계설");
		System.out.println("2.입금");
		System.out.println("3.출금");
		System.out.println("5.종료");
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		AccountManager am = new AccountManager();
		
		while(true) {
			showMenu();			
			
			System.out.print("입력:");
			int menu = scan.nextInt();
			scan.nextLine();
			
			switch(menu) {
			case 1: 
				System.out.println("==계좌개설 실행");
				am.makeAccount();
				break;
			case 2: 
				System.out.println("==입금 실행");
				am.depositMoney();
				break;
			case 3: 
				System.out.println("==출금 실행");
				am.withdrawMoney();
				break;
			case 4: 
				System.out.println("==전체계좌정보출력");
				am.showAccInfo();
				break;
			case 5:
				System.out.println("프로그램종료");
				System.exit(0);
			}
		}
	}
}
