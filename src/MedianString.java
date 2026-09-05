import java.util.*;

public class MedianString {
    private int kmerPatternLen;
    private ArrayList<String> Dna;
    private String medianString;
    private int closest;
    private Set<String> strandSet;
    private HashMap<String, Integer> medians;

    public void MedianString(int patternLength, ArrayList<String> strands) {
        Dna = strands;
        kmerPatternLen = patternLength;
        medianString = "";
        strandSet = new HashSet<>();
        medians = new HashMap<>();
        String start = "A";
        medianString = start.repeat(kmerPatternLen);
    }

    public String getMedianString(ArrayList<String> dna, int k) {
        /*strandSet = getDOffs(medianString, 0, kmerPatternLen);
        for (String diffStrand : strandSet) { //for each k-mer Pattern from AAA · · · AA to TTT · · · TT
            int count = 0;
            if (HammingDiff(diffStrand) < HammingDiff(medianString)) { //if d(Pattern, Dna) < d(BestPattern, Dna)
                medianString = diffStrand; //BestPattern ← Pattern
                count = HammingDiff(diffStrand);
                if(count == 0){
                    return medianString;
                }
            }
            medians.put(medianString, count);
        }
        int check = 100;
        for(int num: medians.values()) {
            if(num < check) {
                check = num;
            }
        }
        for(String kmers: medians.keySet()){
            if(medians.get(kmers) == check){
                medianString = kmers;
            }
        }*/
        Set<String> allKmers = AllKmers(k);
        String medianString = "";
        for (String diffStrand : strandSet) { //for each k-mer Pattern from AAA · · · AA to TTT · · · TT
            int count = 0;
            if (HammingDiff(diffStrand) < HammingDiff(medianString)) { //if d(Pattern, Dna) < d(BestPattern, Dna)
                medianString = diffStrand; //BestPattern ← Pattern
                count = HammingDiff(diffStrand);
                if (count == 0) {
                    return medianString;
                }
            }
            medians.put(medianString, count);
        }
        int minDistance = Integer.MAX_VALUE;
        ;
        for (int num : medians.values()) {
            if (num < minDistance) {
                minDistance = num;
            }
        }
        for (String kmers : medians.keySet()) {
            if (medians.get(kmers) == minDistance) {
                medianString = kmers;
            }
        }
        for (String pattern : allKmers) {
            int currentDistance = HammingDiff(pattern);
            if (currentDistance < minDistance) {
                minDistance = currentDistance;
                medianString = pattern;
            }
        }
        return medianString;
    }

    public static Set<String> AllKmers(int k) {
        Set<String> kmers = new HashSet<>();
        char[] nucleotides = new char[4];
        nucleotides[0] = 'A';
        nucleotides[1] = 'T';
        nucleotides[2] = 'G';
        nucleotides[3] = 'C';
        getKmers("", k, nucleotides, kmers);
        return kmers;
    }

    private static void getKmers(String currentKmer, int k, char[] nucleotides, Set<String> kmers) {
        if (currentKmer.length() == k) {
            kmers.add(currentKmer);
            return;
        }
        for (char nucleotide : nucleotides) {
            getKmers(currentKmer + nucleotide, k, nucleotides, kmers);
        }
    }

    public int HammingDiff(String pattern) {
        int hammingDist = 0;
        int least = 0;
        int total = 0;
        StringBuilder test = new StringBuilder();
        for (String strands : Dna) {
            least = 100;
            for (int j = 0; j < strands.length(); j++) {
                if (j + kmerPatternLen < strands.length()) {
                    String strand = strands.substring(j, j + kmerPatternLen);
                    hammingDist = 0;
                    for (int i = 0; i < kmerPatternLen; i++) {
                        if (pattern.charAt(i) != strand.charAt(i)) {
                            hammingDist++;
                        }
                    }
                    if (hammingDist < least) {
                        least = hammingDist;
                    }
                }
            }
            total += least;
        }
        return total;
    }
}