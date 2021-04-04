
#include <stdio.h>
#include <string.h>
#include <malloc.h>
typedef char * String;


#define MAX_LENGTH_OF_STRING  2000
char strbuf[MAX_LENGTH_OF_STRING];  // �о���� ���ڿ��� �����ϱ� ���� ���� 

double powor10(long n);

/*
 ** SkScanner.h: �輺�� ������ �ۼ��� �Է��� ���� �Լ��� ���� ��� ���� 
 **    o �� SkScanner.h�� �����Ӱ� �Էµ� ������ �߿��� ����, ����, �Ǽ�, ���ڿ�, boolean, �ĺ��ڸ�
 **        ã�Ƽ� �Է��ϴ� �Լ����� �����Ѵ�.
 **
 **    o ��� �� :
 **        char c = getChar();           //  ���ڸ� �Է��Ͽ� char ������ ��ȯ 
 **        int n = getInt();             // �ԷµǴ� ���ڿ����� ù��° ������ ã�� int ������ ��ȯ
 **        int n = getLong();            // �ԷµǴ� ���ڿ����� ù��° ������ ã�� long ������ ��ȯ
 **        double d = getDouble()        // �ԷµǴ� ���ڿ����� ù��° �Ǽ��� ã�� double ������ ��ȯ
 **        float f = getFloat()          // �ԷµǴ� ���ڿ����� ù��° �Ǽ��� ã�� float ������ ��ȯ
 **        char * name = getString();    // '\n'�� �Էµ� ������ �Էµ� ���ڵ��� String ������ ��ȯ
 **        int bool = getBoolean();      // �ԷµǴ� ���ڿ����� true �Ǵ� false�� ã�� boolean ������ ��ȯ
 **        char * id = getIdentifier();  // �ԷµǴ� ���ڿ����� Java�� �ĺ��ڸ� ã�� String ������ ��ȯ
 **                                      //   �ĺ����� ù����: (������ �ѱ� _ $), �����κ�: (������ �ѱ� ���� _ $)
 **    o ���� ����: 2016�� 2�� 19��
 **
 **    o �������
 **        �� ��� ������ �Լ����� ǥ���Է��� Ű������ ��쿡�� �� �����Ѵ�.
 **        �׷��� ǥ���Է��� Ű���尡 �ƴϰ� ���� ������ ����� ���¿��� �Է� �Լ��� ȣ��Ǹ�
 **        ó�� �߿� getcharPrivate()���� EOF(End Of File) ���ڸ� ������ -1�� ��ȯ�Ǹ�,
 **        �̶��� �Է��� ����� ó������ �ʰ� ������ �߻��� �� �ִ�.
 **        �̸� ���� ���� ó���� �� �� ������ �����ϰ� ����ϰ� �ϱ� ���� ���� ó���� ���� �ʾ���
 */

#define MAX_LENGTH_OF_PEEKCHARS  100
int peekChars[MAX_LENGTH_OF_PEEKCHARS]; // �ִ� 100���� ���� ���ڸ� �ٽ� �б� ���� �����ϴ� peekChars �迭
int peekcIndex = -1;	       // peekChars �迭������ ������ ���� ��ġ, -1�̸� ����� ���ڰ� ����

int sign;  // ���� ���� �Ǵ� �Ǽ��� ��ȣ�� ����ϱ� ���� ����


// getcharPrivate() : �� ���ڸ� �б� ���� ���� ���� �Լ�.
//   peekcIndex�� -1�� �ƴϸ� peekChars[peekcIndex]�� ��ȯ
//   peekcIndex�� -1�̸� in.read()�� �̿��Ͽ� �� ���ڸ� �о����
int getcharPrivate() {
	int retval;

	if (peekcIndex >=  0) {
		// peekcIndex�� -1�� �ƴϸ� peekChars[peekcIndex]�� ��ȯ�ϰ�, peekcIndex ����
		retval = peekChars[peekcIndex--];
	}
	else
	   retval = getchar() ;

	return retval ;  // Ű���忡�� �Էµ� ���ڸ� �о� ��ȯ

}


