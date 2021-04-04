
#include <stdio.h>
#include <string.h>
#include <malloc.h>
typedef char * String;


#define MAX_LENGTH_OF_STRING  2000
char strbuf[MAX_LENGTH_OF_STRING];  // ÀĞ¾îµéÀÎ ¹®ÀÚ¿­À» ÀúÀåÇÏ±â À§ÇÑ ¹öÆÛ 

double powor10(long n);

/*
 ** SkScanner.h: ±è¼º±â ±³¼ö°¡ ÀÛ¼ºÇÑ ÀÔ·ÂÀ» À§ÇÑ ÇÔ¼ö¸¦ ¸ğÀº Çì´õ ÆÄÀÏ 
 **    o ÀÌ SkScanner.h´Â ÀÚÀ¯·Ó°Ô ÀÔ·ÂµÈ µ¥ÀÌÅÍ Áß¿¡¼­ ¹®ÀÚ, Á¤¼ö, ½Ç¼ö, ¹®ÀÚ¿­, boolean, ½Äº°ÀÚ¸¦
 **        Ã£¾Æ¼­ ÀÔ·ÂÇÏ´Â ÇÔ¼öµéÀ» Á¤ÀÇÇÑ´Ù.
 **
 **    o »ç¿ë ¿¹ :
 **        char c = getChar();           //  ¹®ÀÚ¸¦ ÀÔ·ÂÇÏ¿© char °ªÀ¸·Î ¹İÈ¯ 
 **        int n = getInt();             // ÀÔ·ÂµÇ´Â ¹®ÀÚ¿­¿¡¼­ Ã¹¹øÂ° Á¤¼ö¸¦ Ã£¾Æ int °ªÀ¸·Î ¹İÈ¯
 **        int n = getLong();            // ÀÔ·ÂµÇ´Â ¹®ÀÚ¿­¿¡¼­ Ã¹¹øÂ° Á¤¼ö¸¦ Ã£¾Æ long °ªÀ¸·Î ¹İÈ¯
 **        double d = getDouble()        // ÀÔ·ÂµÇ´Â ¹®ÀÚ¿­¿¡¼­ Ã¹¹øÂ° ½Ç¼ö¸¦ Ã£¾Æ double °ªÀ¸·Î ¹İÈ¯
 **        float f = getFloat()          // ÀÔ·ÂµÇ´Â ¹®ÀÚ¿­¿¡¼­ Ã¹¹øÂ° ½Ç¼ö¸¦ Ã£¾Æ float °ªÀ¸·Î ¹İÈ¯
 **        char * name = getString();    // '\n'ÀÌ ÀÔ·ÂµÉ ¶§±îÁö ÀÔ·ÂµÈ ¹®ÀÚµéÀ» String °ªÀ¸·Î ¹İÈ¯
 **        int bool = getBoolean();      // ÀÔ·ÂµÇ´Â ¹®ÀÚ¿­¿¡¼­ true ¶Ç´Â false¸¦ Ã£¾Æ boolean °ªÀ¸·Î ¹İÈ¯
 **        char * id = getIdentifier();  // ÀÔ·ÂµÇ´Â ¹®ÀÚ¿­¿¡¼­ JavaÀÇ ½Äº°ÀÚ¸¦ Ã£¾Æ String °ªÀ¸·Î ¹İÈ¯
 **                                      //   ½Äº°ÀÚÀÇ Ã¹±ÛÀÚ: (¿µ¹®ÀÚ ÇÑ±Û _ $), ²¿¸®ºÎºĞ: (¿µ¹®ÀÚ ÇÑ±Û ¼ıÀÚ _ $)
 **    o ÃÖÁ¾ ¼öÁ¤: 2016³â 2¿ù 19ÀÏ
 **
 **    o Âü°í»çÇ×
 **        ÀÌ Çì´õ ÆÄÀÏÀÇ ÇÔ¼öµéÀº Ç¥ÁØÀÔ·ÂÀÌ Å°º¸µåÀÎ °æ¿ì¿¡´Â Àß µ¿ÀÛÇÑ´Ù.
 **        ±×·±µ¥ Ç¥ÁØÀÔ·ÂÀÌ Å°º¸µå°¡ ¾Æ´Ï°í ÆÄÀÏ µîÀ¸·Î º¯°æµÈ »óÅÂ¿¡¼­ ÀÔ·Â ÇÔ¼ö°¡ È£ÃâµÇ¸é
 **        Ã³¸® Áß¿¡ getcharPrivate()¿¡¼­ EOF(End Of File) ¹®ÀÚ¸¦ ¸¸³ª¸é -1ÀÌ ¹İÈ¯µÇ¸ç,
 **        ÀÌ¶§ÀÇ ÀÔ·ÂÀº Á¦Àç·Î Ã³¸®µÇÁö ¾Ê°í ¿À·ù°¡ ¹ß»ıÇÒ ¼ö ÀÖ´Ù.
 **        ÀÌ¸¦ À§ÇØ ¿¹¿Ü Ã³¸®¸¦ ÇÒ ¼ö ÀÖÀ¸³ª °£ÆíÇÏ°Ô »ç¿ëÇÏ°Ô ÇÏ±â À§ÇØ ¿¹¿Ü Ã³¸®´Â ÇÏÁö ¾Ê¾ÒÀ½
 */

#define MAX_LENGTH_OF_PEEKCHARS  100
int peekChars[MAX_LENGTH_OF_PEEKCHARS]; // ÃÖ´ë 100°³ÀÇ ÀĞÀº ¹®ÀÚ¸¦ ´Ù½Ã ÀĞ±â À§ÇØ ÀúÀåÇÏ´Â peekChars ¹è¿­
int peekcIndex = -1;	       // peekChars ¹è¿­¿¡¼­ÀÇ ¸¶Áö¸· ÀúÀå À§Ä¡, -1ÀÌ¸é ÀúÀåµÈ ¹®ÀÚ°¡ ¾øÀ½

int sign;  // ÀĞÀº Á¤¼ö ¶Ç´Â ½Ç¼öÀÇ ºÎÈ£¸¦ ±â·ÏÇÏ±â À§ÇÑ º¯¼ö


