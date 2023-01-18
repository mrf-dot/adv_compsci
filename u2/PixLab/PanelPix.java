   //
   // Torbert, 24 July 2013
	//
   import java.awt.*;
   import java.awt.event.*;
   import javax.swing.*;
   //
   public class PanelPix extends JPanel
   {
      private DisplayPix display;
   	
      private ScoreboardPix scoreboard;
   
      public PanelPix()
      {
         setLayout(new BorderLayout());
         //
			// north
			//
         scoreboard = new ScoreboardPix();
         add(scoreboard,BorderLayout.NORTH);
      	//
			// east
			//
         JPanel east = new JPanel();
         east.setLayout(new GridLayout(17,1));
         /******************************************************************  1 */
         JButton zero = new JButton("Zero Blue");
         zero.addActionListener(new Listener_zero());
         east.add(zero);
      	/******************************************************************  2 */
         JButton negate = new JButton("Negate");
         //negate.setEnabled(false);
         east.add(negate);
         negate.addActionListener(new Listener_negate());
      	/******************************************************************  3 */
         JButton gray = new JButton("Grayscale");
         //gray.setEnabled(false);
			         gray.addActionListener(new Listener_gray());

         east.add(gray);
      	/******************************************************************  4 */
         JButton sepia = new JButton("Sepia Tone");
         //sepia.setEnabled(false);
         east.add(sepia);
			sepia.addActionListener(new Listener_sepia());

      	/******************************************************************  5 */
         JButton blur = new JButton("Blur");
         //blur.setEnabled(false);
         east.add(blur);			
      	         blur.addActionListener(new Listener_blur());
/******************************************************************  6 */
         JButton posterize = new JButton("Posterize");
         //posterize.setEnabled(false);
         east.add(posterize);			
			         posterize.addActionListener(new Listener_posterize());

      	/******************************************************************  7 */
         JButton splash = new JButton("Color Splash");
         //splash.setEnabled(false);
         east.add(splash);					
			         splash.addActionListener(new Listener_splash());

      	/******************************************************************  8 */
         JButton mirrorLR = new JButton("Mirror Left-Right");
         //mirrorLR.setEnabled(false);
         east.add(mirrorLR);			
			         mirrorLR.addActionListener(new Listener_mirrorLR());

      	/******************************************************************  9 */
         JButton mirrorUD = new JButton("Mirror Up-Down");
         //mirrorUD.setEnabled(false);
         east.add(mirrorUD);
			         mirrorUD.addActionListener(new Listener_mirrorUD());

      	/****************************************************************** 10 */
         JButton flipLR = new JButton("Flip Left-Right");
			         flipLR.addActionListener(new Listener_flipLR());

         //flipLR.setEnabled(false);
         east.add(flipLR);
      	/****************************************************************** 11 */
         JButton flipUD = new JButton("Flip Up-Down");
         //flipUD.setEnabled(false);
         east.add(flipUD);			
			         flipUD.addActionListener(new Listener_flipUD());

      	/****************************************************************** 12 */
         JButton pixelate = new JButton("Pixelate");
         //pixelate.setEnabled(false);
         east.add(pixelate);			
			         pixelate.addActionListener(new Listener_pixelate());

      	/****************************************************************** 13 */
         JButton coder = new JButton("Encode-Decode");
         //coder.setEnabled(false);
         east.add(coder);		
			         coder.addActionListener(new Listener_encoder());

      	/****************************************************************** 14 */
         JButton sunsetize = new JButton("Sunsetize");
         //sunsetize.setEnabled(false);
         east.add(sunsetize);		
			         sunsetize.addActionListener(new Listener_sunsetize());

      	/****************************************************************** 15 */
         JButton chromakey = new JButton("Chromakey");
         //chromakey.setEnabled(false);
         east.add(chromakey);		
			         chromakey.addActionListener(new Listener_chromakey());

      	/****************************************************************** 16 */
         JButton redeye = new JButton("Remove Red-Eye");
         //redeye.setEnabled(false);
         east.add(redeye);
			         redeye.addActionListener(new Listener_redeye());
									
      	/****************************************************************** 17 */
         JButton detect = new JButton("Edge Detector");
         //detect.setEnabled(false);
         east.add(detect);
			         detect.addActionListener(new Listener_detect());

      	/****************************************************************** END */
         add(east,BorderLayout.EAST);
      	//
      	// center
      	//
         display = new DisplayPix();
         display.addMouseListener(new Mouse());
         display.addMouseMotionListener(new MouseMotion());
         display.addKeyListener(new Key());
         display.setFocusable(true);
         add(display,BorderLayout.CENTER);
      	//
			// south
			//
         JPanel south = new JPanel();
         south.setLayout(new FlowLayout());
         JButton restore = new JButton("Restore Original Image");
         restore.addActionListener(new Listener_restore());
         south.add(restore);
         JButton openimg = new JButton("Open an Image File");
         openimg.addActionListener(new Listener_openimg());
         south.add(openimg);
         add(south,BorderLayout.SOUTH);
      }    
		//
		/**********************************************************************/
		//
   	// pixel operation listener
   	// 
      private class Listener_zero implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            display.zeroBlue();
            //
            update( display.getXval() , display.getYval() );
         }
      } 
      private class Listener_negate implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            display.negate();
            //
            update( display.getXval() , display.getYval() );
         }
      } 
      private class Listener_gray implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            display.grayScale();
            //
            update( display.getXval() , display.getYval() );
         }
      } 

      private class Listener_sepia implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            display.sepiaTone();
            //
            update( display.getXval() , display.getYval() );
         }
      } 
      private class Listener_blur implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            display.blur();
            //
            update( display.getXval() , display.getYval() );
         }
      } 

      private class Listener_posterize implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            display.posterize();
            //
            update( display.getXval() , display.getYval() );
         }
      } 
		
		private class Listener_splash implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            display.colorSplash();
            //
            update( display.getXval() , display.getYval() );
         }
      } 
		private class Listener_mirrorLR implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            display.mirrorLeftRight();
            //
            update( display.getXval() , display.getYval() );
         }
      } 
      private class Listener_mirrorUD implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            display.mirrorUpDown();
            //
            update( display.getXval() , display.getYval() );
         }
      } 
      private class Listener_flipLR implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            display.flipLeftRight();
            //
            update( display.getXval() , display.getYval() );
         }
      } 
      private class Listener_flipUD implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            display.flipUpDown();
            //
            update( display.getXval() , display.getYval() );
         }
      } 
		
		private class Listener_pixelate implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            display.pixelate();
            //
            update( display.getXval() , display.getYval() );
         }
      } 
      private class Listener_encoder implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            display.encodeDecode();
            //
            update( display.getXval() , display.getYval() );
         }
      } 
		
		private class Listener_sunsetize implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            display.sunsetize();
            //
            update( display.getXval() , display.getYval() );
         }
      } 
		
		private class Listener_chromakey implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            display.chromakey();
            //
            update( display.getXval() , display.getYval() );
         }
      } 

      private class Listener_redeye implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            display.removeRedEye();
            //
            update( display.getXval() , display.getYval() );
         }
      } 
		      private class Listener_detect implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            display.edgeDetector();
            //
            update( display.getXval() , display.getYval() );
         }
      } 







		//   
   	/**********************************************************************/
   	//
      private class Listener_restore implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            display.resetImage();
            //
            update( display.getXval() , display.getYval() );
         }
      }
      private class Listener_openimg implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            if( display.openImage() )
            {
               update( display.getXval() , display.getYval() );
            }
         }
      }
      private class Mouse extends MouseAdapter
      {
         public void mouseClicked(MouseEvent e)
         {
            update( e.getX() , e.getY() );
         }
      }    
      private class MouseMotion extends MouseMotionAdapter
      {
         public void mouseDragged(MouseEvent e)
         {
            update( e.getX() , e.getY() );
         }
      }     
      private class Key extends KeyAdapter
      {
         public void keyPressed(KeyEvent e)
         {
            switch( e.getKeyCode() )
            {
               case KeyEvent.VK_UP:    display.up();    break;
               case KeyEvent.VK_DOWN:  display.down();  break;
               case KeyEvent.VK_LEFT:  display.left();  break;
               case KeyEvent.VK_RIGHT: display.right(); break;
            }
         	//
            update( display.getXval() , display.getYval() );
         }
      }     
      private void update(int x, int y)
      {
         int rgb = display.getRGB(x,y);
         //
         scoreboard.update(x,y,rgb);
         //
         display.update(x,y);
         display.repaint();
			//
         display.requestFocus();
      }
   }
   //
	// end of file
	//