// skUngetc(): in.read()�� �̿��Ͽ� �̹� �Է��� ���ڸ� �ٽ� ���� �� �ֵ��� peekChars �迭�� �����ϴ� �Լ�
void skUngetc(int c) {
	peekChars[++peekcIndex] = c;	// peekcIndex�� 1 ������ �� �־��� ���ڸ� peekChars[peekcIndex]�� ����
}

// removeLastNewLineChar(): ����, �Ǽ�, ���ڿ�, �ĺ��� ���� �б� ���� �Էµ� '\r', '\n'�� ���Ž�Ŵ
//   ����, �Ǽ�, ���ڿ�, �ĺ��� ���� �б� ���� �Էµ� ������ '\r', '\n'�� ���Ž���
//   ������ getChar()�� ���� �� '\r', '\n'�� �������� �ʰ� ��
//   �� �Լ��� �ݵ�� getLong(), getDouble(), getString(),  getIndeifier()�Լ��� ���̸����� ȣ��Ǿ�� ��
void removeLastNewLineChar() {
	int c1;
    if ( (c1 = getcharPrivate()) == '\n') {
    	return;
	} else
		skUngetc(c1);
}


// skipUntilDigit() : ù ����Ʈ�� ���� ������ ���ڵ��� skip�Ͽ� ù ����Ʈ�� ��ȯ�ϴ� �Լ�
//   �� ������ȣ�� ����Ʈ �տ� ���� ������ sign �ʵ带 -1�� �����.
int skipUntilDigit() {
	int c;

	sign = 1;    // sign�� +�� �����ϰ� ��
	while((c=getcharPrivate()) != -1)  {
		if (c>='0' && c <= '9')  // ���� ���ڰ� ����Ʈ�̸� �̸� ��ȯ
			return c;
		else if (c == '-')       // ���� ���ڰ� '-'�̸� sign�� ����(-1)��
			sign = -1;
		else
			sign = 1;	         // �׿ܴ� �����ϰ� sign�� ���(1)�� set
	}

	return -1;
}

// skipUntilDigitOrDot() : ù ����Ʈ �Ǵ� '.'�� ���� ������ ���ڵ��� skip�Ͽ� ù ����Ʈ�� ��ȯ�ϴ� �Լ�
//   �� ������ȣ�� ����Ʈ �տ� ���� ������ sign �ʵ带 -1�� �����.
//   ��ŵ�� �� �� ��ȣ(+/-)�� ��Ÿ���� �̸� ǥ���ϱ� ���� sing ������ 1/-1���� ������
//   �Ǽ����� +.123 �Ǵ� -.123 ���� ������ ���� '.' ������ �Էµ� ��ȣ�� ó����
int skipUntilDigitOrDot() {
	int c, cPriv = -1;

	sign = 1;    // sign�� +�� �����ϰ� ��

	while((c=getcharPrivate()) != -1)  {
		if (c>='0' && c <= '9' || c == '.')  // ���� ���ڰ� ����Ʈ �Ǵ� '.'�̸� �̸� ��ȯ
			return c;
		else if (c == '+' || (c=='.' && cPriv=='+'))         // ���� ���ڰ� '+' �Ǵ� "+."�̸� sign�� ���(1)��
			sign = 1;
		else if (c == '-' || (c=='.' && cPriv=='-'))         // ���� ���ڰ� '-' �Ǵ� "-."�̸� sign�� ����(-1)��
			sign = -1;
		else
			sign = 1;	     // �׿ܴ� �����ϰ� sign�� ���(1)�� set

		cPriv = c;
	}

	return -1;
}


// longStringToLong(char *p): ���� ���ڿ��� long ������ ��ȯ�Ͽ� ��ȯ 
long longStringToLong(char *p) {
	long l = 0;

	while(*p)
		l = l * 10 + *p++ - '0';

	return l;
}

