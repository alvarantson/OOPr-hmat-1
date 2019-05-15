package oop;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KorrastajaLoendur {

    private Map<String, Integer> globalList;

    public Map<String, Integer> getGlobalList() {
        return globalList;
    }

    public KorrastajaLoendur() {
        this.globalList = new HashMap<>();
    }

    public void teeKordaLisa(List<Artikkel> artiklid) {
        for (Artikkel artikkel : artiklid) {
            String pealkiri = artikkel.getPealkiri();
            for (String sõna :pealkiri.split(" ")) {
                String uusSõna = sõna.replaceAll("[,.!?()1234567890:<>|«»]", "").toLowerCase();
                if (uusSõna.equals("") || uusSõna.equals("-")) continue;
                if (globalList.containsKey(uusSõna)) {
                    globalList.put(uusSõna, globalList.get(uusSõna) + 1);
                } else {
                    globalList.put(uusSõna, 1);
                }
            }
        }
    }

    public void loeSisse(List<Ajaleht> ajalehed) throws IOException {
        System.out.println("Alustasin kraapimist...");
        for (Ajaleht ajaleht : ajalehed) {
            teeKordaLisa(ajaleht.getArtiklid());
            System.out.println(ajaleht.getNimi() + " done!");
        }
    }

}
