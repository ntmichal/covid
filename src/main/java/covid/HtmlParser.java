package covid;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;


@Component
public class HtmlParser {

    @Autowired
    private ObjectMapper objectMapper;

    private String html;

    public HtmlParser getPageHtml(String URL) throws IOException {
        this.html = Jsoup.connect(URL).get().html();
        return this;

    }

    public Object getCoronavirusCases() throws IOException{
        String JSON = Jsoup.parse(html).select("pre#registerData").text();
        JsonNode jsonNode = objectMapper.readTree(objectMapper.readTree(JSON).get("parsedData").asText());
        String prettyJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
        TypeReference<List<Map<Object,Object>>> typeReference = new TypeReference<List<Map<Object, Object>>>(){};

        return objectMapper.readValue(prettyJson, typeReference);
    }

}
