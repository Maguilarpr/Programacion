package ManejodeDatos;

import Clases.*;
import java.io.*;

public class Guardar_profesor {

    public static void guardar(Profesor prof) {
        
        String barra = File.separator;// 
        String ubicacion = System.getProperty("user.dir") + barra + "Base_datos" + barra;
        File crear_ubicacion = new File(ubicacion);
        try {
            crear_ubicacion.mkdirs();// Crear ubicacion
            FileOutputStream fileStrem = new FileOutputStream(ubicacion + prof.getDocumento() + ".txt");
            ObjectOutputStream os = new ObjectOutputStream(fileStrem);
            os.writeObject(prof);
            os.close();
        } catch (Exception e) {
            System.out.println("");
        }
    }

    public static Profesor recuperar(String documento) {
        String barra = File.separator;
        String ubicacion = System.getProperty("user.dir") + barra + "Base_datos" + barra;
        try {
            FileInputStream fileStrem = new FileInputStream(ubicacion + documento + ".obj");
            ObjectInputStream os = new ObjectInputStream(fileStrem);
            Object recuperar = os.readObject();
            Profesor recuperado = (Profesor) recuperar;
            os.close();
            return recuperado;
        } catch (Exception e) {
            System.out.println("");
            return null;
        }
    }
}
