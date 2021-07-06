//319021457
package game;
import animation.AnimationRunner;
import animation.GameOver;
import animation.KeyPressStoppableAnimation;
import animation.YouWin;
import biuoop.KeyboardSensor;
import levels.LevelInformation;
import java.util.List;

/**
 * Game Flow - in charge of creating the levels of the game and moving from one level to the next.
 */
public class GameFlow {
    //fields
    private AnimationRunner runner;
    private biuoop.KeyboardSensor keyboard;
    private Counter score;

    /**
     * Constructor.
     * @param runner the animation runner of the game.
     * @param keyboard a keyboard sensor.
     */
     public GameFlow(AnimationRunner runner, biuoop.KeyboardSensor keyboard) {
         this.runner = runner;
         this.keyboard = keyboard;
         this.score = new Counter(0);
     }

    /**
     * The method runs all the levels of the game.
     *
     * @param levels the game levels.
     */
    public void runLevels(List<LevelInformation> levels) {
         int wins = 0; //if the player removed all the blocks
        for (LevelInformation levelInfo : levels) {
            //create a gameLevel of the specific level, initialize and run it.
            GameLevel level = new GameLevel(levelInfo, this.keyboard, this.runner, this.score);
            level.initialize();
            level.run();
            //if there are no more balls - the player died
            if (level.getRemainingBalls().getValue() == 0) {
                this.runner.run(new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY,
                        new GameOver(this.keyboard, level.getScore())));
                break;
            }
            if (level.getRemainingBlocks().getValue() == 0) {
                wins++; //count if the player removed all the blocks in the level
            }
            //the player won the game
            if (wins == levels.size()) {
                this.runner.run(new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY,
                        new YouWin(this.keyboard, level.getScore())));
                break;
            }
        }
        runner.getGui().close();
    }
}
