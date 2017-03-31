package com.github.mauricioaniche.testmetrics;

public class ClassUtils {

	public static String extractClassName(String fullClassName) {
		
		String[] nameInParts = fullClassName.split("\\.");
		String lastPart = nameInParts[nameInParts.length-1];
		
		return lastPart;
	}
	
	public static boolean isTest(String className) {
		return className.endsWith("Test") || className.endsWith("Tests"); 
	}

	public static boolean isAssertMethod(String methodName) {
		return methodName.startsWith("assert");
	}

	public static boolean isFailMethod(String methodName) {
		return methodName.startsWith("fail");
	}
}
