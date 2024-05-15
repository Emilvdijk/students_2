package nl.emilvdijk.schooldirectory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class JsonManager {

  private static final Logger loggy= Logger.getLogger(JsonManager.class.getName());

  public static <T> void SaveFiles(String fileName,List<T> personList) throws IOException {
    FileHandler fileHandler = new FileHandler("JsonManager.log",true);
    fileHandler.setFormatter(new SimpleFormatter());
    loggy.addHandler(fileHandler);
    loggy.setUseParentHandlers(false);


    File file = new  File("target/%s.json".formatted(fileName));
    ObjectMapper json = new ObjectMapper();
    try {
      json.writerWithDefaultPrettyPrinter().writeValue(file, personList);
    } catch (IOException e) {
      System.out.printf("oof toch foutje gemaakt: %s%n", e);
      loggy.log(Level.WARNING,"oof toch foutje gemaakt: ", e );
    }
  }

  public static <T> List<T> LoadFiles(String fileName, Class<T> elementClass) throws IOException {
    FileHandler fileHandler = new FileHandler("JsonManager.log",true);
    fileHandler.setFormatter(new SimpleFormatter());
    loggy.addHandler(fileHandler);
    loggy.setUseParentHandlers(false);

    File file = new File("target/%s.json".formatted(fileName));
    if(!file.exists() || file.isDirectory()) {
      return new ArrayList<>();
    }
    try {
      ObjectMapper json = new ObjectMapper();
      CollectionType listType =
          json.getTypeFactory().constructCollectionType(ArrayList.class, elementClass);
      return json.readValue(file, listType);

    }catch (IOException e){
      System.out.printf("nice try guy: %s%n", e);
      loggy.log(Level.WARNING,"nice try guy: ", e );
    }
    return new ArrayList<>();
  }
}