// getLongStringWithoutSkip() : ǥ���Է¿����� ��ŵ���� ����Ʈ ���ڵ鸦 �о� String Ÿ���� ������ ��ȯ�Ͽ� ��ȯ�ϴ� �Լ�
//     ����Ʈ�� �ƴ� ���ڴ� ��� ��ŵ�� ���¿��� ȣ���
//     Java������ ���� �߰��� _�� ����Ͽ� �� �ڸ����� ������ �б� ���� ǥ��(1_234_567, 1_____234______567)�ϹǷ� 
//     ���� �߰��� _�� ������


char *getLongStringWithoutSkip() {
	int c;
	char *p = strbuf;

	int countUnderScore = 0;  // ���� �߰��� ��Ÿ���� ���ӵ� _�� ����

	while((c = getcharPrivate()) >='0' && c <='9' || c == '_')  { // ���ӵǴ� ����Ʈ �Ǵ� _�� ���Ͽ�
		if (c >= '0' && c <= '9') {
			*p++ = (char) c;         //   ���ڿ��� ���ӷ� ��ȯ
			countUnderScore = 0;
		}
		else if (c == '_') {  // -�� �ԷµǸ�
			countUnderScore++; // ���ӵ� _�� ������ 1 ������Ŵ
		}
	}

	if (countUnderScore > 0)  {  // ������ ���� �� �Էµ� _�� ��� skUngetc��Ŵ
		int i = 0;
		for (i=0; i<countUnderScore; i++)
			skUngetc('_');
	}

	*p = 0;

	skUngetc(c);           // ������ ���� ���ڴ� ���� getcharPrivate()�� �е��� ����

//	printf("  <For debug in getLongStringWithoutSkip() > s = %s \n", strbuf);

	return strbuf ;
}

// getLongWithoutSkip() : ǥ���Է¿����� ��ŵ���� ����Ʈ ���ڵ鸦 �о� lopn Ÿ���� ������ ��ȯ�Ͽ� ��ȯ�ϴ� �Լ�
//     ����� �ƴ϶� ������ ó��, ����Ʈ�� �ƴ� ���ڴ� ��� ��ŵ�� ���¿��� ȣ���
//     �� �Լ��� ȣ��Ǳ� ���� ��ȣ�� ó���Ǿ� sign ������ ����Ǿ� �����Ƿ� sign�� ������
long getLongWithoutSkip() {
	return sign * longStringToLong(getLongStringWithoutSkip());
}
// getintWithoutSkip() : ǥ���Է¿����� ��ŵ���� �������ڵ鸦 �о� int Ÿ���� ������ ��ȯ�Ͽ� ��ȯ�ϴ� �Լ�
//     ����� �ƴ϶� ������ ó��, ����Ʈ�� �ƴ� ���ڴ� ��� ��ŵ�� ���¿��� ȣ���
int getIntWithoutSkip() {
	return (int) getLongWithoutSkip();
}



// �Ҽ��� ������ �Ǻκθ� �о����
double getDoubleUnderPoint() {
	char * longString = getLongStringWithoutSkip();  // �Ҽ��� ������ ������ �о� ���ڿ��� ��ȯ
	int noDigit = strlen(longString);   // �Ҽ��� ������ ������ �ڸ��� ����

//	printf("  <for debug in getDoubleUnderPoint() > s= %s,    noDigit=%d \n", longString, noDigit);

	long  nUnerPoint  = longStringToLong(longString);  // �Ҽ��� ������ long ���� ����


	return  (double) nUnerPoint / powor10(noDigit);  // '.' ���� �����θ� 10^�ڸ����� ������ �Ҽ��η� ��ȯ
}





// �־��� ������ �ڸ����� �����Ͽ� ��ȯ
int getNoDigit(int n) {
	int no = 0;

	while (n != 0) {
		no++;
		n = n / 10;
	}

	return no;
}


// 10�� n �������� ��ȯ
double powor10(long n) {
	double pow = 1.;
//	printf("\n  <for debug in power10 > n = %d \n", n);
	int sign = 1;

	if (n < 0) {
		sign = -1;
		n = -n;
	}


	while(n-- > 0) {
		pow = pow * 10;
	}

	if (sign < 0)
		pow = 1. / pow;

//	printf("\n  <for debug in power10 > pow = %lf  %e\n", pow, pow);

	return pow;
}

