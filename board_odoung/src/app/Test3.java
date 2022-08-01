package app;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Random;

import org.mindrot.jbcrypt.BCrypt;

public class Test3 {
	public static void main(String[] args) throws UnsupportedEncodingException{
		
		String pw1 = BCrypt.hashpw("00012345", BCrypt.gensalt(4));
		System.out.println(pw1);
		String pw2 = BCrypt.hashpw("12345", BCrypt.gensalt());
		System.out.println(pw2);
		
		System.out.println(BCrypt.checkpw("00012345", pw1));
		System.out.println(BCrypt.checkpw("12345", pw2));

		Random random = new Random();
		int result = random.nextInt(10000000);
		System.out.println(result);
		
		// LPAD(?
		System.out.println(String.format("%08d", 1234));
		
		System.out.println(BCrypt.checkpw("51164118",
				URLDecoder.decode("%242a%2410%24ukZtSL1c4TkItyqsWdRdSOeT%2Fjh2uHchNZOK7lXqeJmOKY4MzkSWu", "utf-8")));
	}
}
