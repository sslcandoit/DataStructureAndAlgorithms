class FileSystem {
    Node head;
    public FileSystem() {
        this.head=new Node("/");
    }
    
    public List<String> ls(String path) {
        Node cur=traverse(path);
        List<String> list=new ArrayList<>();
        
        if(cur.isFile){
            list.add(cur.name);
        }else{
            for(String fileName: cur.subFile.keySet()){
                list.add(fileName);
            }
        }
        Collections.sort(list);
        return list;
    }
    
    public void mkdir(String path) {
        traverse(path);
    }
    
    public void addContentToFile(String filePath, String content) {
        Node cur=traverse(filePath);
        cur.isFile=true;
        cur.content.append(content);
    }
    
    public String readContentFromFile(String filePath) {
        Node cur=traverse(filePath);
        return cur.content.toString();
    }
    
    private Node traverse(String path){
        String[] paths=path.split("/");
        Node cur=this.head;
        for(int i=1; i<paths.length; i++){
            if(!cur.subFile.containsKey(paths[i])){
                Node node=new Node(paths[i]);
                cur.subFile.put(paths[i], node);
            }
            cur=cur.subFile.get(paths[i]);
        }
        return cur;
    }
    
    class Node{
        boolean isFile;
        String name;
        StringBuilder content;
        Map<String, Node> subFile;
        public Node(String name){
            this.isFile=false;
            this.name=name;
            this.content=new StringBuilder();
            this.subFile=new HashMap<>();
        }
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */