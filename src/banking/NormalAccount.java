package banking;

public class NormalAccount extends Account{

//		public String accountNum;
//		public String name;
//		public int balance;
	public int interest;
		
	public NormalAccount(String accNumber, String name, int balance, int interest) {
		super(accNumber, name, balance);
		this.interest = interest;
	}	
	
	@Override
	public void deposit(int money) {
		System.out.println("일반계좌 이자 계산하기");

		
		double interest = this.balance*0.02;
		int calculatedInterest = (int) Math.floor(interest);
		this.balance += calculatedInterest + money;
		System.out.println(" 입금 및 이자 처리 완료!");
		balance += money;
    }

    @Override
	public void withdraw(int money) {
        balance -= money;
    }

    @Override
    public void showAccInfo() {
    	System.out.print("[보통계좌]");
    	super.showAccInfo();
    	System.out.println("이자율:"+ this.interest+ "%");
    	System.out.println("--------------------");
    }    
}