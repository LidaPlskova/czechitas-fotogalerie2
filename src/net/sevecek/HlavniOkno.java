package net.sevecek;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import net.sevecek.util.swing.*;

public class HlavniOkno extends JFrame {

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    JLabel labFotky;
    JButton btnFotkaZpet;
    JButton btnFotkaVpred;
    JKeyboard klavesnice;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    JPanel contentPane;
    ArrayList<ImageIcon> seznamFotek;
    Integer aktualniFotka = 0;

    public HlavniOkno() {
        initComponents();
    }

    private void priOtevreniOkna(WindowEvent e) {
        seznamFotek = new ArrayList<ImageIcon>();
        seznamFotek.add(new ImageIcon(getClass().getResource("/net/sevecek/batole.jpeg")));
        seznamFotek.add(new ImageIcon(getClass().getResource("/net/sevecek/dexter.jpeg")));
        seznamFotek.add(new ImageIcon(getClass().getResource("/net/sevecek/honza.jpeg")));
        seznamFotek.add(new ImageIcon(getClass().getResource("/net/sevecek/hv.jpeg")));
        seznamFotek.add(new ImageIcon(getClass().getResource("/net/sevecek/muz.jpeg")));
        seznamFotek.add(new ImageIcon(getClass().getResource("/net/sevecek/normal.jpeg")));
        seznamFotek.add(new ImageIcon(getClass().getResource("/net/sevecek/pomocnik.jpeg")));
        seznamFotek.add(new ImageIcon(getClass().getResource("/net/sevecek/rodinka.jpeg")));
        seznamFotek.add(new ImageIcon(getClass().getResource("/net/sevecek/strihani.jpeg")));
        seznamFotek.add(new ImageIcon(getClass().getResource("/net/sevecek/vlacek.jpeg")));

        nastavAktualniFotku(0);

    }

    private void nastavAktualniFotku(Integer cisloFotky) {
        labFotky.setIcon(seznamFotek.get(cisloFotky));
        labFotky.setBounds(new Rectangle(new Point(90, 30), labFotky.getPreferredSize()));
    }

    private void priKliknutiFotkaZpet(MouseEvent e) {
        posunZpet();
    }

    private void priKliknutiFotkaVpred(MouseEvent e) {
        posunVpred();

    }

    private void priStiskuKlavesy(KeyEvent e) {
        if (klavesnice.isKeyDown(KeyEvent.VK_LEFT)) {
            posunZpet();
        }
        if (klavesnice.isKeyDown(KeyEvent.VK_RIGHT)) {
            posunVpred();
        }
    }

    private void posunVpred() {
        if (aktualniFotka < seznamFotek.size() - 1) {
            aktualniFotka++;
            nastavAktualniFotku(aktualniFotka);
        }
    }

    private void posunZpet() {
        if (aktualniFotka > 0) {
            aktualniFotka--;
            nastavAktualniFotku(aktualniFotka);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        labFotky = new JLabel();
        btnFotkaZpet = new JButton();
        btnFotkaVpred = new JButton();
        klavesnice = new JKeyboard();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Moje nov\u00e1 aplikace");
        setIconImage(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                priOtevreniOkna(e);
            }
        });
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        this.contentPane = (JPanel) this.getContentPane();
        this.contentPane.setBackground(this.getBackground());

        //---- labFotky ----
        labFotky.setBackground(new Color(51, 204, 255));
        labFotky.setBorder(new LineBorder(new Color(0, 204, 255), 2));
        labFotky.setIcon(null);
        contentPane.add(labFotky);
        labFotky.setBounds(new Rectangle(new Point(90, 30), labFotky.getPreferredSize()));

        //---- btnFotkaZpet ----
        btnFotkaZpet.setText("<");
        btnFotkaZpet.setBackground(new Color(204, 204, 204));
        btnFotkaZpet.setFont(new Font("Ubuntu", Font.BOLD, 20));
        btnFotkaZpet.setForeground(new Color(0, 102, 153));
        btnFotkaZpet.setIcon(null);
        btnFotkaZpet.setBorder(new LineBorder(new Color(0, 204, 204), 5, true));
        btnFotkaZpet.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                priKliknutiFotkaZpet(e);
            }
        });
        contentPane.add(btnFotkaZpet);
        btnFotkaZpet.setBounds(0, 255, 45, 44);

        //---- btnFotkaVpred ----
        btnFotkaVpred.setText(">");
        btnFotkaVpred.setBackground(new Color(204, 204, 204));
        btnFotkaVpred.setFont(new Font("Ubuntu", Font.BOLD, 20));
        btnFotkaVpred.setForeground(new Color(0, 102, 153));
        btnFotkaVpred.setIcon(null);
        btnFotkaVpred.setBorder(new LineBorder(new Color(0, 204, 204), 5, true));
        btnFotkaVpred.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                priKliknutiFotkaVpred(e);
            }
        });
        contentPane.add(btnFotkaVpred);
        btnFotkaVpred.setBounds(960, 260, 45, 44);

        //---- klavesnice ----
        klavesnice.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                priStiskuKlavesy(e);
            }
        });
        contentPane.add(klavesnice);
        klavesnice.setBounds(new Rectangle(new Point(960, 10), klavesnice.getPreferredSize()));

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for (int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        setSize(1010, 625);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
