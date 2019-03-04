package com.amazon.online;

//https://aonecode.com/aplusplus/interviewctrl/getInterview/5478025948892386815
/** Given a series of equations e.g. [A = B, B = D, C = D, F = G, E = H, H = C] and then another series [A != C, D != H, ..., F != A ] 

Check whether the equations combined is valid. 

For the example given, your program should return 'invalid', because the first series implies that A = C, which contradicts the statement A != C in the second series.
**/
public class CheckValidEquations {

	// using connected components technique - implementing union find
	public boolean validStatements(char[][] equal, char[][] unequal) {
        int[] sets = new int[26];
        for(int i = 0; i < 26; i++) {
            sets[i] = i;
        }

        for(char[] pair: equal) {
            mergeSets(sets, pair[0] - 'A', pair[1] - 'A');
        }
        for(int i = 0; i < 26; i++) {
            findSrc(sets, i);
        }

        for(char[] pair: unequal) {
            if(sets[pair[0] - 'A'] == sets[pair[1] - 'A']) return false;
        }
        return true;
    }

    private int findSrc(int[] sets, int i) {
        int src = i;
        while(src != sets[src]) {
            src = sets[src];
        }
        int tmp;
        while (i != sets[i]) {
            tmp = sets[i];
            sets[i] = src;
            i = tmp;
        }
        return src;
    }

    private void mergeSets(int[] sets, int a, int b) {
        int srcA = findSrc(sets, a);
        int srcB = findSrc(sets, b);
        sets[srcB] = srcA;
    }
}
