int firstCat(int x, int y, int z) {
    int dxz = abs(z - x);
    int dyz = abs(z - y);
    if(dxz > dyz)
        return 2;
    if(dxz < dyz)
        return 1;
    return 0;
}