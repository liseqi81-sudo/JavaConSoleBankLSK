package banking;

import java.util.Scanner;

public class BankingSystemMain {

	public static void Showmenu() {
		System.out.println("======== Menu ========");
		System.out.println("1. 계좌개설 ");
		System.out.println("2. 입금 ");
		System.out.println("3. 출금 ");
		System.out.println("4. 전체계좌정보출력 ");
		System.out.println("5. 프로그램종료 ");
		System.out.print("메뉴선택>>>");
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		AccountManager Am = new AccountManager ();
		
		while(true) {
			
			Showmenu();
			
			//System.out.print("입력:");
			int menu = scan.nextInt();
			scan.nextLine();
			
			switch(menu) {
			case 1: 
				System.out.println("계좌개설");
				Am.makeAccount();
				break;
			case 2:
				System.out.println("입 금");
				Am.depositMoney();
				break;
			case 3:
				System.out.println("출 금");
				Am.withdrawMoney();
				break;
			case 4:
				System.out.println("전체계좌정보출력");
				Am.showAccInfo();
				break;
			
			case 5:	
				System.out.println("프로그램종료");
				System.exit(0);
			
			}
		}
	}
}

	

