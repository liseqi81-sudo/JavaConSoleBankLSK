package banking;

public class HighCreditAccount {

	public String accountNum;
	public String name;
	public int balance;
	
		
		public HighCreditAccount(String accountNum , String name, int balance ) {
			this.accountNum = accountNum ;
			this.name = name;
			this.balance = balance;
	
		}
		
		void showAccountInfo() {
		        System.out.println("계좌번호: " + accountNum);
		        System.out.println("이름: " + name);
		        System.out.println("잔액: " + balance);
		        
		}
	}
		
		
	

