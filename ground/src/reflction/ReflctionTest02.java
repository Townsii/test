package reflction;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflctionTest02 {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Town> clazz = Town.class;
        Constructor<Town> con = clazz.getDeclaredConstructor(int.class, Human.class);
        Town town = con.newInstance(5,new Human());
        Method str = clazz.getDeclaredMethod("st", int.class, Human.class);
        System.out.println(town.toString());
        System.out.println(town.human.toString());
        str.setAccessible(true);
        str.invoke(town,10,new Human("111",111,true));
    }


}
