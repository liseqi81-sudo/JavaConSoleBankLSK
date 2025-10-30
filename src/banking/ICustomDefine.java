package banking;

public interface ICustomDefine {

	/*
		고객의 신용등급을 A, B, C로 나누고
		7%, 4%, 2%의 추가이율 제공한다.
	*/
	int A=7,  B=4, C=2;
	double rateA = A / 100.0;  
	double rateB = B / 100.0;  
	double rateC = C / 100.0;  
	
	static void showRates() {
        System.out.println("A등급 이율: " + (rateA * 100) + "%");
        System.out.println("B등급 이율: " + (rateB * 100) + "%");
        System.out.println("C등급 이율: " + (rateC * 100) + "%");
    }

	
	
	/*
	1계좌개설
	2입금
	3출금
	4전체계좌정보출력
	5프로그램종료
	*/
	int MAKE=1, DEPOSIT=2, WITHDRAW=3, INQUIRE=4, EXIT=5;
}
