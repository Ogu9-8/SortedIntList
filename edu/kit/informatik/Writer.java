package edu.kit.informatik;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Global utility-class to provide easy printing methods (see 
 * {@link #ln(Object)} and {@link #err(Object)} and easy input 
 * reader methods {@link #input()}.
 * <p>
 * This class is a substitution class to a <i>non-public</i>
 * class provided by the university. It basically shares the same
 * functionality, and only the usage of this class was allowed for
 * I/O operations.
 * <p>
 * This class was the only allowed class to use for the exam,
 * besides the packages {@code java.lang}, {@code java.util}
 * and {@code java.util.regex}.
 * 
 * @author Oguz Han Yazici
 * @version 1.1
 */
public final class Writer {
    /** Reader to read from the standard input stream. */
    private static final BufferedReader IN = new BufferedReader(new InputStreamReader(System.in));
    private Writer() { }
   
    /**
     * Prints the given {@code object} to the standard 
     * output stream.
     * 
     * @param o The object to print.
     */
    public static void wr(Object o) {
        System.out.print(o);
    }
    
    /**
     * Prints the given {@code object} on a separate line to 
     * the standard output stream.
     * 
     * @implNote
     * If the provided argument {@code o} is <b>null</b>, then
     * the string {@code null} is printed.
     * 
     * @param o The object to print.
     */
    public static void ln(Object o) {
        System.out.println(o);
    }
   
    /**
     * Prints the given {@code object} on a separate line to 
     * the standard output stream as an {@code error}.
     * 
     * @implNote
     * If the provided argument {@code o} is <b>null</b>, then
     * the string {@code null} is printed.
     * 
     * @param o The object to print.
     */
    public static void err(Object o) {
        System.err.println("Error: " + o);
    }
    
    /**
     * Reads the next line of text from the standard input stream.
     * @return the read line as a {@code string}.
     */
    public static String input() {
        try {
            return IN.readLine();
        // Catch and rethrow as a RuntimeException. Will be handled later.
        } catch (IOException e) { throw new RuntimeException(e); }
    }
}