import java.util.*;

public class GreedyMotifSearch {
    private int kmerLen;
    private int numStrands;
    private ArrayList<String> dna;
    private ArrayList<ArrayList<String>> matrix;
    private Double[][] profile;
    String cons;

    public GreedyMotifSearch(ArrayList<String> text, int k, int t2) {
        kmerLen = k;
        dna = text;
        numStrands = t2;
        matrix = new ArrayList<>();
        profile = new Double[4][kmerLen];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < kmerLen; j++) {
                profile[i][j] = 0.0;
            }
        }
        cons = "";
    }

    public ArrayList<String> getGreedySearch() {
        ArrayList<String> bestMotifs = new ArrayList<>();
        for (String str : dna) {
            bestMotifs.add(str.substring(0, kmerLen)); //BestMotifs ← ArrayList containing the first kmer from each Dna string
        }

        String firstStrand = dna.getFirst();
        //StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < firstStrand.length(); i++) { //for each k-mer Motif in the first string from Dna
            if (i + kmerLen <= firstStrand.length()) {
                ArrayList<String> motifList = new ArrayList<>();
                motifList.add(firstStrand.substring(i, i + kmerLen));
                for (int j = 1; j < numStrands; j++) {
                    profile = formProfile(motifList);
                    //ProbableProfile p1 = new ProbableProfile(dna.get(j), kmerLen, profile);
                    /*String ans = "";
                    for(int num = 0; num < kmerLen; num++){
                        for(int numj = 0; numj < profile.length; numj++){
                            ans += profile[num][numj] + " ";
                        }
                        ans += "\n";
                    }
                    System.out.println(ans);*/
                    //stringBuilder.append(mostProbable(dna.get(j)) + ": " + ans + "}}}}}");
                    /*if (p1.mostProbable().length() != 0) {
                        motifList.add(p1.mostProbable().substring(0, kmerLen));
                    }*/
                    String check = mostProbable(dna.get(j));
                    //System.out.println("check " + check);
                    if (check.length() != 0) {
                        motifList.add(check.substring(0, kmerLen));
                    }
                }
                if (motifList.size() > 0 && bestMotifs.size() > 0) {
                    if (Score(motifList) < Score(bestMotifs)) {
                        bestMotifs = motifList;
                    }
                }
            }
        }
        return bestMotifs;
    }

    public int Score(ArrayList<String> motifs) {
        String consensus = "";
        int count = 0;
        for (int i = 0; i < motifs.getFirst().length(); i++) {
            int aCount = 0;
            int tCount = 0;
            int gCount = 0;
            int cCount = 0;
            for (int j = 0; j < motifs.size(); j++) {
                String motif = motifs.get(j);
                if (motif.length() > i) {
                    if (motif.charAt(i) == 'A') {
                        aCount++;
                    } else if (motif.charAt(i) == 'C') {
                        cCount++;
                    } else if (motif.charAt(i) == 'G') {
                        gCount++;
                    } else if(motif.charAt(i) == 'T'){
                        tCount++;
                    }
                    if (j == motifs.size() - 1) {
                        if (aCount > tCount && aCount > gCount && aCount > cCount) {
                            consensus += 'A';
                        }
                        else if (cCount > aCount && cCount > gCount && cCount > tCount) {
                            consensus += 'C';
                        }
                        else if (gCount > aCount && gCount > tCount && gCount > cCount) {
                            consensus += 'G';
                        }
                        else {
                            consensus += 'T';
                        }

                    }
                }
            }
        }
        cons = consensus;
        for (int i = 0; i < motifs.getFirst().length(); i++) {
            for (int j = 0; j < motifs.size(); j++) {
                String motif = motifs.get(j);
                if (motif.length() > i && consensus.length() > i) {
                    if (motif.charAt(i) != consensus.charAt(i)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public String getCons(){
        return cons;
    }

    public Double[][] formProfile(ArrayList<String> motif) {
        Double[][] profile = new Double[4][kmerLen];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < kmerLen; j++) {
                profile[i][j] = 0.0;
            }
        }

        for (String strand : motif) {
            if (strand.length() > 0) {
                while (strand.length() > 0) {
                    for (int k = 0; k < kmerLen; k++) {
                        if (strand.charAt(k) == 'A') {
                            profile[0][k] = (profile[0][k] + 1.0);
                        }
                        else if (strand.charAt(k) == 'C') {
                            profile[1][k] = (profile[1][k] + 1.0);
                        }
                        else if (strand.charAt(k) == 'G') {
                            profile[2][k] = (profile[2][k] + 1.0);
                        }
                        else{
                            profile[3][k] = (profile[3][k] + 1.0);
                        }
                    }
                    strand = strand.substring(kmerLen);
                }
            }
        }
        return profile;
    }
    public String mostProbable(String str) {
        double bestProb = -1;
        String bestProbKmers = "";
        String temp = str;
        while (temp.length() >= kmerLen) {
            double prob = 0.0;
            String strand = temp.substring(0, kmerLen);
            //System.out.println("calculating probability for ---->" + strand);
            for(int i = 0; i < kmerLen; i++) {
                Double[] letterLine = new Double[4];
                if (strand.charAt(i) == 'A') {
                    letterLine = profile[0];
                } else if (strand.charAt(i) == 'C') {
                    letterLine = profile[1];
                } else if (strand.charAt(i) == 'G') {
                    letterLine = profile[2];
                } else {
                    letterLine = profile[3];
                }
                if (i == 0) {
                    prob = letterLine[i];
                } else {
                    prob += letterLine[i];
                }
            }

            if (prob > bestProb) {
                bestProb = prob;
                bestProbKmers = strand;
            }
            temp = temp.substring(1);
        }
        return bestProbKmers;
    }
}

/*
GREEDYMOTIFSEARCH(Dna, k, t)
BestMotifs ← motif matrix formed by first k-mers in each string
from Dna
        for each k-mer Motif in the first string from Dna
Motif1 ← Motif
            for i = 2 to t
form Profile from motifs Motif1, …, Motifi - 1
Motifi ← Profile-most probable k-mer in the i-th string
in Dna
Motifs ← (Motif1, …, Motift)
        if Score(Motifs) < Score(BestMotifs)
BestMotifs ← Motifs
        return BestMotifs*/