import javax.swing.*;
import java.awt.*;

/**
 * Created by Xlv QT on 11/23/2016.
 */
public class Window extends Canvas {


    private static final long serialVersionUID = -8941317020691014725L;

    public Window(int width, int height, String title, Game game){
        JFrame frame=new JFrame(title);

        frame.setPreferredSize(new Dimension(width,height));
        frame.setMaximumSize(new Dimension(width,height));
        frame.setMinimumSize(new Dimension(width,height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }
}