// getcharPrivate() : ÇÑ ¹®ÀÚ¸¦ ÀĞ±â À§ÇÑ ³»ºÎ Àü¿ë ÇÔ¼ö.
//   peekcIndex°¡ -1ÀÌ ¾Æ´Ï¸é peekChars[peekcIndex]¸¦ ¹İÈ¯
//   peekcIndex°¡ -1ÀÌ¸é in.read()¸¦ ÀÌ¿ëÇÏ¿© ÇÑ ¹®ÀÚ¸¦ ÀĞ¾îµéÀÓ
int getcharPrivate() {
	int retval;

	if (peekcIndex >=  0) {
		// peekcIndex°¡ -1ÀÌ ¾Æ´Ï¸é peekChars[peekcIndex]¸¦ ¹İÈ¯ÇÏ°í, peekcIndex °¨¼Ò
		retval = peekChars[peekcIndex--];
	}
	else
	   retval = getchar() ;

	return retval ;  // Å°º¸µå¿¡¼­ ÀÔ·ÂµÈ ¹®ÀÚ¸¦ ÀĞ¾î ¹İÈ¯

}


// skUngetc(): in.read()¸¦ ÀÌ¿ëÇÏ¿© ÀÌ¹Ì ÀÔ·ÂÇÑ ¹®ÀÚ¸¦ ´Ù½Ã ÀĞÀ» ¼ö ÀÖµµ·Ï peekChars ¹è¿­¿¡ ÀúÀåÇÏ´Â ÇÔ¼ö
void skUngetc(int c) {
	peekChars[++peekcIndex] = c;	// peekcIndex¸¦ 1 Áõ°¡ÇÑ ÈÄ ÁÖ¾îÁø ¹®ÀÚ¸¦ peekChars[peekcIndex]¿¡ ÀúÀå
}

// removeLastNewLineChar(): Á¤¼ö, ½Ç¼ö, ¹®ÀÚ¿­, ½Äº°ÀÚ µîÀ» ÀĞ±â À§ÇØ ÀÔ·ÂµÈ '\r', '\n'À» Á¦°Å½ÃÅ´
//   Á¤¼ö, ½Ç¼ö, ¹®ÀÚ¿­, ½Äº°ÀÚ µîÀ» ÀĞ±â À§ÇØ ÀÔ·ÂµÈ ¸¶Áö¸· '\r', '\n'À» Á¦°Å½ÃÄÑ
//   ´ÙÀ½¿¡ getChar()¸¦ ÇßÀ» ¶§ '\r', '\n'ÀÌ ÀĞÇôÁöÁö ¾Ê°Ô ÇÔ
//   ÀÌ ÇÔ¼ö´Â ¹İµå½Ã getLong(), getDouble(), getString(),  getIndeifier()ÇÔ¼öÀÇ ¸¶¹Ì¸·¿¡¼­ È£ÃâµÇ¾î¾ß ÇÔ
void removeLastNewLineChar() {
	int c1;
    if ( (c1 = getcharPrivate()) == '\n') {
    	return;
	} else
		skUngetc(c1);
}


// skipUntilDigit() : Ã¹ µğÁöÆ®°¡ ³ª¿Ã ¶§±îÁö ¹®ÀÚµéÀ» skipÇÏ¿© Ã¹ µğÁöÆ®¸¦ ¹İÈ¯ÇÏ´Â ÇÔ¼ö
//   ´Ü À½¼öºÎÈ£°¡ µğÁöÆ® ¾Õ¿¡ ³ª¿Ã ¶§¿¡´Â sign ÇÊµå¸¦ -1·Î ¸¸µç´Ù.
int skipUntilDigit() {
	int c;

	sign = 1;    // signÀº +·Î ½ÃÀÛÇÏ°Ô ÇÔ
	while((c=getcharPrivate()) != -1)  {
		if (c>='0' && c <= '9')  // ÀĞÀº ¹®ÀÚ°¡ µğÁöÆ®ÀÌ¸é ÀÌ¸¦ ¹İÈ¯
			return c;
		else if (c == '-')       // ÀĞÀº ¹®ÀÚ°¡ '-'ÀÌ¸é signÀ» À½¼ö(-1)·Î
			sign = -1;
		else
			sign = 1;	         // ±×¿Ü´Â ¹«½ÃÇÏ°í signÀ» ¾ç¼ö(1)·Î set
	}

	return -1;
}

// skipUntilDigitOrDot() : Ã¹ µğÁöÆ® ¶Ç´Â '.'°¡ ³ª¿Ã ¶§±îÁö ¹®ÀÚµéÀ» skipÇÏ¿© Ã¹ µğÁöÆ®¸¦ ¹İÈ¯ÇÏ´Â ÇÔ¼ö
//   ´Ü À½¼öºÎÈ£°¡ µğÁöÆ® ¾Õ¿¡ ³ª¿Ã ¶§¿¡´Â sign ÇÊµå¸¦ -1·Î ¸¸µç´Ù.
//   ½ºÅµÀ» ÇÒ ¶§ ºÎÈ£(+/-)°¡ ³ªÅ¸³ª¸é ÀÌ¸¦ Ç¥½ÃÇÏ±â À§ÇØ sing º¯¼ö¸¦ 1/-1À¸·Î ¼¼ÆÃÇÔ
//   ½Ç¼ö¿¡¼­ +.123 ¶Ç´Â -.123 µîÀÇ ÆĞÅÏÀ» À§ÇØ '.' ÀÌÀü¿¡ ÀÔ·ÂµÈ ºÎÈ£µµ Ã³¸®ÇÔ
int skipUntilDigitOrDot() {
	int c, cPriv = -1;

	sign = 1;    // signÀº +·Î ½ÃÀÛÇÏ°Ô ÇÔ

	while((c=getcharPrivate()) != -1)  {
		if (c>='0' && c <= '9' || c == '.')  // ÀĞÀº ¹®ÀÚ°¡ µğÁöÆ® ¶Ç´Â '.'ÀÌ¸é ÀÌ¸¦ ¹İÈ¯
			return c;
		else if (c == '+' || (c=='.' && cPriv=='+'))         // ÀĞÀº ¹®ÀÚ°¡ '+' ¶Ç´Â "+."ÀÌ¸é signÀ» ¾ç¼ö(1)·Î
			sign = 1;
		else if (c == '-' || (c=='.' && cPriv=='-'))         // ÀĞÀº ¹®ÀÚ°¡ '-' ¶Ç´Â "-."ÀÌ¸é signÀ» À½¼ö(-1)·Î
			sign = -1;
		else
			sign = 1;	     // ±×¿Ü´Â ¹«½ÃÇÏ°í signÀ» ¾ç¼ö(1)·Î set

		cPriv = c;
	}

	return -1;
}


// longStringToLong(char *p): Á¤¼ö ¹®ÀÚ¿­À» long Á¤¼ö·Î º¯È¯ÇÏ¿© ¹İÈ¯ 
long longStringToLong(char *p) {
	long l = 0;

	while(*p)
		l = l * 10 + *p++ - '0';

	return l;
}

// getLongStringWithoutSkip() : Ç¥ÁØÀÔ·Â¿¡¼­ÀÇ ½ºÅµ¾øÀÌ µğÁöÆ® ¹®ÀÚµé¸¦ ÀĞ¾î String Å¸ÀÔÀÇ °ªÀ¸·Î º¯È¯ÇÏ¿© ¹İÈ¯ÇÏ´Â ÇÔ¼ö
//     µğÁöÆ®°¡ ¾Æ´Ñ ¹®ÀÚ´Â ¸ğµÎ ½ºÅµµÈ »óÅÂ¿¡¼­ È£ÃâµÊ
//     Java¿¡¼­´Â Á¤¼ö Áß°£¿¡ _¸¦ Çã¿ëÇÏ¿© ±ä ÀÚ¸®¼öÀÇ Á¤¼ö¸¦ ÀĞ±â ½±°Ô Ç¥Çö(1_234_567, 1_____234______567)ÇÏ¹Ç·Î 
//     Á¤¼ö Áß°£ÀÇ _´Â ¹«½ÃÇÔ


char *getLongStringWithoutSkip() {
	int c;
	char *p = strbuf;

	int countUnderScore = 0;  // Á¤¼ö Áß°£¿¡ ³ªÅ¸³ª´Â ¿¬¼ÓµÈ _ÀÇ °³¼ö

	while((c = getcharPrivate()) >='0' && c <='9' || c == '_')  { // ¿¬¼ÓµÇ´Â µğÁöÆ® ¶Ç´Â _¿¡ ´ëÇÏ¿©
		if (c >= '0' && c <= '9') {
			*p++ = (char) c;         //   ¹®ÀÚ¿­¿¡ Á¢¼Ó·Î º¯È¯
			countUnderScore = 0;
		}
		else if (c == '_') {  // -°¡ ÀÔ·ÂµÇ¸é
			countUnderScore++; // ¿¬¼ÓµÈ _ÀÇ °³¼ö¸¦ 1 Áõ°¡½ÃÅ´
		}
	}

	if (countUnderScore > 0)  {  // Á¤¼ö°¡ ³¡³­ ÈÄ ÀÔ·ÂµÈ _¸¦ ¸ğµÎ skUngetc½ÃÅ´
		int i = 0;
		for (i=0; i<countUnderScore; i++)
			skUngetc('_');
	}

	*p = 0;

	skUngetc(c);           // ¸¶Áö¸· ÀĞÀº ¹®ÀÚ´Â ´ÙÀ½ getcharPrivate()ÀÌ ÀĞµµ·Ï º¸°ü

//	printf("  <For debug in getLongStringWithoutSkip() > s = %s \n", strbuf);

	return strbuf ;
}

// getLongWithoutSkip() : Ç¥ÁØÀÔ·Â¿¡¼­ÀÇ ½ºÅµ¾øÀÌ µğÁöÆ® ¹®ÀÚµé¸¦ ÀĞ¾î lopn Å¸ÀÔÀÇ °ªÀ¸·Î º¯È¯ÇÏ¿© ¹İÈ¯ÇÏ´Â ÇÔ¼ö
//     ¾ç¼ö»Ó ¾Æ´Ï¶ó À½¼öµµ Ã³¸®, µğÁöÆ®°¡ ¾Æ´Ñ ¹®ÀÚ´Â ¸ğµÎ ½ºÅµµÈ »óÅÂ¿¡¼­ È£ÃâµÊ
//     ÀÌ ÇÔ¼ö°¡ È£ÃâµÇ±â Àü¿¡ ºÎÈ£°¡ Ã³¸®µÇ¾î sign º¯¼ö¿¡ ÀúÀåµÇ¾î ÀÖÀ¸¹Ç·Î signÀ» °öÇØÁÜ
long getLongWithoutSkip() {
	return sign * longStringToLong(getLongStringWithoutSkip());
}
// getintWithoutSkip() : Ç¥ÁØÀÔ·Â¿¡¼­ÀÇ ½ºÅµ¾øÀÌ Á¤¼ö¹®ÀÚµé¸¦ ÀĞ¾î int Å¸ÀÔÀÇ °ªÀ¸·Î º¯È¯ÇÏ¿© ¹İÈ¯ÇÏ´Â ÇÔ¼ö
//     ¾ç¼ö»Ó ¾Æ´Ï¶ó À½¼öµµ Ã³¸®, µğÁöÆ®°¡ ¾Æ´Ñ ¹®ÀÚ´Â ¸ğµÎ ½ºÅµµÈ »óÅÂ¿¡¼­ È£ÃâµÊ
int getIntWithoutSkip() {
	return (int) getLongWithoutSkip();
}



// ¼Ò¼öÁ¡ ÀÌÇÏÀÇ ½ÇºÎºÎ¸¦ ÀĞ¾îµéÀÓ
double getDoubleUnderPoint() {
	char * longString = getLongStringWithoutSkip();  // ¼Ò¼öÁ¡ ÀÌÇÏÀÇ Á¤¼ö¸¦ ÀĞ¾î ¹®ÀÚ¿­·Î ¹İÈ¯
	int noDigit = strlen(longString);   // ¼Ò¼öÁ¡ ÀÌÇÏÀÇ Á¤¼öºÎ ÀÚ¸®¼ö ±¸ÇÔ

//	printf("  <for debug in getDoubleUnderPoint() > s= %s,    noDigit=%d \n", longString, noDigit);

	long  nUnerPoint  = longStringToLong(longString);  // ¼Ò¼öÁ¡ ÀÌÇÏÀÇ long °ªÀ» ±¸ÇÔ


	return  (double) nUnerPoint / powor10(noDigit);  // '.' ÀÌÇÏ Á¤¼öºÎ¸¦ 10^ÀÚ¸®¼ö·Î ³ª´©¾î ¼Ò¼öºÎ·Î ¹İÈ¯
}





// ÁÖ¾îÁø Á¤¼öÀÇ ÀÚ¸®¼ö¸¦ ±¸ÇÔÇÏ¿© ¹İÈ¯
int getNoDigit(int n) {
	int no = 0;

	while (n != 0) {
		no++;
		n = n / 10;
	}

	return no;
}


// 10ÀÇ n Áö¼ö°ªÀ» ¹İÈ¯
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

// getChar() : Ç¥ÁØÀÔ·Â¿¡¼­ÀÇ ¹®ÀÚµé¸¦ ÀĞ¾î ¹İÈ¯ÇÏ´Â ÇÔ¼ö
//
char getChar() {
	return (char) getcharPrivate();
}

// skGetChar() : Ç¥ÁØÀÔ·Â¿¡¼­ÀÇ ¹®ÀÚµé¸¦ ÀĞ¾î ¹İÈ¯ÇÏ´Â ÇÔ¼ö
//
char skGetchar() {
	return getChar();
}


// getLong() : Ç¥ÁØÀÔ·Â¿¡¼­ÀÇ Á¤¼ö¹®ÀÚµé¸¦ ÀĞ¾î lopn Å¸ÀÔÀÇ °ªÀ¸·Î º¯È¯ÇÏ¿© ¹İÈ¯ÇÏ´Â ÇÔ¼ö
//     ¾ç¼ö»Ó ¾Æ´Ï¶ó À½¼öµµ Ã³¸®, Á¤¼ö ¾ÕÀÇ µğÁöÆ®°¡ ¾Æ´Ñ ¹®ÀÚ´Â ½ºÅµÇÔ
//      Á¤¼ö Áß°£¿¡´Â _µµ °¡´ÉÇÔ(1_234_567, 1_____234______567)
long getLong() {
	int c;

	c = skipUntilDigit();   // Ã¹ ¹øÂ° µğÁöÆ®¸¦ ¾òÀ» ‹š±îÁö ¹®ÀÚ¸¦ ÀĞ¾î ¹«½ÃÇÔ
	skUngetc(c);              // ÀĞÀº Ã¹ ¹øÂ° µğÁöÆ®¸¦ ´Ù½Ã ÀĞ±â À§ÇØ ungetc½ÃÅ´

	long l = getLongWithoutSkip(); // ½ºÅµ ¾øÀÌ Á¤¼ö¸¦ ÀĞ¾î long °ªÀ¸·Î ¹İÈ¯

	removeLastNewLineChar();  // Á¤¼ö, ½Ç¼ö, ¹®ÀÚ¿­, ½Äº°ÀÚ µîÀ» ÀĞ±â À§ÇØ ÀÔ·ÂµÈ '\r', '\n'À» Á¦°Å½ÃÅ´
	return l;
}

// getInt() : Ç¥ÁØÀÔ·Â¿¡¼­ÀÇ Á¤¼ö¹®ÀÚµé¸¦ ÀĞ¾î int Á¤¼ö·Î º¯È¯ÇÏ¿© ¹İÈ¯ÇÏ´Â ÇÔ¼ö
//     ¾ç¼ö»Ó ¾Æ´Ï¶ó À½¼öµµ Ã³¸®, Á¤¼ö ¾ÕÀÇ µğÁöÆ®°¡ ¾Æ´Ñ ¹®ÀÚ´Â ½ºÅµÇÔ
int getInt() {
	return (int) getLong() ;
}


