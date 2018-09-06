package com.rishi.backtracking;

import java.util.*;

public class Knight {

    public static int[][] chessboard = new int[8][8];
    public static boolean[][] visited = new boolean[8][8];
    public static int seq =0;


    public static void main(String[] args) {
	// write your code here
        Index index = new Index();
        visited[0][0]=true;
        if(knigtstour(index)){
            print();
        }
        else {
            System.out.println("Not Possible");
        }




    }

    /*
    Static function for generate next alternative for each move;
     */
    public static List<Index> getAlternatives(Index curr){
        List<Index> alternatives = new LinkedList<>();
        Index index1 = new Index(curr.x+1,curr.y-2);
        alternatives.add(index1);
        Index index2 = new Index(curr.x-1,curr.y-2);
        alternatives.add(index2);
        Index index3 = new Index(curr.x+1,curr.y+2);
        alternatives.add(index3);
        Index index4 = new Index(curr.x-1,curr.y+2);
        alternatives.add(index4);
        Index index5 = new Index(curr.x-2,curr.y+1);
        alternatives.add(index5);
        Index index6 = new Index(curr.x-2,curr.y-1);
        alternatives.add(index6);
        Index index7 = new Index(curr.x+2,curr.y+1);
        alternatives.add(index7);
        Index index8 = new Index(curr.x+2,curr.y-1);
        alternatives.add(index8);

        return alternatives;
    }
    public static boolean allvisited(){
        for (int i=0; i<8; i++){
            for (int j=0; j<8; j++ ){
                if(!visited[i][j])
                    return false;
            }
        }
        return true;
    }

    public static boolean isSafe(Index curr){
        return (curr.x>=0 && curr.y>=0 && curr.x<8 && curr.y<8
                && !visited[curr.x][curr.y] );
    }
    public static boolean knigtstour(Index pos){
        if(seq%3==0)
            print();
        List<Index> alternatives=getAlternatives(pos);



        while (!alternatives.isEmpty()){
            Index curr=alternatives.remove(0);
            if(isSafe(curr)){
                seq++;
                chessboard[curr.x][curr.y]=seq;
                visited[curr.x][curr.y]=true;
                if(allvisited())
                    return true;
                else if(knigtstour(curr)){
                    return true;
                }
                else {
                    seq--;
                    chessboard[curr.x][curr.y]=0;
                    visited[curr.x][curr.y]=false;

                }

            }

        }

        return false;

    }
    public static void print(){
        for (int i=0; i<8; i++){
            for (int j=0; j<8; j++ ){
                System.out.print(chessboard[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Done");
    }
}

