package com.spring.shopping.util;

import java.util.UUID;

/*********************************
 * This class is used to generate unique
 * and random keys. Used in Account Activation
 * @author SaiUpadhyayula
 *
 *******************************/
public class KeyGenerator {
	public static long generateKey(){
		UUID uuidKey= UUID.randomUUID();
		long key = uuidKey.getMostSignificantBits();
		return key;
	}
}
