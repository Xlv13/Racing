import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Xlv QT on 11/23/2016.
 */
public class Handler {

    LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void tick(){
        for(int i=0;i<object.size();i++){
            GameObject tempObject=object.get(i);
            tempObject.tick();
        }
    }

    public void render(Graphics g){
        GameObject tempObject;
        if(object!=null)
        for(int i=0;i<object.size();i++) {
            if(object.get(0)!=null) {
                tempObject = object.get(i);
                tempObject.render(g);
            }
        }
    }

    public void clearEnemies(){
        for(int i=0;i<object.size();i++) {
            GameObject tempObject = object.get(i);
            if (tempObject.getID() == ID.Player) {
                object.clear();
                if (Game.gameState != Game.STATE.End)

                    addObject(new Player((int) tempObject.getX(), (int) tempObject.getY(), ID.Player, this));
            }
            }
    }

    public void addObject(GameObject object){
        this.object.add(object);
    }

    public void removeObject(GameObject object){
        this.object.remove(object);
    }

}
