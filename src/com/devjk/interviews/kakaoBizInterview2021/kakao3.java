package com.devjk.interviews.kakaoBizInterview2021;

import java.util.ArrayList;
import java.util.List;

public class kakao3 {

  static class Session {
    int startTime;
    int endTime;
    Session(int startTime, int endTime) {
      this.startTime = startTime;
      this.endTime = endTime;
    }
  }

  public static int Solution(List<Integer> start_time, List<Integer> duration_time) {

    List<Session> sessions = new ArrayList<>();
    sessions = getSortedUserSession(sessions, start_time, duration_time);

    int sessionSize = sessions.size();
    int answer = bruteForce(sessions, 0, sessionSize, 0, 0);

    return answer;
  }

  private static int bruteForce(List<Session> sessions, int index, int sessionSize, int count, int beforeTime) {

    if(index >= sessionSize) {
      return count;
    }

    int retCount = 0;
    Session curSession = sessions.get(index);
    if(beforeTime < curSession.startTime) {
      int thisCount = bruteForce(sessions, index + 1, sessionSize, count + 1, curSession.endTime);
      if(retCount < thisCount) {
        retCount = thisCount;
      }
    }
    int thisCount = bruteForce(sessions, index + 1, sessionSize, count, beforeTime);
    if(retCount < thisCount) {
      retCount = thisCount;
    }

    return retCount;
  }

  private static List<Session> getSortedUserSession(List<Session> sessions, List<Integer> start_time, List<Integer> duration_time) {
    int size = start_time.size();
    for(int i = 0; i < size; i++) {
      int startTime = start_time.get(i);
      int endTime = startTime + duration_time.get(i) - 1;
      sessions.add(new Session(startTime, endTime));
    }
    return customSortedSession(sessions);
  }

  private static List<Session> customSortedSession(List<Session> sessions) {
    sessions.sort((session1, session2) -> {
      if(session1.startTime == session2.startTime) {
        return session1.endTime - session2.endTime;
      }
      return session1.startTime - session2.startTime;
    });
    return sessions;
  }

}

class kakao3_solution {

  public static void main(String[] args) {

    List<Integer> startTime = new ArrayList<>();
    List<Integer> durationTime = new ArrayList<>();

    for(int i = 1; i <= 30; i++) {
      startTime.add(i * 2 - 1);
    }
    for(int i = 1; i <= 30; i++) {
      durationTime.add(1);
    }
    int ans = kakao3.Solution(startTime, durationTime);
    System.out.println(ans);
  }

}