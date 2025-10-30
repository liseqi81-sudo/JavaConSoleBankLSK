package banking;

public class HighCreditAccount extends Account{

//	public String accountNum;
//	public String name;
//	public int balance;
	public int interest;
	public String grade; 
	private static final double BASIC_INTEREST_RATE = 0.02;
		
	public HighCreditAccount(String accNumber, String name, int balance, int interest, String grade) {
		super(accNumber, name, balance);
		this.interest = interest;
		this.grade = grade.toUpperCase();
	}

	@Override
	public void deposit(int money) {
		System.out.println("신용신뢰계좌 이자 계산하기");
	
		double extraInterestRate = 0.0;
		switch (grade) {
        case "A":
        	extraInterestRate = ICustomDefine.A;
            break;
        case "B":
        	extraInterestRate = 0.04;
            break;
        case "C":
        	extraInterestRate = 0.02;
            break;
        default:
        	extraInterestRate = 0.0;
    }
		double interest = (balance * BASIC_INTEREST_RATE) + (balance * extraInterestRate);
		int calculatedInterest = (int) Math.floor(interest);
		
		this.balance = this.balance+calculatedInterest + money;
		
		System.out.println("입금 금액: " + money);
        System.out.println("기본이자율: " + (BASIC_INTEREST_RATE * 100) + "%");
        System.out.printf("추가이자율: %.0f%%\n", extraInterestRate * 100);
        System.out.println("이자 금액: " + calculatedInterest);
		
		
		System.out.println(" 입금 및 이자 처리 완료!");
	
}

    @Override
	public void withdraw(int money) {
        balance -= money;
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