import java.io.*;
public class Throw {
    static void checkFile() throws IOException{
        FileReader file = new FileReader("text.txt");
        BufferedReader fileInput = new BufferedReader(file);
        System.out.println(fileInput.readLine());
        fileInput.close();
    }
    public static void main(String[] args) {
        try{
            checkFile();
        } catch(IOException e){
            System.out.println("File not found or error reading file.");
        }
    }
}
