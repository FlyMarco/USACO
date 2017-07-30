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
bool One_Rotation(char a[][], char b[][], int n) {
    
}
bool Two_Rotation(char a[][], char b[][], int n) {

}
bool Three_Rotation(char a[][], char b[][], int n) {
    
}
bool Reflection(char a[][], char b[][], int n) {
    
}
bool Combination(char a[][], char b[][], int n) {
    
}
bool Nochange(char a[][], char b[][], int n) {
    
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
}