void strcopy(char *d, char *s) {
	while (*d++ = *s++)
		;
}

// getChar() : ǥ���Է¿����� ���ڵ鸦 �о� ��ȯ�ϴ� �Լ�
//
char getChar() {
	return (char) getcharPrivate();
}

// skGetChar() : ǥ���Է¿����� ���ڵ鸦 �о� ��ȯ�ϴ� �Լ�
//
char skGetchar() {
	return getChar();
}


// getLong() : ǥ���Է¿����� �������ڵ鸦 �о� lopn Ÿ���� ������ ��ȯ�Ͽ� ��ȯ�ϴ� �Լ�
//     ����� �ƴ϶� ������ ó��, ���� ���� ����Ʈ�� �ƴ� ���ڴ� ��ŵ��
//      ���� �߰����� _�� ������(1_234_567, 1_____234______567)
long getLong() {
	int c;

	c = skipUntilDigit();   // ù ��° ����Ʈ�� ���� ������ ���ڸ� �о� ������
	skUngetc(c);              // ���� ù ��° ����Ʈ�� �ٽ� �б� ���� ungetc��Ŵ

	long l = getLongWithoutSkip(); // ��ŵ ���� ������ �о� long ������ ��ȯ

	removeLastNewLineChar();  // ����, �Ǽ�, ���ڿ�, �ĺ��� ���� �б� ���� �Էµ� '\r', '\n'�� ���Ž�Ŵ
	return l;
}

// getInt() : ǥ���Է¿����� �������ڵ鸦 �о� int ������ ��ȯ�Ͽ� ��ȯ�ϴ� �Լ�
//     ����� �ƴ϶� ������ ó��, ���� ���� ����Ʈ�� �ƴ� ���ڴ� ��ŵ��
int getInt() {
	return (int) getLong() ;
}