// getDouble() : 23.45, -12.3, -0.0123, +.01234, -.1234e33 1.234e+12, 1.234E-12 µî
//  ½Ç¼ö °ªÀ» ÀÔ·ÂÇÏ¿© double °ªÀ¸·Î ¹İÈ¯ÇÏ´Â ÇÔ¼ö
//    ½Ç¼ö Çü½Ä: "[+/-Á¤¼öºÎ].[¼Ò¼öºÎ]E/e[+/-Áö¼öºÎ]"
//
//    ½Ç¼ö ÀÔ·ÂÀ» À§ÇØ ¹İµå½Ã ¼ıÀÚ°¡ . Àü¿¡ ³ªÅ¸³ªµçÁö . ´ÙÀ½¿¡ ¼ıÀÚ°¡ ³ªÅ¸³ª¾ß ÇÔ
//    ¿Ã¹Ù¸¥ ½Ç¼ö¸¦ ÀÔ·ÂÇÏ´Â °ÍÀº ´Ù¼Ò ¾î·Á¿ò
//       ¿¹¸¦ µé¾î "...---.-12.345.012"ÀÌ ÀÔ·ÂµÇ¸é -12.345À¸·Î ÀÔ·ÂÇØ¾ßÇÏ¹Ç·Î
//    Á¤¼öºÎ°¡ ¾øÀ¸¸é¼­ '.' ´ÙÀ½¿¡ ¼Ò¼öºÎ µğÁöÆ®°¡ ÀÔ·ÂµÇÁö ¾ÊÀ¸¸é ´Ù½Ã ½Ç¼ö ÀÔ·ÂÀÌ ½ÃÀÛµÇ¾î¾ß ÇÑ´Ù.
double getDouble() {
	long n = 0;          // Á¤¼öºÎ ÀúÀåÇÒ º¯¼ö
	double d = 0;       // ¼Ò¼öºÎ ÀúÀåÇÒ º¯¼ö
	long exp = 0;        // Áö¼öºÎ ÀúÀåÇÒ º¯¼ö

	int signInt = 1;    // ºÎÈ£¸¦ ÀúÀåÇÒ º¯¼ö
	int c;

	c = skipUntilDigitOrDot();   // Ã¹ ¹øÂ° µğÁöÆ® ¶Ç´Â '.'¸¦ ¾ò´Â´Ù
	signInt = sign;       // Á¤¼öºÎÀÇ ºÎÈ£¸¦ ÀúÀå

	skUngetc(c);           // ¹æ±İ ÀĞÀº ¹®ÀÚ¸¦ ´Ù½Ã ÀĞ±â À§ÇØ skUngetc()

	int isThereIntPart = 0;          // Á¤¼öºÎ Á¸Àç À¯¹«¸¦ ÀúÀå
	int isThereUnderPointtPart = 0;  // ¼Ò¼öºÎ Á¸Àç À¯¹«¸¦ ÀúÀå

	if (c>='0' && c<='9') { // Á¤¼öºÎ°¡ Á¸ÀçÇÏ¸é
		n = getLongWithoutSkip();         // µğÁöÆ® ¾Æ´Ñ ¹®ÀÚ¿¡ ´ëÇÑ ½ºÅµ ¾øÀÌ Á¤¼öºÎ ÀÔ·Â
		isThereIntPart = 1;
	}

	c = getcharPrivate();  // ¼Ò¼öºÎ¸¦ È®ÀÎÇÏ±â À§ÇØ ¹®ÀÚ¸¦ ÀĞÀ½

	if (c=='.') {   // ´ÙÀ½¿¡  '.' ¹®ÀÚ°¡ ´ÙÀ½¿¡ ³ªÅ¸³ª¸é ¼Ò¼öºÎ°¡ ½ÃÀÛµÉ °¡´É¼ºÀÌ ÀÖÀ¸¹Ç·Î
		int c2 = getcharPrivate();
		if (c2>='0' && c2 <='9') {      // '.' ¹®ÀÚ ´ÙÀ½ ¹®ÀÚ°¡ ¼ıÀÚ µğÁöÆ® ¹®ÀÚÀÌ¸é ¼Ò¼öºÎ°¡ Á¸ÀçÇÏ¹Ç·Î ÀÌ¸¦ Ã³¸®
			skUngetc(c2);                 // ¹æ±İ ÀĞÀº ¹®ÀÚ¸¦ ´Ù½Ã ÀĞ±â À§ÇØ skUngetc()
			d = getDoubleUnderPoint();  // ¼Ò¼öºÎ¸¦ ÀÔ·Â

			isThereUnderPointtPart = 1;
		}
		else {      // '.' ´ÙÀ½¿¡ ¼Ò¼öºÎ°¡ ³ªÅ¸³ªÁö ¾Ê´Â °æ¿ìÀÌ¹Ç·Î
			if (isThereIntPart) {  // Á¤¼öºÎ°¡ ÀÖÀ¸¸é ¼Ò¼öºÎ´Â 0ÀÓ
				d = 0;  // ¼Ò¼öºÎ´Â 0
				skUngetc(c2);           // ÀĞÀº ¹®ÀÚ¸¦ ´Ù½Ã ÀĞ±â À§ÇØ ÀúÀå
			}
			else {  // Á¤¼öºÎµµ ¾ø°í ¼Ò¼öºÎµµ ¾øÀ¸¸é ½Ç¼ö°¡ ÀÔ·ÂÀÌ ¾ÈµÈ »óÅÂÀÌ¹Ç·Î '.'ÀÎ c´Â ¹«½ÃÇÏ°í ´Ù½Ã ½Ç¼ö ÀÔ·Â ½Ãµµ
				skUngetc(c2);           // ÀĞÀº ¹®ÀÚ¸¦ ´Ù½Ã ÀĞ±â À§ÇØ ÀúÀå
				return getDouble();   // Áö±İ±îÁö´Â ÀÔ·ÂÀ» ¹«½ÃÇÏ°í »õ·Î¿î ½Ç¼ö¸¦ ÀÔ·ÂÇÏ¹Ç·Î Àç±Í È£ÃâÀÌ »ç¿ëµÊ
			}
		}
	}
	else
		skUngetc(c); // ¼Ò¼öºÎ°¡ ¾øÀ¸¸é ÀĞÀº ¹®ÀÚ¸¦ skUngetc()

	c = getcharPrivate();  // Áö¼öºÎ¸¦ È®ÀÎÇÏ±â À§ÇØ ¹®ÀÚ¸¦ ÀĞÀ½
	if (c=='e' || c=='E') { // e ¶Ç´Â E·Î Áö¼öºÎ°¡ ½ÃÀÛµÇ¸é
		int c2 = getcharPrivate();

		if (c2 >= '0' && c2 <= '9') {  // ºÎÈ£°¡ ¾ø´Â Áö¼öºÎ°¡ ÀÖÀ¸¸é
			skUngetc(c2); // ÀĞÀº µğÁöÆ® ¹®ÀÚ¸¦ ´Ù½Ã ÀĞ±â À§ÇØ ÀúÀå

			exp = getIntWithoutSkip();         // µğÁöÆ® ¾Æ´Ñ ¹®ÀÚ¿¡ ´ëÇÑ ½ºÅµ ¾øÀÌ Á¤¼öºÎ ÀÔ·ÂÇÏ¿© Áö¼öºÎ °ªÀ¸·Î ÀúÀå
		}
		else { // ºÎÈ£ ÀÖ´Â Áö¼öºÎ°¡ ÀÖ´Â°¡¸¦ Ã¼Å©ÇÏ¿© Ã³¸®ÇÔ
			if (c2 == '+' || c2 == '-') {
				int c3 = getcharPrivate();
				if (c3 >= '0' && c3 <= '9') {  // +/- ´ÙÀ½¿¡ Áö¼öºÎÀÎ Á¤¼ö°¡ ÀÖÀ¸¸é
					skUngetc(c3); // ÀĞÀº ¹®ÀÚ¸¦ ´Ù½Ã ÀĞ±â À§ÇØ ÀúÀå

					exp = getIntWithoutSkip(); // µğÁöÆ® ¾Æ´Ñ ¹®ÀÚ¿¡ ´ëÇÑ ½ºÅµ ¾øÀÌ Á¤¼öºÎ ÀÔ·ÂÇÏ¿© Áö¼öºÎ °ªÀ¸·Î ÀúÀå
					exp = exp * ( (c2 == '+') ? 1 : -1 ) ;   // +Áö¼öºÎ´Â 1, -Áö¼öºÎ´Â -1À» °öÇÔ

//					printf("\n  <for debug in getDouble() > c2 = %c, exp = %d \n", c2, exp);
				}
				else {  // e·Î ½ÃÀÛÇÏ°í +/-°¡ ÀÔ·ÂµÇ¾úÀ¸³ª  +/- ´ÙÀ½¿¡ ¼ıÀÚ ¾Æ´Ï¸é Áö¼öºÎ°¡ ¾ø´Â °ÍÀ¸·Î Ã³¸®
					skUngetc(c3);
					skUngetc(c2);
					skUngetc(c);
				}
			}
			else { // e·Î ½ÃÀÛÇßÀ¸³ª ¼ıÀÚ, + , -°¡ ¾Æ´Ï¸é Áö¼öºÎ°¡ ¾ø´Â °ÍÀ¸·Î Ã³¸®
				skUngetc(c2);
				skUngetc(c);
			}
		}
	}
	else
		skUngetc(c); // Áö¼öºÎ°¡ ¾øÀ¸¸é ÀĞÀº ¹®ÀÚ¸¦ skUngetc()

	if (signInt == 1) // ÀĞÀº Á¤¼öºÎÀÇ ºÎÈ£¿¡ µû¶ó
		d = n + d;	    // ºÎÈ£°¡ ¾ç¼öÀÌ¸é ¼Ò¼öºÎ¸¦ Á¤¼öºÎ¿¡ ´Ü¼øÈ÷ ´õÇØÁÜ
	else
		d = n - d;     // ºÎÈ£°¡ À½¼öÀÌ¸é ¼Ò¼öºÎ¸¦ Á¤¼öºÎ¿¡¼­ »©ÁÖ¾î¾ß ÇÔ

	if (exp != 0)      //  Áö¼öºÎ°¡ ÀÖÀ¸¸é Áö¼öºÎ¸¸Å­ °öÇØÁÜ
		d = d * powor10(exp);

	removeLastNewLineChar();  // Á¤¼ö, ½Ç¼ö, ¹®ÀÚ¿­, ½Äº°ÀÚ µîÀ» ÀĞ±â À§ÇØ ÀÔ·ÂµÈ '\r', '\n'À» Á¦°Å½ÃÅ´

	return d;
}

