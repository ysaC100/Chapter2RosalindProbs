import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MotifEnumeration {
    private int numDiff;
    private String firstGene;
    private String genes;
    private int kmerLength;
    private Set<String> diffSet;
    private HashMap<String, Integer> check;
    //private ArrayList<String> possiblePatterns;
    private String possiblePatterns;
    private int sizeOfStrands;

    public MotifEnumeration(String Dna, int k, int d) {
        numDiff = d;
        kmerLength = k;
        genes = "";
        firstGene = Dna;
        check = new HashMap();
        diffSet = new HashSet<>();
        //possiblePatterns = new ArrayList();
        possiblePatterns = "";
        sizeOfStrands = firstGene.length();
    }

    public void addStrands(String strand) {
        genes = strand;
    }

    public void enumerateFirst() {
        for (int i = 0; i < firstGene.length(); i++) { //for each k-mer pattern in the first Dna sequence
            String kmer = "";
            if (kmerLength + i < firstGene.length()) {
                kmer = firstGene.substring(i, i + kmerLength);
                for (String diffs : getDOffs(kmer, 1, numDiff)) {
                    diffSet.add(diffs);
                }
                diffSet.add(kmer);
            }
        }
            for (String kmers : diffSet) {
                if (!check.containsKey(kmers)) {
                    check.put(kmers, 1);
                }
            }
    }

    public String enumerateRest() {
        for (String kmerDiff : diffSet) {//for each k-mer pattern’ differing from pattern by at most d mismatches ///// ATA ATT GTT TTT
            for (int i = 0; i <= genes.length(); i += sizeOfStrands) {
                if (i + sizeOfStrands <= genes.length()) {
                    String gene = genes.substring(i, i + sizeOfStrands);
                    //possiblePatterns.add(gene);
                    Set<String> tempKmers = new HashSet<>();
                    for (int j = 0; j <= gene.length(); j++) { //if pattern’ appears in each Dna sequence with at most d mismatches
                        String kmer = "";
                        if (kmerLength + j <= gene.length()) {
                            kmer = gene.substring(j, j + kmerLength);
                            for (String diffs : getDOffs(kmer, 1, numDiff)) {
                                tempKmers.add(diffs);
                            }
                            tempKmers.add(kmer);
                        }
                    }

                    if (tempKmers.contains(kmerDiff)) {
                        check.replace(kmerDiff, (check.get(kmerDiff) + 1));//store pattern' as a result
                    }

                    if (check.get(kmerDiff) == (genes.length() / sizeOfStrands + 1) && !possiblePatterns.contains(kmerDiff)) { //need to change to number of strands
                        possiblePatterns += kmerDiff + " ";
                    }
                }
            }
        }
        return possiblePatterns.toString();
    }

    public ArrayList<String> getOneOffs(String kmer) {
        String letter = "";
        String segment = kmer;
        String endKmer = "";
        ArrayList<String> oneOffs = new ArrayList<>();
        int countG = 0;
        int countC = 0;
        int countT = 0;
        int countA = 0;
        for (int i = 0; i < kmer.length(); i++) {
            for (int j = 0; j < 4; j++) { //AACAA
                letter = segment.substring(i, i + 1);
                if (!letter.equals("T") && countT == 0) {
                    countT++;
                    if (i == (segment.length()) - 1) {
                        endKmer = segment.substring(0, i) + 'T';
                    } else if (i == 0) {
                        endKmer = 'T' + segment.substring(i + 1);
                    } else if (i - 1 == 0) {//if( i > 0 && i < kmer.length() - 1){
                        endKmer = segment.substring(0, 1) + 'T' + segment.substring(i + 1);
                    } else {
                        endKmer = segment.substring(0, i) + 'T' + segment.substring(i + 1); // i-1, i
                    }
                } else if (!letter.equals("G") && countG == 0) {
                    countG++;
                    if (i == segment.length() - 1) {
                        endKmer = segment.substring(0, i) + 'G';
                    } else if (i == 0) {
                        endKmer = 'G' + segment.substring(i + 1);
                    } else if (i - 1 == 0) {//if( i > 0 && i < kmer.length() - 1){
                        endKmer = segment.substring(0, 1) + 'G' + segment.substring(i + 1);
                    } else {
                        endKmer = segment.substring(0, i) + 'G' + segment.substring(i + 1);
                    }
                } else if (!letter.equals("C") && countC == 0) {
                    countC++;
                    if (i == segment.length() - 1) {
                        endKmer = segment.substring(0, i) + 'C';
                    } else if (i == 0) {
                        endKmer = 'C' + segment.substring(i + 1);
                    } else if (i - 1 == 0) {//if( i > 0 && i < kmer.length() - 1){
                        endKmer = segment.substring(0, 1) + 'C' + segment.substring(i + 1);
                    } else {
                        endKmer = segment.substring(0, i) + 'C' + segment.substring(i + 1);
                    }
                } else if (!letter.equals("A") && countA == 0) {
                    countA++;
                    if (i == segment.length() - 1) {
                        endKmer = segment.substring(0, i) + 'A';
                    } else if (i == 0) {
                        endKmer = 'A' + segment.substring(i + 1);
                    } else if (i - 1 == 0) {//if( i > 0 && i < kmer.length() - 1){
                        endKmer = segment.substring(0, 1) + 'A' + segment.substring(i + 1);
                    } else {
                        endKmer = segment.substring(0, i) + 'A' + segment.substring(i + 1);
                    }
                }
                if (!oneOffs.contains(endKmer)) {
                    oneOffs.add(endKmer);
                }
            }
            countG = 0;
            countC = 0;
            countT = 0;
            countA = 0;
        }
        return oneOffs;
    }

    public Set<String> getDOffs(String kmer, int currentMismatch, int d) {
        Set<String> resultSet = new HashSet<>();
        if (currentMismatch <= d) {
            for (int i = 0; i < getOneOffs(kmer).size(); i++) {
                String kmers = getOneOffs(kmer).get(i);
                resultSet.add(kmers);
                Set<String> tempSet = getDOffs(kmers, currentMismatch + 1, d);
                for (String str : tempSet) {
                    resultSet.add(str);
                }
            }
        }
        return resultSet;
    }
}