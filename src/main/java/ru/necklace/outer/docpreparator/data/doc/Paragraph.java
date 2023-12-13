package ru.necklace.outer.docpreparator.data.doc;

import lombok.Data;
import ru.necklace.outer.docpreparator.data.Student;
import ru.necklace.outer.docpreparator.data.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
public class Paragraph {
    private String text;

    public String getFilled(Student student, Subject subject) {
        List<String> tagNames = new ArrayList<>();
        Matcher m = Pattern.compile("(?=(%\\{.*?\\}))").matcher(text);
        while(m.find()) {
            tagNames.add(m.group(1));
        }

        for (String tagName : tagNames) {

        }
        return null;
    }
}
