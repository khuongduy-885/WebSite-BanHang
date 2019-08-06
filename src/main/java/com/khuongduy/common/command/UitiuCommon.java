package com.khuongduy.common.command;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class UitiuCommon
{
	
	//Mã hóa AES trong Java
	public String encrypt(String strToEncrypt) {
	      try {
	    	  String myKey = "TVD5@";
	            MessageDigest sha = MessageDigest.getInstance("SHA-1");
	            byte[] key = myKey.getBytes("UTF-8");
	            key = sha.digest(key);
	            key = Arrays.copyOf(key, 16);
	            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
	            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
	            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
	      } catch (Exception e) {
	            System.out.println(e.toString());
	      }
	      return null;
	}
	//Giải mã AES trong Java
	public String decrypt(String strToDecrypt) {
	      try {
	    	  String myKey = "TVD5@";
	            MessageDigest sha = MessageDigest.getInstance("SHA-1");
	            byte[] key = myKey.getBytes("UTF-8");
	            key = sha.digest(key);
	            key = Arrays.copyOf(key, 16);
	            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
	            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
	            cipher.init(Cipher.DECRYPT_MODE, secretKey);
	            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
	      } catch (Exception e) {
	            System.out.println(e.toString());
	      }
	      return null;
	}
	public String maRanDom() {
		Random rd = new Random();
		int number2 = 100000 + rd.nextInt(999999);
	      String s= String.valueOf(number2)+".cc mở được";
		return s;
	}
	public static void main(String[] args) {
		
	      UitiuCommon testAES = new UitiuCommon();
	     
	      String originalString =  testAES.maRanDom();
	      String encryptedString = testAES.encrypt(originalString);
	      System.out.println("Encrypt: " + encryptedString);
	      String decryptedString = testAES.decrypt(encryptedString);
	      System.out.println("Decrypt: " + decryptedString);
	      System.out.println("Decrypt: " +originalString.substring(0, 6));
	}
}
