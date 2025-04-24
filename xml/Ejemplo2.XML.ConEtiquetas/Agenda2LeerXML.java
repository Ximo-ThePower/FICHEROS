package XML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

//VAMOS A LEER UNA AGENDA DESDE UN ARCHIVO XML DONDE LOS DATOS VAN COMO ETIQUETAS

public class Agenda2LeerXML {
    public static void main(String[] args) {
        try {
            // Creamos el parser DOM
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            // Cargamos el archivo XML
            Document doc = db.parse(new File("Agenda2.xml"));

            // Normalizamos (opcional)
            doc.getDocumentElement().normalize();

            // Mostramos el nombre del nodo raíz
            System.out.println("Elemento raíz: " + doc.getDocumentElement().getNodeName());

            // Obtenemos todos los elementos <Contacto>
            NodeList listaContactos = doc.getElementsByTagName("Contacto");

            System.out.println("Número de contactos: " + listaContactos.getLength());

            for (int i = 0; i < listaContactos.getLength(); i++) {
                Node nodo = listaContactos.item(i);

                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element contacto = (Element) nodo;

                    // Obtenemos cada etiqueta hija dentro del nodo <Contacto>
                    String nombre = contacto.getElementsByTagName("Nombre").item(0).getTextContent();
                    String telefono = contacto.getElementsByTagName("Teléfono").item(0).getTextContent(); 
                    String email = contacto.getElementsByTagName("EMail").item(0).getTextContent();

                    System.out.println("\nContacto " + (i + 1));
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Teléfono: " + telefono);
                    System.out.println("Email: " + email);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}