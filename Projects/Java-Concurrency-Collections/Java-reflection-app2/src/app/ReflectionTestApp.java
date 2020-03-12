package app;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReflectionTestApp {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException {

		// Get Class using reflection
		Class<?> concreteClass = ConcreteClass.class;
		concreteClass = new ConcreteClass(5).getClass();
		try {
			concreteClass = Class.forName("app.ConcreteClass");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("THe Class loaded name is " + concreteClass.getCanonicalName());

		// for primitive types, wrapper classes and arrays
		Class<?> booleanClass = boolean.class;
		System.out.println(booleanClass.getCanonicalName()); // prints boolean

		Class<?> cDouble = Double.TYPE;
		System.out.println(cDouble.getCanonicalName()); // prints double

		Class<?> cDoubleArray = Class.forName("[D");
		System.out.println(cDoubleArray.getCanonicalName()); // prints double[]

		Class<?> twoDStringArray = String[][].class;
		System.out.println(twoDStringArray.getCanonicalName()); // prints java.lang.String[][]

		// getting public inner classes, enums, interface information including
		// inherited class

		Class<?> superClass = Class.forName("app.ConcreteClass").getSuperclass();
		System.out.println("The super of ConcreteClass is" + superClass);
		System.out.println("The super of Object is " + Object.class.getSuperclass());
		System.out.println(String[][].class.getSuperclass());

		Class<?>[] classes = concreteClass.getClasses();// returns all the inner compoonents
		// [class app.ConcreteClass$ConcreteClassPublicClass,
		// class app.ConcreteClass$ConcreteClassPublicEnum,
		// interface app.ConcreteClass$ConcreteClassPublicInterface,
		// class app.BaseClass$BaseClassInnerClass,
		// class app.BaseClass$BaseClassMemberEnum]
		System.out.println("All the nested inner classes " + Arrays.toString(classes));

		// getting all of the classes, interfaces, and enums that are explicitly
		// declared in ConcreteClass
		Class<?>[] explicitClasses = Class.forName("app.ConcreteClass").getDeclaredClasses();
		// [class app.ConcreteClass$ConcreteClassDefaultClass,
		// class app.ConcreteClass$ConcreteClassDefaultEnum,
		// class app.ConcreteClass$ConcreteClassPrivateClass,
		// class app.ConcreteClass$ConcreteClassProtectedClass,
		// class app.ConcreteClass$ConcreteClassPublicClass,
		// class app.ConcreteClass$ConcreteClassPublicEnum,
		// interface app.ConcreteClass$ConcreteClassPublicInterface]
		System.out.println(Arrays.toString(explicitClasses));

		Class<?> innerClass = Class.forName("app.ConcreteClass$ConcreteClassDefaultClass");
		// prints app.ConcreteClassDefaultClass
		System.out.println(innerClass.getDeclaringClass().getCanonicalName());
		System.out.println(innerClass.getEnclosingClass().getCanonicalName());

		// Get class modifiers, concreteClass.getModifiers() returns int representation
		// of Modifiers,
		// Modifier class can be used to return it in normal string format

		System.out.println(Modifier.toString(concreteClass.getModifiers()));
		// prints "public abstract interface"
		System.out.println(
				"The Class modifiers are " + Modifier.toString(Class.forName("app.BaseInterface").getModifiers()));

		// Getting package name

		System.out.println("The  package is  " + Class.forName("app.BaseInterface").getPackage().getName());

		// Gte the method names
		// Class clazz = Class.forName("java.util.HashMap");

		Class clazz = Class.forName("app.ConcreteClass");

		final Method[] methods = clazz.getDeclaredMethods();

		final List<String> methodNames = new ArrayList<>();

		for (final Method methodCurrent : methods) {
			methodNames.add(methodCurrent.getName());
		}
		System.out.println("Methods in Class are " + methodNames);

		System.out.println("\n");

		Type[] interfaces = Class.forName("app.ConcreteClass").getGenericInterfaces();

		System.out.println("The interfaces implementd by  class " + Arrays.toString(interfaces));

		// System.out.println(Arrays.toString(Class.forName("java.util.HashMap").getInterfaces()));

		// Get All annotations
		java.lang.annotation.Annotation[] annotations = Class.forName("app.ConcreteClass").getAnnotations();
		System.out.println("Class annotations are " + Arrays.toString(annotations));

		try {
			Field field = Class.forName("app.ConcreteClass").getField("publicInt");
			Class<?> fieldType = field.getType();
			System.out.println(fieldType.getCanonicalName());

			ConcreteClass obj = new ConcreteClass(5);
			System.out.println(field.get(obj)); // prints 5
			field.setInt(obj, 10); // setting field value to 10 in object
			System.out.println(field.get(obj)); // prints 10

			Class<?> fieldClass = field.getDeclaringClass();// Class parnet
			System.out.println("The name of elcl class  is " + fieldClass.getCanonicalName()); // prints
																								// com.journaldev.reflection.BaseInterface

			Field privateField = Class.forName("app.ConcreteClass").getDeclaredField("privateString");

			// turning off access check with below method call
			privateField.setAccessible(true);
			ConcreteClass objTest = new ConcreteClass(1);
			System.out.println("The private variable  value is  " + privateField.get(objTest));

			// set new value to private vraiable
			privateField.set(objTest, "private string updated");
			System.out.println("The new value of private variable   is  \"+" + privateField.get(objTest));

		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}

		try {
			Method method = Class.forName("app.ConcreteClass").getMethod("method4", null);
			System.out.println("Method method4 class " + method.getDeclaringClass());

			method = Class.forName("app.ConcreteClass").getMethod("method5", int.class);
			System.out.println("Method method5  class " + method.getDeclaringClass());
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}

		Method method = Class.forName("app.ConcreteClass").getMethod("method2", String.class);

		System.out.println("The method method2 param types are " + Arrays.toString(method.getParameterTypes()));

		System.out.println("The methjod method2 return type is " + method.getReturnType());
		// get method modifiers
		System.out.println("The methjodmethod2  modifier is " + Modifier.toString(method.getModifiers()));

		// invoking public method

		Object obj = Class.forName("app.ConcreteClass").newInstance();
		Object data = method.invoke(obj, "paramData");
		System.out.println("Method returned value is  " + data);

		// invoking private static method
		method = Class.forName("app.BaseClass").getDeclaredMethod("method3", null);
		method.setAccessible(true);
		method.invoke(null, null); // static method doesnot need instance of class

		// invoking private instance method
		method = Class.forName("app.BaseClass").getDeclaredMethod("updateMethod", Object.class);// parm types

		Class cls = method.getDeclaringClass();// Enclosing class
		System.out.println("The cls name  is " + cls.getCanonicalName());
		method.setAccessible(true);
		double res = (double) method.invoke(cls.newInstance(), new String("bavava")); // Instanvce method need instance
																						// of class
		System.out.println("The return of metjod updateMethod is " + res);

		// constructors

		Constructor<?>[] constructors = Class.forName("app.ConcreteClass").getDeclaredConstructors();

		System.out.println("The constructors are " + constructors.length); // array of constructors
		for (Constructor<?> c : constructors)
			System.out.print(c.getName() + ",");

		Constructor<?> constructor = Class.forName("app.ConcreteClass").getConstructor(int.class);
		// getting constructor parameters
		System.out.println("Constructors " + Arrays.toString(constructor.getParameterTypes()));

		Object myObj = constructor.newInstance(10);

		Method myObjMethod = myObj.getClass().getMethod("method1", null);
		myObjMethod.invoke(myObj, null);

		Constructor<?> hashMapConstructor = Class.forName("java.util.HashMap").getConstructor(null);
		System.out.println(Arrays.toString(hashMapConstructor.getParameterTypes())); // prints "[]"
		HashMap<String, String> myMap = (HashMap<String, String>) hashMapConstructor.newInstance(null);
		myMap.put("key1", "value1");
		System.out.println(myMap.get("key1"));

		// Get Type parameters (generics)
		TypeVariable<?>[] typeParameters = Class.forName("java.util.HashMap").getTypeParameters();
		for (TypeVariable<?> t : typeParameters)
			System.out.print(t.getName() + ",");

	}

}
