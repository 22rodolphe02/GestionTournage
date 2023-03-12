package repository;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MyClass<T> {

    public MyClass() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            if (actualTypeArguments.length > 0) {
                Class<?> type = (Class<?>) actualTypeArguments[0];
                System.out.println(type.getName());
            }
        } else {
            Class<?> superClass = (Class<?>) genericSuperclass;
            System.out.println(superClass.getName());
        }
    }

    public static void main(String[] args) {
        MyClass<String> strings = new MyClass<>();
//        System.out.println(strings.);
//        System.out.println(strings.getClass().);
//        System.out.println(strings.get(0);
    }
}
