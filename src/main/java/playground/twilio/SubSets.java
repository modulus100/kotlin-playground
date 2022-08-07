package playground.twilio;

import java.util.*;

public class SubSets {

    public static void main(String[] args) {
        var worker = new SubSets();

        var subsets = worker.createSubsets2(Set.of("a", "b", "c"));
        System.out.println(subsets);
    }

    public <T> ArrayList<ArrayList<T>> createSubsets2(Collection<T> collection) {
        if (collection.isEmpty()) {
            return new ArrayList<>(0);
        }

        var itFirst = collection.iterator();
        var itSecond = collection.iterator();
        var subsets = new ArrayList<ArrayList<T>>();

        while (itFirst.hasNext() && itSecond.hasNext()) {
            var subset = new ArrayList<T>();
            subset.add(itFirst.next());
            itSecond.next();

            while (itSecond.hasNext()) {
                subset.add(itSecond.next());
            }

            subsets.add(subset);
            itSecond = collection.iterator();
        }

        return subsets;
    }

    public <T> Set<Set<T>> createSubsets(Set<T> set) {
        if (set.isEmpty()) {
            return Set.of();
        }

        Set<Set<T>> subSets = set.stream()
                .map(item -> {
                    Set<T> clone = new HashSet<>(set);
                    clone.remove(item);
                    return clone;
                })
                .map(this::createSubsets)
                .reduce(new HashSet<>(), (x, y) -> {
                    x.addAll(y);
                    return x;
                });

        subSets.add(set);
        return subSets;
    }
}
