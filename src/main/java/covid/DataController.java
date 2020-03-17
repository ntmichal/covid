package covid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin(value = "*")
public class DataController {

    @Autowired
    private HtmlParser htmlParser;

    @GetMapping(value = "/data")
    public Object mainPage() throws IOException {
        String URL = "https://www.gov.pl/web/koronawirus/wykaz-zarazen-koronawirusem-sars-cov-2";
        return  htmlParser.getPageHtml(URL).getCoronavirusCases();
    }
}
