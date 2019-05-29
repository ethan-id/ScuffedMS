package squadw.scuffedms;

import squadw.scuffedms.game.Minesweeper;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class Game extends JFrame {

    private Minesweeper game;

    public Game() {
        initFrame();
        startScreen();
        setVisible(true);
    }

    public Game(int s, int d) {
        game = new Minesweeper(s, d);
        game.setVisible(true);
    }

    public Game(int s) {
        this(s, 2);
    }

    private void initFrame() {
        setSize(400, 500);
        setFocusable(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setFocusTraversalKeysEnabled(false);
        setTitle("Scuffed Minesweeper");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
        catch (Exception e) { System.out.println(e); }
        try { setIconImage(ImageIO.read(getClass().getResource("/squadw/scuffedms/resources/images/flag.png"))); }
        catch(IOException e) { System.out.println(e); }
    }

    private void startScreen() {
        JPanel panel = new JPanel();
        JButton p = new JButton("Play");

        panel.setLayout(new GridBagLayout());
        setContentPane(panel);

        p.setAlignmentX(Component.CENTER_ALIGNMENT);
        p.setAlignmentY(Component.CENTER_ALIGNMENT);
        p.setPreferredSize(new Dimension(150,65));
        panel.add(p);

        p.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panel.setVisible(false);
                sizeScreen();
            }
        });
    }

    private void sizeScreen() {
        JPanel panel = new JPanel();
        GridBagConstraints c = new GridBagConstraints();
        JButton s = new JButton("Small");
        JButton m = new JButton("Medium");
        JButton l = new JButton("Large");

        panel.setLayout(new GridBagLayout());

        c.gridwidth = GridBagConstraints.REMAINDER;
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.VERTICAL;
        c.insets = new Insets(5,0,5,0);

        s.setPreferredSize(new Dimension(150,50));
        m.setPreferredSize(new Dimension(150,50));
        l.setPreferredSize(new Dimension(150,50));

        panel.add(s, c);
        panel.add(m, c);
        panel.add(l, c);

        setContentPane(panel);

        s.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panel.setVisible(false);
                difficultyScreen(9);
            }
        });
        m.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panel.setVisible(false);
                difficultyScreen(16);
            }
        });
        l.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panel.setVisible(false);
                difficultyScreen(25);
            }
        });
    }

    private void difficultyScreen(int size) {
        JPanel panel = new JPanel();
        GridBagConstraints c = new GridBagConstraints();
        JButton e = new JButton("Easy");
        JButton n = new JButton("Normal");
        JButton h = new JButton("Hard");

        panel.setLayout(new GridBagLayout());

        c.gridwidth = GridBagConstraints.REMAINDER;
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.VERTICAL;
        c.insets = new Insets(5,0,5,0);

        e.setPreferredSize(new Dimension(150,50));
        n.setPreferredSize(new Dimension(150,50));
        h.setPreferredSize(new Dimension(150,50));

        panel.add(e, c);
        panel.add(n, c);
        panel.add(h, c);

        setContentPane(panel);

        e.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                game = new Minesweeper(size, 2);
            }
        });
        n.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                game = new Minesweeper(size, 3);
            }
        });
        h.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                game = new Minesweeper(size, 4);
            }
        });
    }
}
