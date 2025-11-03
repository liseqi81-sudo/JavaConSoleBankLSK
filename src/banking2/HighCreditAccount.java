package banking2;

import java.util.Scanner;

public class HighCreditAccount extends Account{
	Scanner sc = new Scanner(System.in);
//	public String accountNum;
//	public String name;
//	public int balance;
	public int interest;
	public String grade; 
	private static final double BASIC_INTEREST_RATE = 0.02;
		
	//생성자
	public HighCreditAccount(String accNumber, String name, int balance, int interest, String grade) {
		super(accNumber, name, balance);
		this.interest = interest;
		this.grade = grade.toUpperCase();//등급문자 대문자 변환
	}

	@Override
	public void deposit(int money) {
		System.out.println("신용신뢰계좌 이자 계산하기");
		
		double extraInterestRate = 0.0;
		
		while(true ) {

			try {
				System.out.print("입금 할 금액을 입력하세요: ");
		        String input = sc.nextLine();
				money = Integer.parseInt(input);	
			
				if (money<=0) {
					throw new IllegalArgumentException("입금 금액은 0보다 커야 합니다.");
				}
			    
			    if(money % 500 !=0) {
					System.out.println("입금 금액은 500원 단위로만 가능합니다.");
	                continue;
			    }
			    break;
			}
			catch (NumberFormatException e) {
				System.out.println("숫자만 입력하세요.");
			}
			catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}	
		}
		
		switch (grade) {
        case "A":
        	extraInterestRate = ICustomDefine.A /100.0;
            break;
        case "B":
        	extraInterestRate = ICustomDefine.B /100.0;
            break;
        case "C":
        	extraInterestRate = ICustomDefine.C /100.0;
            break;
        default:
        	extraInterestRate = 0.0;
		}
		double baseInterest = this.balance * BASIC_INTEREST_RATE;
	    double extraInterest = this.balance * extraInterestRate;
		this.balance = (int) (this.balance + baseInterest + extraInterest + money);
		
		System.out.println("입금 금액: " + money);
        System.out.println("기본이자율: " + (BASIC_INTEREST_RATE * 100) + "%");
        System.out.printf("추가이자율: %.0f%%\n", extraInterestRate * 100);
        System.out.println("이자 금액: " + (int)Math.floor(baseInterest + extraInterest));
		
		
		System.out.println(" 입금 및 이자 처리 완료되었습니다.");
	
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
				System.out.println("금액은 숫자로만 입력해야 합니다.");
			}
    	}	
    }
    
    @Override
    public void showAccInfo() {
    	System.out.print("[신용신뢰계좌]");
    	super.showAccInfo();
    	System.out.println("이자율:"+ interest+ "%");
    	System.out.println(", 회원등급:"+ grade);
    	System.out.println("--------------------");
    }
}