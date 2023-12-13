package ru.necklace.outer.docpreparator.data.doc;

import lombok.Data;
import org.docx4j.jaxb.Context;
import org.docx4j.wml.ObjectFactory;
import org.docx4j.wml.P;
import ru.necklace.outer.docpreparator.data.Student;
import ru.necklace.outer.docpreparator.data.Subject;

import java.util.List;

@Data
public class DocTemplate {
    public List<Paragraph> paragpraphes;

    public P getFilledExemplar(Student student, Subject subject) {
        ObjectFactory wmlObjectFactory = Context.getWmlObjectFactory();
        P documentPart = wmlObjectFactory.createP();
        paragpraphes.stream().forEach(
                paragraph -> {
                    String preparedText = paragraph.getFilled(student, subject);
                }
        );
        return null;
    }
}