// getFoloat() : 23.45, -12.3, -0.012_3, +.012_34, -.1234e3_3 1.234e+12, 1.234E-1_2 µî
//  JavaÀÇ ½Ç¼ö °ªÀ» ÀÔ·ÂÇÏ¿© float °ªÀ¸·Î ¹İÈ¯ÇÏ´Â ÇÔ¼ö
//    ½Ç¼ö Çü½Ä: "[+/-Á¤¼öºÎ].[¼Ò¼öºÎ]E/e[+/-Áö¼öºÎ]"
float getFloat() {
	return (float) getDouble();
}


int nextInt() {
	return getInt();
}


// isAlphabet() : ÁÖ¾îÁø ¹®ÀÚ°¡ JavaÀÇ ½Äº°ÀÚÀÇ ¾ËÆÄº£Æ®¿¡ ÇØ´çµÇ´ÂÁö¸¦ °Ë»çÇÏ´Â  ÇÔ¼ö
//  ¾ËÆÄº£Æ®: ¿µ¹®ÀÚ, ÇÑ±Û, '_', '$'
//  (±×¸®½º ¹®ÀÚ, Áß±¹¾î ¹®ÀÚ, ÀÏº»¾î ¹®ÀÚ µîµµ ¾ËÆÄº£Æ®¿¡ Æ÷ÇÔµÇ³ª ¿©±â¿¡¼­´Â Ã³¸®ÇÏÁö ¾ÊÀ½)
int isAlphabet(int c) {
	if (c>='A' && c <= 'Z' || c>='a' && c <= 'z' )  // ÀĞÀº ¹®ÀÚ°¡ ¿µ¹®ÀÚÀÌ¸é ÀÌ¸¦ ¹İÈ¯
		return 1;
	// À¯´ÏÄÚµå¿¡¼­ ÇÑ±Û ÀÚÀ½°ú ¸ğÀ½Àº '¤¡'(12593)¿¡¼­ '¤Ó'(12643)±îÁö ¹èÁ¤µÊ
	// À¯´ÏÄÚµå¿¡¼­ ÇÑ±Û ¹®ÀÚ´Â '°¡'('\uAC00': 44032)¿¡¼­ 'ÆR'('\uD7A3': 55203)±îÁö ¹èÁ¤µÊ
	else if (c >= 12593 && c <= 12643)   // ÀĞÀº ¹®ÀÚ°¡ ÇÑ±Û ÀÚÀ½ ¶Ç´Â ¸ğÀ½ÀÌ¸é ÀÌ´Â ½Äº°ÀÚ Ã¹¹®ÀÚ¿¡ ÇØ´çµÊ
		return 1;
	else if (c >= 44032 && c <= 55203)   // ÀĞÀº ¹®ÀÚ°¡ ÇÑ±Û À½ÀıÀÌ¸é ÀÌ´Â ½Äº°ÀÚ Ã¹¹®ÀÚ¿¡ ÇØ´çµÊ
		return 1;

	return 0;

}

// skipUntilFistCharOfIentifier() : ½Äº°ÀÚÀÇ Ã¹¹®ÀÚÀÎ ¿µ¹®ÀÚ, ÇÑ±Û, '_', '$'°¡ ³ª¿Ã ¶§±îÁö
//   ¹®ÀÚµéÀ» skipÇÏ¿© ½Äº°ÀÚÀÇ Ã¹ ¹®ÀÚ¸¦ ¹İÈ¯ÇÏ´Â ÇÔ¼ö
int skipUntilFistCharOfIentifier() {
	int c;

	while(1)  {
		c = getcharPrivate();

		if (isAlphabet(c))      // ÀĞÀº ¹®ÀÚ°¡ ¾ËÆÄº£Æ®ÀÌ¸é ÀÌ´Â ½Äº°ÀÚ Ã¹¹®ÀÚ¿¡ ÇØ´ç, ÀÌ¸¦ ¹İÈ¯
			return c;
		else if (c == '_' || c=='$')    // ÀĞÀº ¹®ÀÚ°¡ '_' ¶Ç´Â "$"ÀÌ¸é ÀÌ´Â ½Äº°ÀÚ Ã¹¹®ÀÚ¿¡ ÇØ´ç, ÀÌ¸¦ ¹İÈ¯
			return c;
	}
}    

