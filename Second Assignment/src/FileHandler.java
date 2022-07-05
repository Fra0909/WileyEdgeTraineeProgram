import java.io.*;

public class FileHandler {

    public static void saveToFile() {
        File fileNameOut = new File("./src/dvds.txt");
        try {
            FileWriter fw = new FileWriter(fileNameOut);
            BufferedWriter bw = new BufferedWriter(fw);
            for (DVD dvd : DVD.DVDs) {
                bw.write(dvd.toString() + "\n");
            }
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void loadFromFile() {
        File dvds = new File("./src/dvds.txt");
        String[] attributes;
        try {
            FileReader fr = new FileReader(dvds);
            BufferedReader br = new BufferedReader(fr);
            String lineFromFile;
            do {
                lineFromFile = br.readLine(); // Reads each line
                if (lineFromFile != null) {
                    attributes = lineFromFile.split(",");
                    new DVD(attributes);
                }
            } while (lineFromFile != null);
        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}
