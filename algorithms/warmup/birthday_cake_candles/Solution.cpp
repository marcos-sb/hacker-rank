#include <bits/stdc++.h>

using namespace std;

int birthdayCakeCandles(vector <int> ar) {
    int maxHeight = INT_MIN;
    for(int height : ar)
        maxHeight = max(maxHeight, height);

    int tallestCount = 0;
    for(int height : ar)
        if(height == maxHeight)
            tallestCount++;

    return tallestCount;
}

int main() {
    int n;
    cin >> n;
    vector<int> ar(n);
    for(int ar_i = 0; ar_i < n; ar_i++){
       cin >> ar[ar_i];
    }
    int result = birthdayCakeCandles(ar);
    cout << result << endl;
    return 0;
}