// getTailOfID(int head): Java ½Äº°ÀÚÀÇ ²¿¸®ºÎºĞÀ» ÀÔ·ÂÇÏ¿© ÁÖ¾îÁø Çìµå¹®ÀÚ head¿Í ÇÔ²² ÀüÃ¼ ½Äº°ÀÚ¸¦ ±¸¼ºÇÏ¿© ¹®ÀÚ¿­·Î ¹İÈ¯
//  ½Äº°ÀÚÀÇ Ã¹¹®ÀÚ: ¿µ¹®ÀÚ, ÇÑ±Û, '_', '$'
//  ½Äº°ÀÚÀÇ ²¿¸®ºÎºĞ: ¿µ¹®ÀÚ, ÇÑ±Û, ¼ıÀÚ, '_', '$'
char * getTailOfID(int head) {
	int i=0;

	int c;



	strbuf[0] = (char) head;
	i++;

	while(1)  {
		c = getcharPrivate();
		//			printf("  o tail of identifier = '" + (char) c + "' (" + c + ")");

		if (isAlphabet(c))              // ÀĞÀº ¹®ÀÚ°¡ ¾ËÆÄº£Æ®ÀÌ¸é ÀÌ´Â ½Äº°ÀÚ ²¿¸®¿¡ ÇØ´çµÊ
			strbuf[i++] = (char) c;
		else if (c == '_' || c=='$')    // ÀĞÀº ¹®ÀÚ°¡ '_' ¶Ç´Â "$"ÀÌ¸é ÀÌ´Â ½Äº°ÀÚ ²¿¸®¿¡ ÇØ´çµÊ
			strbuf[i++] = (char) c;
		else if (c >= '0' && c<='9')         // ÀĞÀº ¹®ÀÚ°¡ µğÁöÆ®ÀÌ¸é ÀÌ´Â ½Äº°ÀÚ ²¿¸®¿¡ ÇØ´çµÊ
			strbuf[i++] = (char) c;
		else
			break;
	}

	skUngetc(c); // ¸¶Áö¸· ÀĞÀº ¹®ÀÚ´Â ½Äº°ÀÚ ¹®ÀÚ ¾Æ´Ï¹Ç·Î ´ÙÀ½¿¡ ÀĞÀ» ¼ö ÀÖµµ·Ï skUngetc½ÃÅ´

	strbuf[i] = 0;
	
	char *id = (char *) malloc(strlen(strbuf) + 1);   // ÀĞ¾îµéÀÎ ¹«ÀÚ¿­À» ÀúÀåÇÏ±â À§ÇÑ °ø°£ ÇÒ´ç¹ŞÀ½
	strcopy(id, strbuf);                    // ¾Ì¾îµé¾È ¹®ÀÚ¿­À» ÇÒ´ç¹ŞÀº °ø°£¿¡ º¹»çÇÔ    

	return id;                             // º¹»çµÈ ½Äº°ÀÚ ¹®ÀÚ¿­À» ¹İÈ¯ 
}


// getIdentifier() : JavaÀÇ ½Äº°ÀÚ¸¦ ÀÔ·ÂÇÏ¿© ¹İÈ¯ÇÏ´Â ÇÔ¼ö
//  ½Äº°ÀÚÀÇ Ã¹¹®ÀÚ: ¿µ¹®ÀÚ, ÇÑ±Û, '_', '$'
//  ½Äº°ÀÚÀÇ ²¿¸®ºÎºĞ: ¿µ¹®ÀÚ, ÇÑ±Û, ¼ıÀÚ, '_', '$'
//  (±×¸®½º ¹®ÀÚ, Áß±¹¾î ¹®ÀÚ, ÀÏº»¾î ¹®ÀÚ µîµµ ½Äº°ÀÚ¿¡ Æ÷ÇÔµÇ³ª ¿©±â¿¡¼­´Â Ã³¸®ÇÏÁö ¾ÊÀ½)
char * getIdentifier()  {
	int head = skipUntilFistCharOfIentifier(); // ½Äº°ÀÚÀÇ Ã¹ ¹®ÀÚ¸¦ Ã£¾Æ ÀÔ·ÂÇÏ¿© ¹İÈ¯
	//		printf("  o head of identifier = '" + (char) head + "' (" + head + ")");

	char * identifier = getTailOfID(head); // ½Äº°ÀÚÀÇ ²¿¸®ºÎºĞÀ» ÀÔ·ÂÇÏ¿© Ã¹ ¹®ÀÚ head¿Í °áÇÕÇÏ¿© ¹İÈ¯

	removeLastNewLineChar();  // Á¤¼ö, ½Ç¼ö, ¹®ÀÚ¿­, ½Äº°ÀÚ µîÀ» ÀĞ±â À§ÇØ ÀÔ·ÂµÈ '\r', '\n'À» Á¦°Å½ÃÅ´

	return identifier;
}

// getBoolean() : "true" ¶Ç´Â "false"¸¦ ÀÔ·ÂÇÏ¿© 1 ¶Ç´Â 0¸¦ boolean °ªÀ¸·Î ¹İÈ¯ÇÏ´Â ÇÔ¼ö
//    "true" ¶Ç´Â "false"¸¦ ÀÔ·ÂÇÏ±â À§ÇØ ½Äº°ÀÚ°¡ ¹İµå½Ã ¸ÕÀú ³ªÅ¸³ª¾ß ÇÔ
//    ÀÔ·ÂµÈ ½Äº°ÀÚ°¡ "true" ¶Ç´Â "false"ÀÌ¸é boolean Å¸ÀÔÀÇ 1 ¶Ç´Â 0À»  ¹İÈ¯,
//    ±×·¸Áö ¾ÊÀº °æ¿ì ´ÙÀ½ ½Äº°ÀÚ¸¦ ÀÔ·ÂÇÏ¿© È®ÀÎÀ» ¹İº¹ÇÔ
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

