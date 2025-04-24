package XML;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

//VAMOS A CREAR UNA AGENDA EN XML

public class Agenda1 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();


            //AHORA CREAMOS EL NODO RAÍZ
            Element rootElement = doc.createElement("Agenda");
            doc.appendChild(rootElement);

            //Primer elemento
            Element contacto = doc.createElement("Contacto");
            rootElement.appendChild(contacto);

            //OPCIÓN 1, SE GUARDA COMO ATRIBUTOS
            //Atributos del primer elemento:

            Attr attr = doc.createAttribute("Nombre");
            attr.setValue("AAAAAA");
            contacto.setAttributeNode(attr);

            attr = doc.createAttribute("Teléfono");
            attr.setValue("666 666 666");
            contacto.setAttributeNode(attr);

            attr = doc.createAttribute("email");
            attr.setValue("AAAAA@gmail.com");
            contacto.setAttributeNode(attr);


            //SEGUNDO ELEMENTO
            contacto = doc.createElement("Contacto");
            rootElement.appendChild(contacto);

            attr = doc.createAttribute("Nombre");
            attr.setValue("BBBBB");
            contacto.setAttributeNode(attr);

            attr = doc.createAttribute("Teléfono");
            attr.setValue("111 111 111");
            contacto.setAttributeNode(attr);

            attr = doc.createAttribute("email");
            attr.setValue("BBBBB@gmail.com");
            contacto.setAttributeNode(attr);



            //Se escribe el contenido del XML en un archivo
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("agenda1.xml"));
            transformer.transform(source, result);


        } catch (ParserConfigurationException |TransformerException e)  {
            e.printStackTrace();
        }
    }
}
