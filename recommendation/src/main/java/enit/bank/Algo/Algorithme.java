package enit.bank.Algo;

import enit.bank.Domain.*;

import java.util.*;

public class Algorithme {
    public int algo(List<String> listId) {

        return 0;
    }

    public List<Recommendation> Combinations(List<String> listId) {
        List<Recommendation> comb = new ArrayList<>();
        for (int i = 0; i < listId.size() - 1; i++) {
            for (int j = i + 1; j < listId.size(); j++) {
                Recommendation rec = new Recommendation(listId.get(i), listId.get(j));
                comb.add(rec);
            }
        }
        return comb;
    }
}
