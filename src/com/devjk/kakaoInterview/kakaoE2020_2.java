package com.devjk.kakaoInterview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class kakaoE2020_2 {

    private static Map<String, Integer[]> map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        map = new HashMap<>();

        int teamCnt = Integer.parseInt(input);
        int matchCnt = teamCnt * (teamCnt - 1);
        while(matchCnt-- > 0){
            String matchInput = br.readLine();
            String[] token = matchInput.split(" ");
            String team1 = token[0];
            int team1Win = Integer.parseInt(token[1]);
            String team2 = token[2];
            int team2Win = Integer.parseInt(token[3]);
            if(team1Win > team2Win){
                setWinAndLoseCount(team1, team1Win, team2, team2Win);
            }else{
                setWinAndLoseCount(team2, team2Win, team1, team1Win);
            }
        }

        List<Team> list = new ArrayList<>();
        for(Map.Entry<String, Integer[]> entry : map.entrySet()){
            list.add(new Team(entry.getKey(), entry.getValue()[0], entry.getValue()[1]));
        }

        Collections.sort(list);

        for(Team team : list){
            System.out.println(team.getName() + " " + team.getWinCnt() + " " + team.getSetPoint());
        }

    }

    public static void setWinAndLoseCount(String winTeam, int winTeamCnt, String loseTeam, int loseTeamCnt){
        int setPoint = Math.abs(winTeamCnt - loseTeamCnt);
        setupWinCnt(winTeam);
        setupSetPoint(winTeam, setPoint);
        setupSetPoint(loseTeam, -setPoint);
    }

    public static void setupWinCnt(String winTeam){
        if(!map.containsKey(winTeam)){
            map.put(winTeam, new Integer[]{0, 0});
        }
        Integer[] teamInfo = map.get(winTeam);
        Integer winCnt = teamInfo[0];
        Integer setPoint = teamInfo[1];
        map.put(winTeam, new Integer[]{winCnt + 1, setPoint});
    }

    public static void setupSetPoint(String team, int setAddPoint){
        if(!map.containsKey(team)){
            map.put(team, new Integer[]{0, 0});
        }
        Integer[] teamInfo = map.get(team);
        Integer winCnt = teamInfo[0];
        Integer setPoint = teamInfo[1];
        map.put(team, new Integer[]{winCnt, setPoint + setAddPoint});
    }

}

class Team implements Comparable<Team>{
    String name;
    int winCnt;
    int setPoint;
    public Team(String name, int winCnt, int setPoint){
        this.name = name;
        this.winCnt = winCnt;
        this.setPoint = setPoint;
    }

    @Override
    public int compareTo(Team team) {
        if(this.winCnt != team.winCnt){
            return (this.winCnt > team.winCnt) ? -1 : 1;
        }else if(this.setPoint != team.setPoint){
            return (this.setPoint > team.setPoint) ? -1 : 1;
        }
        return (this.name.compareTo(team.name) > 0) ? 1 : -1;
    }

    public String getName(){
        return this.name;
    }
    public int getWinCnt(){
        return this.winCnt;
    }
    public int getSetPoint(){
        return this.setPoint;
    }

}
