class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while(tx>sx && ty>sy){
            if(ty>tx) ty%=tx;
            else tx%=ty;
        }
        
        return sx == tx && sy <= ty && (ty - sy) % sx == 0 ||
               sy == ty && sx <= tx && (tx - sx) % sy == 0;
    }
}