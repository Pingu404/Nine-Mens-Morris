import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Component; 
import java.util.Map;

public static void main (String[] args) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 600);
    JPanel panel = new JPanel();
    panel.add(new Board()); 
    frame.add(panel);
    frame.setVisible(true);
}

//Game game = new Game ("Player 1", "Player 2");
//game.play;
