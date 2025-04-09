package binario;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;

public class GuardarPersonasBinario {
    public static void main(String[] args) {
        Persona[] personas = {
                new Persona("Aaron", 18),
                new Persona("Jose", 23),
                new Persona("Marcos", 18)
        };
        String rutaArchivo = "personas.bin";
        //METODO PARA GUARDAR PERSONAS
        guardarPersonas(personas, rutaArchivo);

        //METODO PARA LEER PERSONAS
        leerPersonas(personas, rutaArchivo);

    }


    public static void guardarPersonas(Persona[] personas, String rutaArchivo) {
        try (FileOutputStream fos = new FileOutputStream(rutaArchivo);) {
            for (Persona p : personas) {
                fos.write(p.getNombre().length());
                for (char c : p.getNombre().toCharArray()) {
                    fos.write(c);
                }
                //Edad. Ocupamos 4 bytes
                fos.write((p.getEdad() >> 24) & 0xFF);
                fos.write((p.getEdad() >> 16) & 0xFF);
                fos.write((p.getEdad() >> 8) & 0xFF);
                fos.write(p.getEdad() & 0xFF);
                System.out.println("Personas guardadas exitosamente");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


    }

    public static void leerPersonas(Persona[] personas, String rutaArchivo) {
        StringBuilder nombre = new StringBuilder();
        char c;
        int edad;
        try (FileInputStream fis = new FileInputStream(rutaArchivo)) {
            while (fis.available() > 0) {
                //Leer longitud del nombre
                int longitud = fis.read();
                for (int i = 0; i < longitud; i++) {
                    c = (char) fis.read();
                    nombre.append(c);
                }
                //Leer edad
                edad = ( (fis.read() << 24) | (fis.read() << 16) | (fis.read() << 8) | (fis.read()) );
                Persona p = new Persona(nombre.toString(), edad);
                System.out.println(p);

            }
        } catch (IOException ioe) {
            ioe.printStackTrace();

        }

    }
}
