package utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import domain.Board;

public class Util {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<Board> c = Board.class;
		
		Method[] methods = c.getMethods();
		Board board = c.newInstance();
		
		for(Method method : methods) {
			String name = method.getName();
			if(name.startsWith("set")) {
				String fieldName = (char)(name.charAt(3) + 32) + name.substring(4);
				System.out.println(fieldName);
				String paramType = method.getParameters()[0].getType().getSimpleName();
				Object param = null;
				switch (paramType) {
				case "String":
					param = "1234";
					break;
				case "int": case "Integer":
					param = Integer.parseInt("1234");
					break;
				case "long": case "Long":
					param = Long.parseLong("1234");
					break;
				default:
					break;
				}
				System.out.println(paramType);
//				method.invoke(member, "1234");
			}
		}
//		for(Method method : methods) {
//			String name = method.getName();
//			if(name.startsWith("get")) {
//				System.out.println(name);
//				System.out.println(method.invoke(member, new Object[] {}));
//			}
//		}
	}

	public static <T> T getParam(HttpServletRequest req, Class<T> c) {
		T t = null; 
		try {
			t = c.newInstance();
			Method[] methods = c.getMethods();
			for(Method method : methods) {
				String name = method.getName();
				if(name.startsWith("set")) {
					String fieldName = (char)(name.charAt(3) + 32) + name.substring(4);
					System.out.println(fieldName);
					String paramType = method.getParameters()[0].getType().getSimpleName();

					Object param = req.getParameter(fieldName);
					if(param == null) continue;
					
					switch (paramType) {
					case "int": case "Integer":
						param = Integer.parseInt(param.toString());
						break;
					case "long": case "Long":
						param = Long.parseLong(param.toString());
						break;
					default:
						break;
					}
					
					method.invoke(t, param);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
//	public static <T> T getParam(HttpServletRequest req, Class<T> c) {
//		T t = null; 
//		try {
//			t = c.newInstance();
//			Method[] methods = c.getMethods();
//			for(Method method : methods) {
//				String name = method.getName();
//				if(name.startsWith("set")) {
//					method.invoke(t, req.getParameter((char)(name.charAt(3) + 32) + name.substring(4)));
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return t;
//	}
	
	
}
