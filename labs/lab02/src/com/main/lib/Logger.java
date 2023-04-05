package com.main.lib;

public class Logger {

    private static short indent = 0;

    public static void logOK(String out) {
        log("\033[92m" + out + " \033[0m");
    }

    public static void logErr(String out) {
        log("\033[91m" + out + " \033[0m");
    }

    public static void log(String out) {
        System.out.println(indent() + out);
    }

    public static void startTest(String name) {
        log("==== TEST " + name + "====");
        indent++;
    }

    public static void testOK(String input, String output) {
        logOK("passed. " + input + " => " + output);
    }

    public static void testErr(String input, String output, String expected) {
        logErr("failed. " + input + " => " + output);
        indent++;
        logErr("Expected " + expected);
        indent--;
    }

    public static void endTest() {
        indent--;
    }

    private static String indent() {
        String res = "";
        for (short i = 0; i < indent; i++)
            res += "  ";
        return res;
    }
}
