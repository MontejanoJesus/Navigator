package com.solvd.navigator.parsers;

import com.solvd.navigator.App;
import com.solvd.navigator.model.Result;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class JaxbParser {
    private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger(App.class);


    public void marshal(Result result){

        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(Result.class);
            Marshaller mar = context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            mar.marshal(result, new File("src/main/resources/ResultJaxb.xml"));

        } catch (JAXBException e) {
            logger.error(e);
        }

    }

    public Result unmarshal(){

        JAXBContext context = null;
        try {

            context = JAXBContext.newInstance(Result.class);
            return (Result) context.createUnmarshaller().unmarshal(new FileReader("src/main/resources/ResultJaxb.xml"));

        } catch (JAXBException e) {
            logger.error(e);
        } catch (FileNotFoundException e) {
            logger.error(e);
        }
        return null;

    }

}
