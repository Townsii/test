package reflction;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class reflctionTest {

    public static void main(String[] args){
        try{
            Class<Human> clazz = Human.class;
            Field[] sf = clazz.getDeclaredFields();
            Field na = clazz.getDeclaredField("name");
            Method sn = clazz.getDeclaredMethod("setName", String.class);
            Constructor<Human> declaredConstructor = clazz.getDeclaredConstructor(String.class, int.class, boolean.class);
            Human human = declaredConstructor.newInstance("town",20,true);
            sn.invoke(human,"townsii");
            test ts = na.getDeclaredAnnotation(test.class);
            sf[1].setAccessible(true);
            sf[1].set(human,10);

            System.out.println(ts.value());
        }catch (Exception e) {
            e.printStackTrace();
        }



    }


}


