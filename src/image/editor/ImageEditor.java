/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package image.editor;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;
import javax.imageio.ImageIO;

/**
 *
 * @author Team AAA
 */
public class ImageEditor {

    public static void main(String[] args) {

        System.out.println("Enter in the location of the image");
        Scanner stringScan = new Scanner(System.in);
        String locInput = stringScan.next();

        System.out.println("****************************************************");

        System.out.println("What Do you want to do? ");
        System.out.print("1. Trim the borders of the image        ");
        System.out.println("2. Show negative color of Image");
        System.out.print("3. Stretch Horizontally                 ");
        System.out.println("4. Shrink Vertically");
        System.out.println("5. Invert the image");

        System.out.println("****************************************************");

        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();

        int[][] imageData = MainProcesses.imageToTwoD(locInput);
        String finalLocation = pathModifier(locInput);

        switch (input) {
            case 1:
                int[][] trimmed = trimBorders(imageData, 60);
                MainProcesses.twoDToImage(trimmed, finalLocation.concat("trimmed.jpg"));
                break;

            case 2:
                int[][] negative = negativeColor(imageData);
                MainProcesses.twoDToImage(negative, finalLocation.concat("negative.jpg"));
                break;

            case 3:
                int[][] stretchImageHorizontally = stretchHorizontally(imageData);
                MainProcesses.twoDToImage(stretchImageHorizontally, finalLocation.concat("stretched.jpg"));
                break;

            case 4:
                int[][] shrinkImageVertically = shrinkVertically(imageData);
                MainProcesses.twoDToImage(shrinkImageVertically, finalLocation.concat("shrunk.jpg"));
                break;

            case 5:
                int[][] invertedImage = invertImage(imageData);
                MainProcesses.twoDToImage(invertedImage, finalLocation.concat("inverted.jpg"));
                break;

        }

    }
    public static int[] getRGBAFromPixel(int pixelColorValue){
        
        Color pixelColor = new Color(pixelColorValue);
        
        return new int[]{ pixelColor.getRed(), pixelColor.getGreen()
                , pixelColor.getBlue(), pixelColor.getAlpha()};
    }
    
    public static int getColorIntValueFromRGBA(int[] colorData){
        
        if(colorData.length == 4){
            
            Color color = new Color(colorData[0], colorData[1], 
                    colorData[2], colorData[3]);
            return color.getRGB();
        }
        else{
            
            System.out.println("Incorrect number of elements in RGBA array");
            return -1;
        }
    }

}
