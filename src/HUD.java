import java.awt.*;

/**
 * Created by Xlv QT on 11/25/2016.
 */
public class HUD {

    public static int score=0;
    public static int level=1;

    public void tick(){
        score++;
    }

    public void render(Graphics g){
        g.setColor(Color.white);
        g.drawString("Score: "+ score,15,16);
        g.drawString("Level: "+ level,15,32);
    }

    public void score(int score){
        this.score=score;
    }

    public int getScore(){
        return score;
    }

    public int getLevel(){
        return level;
    }
    public void setLevel(int level){
        this.level=level;
    }
}
