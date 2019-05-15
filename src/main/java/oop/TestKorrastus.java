package oop;

import java.io.IOException;
import java.util.*;

import static java.util.stream.Collectors.toMap;

public class TestKorrastus {

    public static void main(String[] args) throws IOException {
        KorrastajaLoendur korda = new KorrastajaLoendur();
        List<Ajaleht> ajalehed = Arrays.asList(new Postimees(), new Õhtuleht(), new Elu24(), new Telegram(),
                new Delfi(), new AnneJaStiil(), new Kroonika());
        korda.loeSisse(ajalehed);
        System.out.println("Tulemusi kokku: "+  korda.getGlobalList().size());
        Map<String, Integer> sorted = korda.getGlobalList()
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));

        System.out.println(sorted);
        /*
        for (String sõna : korda.getGlobalList().keySet()) {
            System.out.println(korda.getGlobalList().get(sõna) + "\t" + sõna);
        }
        */
    }
}