// getDouble() : 23.45, -12.3, -0.0123, +.01234, -.1234e33 1.234e+12, 1.234E-12 ��
//  �Ǽ� ���� �Է��Ͽ� double ������ ��ȯ�ϴ� �Լ�
//    �Ǽ� ����: "[+/-������].[�Ҽ���]E/e[+/-������]"
//
//    �Ǽ� �Է��� ���� �ݵ�� ���ڰ� . ���� ��Ÿ������ . ������ ���ڰ� ��Ÿ���� ��
//    �ùٸ� �Ǽ��� �Է��ϴ� ���� �ټ� �����
//       ���� ��� "...---.-12.345.012"�� �ԷµǸ� -12.345���� �Է��ؾ��ϹǷ�
//    �����ΰ� �����鼭 '.' ������ �Ҽ��� ����Ʈ�� �Էµ��� ������ �ٽ� �Ǽ� �Է��� ���۵Ǿ�� �Ѵ�.
double getDouble() {
	long n = 0;          // ������ ������ ����
	double d = 0;       // �Ҽ��� ������ ����
	long exp = 0;        // ������ ������ ����

	int signInt = 1;    // ��ȣ�� ������ ����
	int c;

	c = skipUntilDigitOrDot();   // ù ��° ����Ʈ �Ǵ� '.'�� ��´�
	signInt = sign;       // �������� ��ȣ�� ����

	skUngetc(c);           // ��� ���� ���ڸ� �ٽ� �б� ���� skUngetc()

	int isThereIntPart = 0;          // ������ ���� ������ ����
	int isThereUnderPointtPart = 0;  // �Ҽ��� ���� ������ ����

	if (c>='0' && c<='9') { // �����ΰ� �����ϸ�
		n = getLongWithoutSkip();         // ����Ʈ �ƴ� ���ڿ� ���� ��ŵ ���� ������ �Է�
		isThereIntPart = 1;
	}

	c = getcharPrivate();  // �Ҽ��θ� Ȯ���ϱ� ���� ���ڸ� ����

	if (c=='.') {   // ������  '.' ���ڰ� ������ ��Ÿ���� �Ҽ��ΰ� ���۵� ���ɼ��� �����Ƿ�
		int c2 = getcharPrivate();
		if (c2>='0' && c2 <='9') {      // '.' ���� ���� ���ڰ� ���� ����Ʈ �����̸� �Ҽ��ΰ� �����ϹǷ� �̸� ó��
			skUngetc(c2);                 // ��� ���� ���ڸ� �ٽ� �б� ���� skUngetc()
			d = getDoubleUnderPoint();  // �Ҽ��θ� �Է�

			isThereUnderPointtPart = 1;
		}
		else {      // '.' ������ �Ҽ��ΰ� ��Ÿ���� �ʴ� ����̹Ƿ�
			if (isThereIntPart) {  // �����ΰ� ������ �Ҽ��δ� 0��
				d = 0;  // �Ҽ��δ� 0
				skUngetc(c2);           // ���� ���ڸ� �ٽ� �б� ���� ����
			}
			else {  // �����ε� ���� �Ҽ��ε� ������ �Ǽ��� �Է��� �ȵ� �����̹Ƿ� '.'�� c�� �����ϰ� �ٽ� �Ǽ� �Է� �õ�
				skUngetc(c2);           // ���� ���ڸ� �ٽ� �б� ���� ����
				return getDouble();   // ���ݱ����� �Է��� �����ϰ� ���ο� �Ǽ��� �Է��ϹǷ� ��� ȣ���� ����
			}
		}
	}
	else
		skUngetc(c); // �Ҽ��ΰ� ������ ���� ���ڸ� skUngetc()

	c = getcharPrivate();  // �����θ� Ȯ���ϱ� ���� ���ڸ� ����
	if (c=='e' || c=='E') { // e �Ǵ� E�� �����ΰ� ���۵Ǹ�
		int c2 = getcharPrivate();

		if (c2 >= '0' && c2 <= '9') {  // ��ȣ�� ���� �����ΰ� ������
			skUngetc(c2); // ���� ����Ʈ ���ڸ� �ٽ� �б� ���� ����

			exp = getIntWithoutSkip();         // ����Ʈ �ƴ� ���ڿ� ���� ��ŵ ���� ������ �Է��Ͽ� ������ ������ ����
		}
		else { // ��ȣ �ִ� �����ΰ� �ִ°��� üũ�Ͽ� ó����
			if (c2 == '+' || c2 == '-') {
				int c3 = getcharPrivate();
				if (c3 >= '0' && c3 <= '9') {  // +/- ������ �������� ������ ������
					skUngetc(c3); // ���� ���ڸ� �ٽ� �б� ���� ����

					exp = getIntWithoutSkip(); // ����Ʈ �ƴ� ���ڿ� ���� ��ŵ ���� ������ �Է��Ͽ� ������ ������ ����
					exp = exp * ( (c2 == '+') ? 1 : -1 ) ;   // +�����δ� 1, -�����δ� -1�� ����

//					printf("\n  <for debug in getDouble() > c2 = %c, exp = %d \n", c2, exp);
				}
				else {  // e�� �����ϰ� +/-�� �ԷµǾ�����  +/- ������ ���� �ƴϸ� �����ΰ� ���� ������ ó��
					skUngetc(c3);
					skUngetc(c2);
					skUngetc(c);
				}
			}
			else { // e�� ���������� ����, + , -�� �ƴϸ� �����ΰ� ���� ������ ó��
				skUngetc(c2);
				skUngetc(c);
			}
		}
	}
	else
		skUngetc(c); // �����ΰ� ������ ���� ���ڸ� skUngetc()

	if (signInt == 1) // ���� �������� ��ȣ�� ����
		d = n + d;	    // ��ȣ�� ����̸� �Ҽ��θ� �����ο� �ܼ��� ������
	else
		d = n - d;     // ��ȣ�� �����̸� �Ҽ��θ� �����ο��� ���־�� ��

	if (exp != 0)      //  �����ΰ� ������ �����θ�ŭ ������
		d = d * powor10(exp);

	removeLastNewLineChar();  // ����, �Ǽ�, ���ڿ�, �ĺ��� ���� �б� ���� �Էµ� '\r', '\n'�� ���Ž�Ŵ

	return d;
}

