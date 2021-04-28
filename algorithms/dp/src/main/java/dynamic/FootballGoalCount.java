package dynamic;

import java.util.List;

public class FootballGoalCount {
    public static void main(String[]args){}
    //Count the number of score combination in Football
    public static int numCombinationForFinalScore(int finalScore, List<Integer> individualPlayScore){
        int [][] numCombinationForFinalScore = new int [individualPlayScore.size()][finalScore+1];
        for(int i=0;i<individualPlayScore.size();i++){
            numCombinationForFinalScore[i][0]= 1;
            for(int j=i;j<=finalScore;++j){
                int withoutThisPlay = i-1>=0?numCombinationForFinalScore[i-1][j]:0;
                int withThisPlay = j>=individualPlayScore.get(i)?numCombinationForFinalScore[i][j-individualPlayScore.get(i)]:0;
                numCombinationForFinalScore[i][j] = withThisPlay+withoutThisPlay;
            }
        }
        return numCombinationForFinalScore[individualPlayScore.size()-1][finalScore];
    }

}
