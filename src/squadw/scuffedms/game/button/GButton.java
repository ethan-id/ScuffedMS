package squadw.scuffedms.game.button;

import javax.swing.*;
import java.awt.*;

public class GButton extends JButton {

    GridBagConstraints c = new GridBagConstraints();

    public GButton() {
        super();
        setCons();
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
    }

    private void setCons() {
        c.ipadx = 6;
        c.ipady = 36;
    }

    public void addButtonToFrame(JFrame frame) {
        frame.add(this, c);
    }

    public void addButtonToFrame(JPanel frame) {
        frame.add(this, c);
    }
}
