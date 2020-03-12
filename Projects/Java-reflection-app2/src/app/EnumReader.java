package app;

import java.lang.reflect.Field;
import java.util.Arrays;

enum CoffeeSize {
    BIG, HUGE, OVERWHELMING; 
	
	       public static Object getEnums() {
	           try {
	               Field field = CoffeeSize.class.getDeclaredField("ENUM$VALUES");
	               return field.get(CoffeeSize.class);
	           } catch (NoSuchFieldException | IllegalAccessException | SecurityException e) {
	               e.printStackTrace();
	               throw new RuntimeException(e);
	           }
	       }
}
	 public class EnumReader {
	   public static void main(String[] args) {
	       CoffeeSize[] cs = (CoffeeSize[]) CoffeeSize.getEnums();
	       System.out.println(Arrays.toString(cs));
	      }
	   }
