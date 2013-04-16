package framework;

/**
 *
 * @author Josh Gillham
 * @version 3-18-13
 */
public abstract class Grader {
    static public class IncorrectAnswer extends Exception {
        public IncorrectAnswer( String message ) {
            super( message );
        }
    }
    static public int possiblePoints = 0;
}
