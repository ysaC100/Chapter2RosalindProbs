public class ProbableProfile {
    private String dna;
    private int kmerLen;
    private Double[][] kmerMatrix;
    public ProbableProfile(String text, int k, Double[][] profile){
        kmerMatrix = profile;
        kmerLen = k;
        dna = text;
    }

    public String mostProbable() {
        double bestProb = 0.0;
        String bestProbKmers = "";
        String temp = dna;
        while (temp.length() > kmerLen) {
            double prob = 0.0;
            String strand = temp.substring(0, kmerLen);
            for(int i = 0; i < kmerLen; i++) {
                Double[] letterLine = new Double[4];
                if (strand.charAt(i) == 'A') {
                    letterLine = kmerMatrix[0];
                } else if (strand.charAt(i) == 'C') {
                    letterLine = kmerMatrix[1];
                } else if (strand.charAt(i) == 'G') {
                    letterLine = kmerMatrix[2];
                } else {
                    letterLine = kmerMatrix[3];
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