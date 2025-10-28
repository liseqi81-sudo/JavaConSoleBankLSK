package banking;

public class Account {
	//멤버변수
	String accNumber; //계좌번호(String형), 
	String name; //이름(String형), 
	int balance; //잔액(int형)
	
	//생성자
	public Account(String accNumber, String name, int balance) {
		super();
		this.accNumber = accNumber;
		this.name = name;
		this.balance = balance;
	}
	public String getAccNumber() {
        return accNumber;
    }

	 public int getBalance() {
	        return balance;
	    }
	
    public void deposit(int amount) {
        balance += amount;
    }
	
    public void withdraw(int amount) {
        balance -= amount;
    }


	public void showAccInfo() {
		System.out.print("계좌번호:"+ this.accNumber);
		System.out.print(", 이름:"+ this.name);
		System.out.println(", 잔액:"+ this.balance);
	}
	
	
}
	
