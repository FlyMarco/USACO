/*
ID: mesysky1
PROG: milk2
LANG: C++
*/

#include <fstream>
#include <iostream>
using namespace std;
const int maxn = 1000001;
int timeline[maxn] = {0};
int main()
{
    ifstream fin("milk2.in");
    ofstream fout("milk2.out");
    int n, start = 1000000, end = 0;

    fin >> n;
    for(int i = 0; i < n; i++) {
        int t_start, t_end;
        fin >> t_start >> t_end;
        if(t_start < start) start = t_start;
        if(t_end > end) end = t_end;
        for(int j = t_start; j < t_end; j++) {
            timeline[j] = 1;
        }
    }
    int maxWorkingTime = 0, maxFreeTime = 0;
    int tempWorking = 0, tempFree = 0;
    for(int i = start; i < end; i++) {
        if(timeline[i] == 1) {
            tempFree = 0;
            tempWorking++;
            if(tempWorking > maxWorkingTime) {
                maxWorkingTime = tempWorking;
            }
        }
        else {
            tempWorking = 0;
            tempFree++;
            if(tempFree > maxFreeTime) {
                maxFreeTime = tempFree;
            }
        }
    }
    fout << maxWorkingTime << " " << maxFreeTime << endl;
//    cout << maxWorkingTime << " " << maxFreeTime << endl;
    fin.close(); fout.close();

    return 0;
}
