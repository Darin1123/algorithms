import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Playground {

    public static void main(String[] args) {
        System.out.println(A.V);
        A a = new A();
        System.out.println(a.V);
    }
}


class A {
    public final static int V = 100;

    private int a;
}
