import java.util.logging.Logger;

public class Playground {

    public static void method1() throws Exception {
        throw new Exception("exception from method1");
    }

    public static void method2() throws Throwable {
        try {
            method1();
        } catch (Exception caughtException) {
            Throwable e = new Exception("exception from method2");
            e.initCause(caughtException);
            throw e;
        }
    }

    public static void main(String[] args) {
        try {
            method2();
        } catch (Throwable caughtException) {
            System.out.println(caughtException);
            System.out.println(caughtException.getCause());
            Logger.getGlobal().info(caughtException.toString());
        }
    }
}
