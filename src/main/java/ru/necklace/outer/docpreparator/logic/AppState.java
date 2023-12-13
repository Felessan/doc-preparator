package ru.necklace.outer.docpreparator.logic;

import org.apache.commons.lang3.tuple.Pair;
import ru.necklace.outer.docpreparator.data.Student;
import ru.necklace.outer.docpreparator.data.Subject;

import java.util.LinkedList;
import java.util.List;

public class AppState {
    private List<Pair<Subject, Student>> dataList = new LinkedList<>();

    public List<Pair<Subject, Student>> dataBean() {
        return dataList;
    }
}
