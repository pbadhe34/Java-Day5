package app;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class EnumRead {

    public static void main(String... args) throws Exception {
        MyEnum[] values = getEnumValues(MyEnum.class);
        System.out.println(Arrays.toString(values));

        //alternatively
        Method method = MyEnum.class.getDeclaredMethod("values");
        Object obj = method.invoke(null);
        System.out.println(Arrays.toString((Object[]) obj));
    }

    private static <E extends Enum> E[] getEnumValues(Class<E> enumClass)
            throws NoSuchFieldException, IllegalAccessException {
        Field f = enumClass.getDeclaredField("ENUM$VALUES");
        System.out.println(f);
        System.out.println(Modifier.toString(f.getModifiers()));
        f.setAccessible(true);
        Object o = f.get(null);
        return (E[]) o;
    }

    private static enum MyEnum {
        A, B, C
    }
}
