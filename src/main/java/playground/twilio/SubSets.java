package playground.twilio;

import java.util.*;

public class SubSets {

    public static void main(String[] args) {
        var worker = new SubSets();

        var subsets = worker.generateSubsets(List.of("aa", "b", "c"));
        System.out.println(subsets);

        var filteredSubsets = subsets.stream()
                .filter(item ->
                        item.stream().reduce("", String::concat).length() == 2)
                .map(worker::toWideCountMap)
                .toList();

        System.out.println(filteredSubsets);

        var anyMatch =  filteredSubsets.stream()
                .anyMatch(subset -> worker.areEqual(subset, Map.of("a", 2)));

        System.out.print("anymatch: " + anyMatch);
    }

    private <K, V> boolean areEqual(Map<K, V> first, Map<K, V> second) {
        if (first.size() != second.size()) {
            return false;
        }

        return first.entrySet().stream()
                .allMatch(e -> e.getValue().equals(second.get(e.getKey())));
    }


    public HashMap<String, Integer> toWideCountMap(List<String> subset) {
        final var countMap = new HashMap<String, Integer>();

        for (String item : subset) {
            for (int i = 0; i < item.length(); i++) {
                final var key = String.valueOf(item.charAt(i));

                if (countMap.containsKey(key)) {
                    countMap.put(key, countMap.get(key) + 1);
                } else {
                    countMap.put(key, 1);
                }
            }
        }

        return countMap;
    }

    public <T> HashMap<T, Integer> toCountMap(List<T> subset) {
        final var countMap = new HashMap<T, Integer>();

        for (T item : subset) {
            if (countMap.containsKey(item)) {
                countMap.put(item, countMap.get(item) + 1);
            } else {
                countMap.put(item, 1);
            }
        }

        return countMap;
    }

    /**
     * Idea is to count on binary representation of array
     * size. Then, consider all binary representations
     * having 1 valued bits using positions of these bits
     * as indexes into array.
     */
    private <T> List<List<T>> generateSubsets(List<T> items) {
        final var subsets = new ArrayList<List<T>>();
        for (int i = 0; i < (1 << items.size()); i++) {
            final var subset = new ArrayList<T>();
            for (int j = 0; j < items.size(); j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(items.get(j));
                }
            }
            subsets.add(subset);
        }
        return subsets;
    }
}
