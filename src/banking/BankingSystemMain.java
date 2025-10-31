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
			
			try {
			
			//System.out.print("입력:");
				int menu = scan.nextInt();
				scan.nextLine();
			
				if (menu < 1 || menu > 5) {
					System.out.println("메뉴는 1~5 사이의 숫자로 입력하세요.\n");
					continue;
				}
			
			switch(menu) {
				case ICustomDefine.MAKE: 
					System.out.println("계좌개설");
					System.out.println("1.보통계좌");
					System.out.println("2.신용신뢰계좌");
					System.out.print("선택: ");				
					int makeAccount = scan.nextInt();
					scan.nextLine();
				
					Am.makeAccount(makeAccount);
					break;
				case ICustomDefine.DEPOSIT:
					System.out.println("입 금");
					//System.out.print("기본이자%(정수형태로입력): ");
					//int interestRate = scan.nextInt();
					//scan.nextLine();
					Am.depositMoney();
					break;
				case ICustomDefine.WITHDRAW:
					System.out.println();
					Am.withdrawMoney();
					break;
				case ICustomDefine.INQUIRE:
					System.out.println();
					Am.showAccInfo();
					break;
			
				case ICustomDefine.EXIT:	
					System.out.println();
					System.exit(0);
				}
			}
			catch (Exception e) {
			System.out.println("잘못된 입력입니다. 메뉴는 숫자로 입력해주세요.\n");
            scan.nextLine();
			}
		}
	}
	
}
