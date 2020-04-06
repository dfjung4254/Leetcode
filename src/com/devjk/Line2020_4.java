package com.devjk;

import java.util.Iterator;
import java.util.TreeMap;

public class Line2020_4 {

    TreeMap<String, String> snapshotMap;
    TreeMap<String, String[]> transactionMap;

    public String[][] solution(String[][] snapshots, String[][] transactions) {
        /* init */
        snapshotMap = new TreeMap<>();
        int sn_size = snapshots.length;
        for(int i = 0; i < sn_size; i++){
            /* 계좌, 잔액 */
            snapshotMap.put(snapshots[i][0], snapshots[i][1]);
        }
        transactionMap = new TreeMap<>();
        int tn_size = transactions.length;
        for(int i = 0; i < tn_size; i++){
            String id = transactions[i][0];
            String[] tran = new String[]{transactions[i][1], transactions[i][2], transactions[i][3]};
            if(!transactionMap.containsKey(id)){
                transactionMap.put(id, tran);
            }
        }

        /* action with transaction log */
        Iterator<String> tn_keys = transactionMap.keySet().iterator();
        while(tn_keys.hasNext()){
            String id = tn_keys.next();
            String[] transaction = transactionMap.get(id);
            String type = transaction[0];
            String account = transaction[1];
            String money = transaction[2];
            if(!snapshotMap.containsKey(account)){
                /* 신규 */
                snapshotMap.put(account, money);
            }else{
                /* 기존 */
                String str_balance = snapshotMap.get(account);
                int new_balance = 0;
                if("SAVE".equals(type)){
                    new_balance = Integer.parseInt(str_balance) + Integer.parseInt(money);
                }else if("WITHDRAW".equals(type)){
                    new_balance = Integer.parseInt(str_balance) - Integer.parseInt(money);
                }
                snapshotMap.put(account, String.valueOf(new_balance));
            }
        }

        /* make answer */
        int ans_size = snapshotMap.size();
        String[][] answer = new String[ans_size][2];
        Iterator<String> sn_keys = snapshotMap.keySet().iterator();
        int idx = 0;
        while(sn_keys.hasNext()){
            String account = sn_keys.next();
            answer[idx][0] = account;
            answer[idx][1] = snapshotMap.get(account);
            idx++;
        }

        return answer;
    }

}