// getString() : '\n', '\r', -1ÀÌ ÀÔ·ÂµÉ ¶§±îÁö ÀÔ·ÂµÈ ¹®ÀÚµéÀ» String °ªÀ¸·Î ¹İÈ¯
//    ¿£ÅÍÅ°°¡ '\n', '\r' µÎ°³ÀÇ ¹®ÀÚ·Î ÀÌ·ç¾îÁö´Â °æ¿ì¸¦ À§ÇØ
//    Ã³À½¿¡ ³ªÅ¸³ª´Â '\n', '\r' ¹®ÀÚ´Â ¹«½ÃÇÑ´Ù.
char * getString()  {
	int i=0;

	int c;

	while((c = getcharPrivate()) != '\n' &&  c != '\r' && c != -1)
		strbuf[i++] = (char) c;
		
	skUngetc(c);

	strbuf[i] = 0;
	
	removeLastNewLineChar();  // Á¤¼ö, ½Ç¼ö, ¹®ÀÚ¿­, ½Äº°ÀÚ µîÀ» ÀĞ±â À§ÇØ ÀÔ·ÂµÈ '\r', '\n'À» Á¦°Å½ÃÅ´

    char *str = (char *) malloc(strlen(strbuf) + 1);   // ÀĞ¾îµéÀÎ ¹«ÀÚ¿­À» ÀúÀåÇÏ±â À§ÇÑ °ø°£ ÇÒ´ç¹ŞÀ½ 
	strcopy(str, strbuf);                    // ¾Ì¾îµé¾È ¹®ÀÚ¿­À» ÇÒ´ç¹ŞÀº °ø°£¿¡ º¹»çÇÔ         

	return str;                             // º¹»çµÈ ¹®ÀÚ¿­À» ¹İÈ¯ 
}

// µğÁöÆ® ¹®ÀÚ°¡ ÀÔ·ÂµÉ ¶§±îÁöÀÇ ¹®ÀÚµéÀ» ÀĞ¾î String ¹®ÀÚ¿­À» ¹İÈ¯
char * getStringUntilNotDigit()  {
	int i=0;

	int c;


	while((c =  getcharPrivate()) >= '0' &&  c <= '9' )
		strbuf[i++] = (char) c;

	skUngetc(c);  // ¸¶Áö¸· ÀĞÀº ¹®ÀÚ¸¦ ´Ù½Ã ÀĞÀ» ¼ö ÀÖµµ·Ï skUngetc()

	strbuf[i] = 0;

	return strbuf;
}

char * nextString() {
	return getString();
}


/*
 * ÇÁ·ÒÇÁÆ® ¸Ş½ÃÁö¸¦ Ãâ·ÂÇÑ µÚ µ¥ÀÌÅÍ ÀÔ·ÂÇÏ´Â ÇÔ¼öµé
 *
 * ÀÔ·ÂÇÒ ¶§ ÇÁ·ÒÇÁÆ® ¸Ş½ÃÁö ¾øÀÌ ÀÔ·ÂÀ» ÇÏ¸é »ç¿ëÀÚ´Â ¸·¿¬È÷ ±â´Ù¸®´Â °æ¿ì°¡ ¹ß»ıÇÑ´Ù.
 * ÀÌ·¯ÇÑ °æ¿ì¸¦ ¹æÁöÇÏ±â À§ÇØ ÀÔ·Â½Ã¿¡´Â ¸Ş½ÃÁö¸¦ ¹Ì¸® Ãâ·ÂÇÏ¿©
 * ÀÔ·ÂÇÒ µ¥ÀÌÅÍÀÇ ¿ëµµ³ª ±â´ÉÀ» ¾Ë·ÁÁÖ´Â ¸Ş½ÃÁö¸¦ ÇÁ·ÒÇÁÆ® ¸Ş½ÃÁö¶ó ÇÑ´Ù.
 *
 * Æ¯È÷ Å°º¸µå¿¡¼­ÀÇ ÀÔ·Â½Ã ÇÁ·ÒÇÁÆ® ¸Ş½ÃÁö´Â Áß¿äÇÏ´Ù.
 */

// ÇÁ·ÒÇÁÆ® ¸Ş½ÃÁö¿Í ¹®ÀÚ ÀÔ·Â
char getCharWithPrompt(char * msg) {
	printf(msg);
	return skGetchar();
}

// ÇÁ·ÒÇÁÆ® ¸Ş½ÃÁö¿Í int Á¤¼ö ÀÔ·Â
int getIntWithPrompt(char * msg) {
	printf(msg);
	return getInt();
}

// ÇÁ·ÒÇÁÆ® ¸Ş½ÃÁö¿Í long Á¤¼ö ÀÔ·Â
long getLongWithPrompt(char * msg) {
	printf(msg);
	return getLong();
}

// ÇÁ·ÒÇÁÆ® ¸Ş½ÃÁö¿Í double ½Ç¼ö ÀÔ·Â
double getDoubleWithPrompt(char * msg) {
	printf(msg);
	return getDouble();
}

// ÇÁ·ÒÇÁÆ® ¸Ş½ÃÁö¿Í float ½Ç¼ö ÀÔ·Â
float getFloatWithPrompt(char * msg) {
	printf(msg);
	return getFloat();
}

// ÇÁ·ÒÇÁÆ® ¸Ş½ÃÁö¿Í boolean °ª ÀÔ·Â
int getBooleanWithPrompt(char * msg) {
	printf(msg);
	return getBoolean();
}

// ÇÁ·ÒÇÁÆ® ¸Ş½ÃÁö¿Í ¹®ÀÚ¿­ ÀÔ·Â
char * getStringWithPrompt(char * msg) {
	printf(msg);
	return getString();
}

//	// ÇÁ·ÒÇÁÆ® ¸Ş½ÃÁö¿Í ½Äº°ÀÚ ÀÔ·Â
	char * getIdentifierWithPrompt(char * msg) {
		printf(msg);
		return getIdentifier();
}


int main1(int argc, char * argv[]) {
		while(1) {

			/*
			 *  ÀÌ ºÎºĞÀº Å×½ºÆ®¸¦ À§ÇÑ ºÎºĞÀÓ
			 *
			 *  ÀÔ·Â ÇÔ¼ö¸¦ ÇÑ¹ø¾¿ È£ÃâÇÔ
			 */
// 
//
//			printf("\n  o input int (ÃÖ´ë°ª: %d ) > ", (0x7FFFFFFF));
//			int no = getInt();
//			printf("  * int = %d", no);
//
//			printf("\n  o input long(ÃÖ´ë°ª: : %ld ) > ", (0x7FFFFFFFFFFFFFFFL));
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
		 * ÇÁ·ÒÇÁÆ® ¸Ş½ÃÁö¸¦ Ãâ·ÂÇÏ´Â ÀÔ·Â ÇÔ¼ö È£Ãâ
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

