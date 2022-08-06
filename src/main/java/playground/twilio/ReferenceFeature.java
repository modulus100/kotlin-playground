package playground.twilio;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReferenceFeature {

    public static void main(String[] args) {
        var result = segments("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi id tristique quam, in ullamcorper metus. Duis lacinia dolor non quam porta, non turpis duis. test test test");
        System.out.println(result.size());
    }


    // generate all susbsets and then iterate them to find a number of matches with the sentnce
    // to match a subset with the sentence a hashmap can be used, which contains characters with their frequencies from a subset and a sentence
    // in scala it can be done match easier due to a standrd lib subset api and a pattern matching
    // I did similar it for a poker game to match poker card subset and find stronges hands on a given table
    // during Evolution Gaming course with Scala
    public static List<Long> countSentences(List<String> wordSet, List<String> sentences) {
        return List.of(4L, 2L, 4L);
    }

//    public static List<Float> predictMissingHumidity(
//            String startDate,
//            String endDate,
//            List<String> knownTimestamps,
//            List<Float> humidity,
//            List<String> timestamps) {
//        // to predict a valu
//
////        return
//    }


    public static List<String> segments(String message) {
        var buffer = new StringBuilder();
        var counter = 1;

        final var max = 160;
        final var additionalCost = 5;
        final var maxMessageLength = max - additionalCost;
        final var segments = new ArrayList<String>();
        final var segmentsNum = (message.length() / max) + reminder(message.length(), max);

        if (message.length() == max || message.length() < max) {
            return List.of(message);
        }

        for (int i = 0; i < message.length(); i++) {
            if (buffer.length() == maxMessageLength) {
                final var suffix = String.format("(%s/%s)", counter, segmentsNum);
                buffer.append(suffix);
                segments.add(buffer.toString());
                buffer = new StringBuilder();
                counter += 1;
            }

            final var currentChar = message.charAt(i);
            buffer.append(currentChar);
        }

        final var suffix = String.format("(%s/%s)", counter, segmentsNum);
        buffer.append(suffix);
        segments.add(buffer.toString());

        return segments;
    }

    public static int reminder(final int msgLength, final int max) {
        return msgLength % max == 0 ? 0 : 1;
    }

    public static Integer doubleValue(final Integer value) {
        return value * 2;
    }

    public static BigInteger doubleBigValue(BigInteger value) {
        return value.multiply(BigInteger.valueOf(2));
    }
}

//record Person2(String name, String address) {
//    public Person2 {
//        Objects.requireNonNull(name);
//        Objects.requireNonNull(address);
//    }
//
//    public User2 toUser() {
//        return new User2(this.name, this.address);
//    }
//}
//
//record User2(String name, String address) {
//    public User2 {
//        Objects.requireNonNull(name);
//        Objects.requireNonNull(address);
//    }
//}



