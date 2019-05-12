/*
 * File name: MD5Digest.java
 *
 * Programmer: Ann Gauger
 * ULID: amgauge
 *
 * Date: Apr 14, 2019
 *
 * Class: IT 168
 * Lecture Section: 10
 * Lecture Instructor: Terry Plickebaum 
 * Lab Section: 12
 * Lab Instructor: Kumar Rakholia
 */

package helpingAnn41619;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Digest 
{

	public String encrypt(String password) throws NoSuchAlgorithmException
	{      
      //Copy and paste this section of code
		String original = password;  //Replace "password" with the actual password inputted by the user
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(original.getBytes());
		byte[] digest = md.digest();
      StringBuffer sb = new StringBuffer();
		for (byte b : digest) {
			sb.append(String.format("%02x", b & 0xff));
		}
      String encrypt = sb.toString();
      return encrypt;
	}
}
