# Matching Brackets

## Tasks

In this exercise you are tasked within creating a program that can evaluate whether there is a balance within a string
of brackets. An example of this is `[{}]` where there are equally many opening brackets as there are closing.
`[{()]` is an example of no balance between the brackets as we are missing one.

### Task 1

Implement the `ckeckBrackets` method.

To see whether an expression of the form “`–{ [b ⋅ b – (4 ⋅ a ⋅ c ) ] / (2 ⋅ a) }`” is correctly formed, place the
parentheses onto a `Stack<Character>`:

- When you see an opening parenthesis, push it on the stack.
- When you see a closing parenthesis, pop the stack.
- If the opening and closing parentheses don’t match - the parentheses are unbalanced. Exit.
- If at the end the stack is empty - the parentheses are balanced.
- Else:    The parentheses are not balanced.

### Task 2

- Use a `List<Character>` instead of a `Stack`, implement your own version of `push()` and `pop()` - remember that values should be inserted and retrieved in a FIFO (first in, first out) manner. 
    - You are free to create a new class for this purpose, if you don't want to overwrite the existing one.

![stack](assets/stack.png)

- The main method should now take a file as an input instead of input from the keyboard.