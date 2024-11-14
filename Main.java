import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class Main {

    // exo 1

    public void copierFichierSimple(String pathsource,String pathdestination) throws IOException {
        File filesource = new File(pathsource);
        File filedestination = new File(pathdestination);
        FileOutputStream fos = new FileOutputStream(filedestination);
        if(!filedestination.exists()){
            filedestination.createNewFile();
        }
        try {
            FileInputStream fis = new FileInputStream(filesource);
            byte[] buffer = new byte[(int) filesource.length()];
            fis.read(buffer);
            fos.write(buffer);
            fos.flush();
            fis.close();
        } finally {
            fos.close();
        }
    }

    // exo3

    public void copierFichier(String pathsource,String pathdestination) throws IOException {
        File filesource = new File(pathsource);
        File filedestination = new File(pathdestination);
        FileOutputStream fos = new FileOutputStream(filedestination);
        if(!filedestination.exists()){
            filedestination.createNewFile();
        }
        try {
            Scanner sc = new Scanner(new FileInputStream(filesource));
            while (sc.hasNextLine()) {
                fos.write(sc.nextLine().getBytes());
            }
        } finally {
            fos.close();
        }
    }

    // exo2

    public void copierFichierChar(String pathsource,String pathdestination) throws IOException {
        File filesource = new File(pathsource);
        File filedestination = new File(pathdestination);
        if (!filedestination.exists()) {
            filedestination.createNewFile();            
        }
        FileReader fileReader = new FileReader(filesource);

        try {
            Writer fileWriter = new OutputStreamWriter(new FileOutputStream(filedestination));
            int caracters;
            while (( caracters = fileReader.read() )!= -1) {
                fileWriter.write(caracters);
            }    
            fileWriter.flush();
            fileWriter.close();
        }finally {
            fileReader.close();
        }
    }

    // Exo 4

    public void copierKeyBoard(String pathdestination) throws IOException {
        File filedestination = new File(pathdestination);
        if(!filedestination.exists()){
            filedestination.createNewFile();
        }
        try{

            Scanner sc = new Scanner(System.in);
            FileWriter fw = new FileWriter(filedestination);
            while (sc.hasNextLine()) {
                fw.write(sc.nextLine());
            }
            fw.flush();
            fw.close();
        } finally {
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        try {
            main.copierFichier("hello.txt","goodbye.txt");
            main.copierFichierChar("hello.txt","goodbye2.txt");
            main.copierFichierSimple("hello.txt","goodbye3.txt");
            main.copierKeyBoard("keyboard.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}