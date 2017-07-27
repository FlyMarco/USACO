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
            if(all >= n) {
                fout << n << endl;
                return 0;
            }
        }
        colorleft = beads[left];
        left--;
        while(beads[(left+n) % n] == 'w' || beads[(left+n) % n] == colorleft) {
            all++;
            left--;
            if(all >= n) {
                fout << n << endl;
                return 0;
            }
        }

        int right = i;
        int colorright;
        while(beads[(right+n) % n] == 'w') {
            all++;
            right++;
            if(all >= n) {
                fout << n << endl;
                return 0;
            }
        }
        colorright = beads[right];
        right++;
        while(beads[(right+n) % n] == 'w' || beads[(right+n) % n] == colorright) {
            all++;
            right++;
            if(all >= n) {
                fout << n << endl;
                return 0;
            }
        }
        if(all > maxlen) maxlen = all;
    }
    fout << maxlen << endl;
    fin.close();
    fout.close();
    return 0;
}