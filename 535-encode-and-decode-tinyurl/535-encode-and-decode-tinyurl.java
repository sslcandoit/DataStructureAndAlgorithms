public class Codec {
    Map<String, String> shortToLong=new HashMap<>();
    String base="http://tinyurl.com/";
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String dic="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String key=null;
        do{
            key="";
            for(int i=0; i<6; i++){
                key=key+dic.charAt((int)(Math.random()*dic.length()));
            }
        }while(shortToLong.containsKey(key));
        shortToLong.put(key, longUrl);
        return base+key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortToLong.get(shortUrl.replace(base, ""));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));