class Solution {
    /*
        Tree proble. Lowest common ancester. Build a map of parents for each node.
    */
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        if (regions.size() == 0 || region1.length() == 0 || region2.length() == 0) return "";
        
        Map<String, String> map = new HashMap<>();
        for (List<String> list : regions) {
            String parent = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                map.put(list.get(i), parent);
            }
        }
        
        Set<String> set = new HashSet<>();        
        while (region1 != null) {
            set.add(region1);
            region1 = map.get(region1);
        }
        
        while (!set.contains(region2)) {
            region2 = map.get(region2);
        }
        
        return region2;
    }
}