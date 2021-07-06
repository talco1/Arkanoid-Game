//319021457
package game;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import animation.Animation;
import animation.AnimationRunner;
import animation.KeyPressStoppableAnimation;
import animation.PauseScreen;
import animation.CountdownAnimation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import collide.Collidable;
import geometry.Point;
import geometry.Rectangle;
import levels.LevelInformation;
import listeners.BallRemover;
import listeners.BlockRemover;
import listeners.ScoreTrackingListener;
import objects.Ball;
import objects.Block;
import objects.Paddle;
import sprite.Sprite;
import sprite.SpriteCollection;

/**
 * A Game class - to create a game: with ball, blocks and etc.
 */
public class GameLevel implements Animation {
    //screen size and finals
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    static final int X_BALL = 400;
    static final int Y_BALL = 550;
    static final int RADIUS = 5;
    static final int SIDE_WIDTH = 25;
    static final int Y_PADDLE = 560;
    static final int HEIGHT_PADDLE = 20;
    static final int ZERO = 0;
    static final int LENGTH = 20;
    static final int NUM_OF_SECONDS = 2;
    static final int COUNT = 3;

    //fields
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Counter remainingBlocks;
    private Counter remainingBalls;
    private Counter score;
    private AnimationRunner runner;
    private boolean running;
    private LevelInformation level;
    private biuoop.KeyboardSensor keyboard;

    /**
     * Constructor.
     * @param level the specific game level.
     * @param keyboard the keyboard sensor.
     * @param runner the animation runner.
     * @param score the score of the level.
     */
    public GameLevel(LevelInformation level, biuoop.KeyboardSensor keyboard, AnimationRunner runner, Counter score) {
        this.level = level;
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.remainingBlocks = new Counter(this.level.numberOfBlocksToRemove());
        this.remainingBalls = new Counter(this.level.numberOfBalls());
        this.score = score;
        this.runner = runner;
        this.keyboard = keyboard;
    }

    /**
     * The method adds a collidable to the game environment.
     *
     * @param c Collide.Collidable object to add.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * The method adds a sprite to the sprite collection of the game.
     *
     * @param s sprite.Sprite object to add.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * The method removes a collidable from the game environment.
     *
     * @param c Collide.Collidable object to remove.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * The method removes a sprite from the sprite collection of the game.
     *
     * @param s sprite.Sprite object to remove.
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * @return the number of remaining blocks in the level.
     */
    public Counter getRemainingBlocks() {
        return this.remainingBlocks;
    }

    /**
     * @return the number of remaining balls in the level.
     */
    public Counter getRemainingBalls() {
        return this.remainingBalls;
    }

    /**
     * @return the score of the level.
     */
    public Counter getScore() {
        return this.score;
    }

    /**
     * The method initializes the game according to the specific level.
     * Adding the balls, blocks, paddle, background and etc.
     * And adding them to the game environment.
     */
    public void initialize() {
        //creating BlockRemover, BallRemover and ScoreTrackingListener
        BlockRemover blockRemover = new BlockRemover(this, this.remainingBlocks);
        BallRemover ballRemover = new BallRemover(this, this.remainingBalls);
        ScoreTrackingListener scoreTracking = new ScoreTrackingListener(this.score);
        //adding the background
        this.addSprite(this.level.getBackground());
        //creating the balls
        List<Ball> balls = new ArrayList<Ball>();
        for (int i = 0; i < level.numberOfBalls(); i++) {
            Ball ball = new Ball(X_BALL, Y_BALL, RADIUS, Color.WHITE);
            ball.setVelocity(this.level.initialBallVelocities().get(i));
            balls.add(ball);
        }
        //adding the screen boundaries to the game environment as blocks
        Block screenUp = new Block(new Rectangle(new Point(ZERO, LENGTH), WIDTH, SIDE_WIDTH),
                Color.GRAY);
        Block screenLeft = new Block(new Rectangle(new Point(ZERO, ZERO), SIDE_WIDTH, HEIGHT), Color.GRAY);
        Block screenRight = new Block(new Rectangle(new Point(WIDTH - SIDE_WIDTH, ZERO), SIDE_WIDTH, HEIGHT),
                Color.GRAY);
        screenLeft.addToGame(this);
        screenRight.addToGame(this);
        screenUp.addToGame(this);
        //creating the death region and adding it as a HitListener
        Block deathRegion = new Block(new Rectangle(new Point(ZERO, HEIGHT), WIDTH, LENGTH), Color.GRAY);
        deathRegion.addToGame(this);
        deathRegion.addHitListener(ballRemover);
        //adding the blocks to the game environment and adding the listeners to them
        for (int i = 0; i < this.level.blocks().size(); i++) {
            Block b = this.level.blocks().get(i);
            b.addToGame(this);
            b.addHitListener(blockRemover);
            b.addHitListener(scoreTracking);
        }
        //creating the paddle and adding it to the game environment
        double width = (double) this.level.paddleWidth();
        Rectangle rect = new Rectangle(new Point((X_BALL - (width / 2)), Y_PADDLE),
                this.level.paddleWidth(), HEIGHT_PADDLE);
        Paddle paddle = new Paddle(rect, Color.ORANGE, this.environment, this.keyboard);
        paddle.addToGame(this);
        //adding the game environment to the balls and add them to the game
        for (int i = 0; i < this.level.numberOfBalls(); i++) {
            Ball b = balls.get(i);
            b.setGameEnvironment(this.environment);
            b.addToGame(this);
        }
        //adding the scoreIndicator to the game
        ScoreIndicator scoreIndicator = new ScoreIndicator(this.score);
        this.addSprite(scoreIndicator);
        //adding the name of the level to the game
        this.addSprite(new LevelName(this.level.levelName()));
    }

    /**
     * The method runs the animation loop of the game.
     */
    public void run() {
        // countdown before turn starts
        this.runner.run(new CountdownAnimation(NUM_OF_SECONDS, COUNT, this.sprites));
        this.running = true;
        // run the level of the game
        this.runner.run(this);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        //drawing all the sprites
        this.sprites.drawAllOn(d);
        //notify time passed
        this.sprites.notifyAllTimePassed();
        if (this.remainingBalls.getValue() == 0) {
            this.running = false;
        }
        if (this.remainingBlocks.getValue() == 0) {
            this.running = false;
            this.score.increase(100);
        }
        //if pause is pressed
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY,
                    new PauseScreen(this.keyboard)));
        }
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }
}
