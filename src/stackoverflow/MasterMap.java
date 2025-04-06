package stackoverflow;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class MasterMap {
    private TreeMap<String, KeywordMapping> mappings = new TreeMap<>();

    public KeywordMapping put(String key, KeywordMapping value) {
        return mappings.put(key, value);
    }

    public KeywordMapping get(String key) {
        return mappings.get(key);
    }

    public KeywordMapping firstMapping() {
        return mappings.firstEntry().getValue();
    }

    public KeywordMapping getMappingForKey(String key) {
        return mappings.get(key);
    }

    public KeywordMapping getMappingAtPosition(int pos) {
        AtomicReference<KeywordMapping> mapping = new AtomicReference<>();
        AtomicInteger counter = new AtomicInteger(1);
        mappings.entrySet().forEach(entry -> {
            if (counter.get() == pos) {
                mapping.set(entry.getValue());
            }
            counter.getAndIncrement();
        });
        return mapping.get();
    }

    public String getKeywordForTitle (String titleId) {

        List<KeywordMapping> keywords = new ArrayList<>();

        Collection<KeywordMapping> values = mappings.values();
        Iterator<KeywordMapping> iter = values.iterator();

        while (iter.hasNext()) {
            KeywordMapping value = iter.next();
            if (value.containsTitle(titleId)) {
                keywords.add(value);
            }
        }

        KeywordMapping temp = keywords.stream()
                .max(Comparator.comparingInt(KeywordMapping::getFrequency)
                        .thenComparing(KeywordMapping::getKeyword).reversed())
                .get();

        return temp.getKeyword();
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        mappings.entrySet().forEach(entry ->
                buffer.append(entry.getKey() + " = " + entry.getValue().toString() + "\n"));

        return buffer.toString();
    }
}
