import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterFrequency {
    public static void main(String[] args) {
        String word = "hannah";
        System.out.println("The most frequent character(s): " + characterCount(word));
    }

    public static List<Character> characterCount(String word) {
        Map<Character, Long> frequencyMap = word.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Find the maximum frequency value
        long maxCount = frequencyMap.values().stream()
                .max(Long::compare)
                .orElse(0L);

        // Filter map to get all characters matching that maximum frequency
        return frequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() == maxCount)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

    }
}
