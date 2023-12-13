package ru.necklace.outer.docpreparator.logic;

import org.apache.commons.lang3.tuple.Pair;
import org.docx4j.jaxb.Context;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.CTBorder;
import org.docx4j.wml.ObjectFactory;
import org.docx4j.wml.P;
import org.docx4j.wml.PPr;
import org.docx4j.wml.PPrBase.PBdr;
import org.docx4j.wml.STBorder;
import ru.necklace.outer.docpreparator.data.Student;
import ru.necklace.outer.docpreparator.data.Subject;
import ru.necklace.outer.docpreparator.data.doc.DocTemplate;

import java.io.File;
import java.math.BigInteger;
import java.util.List;

public class GeneratorService {
    private DocTemplate docTemplate;
    private List<Pair<Subject, Student>> dataList;

    public void fillAndFlush() throws Docx4JException {
        WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();
        MainDocumentPart mainDocumentPart = wordMLPackage.getMainDocumentPart();

        ObjectFactory factory = Context.getWmlObjectFactory();

        dataList.forEach(
                subjToStudent -> {

                    P p = docTemplate.getFilledExemplar(subjToStudent.getValue(), subjToStudent.getKey());

                    CTBorder border = factory.createCTBorder();
                    //Copied from extracted xml: <w:bottom w:val="single" w:sz="12" w:space="1" w:color="000000"/>
                    border.setVal(STBorder.SINGLE);
                    border.setSz(BigInteger.valueOf(12));
                    border.setSpace(BigInteger.valueOf(1));
                    border.setColor("000000");

                    PBdr pbdr = factory.createPPrBasePBdr();
                    pbdr.setBottom(border);

                    PPr ppr = factory.createPPr();
                    ppr.setPBdr(pbdr);
                    p.setPPr(ppr);

                    mainDocumentPart.getContent().add(p);
                }
        );

        wordMLPackage.save(new File("result.docx"));
    }
}
