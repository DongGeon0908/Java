package Annotation;

import java.lang.reflect.Method;

public class PrintAnnotationExamole {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Method[] declaredMethods = Service.class.getDeclaredMethods();

		for (Method method : declaredMethods) {
			if (method.isAnnotationPresent(PrintAnnotation.class)) {
				PrintAnnotation printAnnotation = method.getAnnotation(PrintAnnotation.class);

				System.out.println("[" + method.getName() + "]");

				for (int i = 0; i < printAnnotation.number(); i++) {
					System.out.print(printAnnotation.value());
				}
				System.out.println();

				try {
					method.invoke(new Service());
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println();
				}
			}
		}
	}

}
