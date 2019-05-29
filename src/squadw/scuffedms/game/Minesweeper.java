package squadw.scuffedms.game;

import squadw.scuffedms.game.board.Board;
import squadw.scuffedms.game.tile.Mine;
import squadw.scuffedms.game.tile.Tile;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Minesweeper extends JFrame {

    private JPanel boardPanel = new JPanel();
    private JPanel content = new JPanel();

    private Board board;
    private int w;
    private int h;

    public Minesweeper(int s, int d) {
        board = new Board(s,d);
        w = board.getSize() * 40;
        h = board.getSize() * 40 + 20;
        initPanel();
        initFrame();
        initButtons();
        setVisible(true);
        printBoard();
    }

    public void printBoard() {
        Tile[][] temp = board.getBoard();

        for (int i = 0; i < board.getSize(); i++) {
            System.out.println();
            for (int j = 0; j < board.getSize(); j++) {
                System.out.print(temp[i][j] + " ");
            }
        }
    }


    private void initButtons() {
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                board.getBoard()[i][j].getButton().addButtonToFrame(boardPanel);
            }
        }
    }

    private void initPanel() {
        content.setSize(w, h);
        content.setFocusable(true);
        content.setFocusTraversalKeysEnabled(false);
        getContentPane().add(content);
        initLayout();
    }

    private void initLayout(){
        LayoutManager layout = new BoxLayout(content, BoxLayout.Y_AXIS);
        Box[] boxes = new Box[2];
        boxes[0] = Box.createHorizontalBox();
        boxes[1] = Box.createHorizontalBox();

        boxes[0].createGlue();
        boxes[1].createGlue();

        content.add(boxes[0]);
        content.add(boxes[1]);

        JPanel panel = new JPanel();
        boardPanel.setLayout(new GridLayout(board.getSize(), board.getSize(), 0, 0));
        boardPanel.setPreferredSize(new Dimension(w,h * (7/8)));
        panel.setPreferredSize(new Dimension(w, h * (1/8)));

        boxes[0].add(boardPanel);
        boxes[1].add(panel);
    }

    private void initFrame() {
        setSize(w, h);
        setFocusable(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setFocusTraversalKeysEnabled(false);
        setTitle("Scuffed Minesweeper");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        try { setIconImage(ImageIO.read(getClass().getResource("/squadw/scuffedms/resources/images/flag.png"))); }
        catch(IOException e) { System.out.println(e); }
    }
}
