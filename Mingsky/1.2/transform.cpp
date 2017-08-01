/*
ID: mesysky1
PROG: transform
LANG: C++
*/
#include <fstream>
#include <iostream>
#include <string>
using namespace std;
const int maxn = 11;
char A[maxn][maxn], B[maxn][maxn];
bool Judge(int n) {
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            if(A[i][j] != B[i][j]) return false;
        }
    }
    return true;
}
void Rotation(int n) {
    char temp[n][n];
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            temp[j][n-i-1]=A[i][j];
        }
    }
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            A[i][j] = temp[i][j];
        }
    }
}

void Reflection(int n) {
    char temp[n][n];
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            temp[i][j] =  A[i][n-j-1];
        }
    }
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            A[i][j] = temp[i][j];
        }
    }
}
int main()
{
    ifstream fin("transform.in");
    ofstream fout("transform.out");
    int n;
    fin >> n;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            fin >> A[i][j]; 
        }
    }
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            fin >> B[i][j];
        }
    }
    Rotation(n);
    if(Judge(n)) {
        fout << 1 << endl;
        return 0;
    }
    Rotation(n);
    if(Judge(n)) {
        fout << 2 << endl;
        return 0;
    }
    Rotation(n);
    if(Judge(n)) {
        fout << 3 << endl;
        return 0;
    }
    Rotation(n);
    Reflection(n);
    if(Judge(n)) {
        fout << 4 << endl;
        return 0;
    }
    Rotation(n);
    if(Judge(n)) {
        fout << 5 << endl;
        return 0;
    }
    Rotation(n);
    if(Judge(n)) {
        fout << 5 << endl;
        return 0;
    }
    Rotation(n);
    if(Judge(n)) {
        fout << 5 << endl;
        return 0;
    }
    Rotation(n);
    Reflection(n);
    if(Judge(n)) {
        fout << 6 << endl;
        return 0;
    }
    fout << 7 << endl;
    return 0;
}