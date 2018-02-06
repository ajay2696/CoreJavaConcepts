package com.mine.practice.crypto;

import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class CryptoProvider {
  public static void main(String[] args) throws Exception {
	  Security.addProvider(new BouncyCastleProvider());
	  IvParameterSpec iv = new IvParameterSpec("0102030405060708".getBytes());
	  Cipher cipher = Cipher.getInstance("AES");
	  byte[] keyBytes   = new byte[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
	  String algorithm  = "RawBytes";
	  SecretKeySpec key = new SecretKeySpec(keyBytes, algorithm);
	  cipher.init(Cipher.ENCRYPT_MODE, key,iv);
	  cipher.init(Cipher.DECRYPT_MODE, key,iv);
	  
	  byte[] plainText  = "abcdefghijklmnopqrstuvwx".getBytes("UTF-16");
	  System.out.println(plainText.length+plainText.toString());
	  byte[] cipherText = cipher.doFinal(plainText);
	  
	  System.out.println("---plainText---"+plainText);
	  System.out.println("---cipherText---"+cipherText);	  
	  byte[] decodedText = cipher.doFinal(cipherText);
	  System.out.println("---Decoded Text---"+decodedText);
  }
}
