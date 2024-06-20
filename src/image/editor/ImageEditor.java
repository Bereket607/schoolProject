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
public static int[][] stretchHorizontally(int[][] imageTwoD){
        
        int[][] stretchedImage = new int[imageTwoD.length][2*imageTwoD[0].length];
        int pos = 0;
        
        for(int i=0; i<imageTwoD.length; i++){
            for(int j=0; j<imageTwoD[0].length; j++){
                
                pos = j * 2;
                stretchedImage[i][pos] = imageTwoD[i][j];
                stretchedImage[i][pos + 1] = imageTwoD[i][j];
            }
        }
        
        return stretchedImage;
    }
    
    public static int[][] shrinkVertically(int[][] imageTwoD){
        
        int[][] shrunkImage = new int[imageTwoD.length / 2][imageTwoD[0].length];
        
        for(int i=0; i<imageTwoD[0].length; i++){
            for(int j=0; j<imageTwoD.length - 1; j+=2){
                
                shrunkImage[j/2][i] = imageTwoD[j][i];
            }
        }
        
        return shrunkImage;
    }
}
