class Solution {
    public String reformatDate(String date) {
        String[] dates=date.split(" ");
        
        Map<String, String> m=new HashMap<>();
        m.put("Jan", "01");
        m.put("Feb", "02");
        m.put("Mar", "03");
        m.put("Apr", "04");
        m.put("May", "05");
        m.put("Jun", "06");
        m.put("Jul", "07");
        m.put("Aug", "08");
        m.put("Sep", "09");
        m.put("Oct", "10");
        m.put("Nov", "11");
        m.put("Dec", "12");
        
        String y=dates[2]+"-";
        String month=m.get(dates[1])+"-";
        
        int len=dates[0].length();
        String d=(len==3)? "0":"";
        d=d+dates[0].substring(0, len-2);
        
        return y+month+d;
    }
}