class ProductOfNumbers {
    List<Integer> products;
    int lastZero=-1;
    public ProductOfNumbers() {
        this.products=new ArrayList<>();
        products.add(1);
    }
    
    public void add(int num) {
        int n=products.size();
        if(num==0){
            lastZero=n;
            this.products.add(1);
        }else products.add(products.get(n-1)*num);
    }
    
    public int getProduct(int k) {
        int n=products.size();
        if(lastZero<n-k) return products.get(n-1)/products.get(n-1-k);
        return 0;
    }
}
//[3, 0, 2, 5, 4, 8,  0, 7, 2]
// 3  1  2  10 40 320 1, 7, 14
/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */