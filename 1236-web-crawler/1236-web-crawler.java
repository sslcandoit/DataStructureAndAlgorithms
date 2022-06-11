/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */

class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        String[] temp=startUrl.split("/");
        String hostname=temp[2];
        
        Set<String> set=new HashSet<>();
        set.add(startUrl);
        Queue<String> q=new LinkedList<>();
        q.add(startUrl);
        
        while(!q.isEmpty()){
            String curUrl=q.poll();
            for(String url:htmlParser.getUrls(curUrl)){
                if(url.contains(hostname) && !set.contains(url)){
                    q.add(url);
                    set.add(url);
                }
            }
        }
        return new ArrayList<String>(set);
    }
}