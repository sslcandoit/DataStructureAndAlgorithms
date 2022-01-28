class Solution {
    private static int[] months={31,28,31,30,31,30,31,31,30,31,30,31};
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(daysSince1971(date1)-daysSince1971(date2));
    }
    private boolean isLeapYear(int year){
        return year%400==0 || (year%100 !=0 && year%4==0);
    }
    private int daysSince1971(String date){
        String[] dates=date.split("-");
        
        int y=Integer.parseInt(dates[0]);
        int m=Integer.parseInt(dates[1]);
        int d=Integer.parseInt(dates[2]);
        
        int days= (m>2 && isLeapYear(y))? d+1:d;
        for(int y_i=1971; y_i<y; y_i++) days+= (isLeapYear(y_i))? 366:365;
        for(int m_i=0; m_i<m-1; m_i++) days+=this.months[m_i];
        
        return days;
    }
}