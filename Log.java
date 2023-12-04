public class Log  
{
    public static boolean debug = false;

    public static void info(String input) {
        if(debug) {
            System.out.println(input);
        }
    }

    public static void info(int input) {
        if(debug) {
            System.out.println(input);
        }
    }

    public static void info(double input) {
        if(debug) {
            System.out.println(input);
        }
    }
}
