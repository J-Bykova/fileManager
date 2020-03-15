import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class FileManager {

    public void createFile(String filePath) {
        try {
            File myNewFile = new File(filePath);
            if (myNewFile.createNewFile()) {
                System.out.println("File created: " + myNewFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void writeToFile(String filePath, String textForFile) {
        try {
            FileWriter myNewFileWriter = new FileWriter(filePath);
            myNewFileWriter.write(textForFile);
            myNewFileWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void readFile(String filePath) {
        try {
            File myNewFile = new File(filePath);
            Scanner myReader = new Scanner(myNewFile);
            while (myReader.hasNextLine()) {
                String myDate = myReader.nextLine();
                System.out.println(myDate);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void getFileInfo(String filePath) {
        File myNewFile = new File(filePath);
        if (myNewFile.exists()) {
            System.out.println("File name: " + myNewFile.getName());
            System.out.println("Absolute path: " + myNewFile.getAbsolutePath());
            System.out.println("Writeable: " + myNewFile.canWrite());
            System.out.println("Readable " + myNewFile.canRead());
            System.out.println("File size in bytes " + myNewFile.length());
        } else {
            System.out.println("The file does not exist.");
        }
    }

    public void deleteFile(String filePath) {
        File myNewFile = new File(filePath);
        if (myNewFile.delete()) {
            System.out.println("Deleted the file: " + myNewFile.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
}


