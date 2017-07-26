/*
ID: mesysky1
PROG: beads
LANG: C++
*/

#include <fstream>
#include <string>
#include <iostream>
using namespace std;

int main()
{
    ifstream fin("beads.in");
    ofstream fout("beads.out");
    int n;
    string beads;
    fin >> n >> beads;
    int maxlen = 0;

    for(int i = 0; i < n; i++) {
        int all = 2;
        int left = i - 1;
        int colorleft;
        while(beads[(left+n) % n] == 'w') {
            all++;
            left--;
            if(all >= n) return n;
        }
        colorleft = beads[left];
        while(beads[(left+n) % n] == 'w' || beads[(left+n) % n] == colorleft) {
            all++;
            left--;
            if(all >= n) return n;
        }

        int right = i;
        int colorright;
        while(beads[(right+n) % n] == 'w') {
            all++;
            right++;
            if(all >= n) return n;
        }
        colorright = beads[right];
        while(beads[(right+n) % n] == 'w' || beads[(right+n) % n] == colorright) {
            all++;
            right++;
            if(all >= n) return n;
        }
        if(all > maxlen) maxlen = all;
    }
    fout << maxlen << endl;
    return 0;
}