// getFoloat() : 23.45, -12.3, -0.012_3, +.012_34, -.1234e3_3 1.234e+12, 1.234E-1_2 ��
//  Java�� �Ǽ� ���� �Է��Ͽ� float ������ ��ȯ�ϴ� �Լ�
//    �Ǽ� ����: "[+/-������].[�Ҽ���]E/e[+/-������]"
float getFloat() {
	return (float) getDouble();
}


int nextInt() {
	return getInt();
}


// isAlphabet() : �־��� ���ڰ� Java�� �ĺ����� ���ĺ�Ʈ�� �ش�Ǵ����� �˻��ϴ�  �Լ�
//  ���ĺ�Ʈ: ������, �ѱ�, '_', '$'
//  (�׸��� ����, �߱��� ����, �Ϻ��� ���� � ���ĺ�Ʈ�� ���Եǳ� ���⿡���� ó������ ����)
int isAlphabet(int c) {
	if (c>='A' && c <= 'Z' || c>='a' && c <= 'z' )  // ���� ���ڰ� �������̸� �̸� ��ȯ
		return 1;
	// �����ڵ忡�� �ѱ� ������ ������ '��'(12593)���� '��'(12643)���� ������
	// �����ڵ忡�� �ѱ� ���ڴ� '��'('\uAC00': 44032)���� '�R'('\uD7A3': 55203)���� ������
	else if (c >= 12593 && c <= 12643)   // ���� ���ڰ� �ѱ� ���� �Ǵ� �����̸� �̴� �ĺ��� ù���ڿ� �ش��
		return 1;
	else if (c >= 44032 && c <= 55203)   // ���� ���ڰ� �ѱ� �����̸� �̴� �ĺ��� ù���ڿ� �ش��
		return 1;

	return 0;

}

// skipUntilFistCharOfIentifier() : �ĺ����� ù������ ������, �ѱ�, '_', '$'�� ���� ������
//   ���ڵ��� skip�Ͽ� �ĺ����� ù ���ڸ� ��ȯ�ϴ� �Լ�
int skipUntilFistCharOfIentifier() {
	int c;

	while(1)  {
		c = getcharPrivate();

		if (isAlphabet(c))      // ���� ���ڰ� ���ĺ�Ʈ�̸� �̴� �ĺ��� ù���ڿ� �ش�, �̸� ��ȯ
			return c;
		else if (c == '_' || c=='$')    // ���� ���ڰ� '_' �Ǵ� "$"�̸� �̴� �ĺ��� ù���ڿ� �ش�, �̸� ��ȯ
			return c;
	}
}    

// getTailOfID(int head): Java �ĺ����� �����κ��� �Է��Ͽ� �־��� ��幮�� head�� �Բ� ��ü �ĺ��ڸ� �����Ͽ� ���ڿ��� ��ȯ
//  �ĺ����� ù����: ������, �ѱ�, '_', '$'
//  �ĺ����� �����κ�: ������, �ѱ�, ����, '_', '$'
char * getTailOfID(int head) {
	int i=0;

	int c;



	strbuf[0] = (char) head;
	i++;

	while(1)  {
		c = getcharPrivate();
		//			printf("  o tail of identifier = '" + (char) c + "' (" + c + ")");

		if (isAlphabet(c))              // ���� ���ڰ� ���ĺ�Ʈ�̸� �̴� �ĺ��� ������ �ش��
			strbuf[i++] = (char) c;
		else if (c == '_' || c=='$')    // ���� ���ڰ� '_' �Ǵ� "$"�̸� �̴� �ĺ��� ������ �ش��
			strbuf[i++] = (char) c;
		else if (c >= '0' && c<='9')         // ���� ���ڰ� ����Ʈ�̸� �̴� �ĺ��� ������ �ش��
			strbuf[i++] = (char) c;
		else
			break;
	}

	skUngetc(c); // ������ ���� ���ڴ� �ĺ��� ���� �ƴϹǷ� ������ ���� �� �ֵ��� skUngetc��Ŵ

	strbuf[i] = 0;
	
	char *id = (char *) malloc(strlen(strbuf) + 1);   // �о���� ���ڿ��� �����ϱ� ���� ���� �Ҵ����
	strcopy(id, strbuf);                    // �̾��� ���ڿ��� �Ҵ���� ������ ������    

	return id;                             // ����� �ĺ��� ���ڿ��� ��ȯ 
}


