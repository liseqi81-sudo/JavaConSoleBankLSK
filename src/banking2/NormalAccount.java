package banking2;

import java.io.OutputStream;
import java.util.Scanner;

public class NormalAccount extends Account{
	Scanner sc = new Scanner(System.in);
//		public String accountNum;
//		public String name;
//		public int balance;
	//멤버변수
	public int interest;
	//생성자	
	public NormalAccount(String accNumber, String name, int balance, int interest) {
		super(accNumber, name, balance);
		this.interest = interest;
	}	
	
	@Override
	public void deposit(int money) {
		while(true ) {
		
			try {
				System.out.print("입금 할 금액을 입력하세요: ");
		        String input = sc.nextLine();
				money = Integer.parseInt(input);	
			
				if (money<=0) {
					System.out.println("입금 금액은 0보다 커야 합니다.");	
				}
					if(money % 500 !=0) {
						System.out.println("입금 금액은 500원 단위로만 가능합니다.");
		                continue;
					}	
			    System.out.println("일반계좌 이자 계산하기");

				double interest = this.balance*0.02;
				int calculatedInterest = (int) Math.floor(interest);
				this.balance += calculatedInterest + money;
				System.out.println(" 입금 및 이자 처리 완료!");
				break;
			} 
			catch (NumberFormatException e) {
				System.out.println("숫자만 입력하세요.");
			}
			catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}	
		}
		
    }
	
    @Override
	public void withdraw(int money) {
    	while (true ) {
    		
        	System.out.print("출금 할 금액을 입력하세요: ");
        	String input = sc.nextLine();
        	String output = null;
        	try {
        		money = Integer.parseInt(input);
        		
        		if (money<=0) {
        			System.out.println("출금 금액은 0보다 커야 합니다.");
        			continue;
        		}
        		if(this.balance <money) {
        			System.out.println("잔고가 부족합니다. (현재 잔액: " + this.balance + "원)");
        			System.out.print("금액 전체 (" + this.balance + "원)를 출금할까요? (YES/NO): ");
        			output = sc.nextLine().trim().toUpperCase();
        		}
        			if("YES".equals(output)) {
        				money = this.balance;
        				this.balance = 0;
        				System.out.println(" 잔액 " + money + "원 전체 출금 처리되었습니다.");
        				break;
        			}
        			else if("NO".equals(output)) {
        				System.out.println("출금요청이 취소되었습니다.");
        				break;
        			}
        		else {
        			this.balance -= money;
        			System.out.println(" " + money + "원이 출금되었습니다.");
        			break;
        		}
        	} 
			catch (NumberFormatException e) {
				System.out.println("오류 : 금액은 숫자로만 입력해야 합니다.");
			}
    	}	
    }	
   
    @Override
    public void showAccInfo() {
    	System.out.print("[보통계좌]");
    	super.showAccInfo();
    	System.out.println("이자율:"+ this.interest+ "%");
    	System.out.println("--------------------");
    }    
}