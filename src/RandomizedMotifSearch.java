import java.util.ArrayList;

public class RandomizedMotifSearch {
    private ArrayList<String> dna;
    private int kmerLen;
    private int numStrands;
    private Double[][] profile;
    private String cons;
    public RandomizedMotifSearch(ArrayList<String> strands, int k, int t){
        dna = strands;
        kmerLen = k;
        numStrands = t;
        profile = new Double[4][kmerLen];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < kmerLen; j++) {
                profile[i][j] = 0.0;
            }
        }
    }
    public ArrayList<String> getRandomSearch(){
        ArrayList<String> bestMotifs = new ArrayList<>();
        ArrayList<String> motifs = new ArrayList<>();
        for(String str: dna) { //bestMotifs ← randomly select k-mers in each Dna string
            int rand = (int) (Math.random() * (str.length()-kmerLen + 1));
            bestMotifs.add(str.substring(rand, rand + kmerLen));
        }
        while(true){
            profile = formProfile(bestMotifs);//Profile ← Profile(bestMotifs)
            motifs = new ArrayList<>();
            for (String s : dna) {
                motifs.add(mostProbable(s));
            }
            if(Score(motifs) < Score(bestMotifs)){//if Score(Motifs) < Score(bestMotifs)
                bestMotifs = motifs;//bestMotifs ← Motifs
            }
            else{
                return bestMotifs; //return bestMotifs
            }
        }
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
            cons = consensus;
        }

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
            String temp = str;
            String bestProbKmers = "";
            while (temp.length() >= kmerLen) {
                double prob = 0.0;
                String strand = temp.substring(0, kmerLen);
                for (int i = 0; i < kmerLen; i++) {
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
    public String getCons(){
        return cons;
    }
}