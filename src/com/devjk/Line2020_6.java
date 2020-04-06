package com.devjk;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class Line2020_6 {

    TreeMap<String, Dir> root;

    public String[] solution(String[] directory, String[] command) {
        /* init */
        int size = directory.length;
        Dir rootDir = new Dir(directory[0]);
        root.put(rootDir.name, rootDir);
        for(int i = 1; i < size; i++){
            String[] childs = directory[i].split("/");
            Dir currentDir = rootDir;
            for(String child_dir : childs){
                if(!currentDir.child.containsKey(child_dir)){
                    /* 신규 */
                    currentDir.child.put(child_dir, new Dir(child_dir));
                }
                currentDir = currentDir.child.get(child_dir);
            }
        }

        /* command */
        for(String cmd : command){
            String args[] = cmd.split(" ");
            if("mkdir".equals(args[0])){
                String[] childs = args[1].split("/");
                Dir currentDir = rootDir;
                for(String child_dir : childs){
                    if(!currentDir.child.containsKey(child_dir)){
                        /* 신규 */
                        currentDir.child.put(child_dir, new Dir(child_dir));
                    }
                    currentDir = currentDir.child.get(child_dir);
                }
            }else if("cp".equals(args[0])){

            }else if("rm".equals(args[0])){

            }
        }

        ArrayList<String> list = new ArrayList<>();
        Queue<Dir> q = new LinkedList<>();
        q.offer(rootDir);
        while(!q.isEmpty()){
            Dir dir = q.poll();
            list.add(dir.name);
            for(String c_dir_name : dir.child.keySet()){
                q.offer(dir.child.get(c_dir_name));
            }
        }

        String[] answer = new String[];
        return answer;
    }

}

class Dir {
    String name;
    TreeMap<String, Dir> child;
    Dir(String name){
        this.name = name;
        child = new TreeMap<>();
    }
}