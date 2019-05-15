package oop;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TestKorrastus {

    public static void main(String[] args) throws IOException {
        KorrastajaLoendur korda = new KorrastajaLoendur();
        List<Ajaleht> ajalehed = Arrays.asList(new Postimees(), new Õhtuleht(), new Elu24(), new Telegram(),
                new Delfi(), new AnneJaStiil(), new Kroonika());
        korda.loeSisse(ajalehed);
        System.out.println("Tulemusi kokku: "+  korda.getGlobalList().size());
        for (String sõna : korda.getGlobalList().keySet()) {
            System.out.println(korda.getGlobalList().get(sõna) + "\t" + sõna);
        }
    }

}
