package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public class background implements IRenderable{
	
	private Image bgImage = null;
	private double currentY;
	private int imageWidth; 
	private int imageHeight; 
	private int screenWidth = 600;// can be changed later (according to our game screen size)
	private int screenHeight = 800;
	private double scrollSpeed = 0.75;
	
	public background(){
		// TODO Auto-generated constructor stub
		bgImage = RenderableHolder.background;
		if (bgImage != null) {
			imageWidth = (int) bgImage.getWidth();
			imageHeight = (int) bgImage.getHeight();
			//System.out.println(imageWidth + " " + imageHeight);
			currentY = 0;
		}
		else{
			imageWidth = 0;
			imageHeight = 0;
		}
	}
	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return Integer.MIN_VALUE;
	}
	
	public void updateBackground() {
		currentY += scrollSpeed;
		if(currentY >= screenHeight) {
			//System.out.println("ตกขอบบบบ");
			currentY = 0;
		}
	}
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		if(bgImage == null) {
			return;
		}
		updateBackground();
		System.out.println(currentY);
		//WritableImage croppedImage = new WritableImage(bgImage.getPixelReader(), 0, currentY, screenWidth, screenHeight);
		gc.drawImage(bgImage, 0, currentY);
		
		gc.drawImage(bgImage, 0, currentY - screenHeight);
		
		updateBackground();
		
		
	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}

}
