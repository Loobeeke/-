package com.lvqiao.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.lvqiao.view.LoginView;
import com.sun.org.apache.bcel.internal.classfile.Code;

public class CodePicture {

	// 验证码字符集

	private static final char[] chars = ("0123456789abcdefghijklmnopqrstuvwxyz"

			+ "ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();

	// 字符数量

	private static final int SIZE = 4;

	// 干扰线数量

	private static final int LINES = 10;

	// 宽度

	private static final int WIDTH = 80;

	// 高度

	private static final int HEIGHT = 40;

	// 字体大小

	private static final int FONT_SIZE = 30;//30

 

	/**

	 * 生成随机验证码及图片

	 */

	public static Object[] createImage() {

		StringBuffer code = new StringBuffer();

		// 1.创建空白图片

		BufferedImage image = new BufferedImage(

			WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

		// 2.获取图片画笔

		Graphics graphic = image.getGraphics();

		// 3.设置画笔颜色

		graphic.setColor(Color.LIGHT_GRAY);

		// 4.绘制矩形背景

		graphic.fillRect(0, 0, WIDTH, HEIGHT);

		// 5.画随机字符

		Random ran = new Random();

		for (int i = 0; i <SIZE; i++) {

			// 取随机字符索引

			int n = ran.nextInt(chars.length);

			// 设置随机颜色

			graphic.setColor(getRandomColor());

			// 设置字体大小

			graphic.setFont(new Font(

				null, Font.BOLD + Font.ITALIC, FONT_SIZE));

			// 画字符

			graphic.drawString(

				chars[n] + "", i * WIDTH / SIZE, HEIGHT/2+10);

			// 记录字符

			code.append(chars[n]);
			
		}

		// 6.画干扰线

		for (int i = 0; i < LINES; i++) {

			// 设置随机颜色

			graphic.setColor(getRandomColor());

			// 随机画线

			graphic.drawLine(ran.nextInt(WIDTH), ran.nextInt(HEIGHT),

					ran.nextInt(WIDTH), ran.nextInt(HEIGHT));

		}

		// 7.返回验证码和图片

		return new Object[]{code.toString(), image};
		

	}

	

	




	public void getPicture(JLabel Jb_verify/*,JTextField tx_verify2*/){

		Object[] obj = CodePicture.createImage();
		String code = obj[0].toString();
		System.out.println("验证码:"+code);
		ImageIcon img = new ImageIcon((BufferedImage)obj[1]);//创建图片对象
		Jb_verify.setIcon((Icon)img);
		

	}





	/**

	 * 随机取色

	 */

	public static Color getRandomColor() {

		Random ran = new Random();

		Color color = new Color(ran.nextInt(256), 

				ran.nextInt(256), ran.nextInt(256));

		return color;

	}

	


	

	//测试输出

	public static void main(String[] args) throws IOException {

		Object[] objs = createImage();

		BufferedImage image = 

			(BufferedImage) objs[1];

		// UNIX系统 /home/soft01/1.png

		OutputStream os = 

			new FileOutputStream("d:/3.png");

		ImageIO.write(image, "png", os);

		os.close();

	}

}
