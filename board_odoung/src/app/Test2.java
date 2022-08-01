package app;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Random;

import org.mindrot.jbcrypt.BCrypt;

public class Test2 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		String pw1 = BCrypt.hashpw("00012345", BCrypt.gensalt(5));
		System.out.println(pw1);
		String pw2 = BCrypt.hashpw("가", BCrypt.gensalt(5));
		System.out.println(pw2);
		
		System.out.println(BCrypt.checkpw("00012345", pw1));
		System.out.println(BCrypt.checkpw("가", pw2));
		
		Random random = new Random();
		int result = random.nextInt(100000000);
		System.out.println(result);
		
		// LPAD(?
		System.out.println(String.format("%08d", 12345));
		
		System.out.println(BCrypt.checkpw("83739956", 
				URLDecoder.decode("%242a%2410%24OaXeCQXfEdWeCgnkR%2FQN6eShEeQ5pxYE7Bcp5NEjXOqaVH7.CwCJK", "utf-8")));
		
	}
}
