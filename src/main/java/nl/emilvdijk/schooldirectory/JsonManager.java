package nl.emilvdijk.schooldirectory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class JsonManager {
  public static <T> void SaveFiles(String fileName,List<T> personList){
    File file = new File("target/%s.json".formatted(fileName));
    ObjectMapper json = new ObjectMapper();
    json.registerModule(new JavaTimeModule());
    try {
      json.writeValue(file, personList);
    } catch (IOException e) {
      System.out.printf("oof toch foutje gemaakt: %s%n", e);
    }
  }

  public static <T> List<T> LoadFiles(String fileName, Class<T> elementClass){
    File file = new File("target/%s.json".formatted(fileName));
    if(!file.exists() || file.isDirectory()) {
      return new ArrayList<>();
    }
    try {
      ObjectMapper json = new ObjectMapper();
      json.registerModule(new JavaTimeModule());
      CollectionType listType =
          json.getTypeFactory().constructCollectionType(ArrayList.class, elementClass);
      return json.readValue(file, listType);

    }catch (IOException e){
      System.out.printf("nice try guy: %s%n", e);
    }

    return new ArrayList<>();
  }
}
