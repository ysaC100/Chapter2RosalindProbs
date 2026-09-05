import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*MotifEnumeration newMotif = new MotifEnumeration("ATTTGGC", 3, 1);
        newMotif.enumerateFirst();
        newMotif.addStrands("TGCCTTACGGTATCGAAAATT");
        //System.out.println(newMotif.enumerateRest());
        MotifEnumeration m1 = new MotifEnumeration("CCGCGTTGCGTATGGGAGAAACCGT", 5, 1);
        m1.enumerateFirst();
        m1.addStrands("CATTCGAAAACGGTAATGCCCAGTGGGCAGGACAACTAGTACCTAACTCTATCTCGAGAAGTCCGGAAGATAGTGGACCTACCTCCGCTACTCGCGAGAATGGCAGAGTTGAGAACTTGCAGAAACTAAAGATAAGAGAACATGCACAATACACATTGCAGAGAACTGCAAAGACGAGAAAGTGTGAAGTTTTCTGTCGCAAGATTGGGCGCCCTGACAATGCCG");*/
        //System.out.println(m1.enumerateRest());
        /*ArrayList<String> dnaStrands = new ArrayList<>();
        dnaStrands.add("AAATTGACGCAT");
        dnaStrands.add("GACGACCACGTT");
        dnaStrands.add("CGTCAGCGCCTG");
        dnaStrands.add("GCTGAGCACCGG");
        dnaStrands.add("AGTACGGGACAG");
        MedianString medianString = new MedianString();
        medianString.MedianString(3, dnaStrands);
        System.out.println(medianString.getMedianString(dnaStrands, 3));*/

        //System.out.println(medianString.getDOffs("AAA", 0, 3));
        /*ArrayList<String> dnaStrands = new ArrayList<>();
        dnaStrands.add("CCGATCTGGCTAGGTCATTCCCTTGGCTATAAAGTTTCGCCG");
        dnaStrands.add("TCCCTTTCTGACATTGACTATAAGGTCGGCAGTTGCACCAGC");
        dnaStrands.add("TGATATGCCGGAGTTCGTACCCTTCAAATGATGGGCGCTACC");
        dnaStrands.add("GTTGAGACCCTTTTTACATAGTCAACGAGCCATTGGTTCGTT");
        dnaStrands.add("CTCTGACGTTAAACCCTTGATTTCATACTAACTTGTACGACT");
        dnaStrands.add("CCCTAGAGAAAGATGGACATCCTATCCCTTCTTATCATCCCA");
        dnaStrands.add("AAGCCCCGGGTGAAAGACTCCCTTATTTTCCCTTGAGACTAC");
        dnaStrands.add("CTCGGTACCCTTAGCAGTATCTATGCTGTAGGTCCCAACAGG");
        dnaStrands.add("CCCCTTATGAGGGGCAGGAGTAAGCTATCGAGCTCAGTCGTC");
        dnaStrands.add("ACCCTTCCTCCGTGAACCTCACGCCTCTTGATATCCTACAGA");
        MedianString medianString = new MedianString();
        medianString.MedianString(6, dnaStrands);
        System.out.println(medianString.getMedianString(dnaStrands, 6));*/
        //System.out.println(medianString.getDOffs("AAAAAA", 0, 6));
        /*String profile = "rosalind_ba2c.txt";
        Scanner in;
        ArrayList<ArrayList<Double>> lines = new ArrayList<>();
        //in = new Scanner(profile);
        ArrayList<Double> temp = new ArrayList<>();
        in = new Scanner(profile);
        Double[][] probMatrix = new Double[4][5];
        for(int i = 0; i < 4; i++){
            //ArrayList<Double> probs = new ArrayList<>();
            for(int j = 0; j < 5; j++){
                probMatrix[i][j] = in.nextDouble();
                //probs.add(Double.parseDouble(nums[i]));
            }
            //lines.add(probs);
        }*/
        //temp.add(in.nextDouble());
        /*String matrix = "0.321 0.179 0.357 0.107 0.25 0.393 0.107 0.357 0.214 0.179 0.357 0.357 0.214 0.429 0.214 0.286 0.286 0.25 0.25 0.107 0.25 0.107 0.321 0.179 0.286 0.143 0.286 0.214";
        String[] nums = matrix.split(" ");
        Double[][] probMatrix = new Double[4][7];
        int count = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 7; j++) {
                probMatrix[i][j] = Double.parseDouble(nums[count]);
                count++;
            }
        }
        ProbableProfile p1 = new ProbableProfile("GCGGAGCCCCCGAGGAGCGTGTTAGCAGGACACGCTTCCCATAAGCTACTCAAACGTCGTGTCGCCTTTAGAAAAGTGAGTGCTAGCTTAGAAAGTTATGATCTATTGGCGAACCGCGTGTCATGGGTATCGTCTCCCTTAATTAGGAGAGTGGACGACTAGCGTTTGTCCCTATTGAGCTGGCACTTTCTTCAGTTCTA", 7, probMatrix);
        System.out.println(p1.mostProbable());*/

        //ArrayList<String> dnaStrands = new ArrayList<>();
        /*
        dnaStrands.add("ACCAG");
        dnaStrands.add("GCAAG");
        dnaStrands.add("GGCCA");*/

        /*dnaStrands.add("GGCGTTCAGGCA");
        dnaStrands.add("AAGAATCAGTCA");
        dnaStrands.add("CAAGGAGTTCGC");
        dnaStrands.add("CACGTCAATCAC");
        dnaStrands.add("CAATAATATTCG");

*/
        /*Scanner in = new Scanner(System.in);
        ArrayList<String> dnaStrands = new ArrayList<>();
        File txt = new File("rosalind_ba2e.txt");
        try {
            in = new Scanner(txt);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for(int i = 0; i < 26; i++) {
            String sample = in.nextLine();
            dnaStrands.add(sample);
        }
        dnaStrands.remove(0);
        //CAG CAG CAA CAA CAA
        //TTC ATC TTC ATC TTC
        GreedyMotifSearch g1 = new GreedyMotifSearch(dnaStrands, 12,25);
        //System.out.println(g1.getGreedySearch().toString());
        for(String strand: g1.getGreedySearch()){
            System.out.println(strand);
        }*/

        //Scanner in = new Scanner(System.in);
        //ArrayList<String> dnaStrands = new ArrayList<>();
        /*dnaStrands.add("CGCCCCTCTCGGGGGTGTTCAGTAAACGGCCA");
        dnaStrands.add("GGGCGAGGTATGTGTAAGTGCCAAGGTGCCAG");
        dnaStrands.add("TAGTACCGAGACCGAAAGAAGTATACAGGCGT");
        dnaStrands.add("TAGATCAAGTTTCAGGTGCACGTCGGTGAACC");
        dnaStrands.add("AATCCACCAGCTCCACGTGCAATGTTGGCCTA");*/
        //TCTCGGGG
        //CCAAGGTG
        //TACAGGCG
        //TTCAGGTG
        //TCCACGTG

        /*dnaStrands.add("TTACCTTAAC");
        dnaStrands.add("GATGTCTGTC");
        dnaStrands.add("CCGGCGTTAG");
        dnaStrands.add("CACTAACGAG");
        dnaStrands.add("CGTCAGAGGT");*/

        /*File txt = new File("rosalind_ba2f.txt");
        try {
            in = new Scanner(txt);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for(int i = 0; i < 21; i++) {
            String sample = in.nextLine();
            dnaStrands.add(sample);
        }
        dnaStrands.remove(0);
       ArrayList<String> bestMotifs = new ArrayList<>();
       ArrayList<String> motifs = new ArrayList<>();*/
        /*for(int i = 0; i < 1500; i++) {
            RandomizedMotifSearch r1 = new RandomizedMotifSearch(dnaStrands, 15,20);
            motifs = r1.getRandomSearch();
            //if this is the first iteration OR Score(motifs) < Score(bestMotifs)
                 //bestMotifs = motifs
            if(i == 0 || r1.Score(motifs) < r1.Score(bestMotifs)){
                bestMotifs = motifs;
            }
        }
        for(String strand: bestMotifs){
            System.out.println(strand);
        }*/
        //TTACCTTAAC -> ACCT
        //          GATGTCTGTC -> ATGT
        //          CCGGCGTTAG -> GCGT
        //          CACTAACGAG -> ACGA
        //          CGTCAGAGGT -> AGGT
        /*ArrayList<String> newStrs = new ArrayList<>();
        newStrs.add("TTACCTTAAC");
        newStrs.add("GATGTCTGTC");
        newStrs.add("CCGGCGTTAG");
        newStrs.add("CACTAACGAG");
        newStrs.add("CGTCAGAGGT");
        RandomizedMotifSearch r2 = new RandomizedMotifSearch(newStrs, 4, 5);
        Double[][] prof = new Double[4][4];
        prof[0][0] = 2.0;
        prof[0][1] = 1.0;
        prof[0][2] = 1.0;
        prof[0][3] = 1.0;
        prof[1][0] = 1.0;
        prof[1][1] = 2.0;
        prof[1][2] = 1.0;
        prof[1][3] = 1.0;
        prof[2][0] = 1.0;
        prof[2][1] = 1.0;
        prof[2][2] = 3.0;
        prof[2][3] = 1.0;
        prof[3][0] = 1.0;
        prof[3][1] = 1.0;
        prof[3][2] = 0.0;
        prof[3][3] = 2.0;

        System.out.println(r2.mostProbable("TTACCTTAAC", prof));
        System.out.println(r2.mostProbable("GATGTCTGTC", prof));
        System.out.println(r2.mostProbable("CCGGCGTTAG", prof));
        System.out.println(r2.mostProbable("CACTAACGAG", prof));
        System.out.println(r2.mostProbable("CGTCAGAGGT", prof));*/
        /// Lab Part
        String motif = "AAAAAAAAGGGGGGG";
        int diffs = 4;
        int numStrands = 10;
        ArrayList<String> tempStrands = new ArrayList<>();
        ArrayList<Character> kmers = new ArrayList<>();
        ArrayList<String> strands = new ArrayList<>();
        kmers.add('A');
        kmers.add('C');
        kmers.add('G');
        kmers.add('T');
        for(int j = 0; j < 10; j++) {
            String strand = "";
            for (int i = 0; i < 600; i++) {
                int rand = (int) (Math.random() * 4);
                strand += kmers.get(rand);
            }
            tempStrands.add(strand);
        }
        for(String str: tempStrands){
            int randDiff = (int)(Math.random() * 4);
            int otherRand = (int)(Math.random() * (585));
            String implantedStr = "";
            for(int i = 0; i < 15; i++){
                implantedStr += motif.charAt(i);
            }
            for(int num = 0; num < randDiff; num++) {
                int randKmer = (int) (Math.random() * 4);
                int randIndex = (int) (Math.random() * 15);
                Character kmer = kmers.get(randKmer);
                implantedStr = implantedStr.substring(0, randIndex) + kmer + implantedStr.substring(randIndex + 1);
            }
            str = str.substring(0, otherRand) + implantedStr + str.substring(otherRand + 15);
            strands.add(str);
        }
        for(String str: strands){
            //System.out.println(str);
        }
        Scanner in = new Scanner(System.in);
        ArrayList<String> dnaStrands = new ArrayList<>();
        File txt = new File("rosalind_ba2e.txt");
        try {
            in = new Scanner(txt);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for(int i = 0; i < 11; i++) {
            String sample = in.nextLine();
            dnaStrands.add(sample);
        }
        dnaStrands.remove(0);
        MedianString m1 = new MedianString();
        //m1.MedianString(15, dnaStrands);
        //System.out.println(m1.getMedianString(dnaStrands, 15));
        GreedyMotifSearch g1 = new GreedyMotifSearch(dnaStrands, 15, 10);
        ArrayList<String> bestMotifs = new ArrayList<>();
        bestMotifs = g1.getGreedySearch();
        System.out.println(bestMotifs);
        System.out.println(g1.Score(bestMotifs));
        System.out.println(g1.getCons());
        ArrayList<String> bestMotifs2 = new ArrayList<>();
        for(int i = 0; i < 1500; i++) {

        }
        ArrayList<String> motifs = new ArrayList<>();
        for(int i = 0; i < 1500; i++) {
            RandomizedMotifSearch r1 = new RandomizedMotifSearch(dnaStrands, 15, 10);
            motifs = r1.getRandomSearch();
            if(i == 0 || r1.Score(motifs) < r1.Score(bestMotifs)){
                bestMotifs2 = motifs;
                System.out.println(r1.Score(bestMotifs2));
                System.out.println(r1.getCons());
            }
        }
        System.out.println(bestMotifs2);
    }
}