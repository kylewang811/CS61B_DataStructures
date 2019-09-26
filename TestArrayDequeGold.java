import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    @Test
    public void testDeque() {
        //@Source Joshua Hug
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> correct1 = new ArrayDequeSolution<>();

        int counter = 0;
        String errorMessage = "";

        while (true) {
            double random = StdRandom.uniform();
            if (random >= 0 && random < 0.25) {
                if (!(sad1.size() == 0) && !(correct1.size() == 0)) {
                    Integer studentNum = sad1.removeFirst();
                    Integer correctNum = correct1.removeFirst();
                    errorMessage = errorMessage + "removeFirst(" + studentNum + ")\n";
                    assertEquals(errorMessage, studentNum, correctNum);
                }
            } else if (random >= .25 && random < .5) {
                if (!(sad1.size() == 0) && !(correct1.size() == 0)) {
                    Integer studentNum = sad1.removeLast();
                    Integer correctNum = correct1.removeLast();
                    errorMessage = errorMessage + "removeLast(" + studentNum + ")\n";
                    assertEquals(errorMessage, studentNum, correctNum);
                }
            } else if (random >= .5 && random < .75) {

                sad1.addFirst(counter);
                correct1.addFirst(counter);
                errorMessage = errorMessage + "addFirst(" + counter + ")\n";
            } else {

                sad1.addLast(counter);
                correct1.addLast(counter);
                errorMessage = errorMessage + "addLast(" + counter + ")\n";
            }
            counter += 1;
        }
    }
}
