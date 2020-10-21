package programmers;

public class LockAndKeys {

    public boolean solution(int[][] key, int[][] lock) {

        int keySize = key.length;
        int lockSize = lock.length;
        boolean ans = false;

        /* simulation */
        for(int rot = 0; rot < 4; rot++){
            int[][] rotatedKey = rotate(key, rot);
            for(int chI = -keySize; chI <= lockSize; chI++){
                for(int chJ = -keySize; chJ <= lockSize; chJ++){
                    if(isOk(rotatedKey, lock, chI, chJ)){
                        ans = true;
                    }
                }
            }
        }

        return ans;
    }

    private int[][] rotate(int[][] key, int gakdo){
        int[][] rotateKey = new int[key.length][key.length];
        for(int i = 0; i < rotateKey.length; i++){
            for(int j = 0; j < rotateKey[i].length; j++){
                rotateKey[i][j] = key[i][j];
            }
        }
        for(int i = 0; i < gakdo; i++){
            rotate90(rotateKey);
        }

        return rotateKey;
    }

    private void rotate90(int[][] key){
        int size = key.length;
        for (int i = 0; i < size / 2; i++){
            for (int j = i; j < size - 1 - i; j++) {
                int Top = key[i][j];
                key[i][j] = key[size - 1 - j][i];
                key[size - 1 - j][i] = key[size - 1 - i][size - 1 - j];
                key[size - 1 - i][size - 1 - j] = key[j][size - 1 - i];
                key[j][size - 1 - i] = Top;
            }
        }
    }

    private boolean isOk(int[][] rotatedKey, int[][] lock, int chI, int chJ){

        int[][] copiedLock = new int[lock.length][lock.length];
        for(int i = 0; i < copiedLock.length; i++){
            for(int j = 0; j < copiedLock[i].length; j++){
                copiedLock[i][j] = lock[i][j];
            }
        }

        for(int i = 0; i < rotatedKey.length; i++){
            for(int j = 0; j < rotatedKey[i].length; j++){
                int posI = i + chI;
                int posJ = j + chJ;
                if(posI >= 0 && posI < copiedLock.length && posJ >= 0 && posJ < copiedLock.length
                && rotatedKey[i][j] == 1){
                    copiedLock[posI][posJ] += rotatedKey[i][j];
                }
            }
        }

        boolean ret = true;
        for(int i = 0; i < copiedLock.length; i++){
            for(int j = 0; j < copiedLock[i].length; j++){
                if(copiedLock[i][j] != 1){
                    ret = false;
                }
            }
        }
        return ret;
    }

}
