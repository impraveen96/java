#include<bits/stdc++.h>
using namespace std;

#define vi vector<int>
#define rep(i, a, b) for(int i = a; i<b; i++)

int main()
{
    int n,k;
    cin>>n>>k;

    vi a(n);

    rep(i, 0, n)
    {
        cin>>a[i];
    }

    int s = 0; 
    int ans = INT_MAX;
    rep(i, 0, k)
    {
        s += a[i];
    }
    // cout<<s<<" ";
    ans = min(ans, s);
    //sliding window

    rep(i, 1, n-k+1)
    {
        s -= a[i-1];
        s += a[i+k-1];
        ans = min(ans, s);
        // cout<<s<<" ";
    }
    cout<<ans;
    return 0;
}