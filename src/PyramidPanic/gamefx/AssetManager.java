package PyramidPanic.gamefx;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static javax.imageio.ImageIO.read;

public class AssetManager {

    /*1 wall,3 border,4 sword,5 horiz block,6 vert block*/
    public static BufferedImage background, wall, border, horiz_block, vert_block, sword_block;
    public static BufferedImage player_down, player_up, player_left, player_right;
    public static BufferedImage mummy_down, mummy_up, mummy_left, mummy_right;
    public static BufferedImage scorpion_left, scorpion_right;
    public static BufferedImage beetle_up, beetle_down;
    public static BufferedImage anubis, amulet, scarab, sword;
    public static BufferedImage menuBG, start, help, quit, titleImg, winImg, loseImg;

    public static void init() {
        try {
            background = read(AssetManager.class.getResource("/Background2.bmp"));
            wall = read(AssetManager.class.getResource("/Wall1.gif"));
            border = read(AssetManager.class.getResource("/Wall2.gif"));
            horiz_block = read(AssetManager.class.getResource("/Block_hor.gif"));
            vert_block = read(AssetManager.class.getResource("/Block_vert.gif"));
            sword_block = read(AssetManager.class.getResource("/Door.gif"));

            player_down = read(AssetManager.class.getResource("/Explorer_down.gif"));
            player_up = read(AssetManager.class.getResource("/Explorer_up.gif"));
            player_left = read(AssetManager.class.getResource("/Explorer_left.gif"));
            player_right = read(AssetManager.class.getResource("/Explorer_right.gif"));

            mummy_down = read(AssetManager.class.getResource("/Mummy_down.gif"));
            mummy_up = read(AssetManager.class.getResource("/Mummy_up.gif"));
            mummy_left = read(AssetManager.class.getResource("/Mummy_left.gif"));
            mummy_right = read(AssetManager.class.getResource("/Mummy_right.gif"));

            scorpion_left = read(AssetManager.class.getResource("/Scorpion_left.gif"));
            scorpion_right = read(AssetManager.class.getResource("/Scorpion_right.gif"));

            beetle_down = read(AssetManager.class.getResource("/Beetle_down.gif"));
            beetle_up = read(AssetManager.class.getResource("/Beetle_up.gif"));

            anubis = read(AssetManager.class.getResource("/Treasure2.gif"));
            amulet = read(AssetManager.class.getResource("/Treasure1.gif"));
            sword = read(AssetManager.class.getResource("/Sword.gif"));
            scarab = read(AssetManager.class.getResource("/Scarab.gif"));

            menuBG = read(AssetManager.class.getResource("/Background1.bmp"));
            start = read(AssetManager.class.getResource("/Button_start.gif"));
            help = read(AssetManager.class.getResource("/Button_help.gif"));
            quit = read(AssetManager.class.getResource("/Button_quit.gif"));
            titleImg = read(AssetManager.class.getResource("/Title.gif"));

            winImg = read(AssetManager.class.getResource("/win_image.png"));
            loseImg = read(AssetManager.class.getResource("/lose_image.png"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}