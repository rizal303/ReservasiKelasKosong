/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Herie-PC
 */
public class ikon {
    @SuppressWarnings("CallToPrintStackTrace")
    public static BufferedImage loadImage(String ref){
        BufferedImage bimg=null;
        try{
            bimg=ImageIO.read(new File(ref));
        } catch(Exception e){
            e.printStackTrace();
        }
        return bimg;
    }
    
    public static BufferedImage resize(BufferedImage img, int newW, int newH){
        int w = img.getWidth();
        int h = img.getHeight();
        
        @SuppressWarnings("UnusedAssignment")
        BufferedImage dimg = dimg = new BufferedImage(newW, newH,img.getType());
        
        Graphics2D g = dimg.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
        RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);
        g.dispose();
        return dimg;
    }
    
    public Icon tampilkanIcon(String lg) {
        ImageIcon imageIcon = new ImageIcon("src/image/"+lg); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(10, 10,  java.awt.Image.SCALE_DEFAULT); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);
        
        return imageIcon;
    }
    
}
