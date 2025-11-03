package banking2;

import java.io.Serializable;

abstract class Account implements Serializable {
	
	//Serializable 인터페이스를 구현해야 파일 저장 가능
	//serialVersionUID는 이 클래스의 고유 버전 번호
	private static final long serialVersionUID = 1L;
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
	
	//오버라이딩을 목적으로 생성한 메서드 
    public abstract void deposit(int amount); 	
    public abstract void withdraw(int amount); 
    
	public void showAccInfo() {
		System.out.print("계좌번호:"+ this.accNumber);
		System.out.print(", 이름:"+ this.name);
		System.out.println(", 잔액:"+ this.balance);
	}	
}
	