// getIdentifier() : Java�� �ĺ��ڸ� �Է��Ͽ� ��ȯ�ϴ� �Լ�
//  �ĺ����� ù����: ������, �ѱ�, '_', '$'
//  �ĺ����� �����κ�: ������, �ѱ�, ����, '_', '$'
//  (�׸��� ����, �߱��� ����, �Ϻ��� ���� � �ĺ��ڿ� ���Եǳ� ���⿡���� ó������ ����)
char * getIdentifier()  {
	int head = skipUntilFistCharOfIentifier(); // �ĺ����� ù ���ڸ� ã�� �Է��Ͽ� ��ȯ
	//		printf("  o head of identifier = '" + (char) head + "' (" + head + ")");

	char * identifier = getTailOfID(head); // �ĺ����� �����κ��� �Է��Ͽ� ù ���� head�� �����Ͽ� ��ȯ

	removeLastNewLineChar();  // ����, �Ǽ�, ���ڿ�, �ĺ��� ���� �б� ���� �Էµ� '\r', '\n'�� ���Ž�Ŵ

	return identifier;
}

// getBoolean() : "true" �Ǵ� "false"�� �Է��Ͽ� 1 �Ǵ� 0�� boolean ������ ��ȯ�ϴ� �Լ�
//    "true" �Ǵ� "false"�� �Է��ϱ� ���� �ĺ��ڰ� �ݵ�� ���� ��Ÿ���� ��
//    �Էµ� �ĺ��ڰ� "true" �Ǵ� "false"�̸� boolean Ÿ���� 1 �Ǵ� 0��  ��ȯ,
//    �׷��� ���� ��� ���� �ĺ��ڸ� �Է��Ͽ� Ȯ���� �ݺ���
int getBoolean()  {
	while (1) {
		char * id = getIdentifier();

//		printf("  o identifier = '%s'", id);

		if (strcmp(id, "true") == 0)
			return 1;
		else if (strcmp(id, "false") == 0)
			return 0;
	}
}

// getString() : '\n', '\r', -1�� �Էµ� ������ �Էµ� ���ڵ��� String ������ ��ȯ
//    ����Ű�� '\n', '\r' �ΰ��� ���ڷ� �̷������ ��츦 ����
//    ó���� ��Ÿ���� '\n', '\r' ���ڴ� �����Ѵ�.
char * getString()  {
	int i=0;

	int c;

	while((c = getcharPrivate()) != '\n' &&  c != '\r' && c != -1)
		strbuf[i++] = (char) c;
		
	skUngetc(c);

	strbuf[i] = 0;
	
	removeLastNewLineChar();  // ����, �Ǽ�, ���ڿ�, �ĺ��� ���� �б� ���� �Էµ� '\r', '\n'�� ���Ž�Ŵ

    char *str = (char *) malloc(strlen(strbuf) + 1);   // �о���� ���ڿ��� �����ϱ� ���� ���� �Ҵ���� 
	strcopy(str, strbuf);                    // �̾��� ���ڿ��� �Ҵ���� ������ ������         

	return str;                             // ����� ���ڿ��� ��ȯ 
}

// ����Ʈ ���ڰ� �Էµ� �������� ���ڵ��� �о� String ���ڿ��� ��ȯ
char * getStringUntilNotDigit()  {
	int i=0;

	int c;


	while((c =  getcharPrivate()) >= '0' &&  c <= '9' )
		strbuf[i++] = (char) c;

	skUngetc(c);  // ������ ���� ���ڸ� �ٽ� ���� �� �ֵ��� skUngetc()

	strbuf[i] = 0;

	return strbuf;
}

