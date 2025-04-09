package Serializable;

import java.io.*;

public class GuardarObjeto {
    public static void main(String[] args) {

        binario.Persona[] personas = {
                new binario.Persona("Aaron", 18),
                new binario.Persona("Jose", 23),
                new binario.Persona("Marcos", 18)
        };
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("persona.ser"))) {
            oos.writeObject(personas);
            System.out.println("Persona guardado");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


        //Leemos
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("persona.ser"))) {
            binario.Persona[] p2;
            p2 = (binario.Persona[]) ois.readObject();

        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
