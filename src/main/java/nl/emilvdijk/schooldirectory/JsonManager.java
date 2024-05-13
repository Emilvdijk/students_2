package nl.emilvdijk.schooldirectory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class JsonManager {
  public static <T> void SaveFiles(String fileName,List<T> personList){
    File file = new  File("target/%s.json".formatted(fileName));
    ObjectMapper json = new ObjectMapper();
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
//          .registerModule(new ParameterNamesModule(JsonCreator.Mode.PROPERTIES))
//          .registerModule(new JavaTimeModule());

//      ObjectMapper json = JsonMapper.builder()
//          .addModule(new ParameterNamesModule(JsonCreator.Mode.PROPERTIES)).build()
//          .registerModule(new JavaTimeModule());

//      ObjectMapper json = new ObjectMapper().findAndRegisterModules();

      CollectionType listType =
          json.getTypeFactory().constructCollectionType(ArrayList.class, elementClass);
      return json.readValue(file, listType);

    }catch (IOException e){
      System.out.printf("nice try guy: %s%n", e);
    }

    return new ArrayList<>();
  }
}
