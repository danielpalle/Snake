import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI {
    static Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    static GameSquare[][] square = new GameSquare[20][20];
    static JFrame f = new JFrame();
    static JPanel upperborder = new JPanel();
    static JPanel gamearea = new JPanel();
    static JPanel lowerborder = new JPanel();
    static JButton presstostartbutton = new JButton("Press to start");
    static JLabel steersnake = new JLabel("Steer snake with arrowkeys");

    public static void createGameWindow() {
        f.setPreferredSize(new Dimension(400, 500));
        f.setLayout(new BorderLayout());
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setTitle("Snake");
        f.setFocusable(true);

        f.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    if (GameControl.movesnakedirection!="left")
                    GameControl.movesnakedirection = "right";
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    if (GameControl.movesnakedirection!="down")
                    GameControl.movesnakedirection = "up";
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    if (GameControl.movesnakedirection!="right")
                    GameControl.movesnakedirection = "left";
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (GameControl.movesnakedirection!="up")
                    GameControl.movesnakedirection = "down";
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        upperborder.setPreferredSize(new Dimension(400, 50));
        upperborder.setBackground(Color.lightGray);
        f.add("North", upperborder);
        presstostartbutton.setFont(new Font("Arial", Font.PLAIN, 20));
        upperborder.add(presstostartbutton);

        presstostartbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameControl.createSnake();
                MoveSnakeTimer.startGame();
                lowerborder.add(steersnake);
                upperborder.remove(presstostartbutton);
                upperborder.repaint();
            }
        });

        lowerborder.setPreferredSize(new Dimension(400, 50));
        lowerborder.setBackground(Color.lightGray);
        f.add("South", lowerborder);

        gamearea.setPreferredSize(new Dimension(400, 400));
        gamearea.setBackground(Color.black);
        f.add("Center", gamearea);
        gamearea.setLayout(new GridLayout(20,20));

        f.pack();
        f.setVisible(true);
        f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
    }

    public static void createGameGrid() {
        for (int i = 0; i< GUI.square.length; i++) {
            for (int j = 0; j < GUI.square[i].length; j++) {
                GUI.square[i][j] = new GameSquare(i, j);
                GUI.gamearea.add(GUI.square[i][j]);
                GUI.square[i][j].setBackground(Color.black);
            }
        }
        GUI.f.setVisible(true);
    }
}
