import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageEncryption {

    // Encryption key
    private static final int KEY = 123;

    public static void main(String[] args) {
        try {

            File inputFile = new File("input.png.jpeg"); 
            BufferedImage image = ImageIO.read(inputFile);

            int width = image.getWidth();
            int height = image.getHeight();

            // Encrypt pixels
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {

                    int pixel = image.getRGB(x, y);

                    // Apply XOR operation
                    int encryptedPixel = pixel ^ KEY;

                    image.setRGB(x, y, encryptedPixel);
                }
            }

            // Save encrypted image
            File outputFile = new File("encrypted.png");
            ImageIO.write(image, "png", outputFile);

            System.out.println("Image Encrypted Successfully!");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
