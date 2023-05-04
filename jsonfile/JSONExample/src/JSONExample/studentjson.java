package JSONExample;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class studentjson {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        ObjectNode student = mapper.createObjectNode(); 
        student.put("name", "Alice");
        student.put("age", 20);

        ArrayNode subjects = mapper.createArrayNode();
        subjects.add("Math");
        subjects.add("Physics");
        subjects.add("Chemistry");

        student.set("subjects", subjects);

        try {
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
            System.out.println(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


