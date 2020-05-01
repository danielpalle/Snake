import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI {
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    GameSquare[][] square = new GameSquare[20][20];
    JFrame f = new JFrame();
    JPanel upperborder = new JPanel();
    JPanel gamearea = new JPanel();
    JPanel lowerborder = new JPanel();
    JButton presstostartbutton = new JButton("Press to start");
    JLabel steersnake = new JLabel("Steer snake with arrow keys");
    GameControl gamecontrol1;

    public GUI(GameControl k){
        gamecontrol1 = k;
    }

    public void createGameWindow() {
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
                    if (gamecontrol1.getMoveSnakeDirection() != "left")
                        gamecontrol1.setMoveSnakeDirection("right");
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    if (gamecontrol1.getMoveSnakeDirection() != "down")
                        gamecontrol1.setMoveSnakeDirection("up");
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    if (gamecontrol1.getMoveSnakeDirection() != "right")
                        gamecontrol1.setMoveSnakeDirection("left");
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (gamecontrol1.getMoveSnakeDirection() != "up")
                        gamecontrol1.setMoveSnakeDirection("down");
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
                gamecontrol1.createSnake();
                gamecontrol1.placeFood();
                gamecontrol1.startGame();
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

        createGameGrid();
    }

    public void createGameGrid() {
        for (int i = 0; i< square.length; i++) {
            for (int j = 0; j < square[i].length; j++) {
                square[i][j] = new GameSquare(i, j);
                gamearea.add(square[i][j]);
                square[i][j].setBackground(Color.black);
            }
        }
        f.setVisible(true);
    }
}
