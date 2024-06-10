/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package antarticagui;

/**
 *
 * @author matthew
 */
import java.awt.Dimension;
import java.awt.Graphics;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
    
    private final ImageIcon backgroundImage;
    
    public ImagePanel(String imagePath) {
        URL imgUrl = getClass().getResource(imagePath);
        if (imgUrl == null) {
            throw new IllegalArgumentException("Image not found: " + imagePath);
        }
        backgroundImage = new ImageIcon(imgUrl);
        System.out.println(backgroundImage.getIconWidth() + " " + backgroundImage.getIconHeight());
        Dimension size = new Dimension(backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);  // We want to position components manually
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage.getImage(), 0, 0, this);
    }
    
    public Dimension getImageSize() {
        return new Dimension(backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
    }
}

