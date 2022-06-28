class ParkingSystem {
    int[] park;
    public ParkingSystem(int big, int medium, int small) {
        this.park=new int[]{0, big, medium, small};
    }
    public boolean addCar(int carType) {
        return this.park[carType]-- >0;
    }
    /*
    int[] park;
    int[] size;
    public ParkingSystem(int big, int medium, int small) {
        this.park=new int[4];
        this.size=new int[]{0, big, medium, small};
    }
    
    public boolean addCar(int carType) {
        if(this.park[carType]<this.size[carType]){
            this.park[carType]++;
            return true;
        }
        return false;
    }
    */
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */