package stuffhere.graphics.Animation;

import java.util.ArrayList;

import stuffhere.graphics.Sprite;
import stuffhere.input.Keyboard;
import stuffhere.input.Mouse;

public class Animation {
	//Normal frames
	private ArrayList<Frame> frames;
	
	// Direction frames
	private ArrayList<Frame> framesLeft;
	private ArrayList<Frame> framesRight;
	private ArrayList<Frame> framesUp;
	private ArrayList<Frame> framesDown;
	
	// Fields
	private boolean animationStarted = false;
	private int animationCounter = 0;
	private int totalFrameDuration = 0;
	private Frame currentFrame;
	private int currentFrameNum = 0;
	private boolean animationInProgress = false;

	public Animation() {
		frames = new ArrayList<>();
		framesLeft = new ArrayList<>();
		framesRight = new ArrayList<>();
		framesUp = new ArrayList<>();
		framesDown = new ArrayList<>();

	}

	private void setTotalFrameDuration(ArrayList<Frame> frames) {
		for (Frame frame : frames) {
			totalFrameDuration += frame.getDuration();
		}
	}

	private boolean isLastFrame(ArrayList<Frame> frames) {
		if (currentFrameNum == frames.size() - 1)
			return true;
		return false;
	}
	
	private void doAnimation(ArrayList<Frame> framesWithDirection) {
		
		if (animationCounter > currentFrame.getDuration()) {
			if (isLastFrame(framesWithDirection)) {
				currentFrame = framesWithDirection.get(0);
				currentFrameNum = 0;
				resetAnimationCounter();
				return;
			}
			currentFrameNum++;
			currentFrame = framesWithDirection.get(currentFrameNum);
			resetAnimationCounter();
		}
		incrementAnimationCounter();
	}

	public void update(Keyboard key, Mouse mouse) {
		
		// Makes sure that we only do one animation even if we press two or more buttons on the keyboard.
		animationInProgress = false;

		if (key.down && !animationInProgress) {
			doAnimation(framesDown);
			animationInProgress = true;
		}

		if (key.up && !animationInProgress) {
			doAnimation(framesUp);
			animationInProgress = true;
		}
		
		if (key.left && !animationInProgress) {
			doAnimation(framesLeft);
			animationInProgress = true;
		}
		
		if (key.right && !animationInProgress) {
			doAnimation(framesRight);
			animationInProgress = true;
		}
	}

	public Sprite getCurrentSprite() {
		return currentFrame.getSprite();
	}

	public void addFrame(String path, int duration, String listName) {
		if (listName.equals("normal")) frames.add(new Frame(path, duration));
		if (listName.equals("left")) framesLeft.add(new Frame(path, duration));
		if (listName.equals("right")) framesRight.add(new Frame(path, duration));
		if (listName.equals("down")) framesDown.add(new Frame(path, duration));
		if (listName.equals("up")) framesUp.add(new Frame(path, duration));

	}

	public void incrementAnimationCounter() {
		if (animationStarted)
			animationCounter++;
	}

	public void resetAnimationCounter() {
		animationCounter = 0;
	}

	public Frame getCurrentFrame() {
		return currentFrame;
	}

	public void startAnimation() {
		animationStarted = true;
		currentFrame = frames.get(currentFrameNum);
		setTotalFrameDuration(frames);
	}

	public void stopAnimation() {
		animationStarted = false;
	}

	public int getTotalFrameDuration() {
		return totalFrameDuration;
	}

	public int getAnimationCounter() {
		return animationCounter;
	}

}
