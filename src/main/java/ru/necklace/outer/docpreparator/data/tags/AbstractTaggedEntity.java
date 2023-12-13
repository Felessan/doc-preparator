package ru.necklace.outer.docpreparator.data.tags;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractTaggedEntity {
    protected final Map<String, Object> fields = new HashMap<>();
    protected Object getByName(String name) {
        return fields.get(name);
    }
}
