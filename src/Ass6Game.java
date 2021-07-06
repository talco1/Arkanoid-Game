//319021457
import animation.AnimationRunner;
import game.GameFlow;
import levels.FirstLevel;
import levels.LevelInformation;
import levels.SecondLevel;
import levels.ThirdLevel;
import levels.FourthLevel;
import java.util.ArrayList;
import java.util.List;

/**
 * Ass5Game - putting all the project together.
 */
public class Ass6Game {

    /**
     * main method to run the game.
     *
     * @param args string from main.
     */
    public static void main(String[] args) {
        List<LevelInformation> levels = new ArrayList<>();
        // add the levels according to the input from the user
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("1")) {
                levels.add(new FirstLevel());
            }
            if (args[i].equals("2")) {
                levels.add(new SecondLevel());
            }
            if (args[i].equals("3")) {
                levels.add(new ThirdLevel());
            }
            if (args[i].equals("4")) {
                levels.add(new FourthLevel());
            }
        }
        //if the list is empty - run 4 levels
        if (levels.isEmpty()) {
            levels.add(new FirstLevel());
            levels.add(new SecondLevel());
            levels.add(new ThirdLevel());
            levels.add(new FourthLevel());
        }
        //create the animation runner of the game
        AnimationRunner runner = new AnimationRunner();
        biuoop.KeyboardSensor keyboard = runner.getGui().getKeyboardSensor();
        //create the game and run it
        GameFlow game = new GameFlow(runner, keyboard);
        game.runLevels(levels);
    }
}
