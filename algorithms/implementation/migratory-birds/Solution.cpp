int migratoryBirds(int n, vector <int> ar) {
    unordered_map<int,int> type2count;
    for(auto kind : ar)
        type2count[kind]++;

    int max = -1;
    int max_type = -1;
    for(auto kv : type2count)
        if(max == kv.second)
            max_type = min(kv.first, max_type);
        else if(max < kv.second) {
            max = kv.second;
            max_type = kv.first;
        }

    return max_type;
}