package stackoverflow;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class NodeListDemo
{

    public static void main(String... args)
    {
        File fXmlFile = new File("xmltest.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try
        {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            NodeList nList = doc.getChildNodes();
            System.out.println("List size: " + nList.getLength());
            for(int i = 0; i < nList.getLength(); i++)
            {
                Node node = nList.item(i);
                System.out.println(node.getNodeName());
            }
        }
        catch (ParserConfigurationException | SAXException | IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
