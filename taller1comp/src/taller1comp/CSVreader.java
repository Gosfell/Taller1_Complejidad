package taller1comp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Mendoza-Diego_Muñoz-Tomas_Torres-Sebastian
 */
public class CSVreader {

    private Info[] info;

    public CSVreader() {
        this.info=entregarArreglo();
    }

    public Info[] entregarArreglo() {

        Info[] arreglo = new Info[18249];
        String csvFile = "palta.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
            br = new BufferedReader(new FileReader(csvFile));
            int contador = 0;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(cvsSplitBy);
                Info info = new Info(toLong(datos[2]), toLong(datos[3]), toLong(datos[4]), toLong(datos[5]), toLong(datos[6]), toLong(datos[7]));
                arreglo[contador] = info;
                contador++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return arreglo;
    }

    public long toLong(String string) {
        return Long.parseLong(string.replace(".", ""));
    }

    public Info[] getInfo() {
        return info;
    }

    public void setInfo(Info[] info) {
        this.info = info;
    }
}
