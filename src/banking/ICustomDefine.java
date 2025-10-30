package banking;

public interface ICustomDefine {

	/*
		고객의 신용등급을 A, B, C로 나누고
		7%, 4%, 2%의 추가이율 제공한다.
	*/
	int A=7, B=4, C=2;
	/*
	1계좌개설
	2입금
	3출금
	4전체계좌정보출력
	5프로그램종료
	*/
	int MAKE=1, DEPOSIT=2, WITHDRAW=3, INQUIRE=4, EXIT=5;
}
