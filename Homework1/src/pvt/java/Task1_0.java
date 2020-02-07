package pvt.java;

public class Task1_0 {
    public static void main(String[] args) {
	/*
	 ++i is called pre-increment operator since ++ precedes the argument.
     i++ is called post-increment operator since ++ is placed post argument.
     Both of these increment the value of the operand only by 1.
     Pre-increment operator increments the value before it is used in the statement.
     Pre-increment operator increments the value after it is used in the statement.
	 */
        int increment1 = 1;
        System.out.println(++increment1); // Will print 2 since value of i is first incremented and then used.
        int increment2 = 1;
        System.out.println(increment2++); // Will print 1 because first the value is used and then incremented.
    }
}
