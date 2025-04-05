// A class serves as a blueprint to create objects
public class Main {
    public static void main(String[] args) {
        // Creating an object of the class
        classname obj = new classname();

        // Setting instance variables
        obj.var1 = 10;
        obj.var2 = "Java class";

        // Calling a method and printing result
        int result = obj.method1(5);
        System.out.println("Result from method1: " + result);
    }
}

// and objects are an instance of a class
class classname {
    // instance variables
    int var1;
    String var2;

    // method with a parameter
    int method1(int value) {
        // Example logic: add the parameter to var1
        return var1 + value;
    }
}