char * nextString() {
	return getString();
}


/*
 * ������Ʈ �޽����� ����� �� ������ �Է��ϴ� �Լ���
 *
 * �Է��� �� ������Ʈ �޽��� ���� �Է��� �ϸ� ����ڴ� ������ ��ٸ��� ��찡 �߻��Ѵ�.
 * �̷��� ��츦 �����ϱ� ���� �Է½ÿ��� �޽����� �̸� ����Ͽ�
 * �Է��� �������� �뵵�� ����� �˷��ִ� �޽����� ������Ʈ �޽����� �Ѵ�.
 *
 * Ư�� Ű���忡���� �Է½� ������Ʈ �޽����� �߿��ϴ�.
 */

// ������Ʈ �޽����� ���� �Է�
char getCharWithPrompt(char * msg) {
	printf(msg);
	return skGetchar();
}

// ������Ʈ �޽����� int ���� �Է�
int getIntWithPrompt(char * msg) {
	printf(msg);
	return getInt();
}

// ������Ʈ �޽����� long ���� �Է�
long getLongWithPrompt(char * msg) {
	printf(msg);
	return getLong();
}

// ������Ʈ �޽����� double �Ǽ� �Է�
double getDoubleWithPrompt(char * msg) {
	printf(msg);
	return getDouble();
}

// ������Ʈ �޽����� float �Ǽ� �Է�
float getFloatWithPrompt(char * msg) {
	printf(msg);
	return getFloat();
}

// ������Ʈ �޽����� boolean �� �Է�
int getBooleanWithPrompt(char * msg) {
	printf(msg);
	return getBoolean();
}

// ������Ʈ �޽����� ���ڿ� �Է�
char * getStringWithPrompt(char * msg) {
	printf(msg);
	return getString();
}

//	// ������Ʈ �޽����� �ĺ��� �Է�
	char * getIdentifierWithPrompt(char * msg) {
		printf(msg);
		return getIdentifier();
}


int main1(int argc, char * argv[]) {
		while(1) {

			/*
			 *  �� �κ��� �׽�Ʈ�� ���� �κ���
			 *
			 *  �Է� �Լ��� �ѹ��� ȣ����
			 */
// 
//
//			printf("\n  o input int (�ִ밪: %d ) > ", (0x7FFFFFFF));
//			int no = getInt();
//			printf("  * int = %d", no);
//
//			printf("\n  o input long(�ִ밪: : %ld ) > ", (0x7FFFFFFFFFFFFFFFL));
//			long l = getLong();
//			printf("  * long = %ld", l);

			printf("\n  o input double > ");
			double  d = getDouble();
			printf("  * double = %lf ( %e )", d, d);
			printf("\n  o input char > ");
			char c = skGetchar();
			printf("  * char = %c, (%d))", c, (int) c );

			printf("\n  o input String > ");
			char * s = getString();
			printf("  * String = '%s'", s);

			printf("\n  o input identifier > ");
			char * id = getIdentifier();
			printf("  * identifier = %s", id);

			printf("\n  o input boolean (true or false) > ");
			int b = getBoolean();
				printf("  * boolean = %s", (b==1 ? "true" : "false"));
				

       	/*
		 * ������Ʈ �޽����� ����ϴ� �Է� �Լ� ȣ��
		 */
		c = getCharWithPrompt("\n  o input char > ");
		printf("  * char = %c (%d)", c, c);
		
		int no = getIntWithPrompt("\n  o input int > ");
		printf("  * int = %d", no);
		
		d = getDoubleWithPrompt("\n  o input double > ");
	    printf("  * double = %lf ( %e ))", d, d);

		s = getStringWithPrompt("\n  o input String > ");
		printf("  * String = '%s''", s);
		
		id = getIdentifierWithPrompt("\n  o input identifier > ");
			printf("  * identifier = %s", id);
	
		b = getBooleanWithPrompt("\n  o input boolean (true or false) > ");
		printf("  * boolean = %s", (b==1 ? "true" : "false"));

		printf("\n** End **\n");

		}
	}

