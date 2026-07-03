class TimeMap {
    record Pair(int time, String val) {}
    private Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>())
            .add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        String ans = searchAns(map.get(key), timestamp);

        return ans;
    }

    private String searchAns(List<Pair> values, int ts) {
        int n = values.size();
        int low = 0;
        int high = n - 1;
        String ans = "";
        
        while (low <= high) {
            int mid = (low + high) / 2;

            Pair p = values.get(mid);
            if (p.time <= ts) {
                ans = p.val;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}
