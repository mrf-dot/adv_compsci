   //
   // Torbert, 24 July 2013
	//
   import java.awt.*;
   import java.awt.image.BufferedImage;
   import java.io.File;
   import javax.swing.*;
	//
   public class DisplayPix extends JPanel
   {
      private PixelOperations pix = new PixelOperations();
   	
      private ImageIcon i = new ImageIcon("images/beach.jpg");
      
      private BufferedImage img= new BufferedImage(1600,1200,BufferedImage.TYPE_INT_RGB);
   	
      private Graphics buf = img.getGraphics();
      
      private boolean clicked = false;
   
      private int x , y;
      
      public DisplayPix()
      {
         int w = img.getWidth();
         int h = img.getHeight();
      	//
         buf.drawImage( i.getImage() , 0 , 0 , w , h , null );
      }
      //
      public int getXval() // not getX !
      {
         return x;
      } 
      public int getYval() // not getY !
      {
         return y;
      }  
      public int getRGB(int x, int y)
      {
         int xpos = x * img.getWidth( ) / getWidth() ;
         int ypos = y * img.getHeight() / getHeight();
      	//
         return img.getRGB(xpos,ypos);
      }      
      public void update(int xval, int yval)
      {
         clicked = true;
			//
         x       = xval;
         y       = yval;
      } 
		
		//
   	/**********************************************************************/
   	//
   	// pixel operation
   	// 
      public void zeroBlue()
      {
         Color[][] tmp = pix.getArray( img );
         //
         pix.zeroBlue( tmp );
      	//
         pix.setImage( img , tmp );
      } 
   	//
   	/**********************************************************************/
   	//
   	// pixel operation
   	// 
      public void negate()
      {
         Color[][] tmp = pix.getArray( img );
         //
         pix.negate( tmp );
      	//
         pix.setImage( img , tmp );
      }//
   	/**********************************************************************/
   	//
   	// pixel operation
   	// 
      public void grayScale()
      {
         Color[][] tmp = pix.getArray( img );
         //
         pix.grayScale( tmp );
      	//
         pix.setImage( img , tmp );
      }//
   	/**********************************************************************/
   	//
   	// pixel operation
   	// 
      public void sepiaTone()
      {
         Color[][] tmp = pix.getArray( img );
         //
         pix.sepiaTone( tmp );
      	//
         pix.setImage( img , tmp );
      }//
   	/**********************************************************************/
   	//
   	// pixel operation
   	// 
      public void blur()
      {
         Color[][] tmp = pix.getArray( img );
         //
         pix.blur( tmp );
      	//
         pix.setImage( img , tmp );
      }//
   	/**********************************************************************/
   	//
   	// pixel operation
   	// 
      public void posterize()
      {
         Color[][] tmp = pix.getArray( img );
         //
         pix.posterize( tmp );
      	//
         pix.setImage( img , tmp );
      }//
   	/**********************************************************************/
   	//
   	// pixel operation
   	// 
      public void colorSplash()
      {
         Color[][] tmp = pix.getArray( img );
         //
         pix.colorSplash( tmp );
      	//
         pix.setImage( img , tmp );
      }//
   	/**********************************************************************/
   	//
   	// pixel operation
   	// 
      public void mirrorLeftRight()
      {
         Color[][] tmp = pix.getArray( img );
         //
         pix.mirrorLeftRight( tmp );
      	//
         pix.setImage( img , tmp );
      }//
   	/**********************************************************************/
   	//
   	// pixel operation
   	// 
      public void mirrorUpDown()
      {
         Color[][] tmp = pix.getArray( img );
         //
         pix.mirrorUpDown( tmp );
      	//
         pix.setImage( img , tmp );
      }//
   	/**********************************************************************/
   	//
   	// pixel operation
   	// 
      public void flipLeftRight()
      {
         Color[][] tmp = pix.getArray( img );
         //
         pix.flipLeftRight( tmp );
      	//
         pix.setImage( img , tmp );
      }//
   	/**********************************************************************/
   	//
   	// pixel operation
   	// 
      public void flipUpDown()
      {
         Color[][] tmp = pix.getArray( img );
         //
         pix.flipUpDown( tmp );
      	//
         pix.setImage( img , tmp );
      }
//
   	/**********************************************************************/
   	//
   	// pixel operation
   	// 
      public void pixelate()
      {
         Color[][] tmp = pix.getArray( img );
         //
         pix.pixelate( tmp );
      	//
         pix.setImage( img , tmp );
      }//
   	/**********************************************************************/
   	//
   	// pixel operation
   	// 
      public void encodeDecode()
      {
         Color[][] tmp = pix.getArray( img );
         //
         pix.encodeDecode( tmp );
      	//
         pix.setImage( img , tmp );
      }//
   	/**********************************************************************/
   	//
   	// pixel operation
   	// 
      public void sunsetize()
      {
         Color[][] tmp = pix.getArray( img );
         //
         pix.sunsetize( tmp );
      	//
         pix.setImage( img , tmp );
      }//
   	/**********************************************************************/
   	//
   	// pixel operation
   	// 
      public void chromakey()
      {
         Color[][] tmp = pix.getArray( img );
         //
         pix.chromakey( tmp );
      	//
         pix.setImage( img , tmp );
      }
		
		//
   	/**********************************************************************/
   	//
   	// pixel operation
   	// 
      public void removeRedEye()
      {
         Color[][] tmp = pix.getArray( img );
         //
         pix.removeRedEye( tmp );
      	//
         pix.setImage( img , tmp );
      }
		
		//
   	/**********************************************************************/
   	//
   	// pixel operation
   	// 
      public void edgeDetector()
      {
         Color[][] tmp = pix.getArray( img );
         //
         pix.edgeDetector( tmp );
      	//
         pix.setImage( img , tmp );
      }
   	//
   	/**********************************************************************/
   	//  
      public void resetImage()
      {
         int w = img.getWidth();
         int h = img.getHeight();
      	//
         buf.drawImage( i.getImage() , 0 , 0 , w , h , null );
      }  
      public boolean openImage()
      {
         int w = img.getWidth();
         int h = img.getHeight();
      	//
         JFileChooser fc = new JFileChooser("images");
         fc.showOpenDialog( null );
         File f = fc.getSelectedFile();
      	//
         try {
            i = new ImageIcon("images/" + f.getName());
         }
            catch(Exception e)
            {
               return false;
            }
         buf.drawImage( i.getImage() , 0 , 0 , w , h , null );
      	//
         return true;
      }  
      public void up()
      {
         y = Math.max( 0 , y-1 );
      }
      public void down()
      {
         y = Math.min( getHeight()-1 , y+1 );
      }
      public void left()
      {
         x = Math.max( 0 , x-1 );
      }
      public void right()
      {
         x = Math.min( getWidth()-1 , x+1 );
      }   
      public void paintComponent(Graphics g)
      {
         g.drawImage( img , 0 , 0 , getWidth() , getHeight() , null );
         //
         if(clicked)
         {
            g.setColor(Color.black);
            g.drawLine(x-5,y-1,x+5,y-1);
            g.drawLine(x-5,y+1,x+5,y+1);
            g.drawLine(x-1,y-5,x-1,y+5);
            g.drawLine(x+1,y-5,x+1,y+5);
            //
            g.setColor(Color.yellow);
            g.drawLine(x-5,y,x-1,y);
            g.drawLine(x+1,y,x+5,y);
            g.drawLine(x,y-5,x,y-1);
            g.drawLine(x,y+1,x,y+5);
         }
      }
   }
   //
	// end of file
	//