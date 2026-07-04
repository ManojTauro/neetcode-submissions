class CountSquares {
    record Point(int x, int y) {}
    private Map<Point, Integer> map = new HashMap<>();

    public CountSquares() {
        
    }
    
    public void add(int[] point) {
        Point p = new Point(point[0], point[1]); 
        map.put(p, map.getOrDefault(p, 0) + 1);
    }
    
    public int count(int[] point) {
        int res = 0;

        int qx = point[0];
        int qy = point[1];

        for (Point p: map.keySet()) {
            int px = p.x;
            int py = p.y;

            if (px == qx && py == qy) continue;
            
            if (Math.abs(qx - px) != Math.abs(qy - py)) continue;

            Point bottomLeft = new Point(px, qy);
            Point topRight = new Point(qx, py);

            if (!map.containsKey(bottomLeft)) continue;
            if (!map.containsKey(topRight)) continue;

            res += map.get(p) * map.get(bottomLeft) * map.get(topRight);
        }

        return res;
    }
}
