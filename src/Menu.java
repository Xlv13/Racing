import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * Created by Darius on 2/23/2017.
 */
public class Menu extends MouseAdapter{
    private int maxScore;
    private Game game;
    private Handler handler;
    private Random r=new Random();
    public Menu(Game game,Handler handler){
        this.game=game;
        this.handler=handler;
    }
    public void mousePressed(MouseEvent e){
        int mx=e.getX();
        int my=e.getY();
        if(game.gameState== Game.STATE.Menu){
            if(mouseOver(mx,my,90,110,150,64)){
                HUD.score=0;
                HUD.level=0;
                GameObject.incr=0.4;
                game.addKeyListener(new KeyInput(handler));
                AudioPlayer.getSound("menu_sound").play();
                handler.clearMenu();
                handler.addObject(new Player(Game.WIDTH/2-32,Game.HEIGHT-92,ID.Player,handler,game));
                game.gameState= Game.STATE.Game;
            }
            //help
            if(mouseOver(mx,my,90,210,150,64)){
                game.gameState= Game.STATE.Help;
                AudioPlayer.getSound("menu_sound").play();
            }

            //quit
            if(mouseOver(mx,my,90,310,150,64)){
            	AudioPlayer.getSound("menu_sound").play();
                System.exit(1);
            }

        }

        if(game.gameState== Game.STATE.Help){
            if(mouseOver(mx,my,90,370,150,64)){
                game.gameState= Game.STATE.Menu;
                AudioPlayer.getSound("menu_sound").play();
                return;
            }
        }
    }

    public void mouseReleased(MouseEvent e){

    }

    private boolean mouseOver(int mx,int my,int x,int y,int width,int height){
        if(mx> x && mx<x+width){
            if(my>y && my<y+height){
                return true;
            }else return false;
        }else return false;
    }

    public void tick(){
    }


    public void render(Graphics g) {
        if(maxScore<HUD.score)
        maxScore=HUD.score;
        if (game.gameState == Game.STATE.Menu) {
            Font fnt = new Font("arial", 1, 40);
            Font fnt2 = new Font("arial", 1, 25);
            Font fnt3 = new Font("arial", 1, 15);
            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Menu", 110, 35);

            g.setFont(fnt2);

            g.drawRect(90, 110, 150, 64);
            g.drawString("Play", 140, 150);

            g.drawRect(90, 210, 150, 64);
            g.drawString("Help", 140, 250);

            g.drawRect(90, 310, 150, 64);
            g.drawString("Quit", 140, 350);

            g.setFont(fnt3);
            g.drawString("Your max score is: "+maxScore, 90, 480);
        } else if (game.gameState == Game.STATE.Help) {
            Font fnt = new Font("arial", 1, 40);
            Font fnt2 = new Font("arial", 1, 25);
            Font fnt3 = new Font("arial", 1, 15);
            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Help", 110, 35);

            g.setFont(fnt3);
            g.drawString("Use arrow keys to move player and",10,200);
            g.drawString("dodge enemies",5,220);


            g.setFont(fnt2);
            g.drawRect(90, 370, 150, 64);
            g.drawString("Back", 140, 410);
        }

    }
}
