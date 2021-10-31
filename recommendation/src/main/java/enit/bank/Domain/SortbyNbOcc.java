package enit.bank.Domain;

import java.util.Comparator;

public class SortbyNbOcc implements Comparator<Recommendation> {
    public int compare(Recommendation a, Recommendation b)
    {
        return a.nbrOccurrences - b.nbrOccurrences;
    }
}
