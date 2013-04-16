

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author jgillham
 */
public class GradeAll {
    static public void main( String[] args ) {
        int score = GradeArrayQuestions.grade();
        int possiblePoints = GradeArrayQuestions.possiblePoints;
        score += GradeLoopQuestions.grade();
        possiblePoints += GradeLoopQuestions.possiblePoints;
        System.out.printf( "You got %d out of %d.\n", score, possiblePoints );
    }    
}
