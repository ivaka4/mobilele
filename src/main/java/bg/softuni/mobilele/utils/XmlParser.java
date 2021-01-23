package bg.softuni.mobilele.utils;

import javax.xml.bind.JAXBException;

public interface XmlParser {
    <O> O parseXml(Class<O> objectClass, String filePath) throws JAXBException;

    <O> void exportXml(O object, Class<O> objectClass, String path) throws JAXBException;

    <O> String exportXml(O object, Class<O> objectClass);
}
