   //
   // Mitch F
   // 10/6/2022
	//
   import java.awt.Color;
   import java.awt.image.BufferedImage;
	//
   public class PixelOperations
   {
      public Color[][] getArray(BufferedImage img)
      {
         Color[][] arr;
      	//
         int numcols = img.getWidth();
         int numrows = img.getHeight();
      	//
         arr = new Color[numrows][numcols];
      	//
         for(int j = 0; j < arr.length; j++)
         {
            for(int k = 0; k < arr[0].length; k++)
            {
               int rgb = img.getRGB(k,j);
            	//
               arr[j][k] = new Color(rgb);
            }
         }
      	//
         return arr;
      }
      public void setImage(BufferedImage img, Color[][] arr)
      {
         for(int j = 0; j < arr.length; j++)
         {
            for(int k = 0; k < arr[0].length; k++)
            {
               Color tmp = arr[j][k];
               //
               int rgb = tmp.getRGB();
               //
               img.setRGB(k,j,rgb);
            }
         }
      }
      //
   	/**********************************************************************/
   	//
   	// pixel operation
   	//
      public void zeroBlue(Color[][] arr)
      {
         for(int j = 0; j < arr.length; j++)
         {
            for(int k = 0; k < arr[0].length; k++)
            {
               Color tmp = arr[j][k];
               //
               arr[j][k] = new Color( tmp.getRed() , tmp.getGreen() , 0 );

}
         }
      }
      //
   	/**********************************************************************/
   	//
		 //
   	/**********************************************************************/
   	//
   	// pixel operation
   	//
      public void negate(Color[][] arr)
      {
			for ( int i = 0;i < arr.length;i++){
				for ( int j = 0; j < arr[i].length;j++){
					Color c = arr[i][j];
					Color newColor = new Color(
						255-c.getRed(),
						255-c.getGreen(),
						255-c.getBlue());

					arr[i][j] = newColor;
				}
			}

		}

		 //
   	/**********************************************************************/
   	//
   	// pixel operation
   	//
      public void grayScale(Color[][] arr)
      {
	      for (int i = 0; i < arr.length; i++) {
		      for (int j = 0; j < arr[i].length; j++) {
			      Color c = arr[i][j];
			      int val = (c.getRed() + c.getGreen() + c.getBlue()) / 3;
			      arr[i][j] = new Color(val, val, val);
		      }
	      }
		}

		 //
   	/**********************************************************************/
   	//
   	// pixel operation
   	//
      public void sepiaTone(Color[][] arr)
      {
	      	      for (int i = 0; i < arr.length; i++) {
		      for (int j = 0; j < arr[i].length; j++) {
			      Color c = arr[i][j];
			      double red = c.getRed();
			      double green = c.getGreen();
			      double blue = c.getBlue();
			      int r = (int) (.393 * red +  .769 * green + .189 * blue);
			      int g = (int) (.349 * red + .686 * green + .168 * blue);
			      int b = (int) (.272 * red + .534 * green + .131 * blue);
			      r = r > 255? 255: r;
			      g = g > 255 ? 255 : g;
			      b = b > 255 ? 255 : b;


			      arr[i][j] = new Color(r, g, b);
		      }
	      }
		}
		 //
   	/**********************************************************************/
   	//
   	// pixel operation
   	//
      public void blur(Color[][] arr)
      {
		      }


		 //
   	/**********************************************************************/
   	//
   	// pixel operation
   	//
      public void posterize(Color[][] arr)
      {
	      	      for (int i = 0; i < arr.length; i++) {
		      for (int j = 0; j < arr[i].length; j++) {
			      Color c = arr[i][j];
			      int r=c.getRed(), g = c.getGreen(), b = c.getBlue();
			      r +=  r % 70 > 35 ?  r % 70 : - (r % 70);
			      g +=  g % 70 > 35 ?  g % 70 : - (r % 70);
			      b +=  b % 70 > 35 ?  b % 70 : - (b % 70);
			      r = r > 255 ? 255 : r < 0 ? 0 : r;
			      g = g > 255 ? 255 : g < 0 ? 0 : g;
			      b = b > 255 ? 255 : b < 0 ? 0 : b;
			      arr[i][j] = new Color(r, g, b);

		      }
	      }
		}

		 //
   	/**********************************************************************/
   	//
   	// pixel operation
   	//
      public void colorSplash(Color[][] arr)
      {
	      	      for (int i = 0; i < arr.length; i++) {
		      for (int j = 0; j < arr[i].length; j++) {
			      Color c = arr[i][j];
			      arr[i][j] = new Color(255, (c.getGreen() + c.getBlue()) / 2, (c.getGreen() + c.getBlue()) / 2);
		      }
	      }
		}

		 //
   	/**********************************************************************/
   	//
   	// pixel operation
   	//
      public void mirrorLeftRight(Color[][] arr)
	   {
		   for (int i = 0; i < arr.length; i++)
			   for (int j = 0; j < arr.length; j++) {
				   arr[i][arr[i].length-j-1] = arr[i][j];
			   }
		}

		 //
   	/**********************************************************************/
   	//
   	// pixel operation
   	//
      public void mirrorUpDown(Color[][] arr)
      	{
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[arr.length - i - 1][j] = arr[i][j];
			}
		}
		}

		 //
   	/**********************************************************************/
   	//
   	// pixel operation
   	//
      public void flipLeftRight(Color[][] arr)
      {
	      for (int i = 0; i < arr.length; i++) {
		      for (int j = 0; j < arr[i].length / 2;j++) {
			      Color tmp = arr[i][j + arr[i].length / 2];
			      arr[i][j + arr[i].length / 2] = arr[i][j];
			      arr[i][j] = tmp;
		      }
	      }
		}

		 //
   	/**********************************************************************/
   	//
   	// pixel operation
   	//
      public void flipUpDown(Color[][] arr)
      {
	      for (int i = 0; i < arr.length / 2; i++) {
		      for (int j = 0; j < arr[i].length; j++) {
			      Color tmp = arr[i + arr.length / 2][j];
			      arr[i + arr.length / 2][j] = arr[i][j];
			      arr[i][j] = tmp;
		      }
	      }
		}

		 //
   	/**********************************************************************/
   	//
   	// pixel operation
   	//
      public void pixelate(Color[][] arr)
      {
		}

		 //
   	/**********************************************************************/
   	//
   	// pixel operation
   	//
      public void encodeDecode(Color[][] arr)
      {
		}

		public void sunsetize(Color [][] arr)
		{
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					Color c = arr[i][j];
					int r = c.getRed();
					int g = (int) (c.getGreen() - c.getGreen() * 0.2);
					int b = (int) (c.getBlue() - c.getBlue() * 0.2);
					arr[i][j] = new Color(r, g, b);
				}
			}
		}

		 //
   	/**********************************************************************/
   	//
   	// pixel operation
   	//
      public void chromakey(Color[][] arr)
      {
		}

		 //
   	/**********************************************************************/
   	//
   	// pixel operation
   	//
      public void removeRedEye(Color[][] arr)
      {
		}

		 //
   	/**********************************************************************/
   	//
   	// pixel operation
   	//
      public void edgeDetector(Color[][] arr)
      {
	      for (int i = 0; i < arr.length; i++) {
		      for (int j = 0; j < arr[i].length - 1; j++) {
			      Color c1 = arr[i][j];
			      Color c2 = arr[i][j+1];
			      arr[i][j] = Math.abs(c1.getRed() - c2.getRed()) > 10 || Math.abs(c1.getGreen() - c2.getGreen()) > 10 || Math.abs(c1.getBlue() - c2.getBlue()) > 10 ? new Color(0, 0, 0) : new Color(255, 255, 255);
		      }
	      }
		}
   }
   //
	// end of file
	//
