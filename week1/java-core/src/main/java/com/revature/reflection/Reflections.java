package com.revature.reflection;

import java.lang.reflect.*;

import com.revature.fileio.CerealBox;

public class Reflections {

	/*
	 * Reflection allows you to get information about
	 * classes and their members.
	 */
	public static void main(String... args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		CerealBox box = new CerealBox(true, "General Mills",
				"Lucky Charms", 8);
		
		// see the class
		Class<CerealBox> clazz = CerealBox.class;
		System.out.println(clazz);
		
		// see the members in a class
		Field[] vars = clazz.getDeclaredFields();
		for(Field f : vars) {
			System.out.println(f);
		}
		
		Constructor constr = clazz.getDeclaredConstructor(boolean.class, String.class, String.class, int.class);
		//talked about Wrapper classes
		//boxing - from primitive to object
		//un-boxing - from object to primitive
		System.out.println(constr);
		
		Method method = clazz.getDeclaredMethod("toString");
		if(method.getAnnotation(Deprecated.class) == null) {
			method.invoke(box);
		}
		

	}

}
