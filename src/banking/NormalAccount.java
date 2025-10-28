package banking;

public class NormalAccount {

		public String accountNum;
		public String name;
		public int balance;
		
	
		
		public NormalAccount(String accountNum, String name, int balance) {
			this.accountNum = accountNum;
			this.name = name;
			this.balance = balance;
		
			
		}
		
		
		public void deposit(int money) {
	        
			balance += money;
	    }

	    public void withdraw(int money) {
	        balance -= money;
	    }

	    public void showAccountInfo() {
	        System.out.println("계좌번호: " + accountNum);
	        System.out.println("이름: " + name);
	        System.out.println("잔액: " + balance);
	    }
	}