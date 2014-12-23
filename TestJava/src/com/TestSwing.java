package com;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * ª≠Õº¿‡
 * 
 * @author WGJ
 * 
 */
public class TestSwing {

	public static void main(String[] args) {
		final JFrame jf = new JFrame();
		JPanel jp = new JPanel(new BorderLayout());
		JLabel jl = new JLabel() {
			private static final long serialVersionUID = 7550728384054889766L;
		};
		jp.setPreferredSize(new Dimension(555, 555));
		jp.add(jl, BorderLayout.CENTER);
		jf.getContentPane().add(jp);
		jf.pack();
		BufferedImage image = createImg(jp);
		jf.dispose();
		try {
			ImageIO.write(image, "png", new File("d:/test.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public static BufferedImage createImg(JPanel jp) {
		int totalWidth = jp.getPreferredSize().width;
		int totalHeight = jp.getPreferredSize().height;
		BufferedImage img = new BufferedImage(totalWidth, totalHeight, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = (Graphics2D) img.createGraphics();
		g2d.setColor(Color.BLUE);
		g2d.fillRect(0, 0, totalWidth, totalHeight);
		g2d.translate(0, 0);
		jp.disable();
		return img;
	}

}
