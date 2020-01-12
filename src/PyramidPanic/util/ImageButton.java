package PyramidPanic.util;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageButton extends UIObject {

    private BufferedImage image;
    private Clicker click;

    public ImageButton(float x, float y, int width, int height, BufferedImage image, Clicker click){
        super(x, y, width, height);
        this.image = image;
        this.click = click;
    }


    @Override
    public void update(){}

    @Override
    public void render(Graphics g) { g.drawImage(image, (int) x, (int) y, width, height, null); }

    @Override
    public void onClick() {
        click.onClick();
    }
}
