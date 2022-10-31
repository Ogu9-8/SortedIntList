package edu.kit.informatik;

import edu.kit.informatik.list.SortedLinkedList;

/**
 * Main class of the programm.
 * 
 * @author Oguz Han Yazici
 * @version 1.0
 */
public final class Main {

    /**
     * The quit command.
     */
    private static final String QUIT = "quit";
    
    /**
     * The current state of the program.
     */
    private static boolean isRunning = false;
    
    /**
     * Block instantiation of this class.
     */
    private Main() {}
    
    /**
     * Main method.
     * 
     * @param args - Unused.
     */
    public static void main(String[] args) {
        final SortedLinkedList list = new SortedLinkedList();
        isRunning = true;
        do {
            Writer.wr(">> ");
            final String input = Writer.input();
            
            if (input.equals(QUIT)) {
                isRunning = false;
                Writer.ln("Stopped program.");
            } else {
                try {
                    Writer.ln(CLI.of(list, input));
                } catch(IllegalArgumentException | IndexOutOfBoundsException e) {
                    Writer.err(e.getMessage());
                }
            }
        } while(isRunning);
    }
}