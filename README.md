# Sorted Int List
Solution for the submission task "Sorted Integer Linked List" on the Karlsruher Institute of Technology
for the lecture "Programming 1" of the course "Bachelor of Computer Science".

# Task
The task was from 2018/2019. A linked list for integers should be implemented, which automatically sorts
all elements inside the list in natural order (smallest to biggest). Following methods should be
included:
<ul>
    <li>size
    <li>contains
    <li>isEmpty
    <li>toString
    <li>add
    <li>remove
    <li>removeIndex
    <li>indexOf
    <li>lastIndexOf
    <li>clear
</ul>
The implementation should be accessible through a <strong>command line interface</strong>. Only the
usage of the provided helper class <code>Writer</code> and the packages <code>java.lang</code>, 
<code>java.util.regex</code> is allowed.

# Usage
When the program is started, the interface is immediately available. All available commands:
<ul>
    <li><code>size</code>: Prints the current size of the list.
    <li><code>contains <integer></code>: Prints <code>true</code> if the list contains the value, otherwise <code>false</code>.
    <li><code>isEmpty</code>: Prints <code>true</code> if the list is empty, otherwise <code>false</code>.
    <li><code>print</code>: Prints the list.
    <li><code>add <integer></code>: Adds the specified integer to the list.
    <li><code>remove <integer></code>: Removes the specified integer from the list.
    <li><code>removeIndex <integer></code>: Removes the element at the specified index from the list.
    <li><code>indexOf <integer></code>: Prints the index of the first occurrence of the specified value if it exist, otherwise -1 is printed.
    <li><code>lastIndexOf <integer></code>: Prints the index of the last occurrence of the specified value if it exist, otherwise -1 is printed.
    <li><code>clear</code>: Removes all elements from this list.
    <li><code>quit</code>: Ends the program.
</ul>
