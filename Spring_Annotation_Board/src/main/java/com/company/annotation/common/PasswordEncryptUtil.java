package com.company.annotation.common;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * 자바에서 SHA 알고리즘을 사용하려면 MessageDigest 클래스를 이용한다.
 * update() 메소드를 호출할 때마다 객체 내에 저장된 digest 값이 계속해서 갱신된다.
 * 최종적으로 digest() 메소드를 호출하면 그 값을 가져올 수 있다.
 *
 */

public class PasswordEncryptUtil {
		//패스워드를 받아서 암호화 시키는 메소드 구현
	
		public static String encryptSHA256(String plainText) {

		String sha256 = "";
		
		try {
			//MessageDigest 클래스의 getInstance() 메소드의 매개변수에 'SHA-256' 알고리즘 이름을
			//지정함으로써 해당 알고리즘에서 해시 값을 계산하는 mdSHA256을 구할 수 있다.
			MessageDigest mdSHA256 = MessageDigest.getInstance("SHA-256");
			
			//데이터(패스워드 평문)를 update한다. 즉,'암호화'한다와 유사한 개념이다.
			mdSHA256.update(plainText.getBytes("UTF-8"));
			
			//digest(): byte 배열로 해시를 반환(return)시킨다.
			byte[] sha256Hash = mdSHA256.digest();
			
			
			//문자열을 계속 변경하는 등의 변화가 있으면 StringBuffer를 사용하는 것이 좋다.
			//String: 데이터를 추가, 변경할 때마다 새로운 객체가 생성됌
			//StirngBuffer객체는 계속해서 append를 해도 객체는 오직 하나만 생성된다. 메모리 낭비를 개선!
			//=> StringBuffer가 효율적!
			StringBuffer hexSHA256hash = new StringBuffer();
			
			//256비트로 생성 => 32Byte => 1Byte(8bit) => 16진수 2자리로 변환 => 16진수 한자리는 4bit
			for(byte b: sha256Hash) {
				String hexString = String.format("%02x", b); //16진수 두자리로 변경
				hexSHA256hash.append(hexString);
			}
			
			sha256 = hexSHA256hash.toString();
		}catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return sha256;
		
		}
}
