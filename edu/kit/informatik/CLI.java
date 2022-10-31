package edu.kit.informatik;

import java.util.regex.Pattern;

import edu.kit.informatik.list.SortedLinkedList;

/**
 * A command-line interface for the {@link SortedLinkedList}.
 * 
 * @author Oguz Han Yazici
 * @version 1.0
 */
abstract class CLI {
    
    /**
     * All available commands.
     */
    private static final CLI[] COMMANDS = new CLI[] {
        new CLI("print") {
            @Override
            public String exec(SortedLinkedList list, String cmd) {
                return list.toString();
            }
        },
        
        new CLI("clear") {
            @Override
            public String exec(SortedLinkedList list, String cmd) {
                return list.clear();
            }
        
        },
        
        new CLI("size") {
            @Override
            public String exec(SortedLinkedList list, String cmd) {
                return String.valueOf(list.size());
            }
        },
        
        new CLI("isEmpty") {
            @Override
            public String exec(SortedLinkedList list, String cmd) {
                return String.valueOf(list.isEmpty());
            }
        },
        
        new CLI("contains -?\\d+") {
            @Override
            public String exec(SortedLinkedList list, String cmd) {
                return String.valueOf(list.contains(Integer.parseInt(cmd.split("\\s")[1])));
            }
        },
        
        new CLI("indexOf -?\\d+") {
            @Override
            public String exec(SortedLinkedList list, String cmd) {
                return String.valueOf(list.contains(Integer.parseInt(cmd.split("\\s")[1])));
            }
        },
        
        new CLI("lastIndexOf -?\\d+") {
            @Override
            public String exec(SortedLinkedList list, String cmd) {
                return String.valueOf(list.contains(Integer.parseInt(cmd.split("\\s")[1])));
            }
        },
        
        new CLI("remove -?\\d+") {
            @Override
            public String exec(SortedLinkedList list, String cmd) {
                return String.valueOf(list.remove(Integer.parseInt(cmd.split("\\s")[1])));
            }
        },
        
        new CLI("removeIndex \\d+") {
            @Override
            public String exec(SortedLinkedList list, String cmd) {
                return String.valueOf(list.removeIndex(Integer.parseInt(cmd.split("\\s")[1])));
            }
        },
        
        new CLI("add -?\\d+") {
            @Override
            public String exec(SortedLinkedList list, String cmd) {
                return list.add(Integer.parseInt(cmd.split("\\s")[1]));
            }
        }
    };
    
    /**
     * The pattern of the command.
     */
    private final Pattern pattern;
    
    /**
     * Creates a new pattern for a command.
     * @param pattern The pattern of this command.
     */
    private CLI(String pattern) {
        this.pattern = Pattern.compile(pattern);
    }
   
    public static String of(SortedLinkedList list, String cmd) {
        for (CLI command : COMMANDS) {
            if (command.pattern.matcher(cmd).matches())
                return command.exec(list, cmd);
        }
        throw new IllegalArgumentException("The provided command does not exist!");
    }
    
    /**
     * Executes this command for the specified {@linkplain SortedLinkedList list}
     * and returns the result.
     * 
     * @param list The list to execute the command on.
     * @param cmd  The command to execute on the list.
     * @return the result of the operation.
     */
    public abstract String exec(SortedLinkedList list, String cmd);
}