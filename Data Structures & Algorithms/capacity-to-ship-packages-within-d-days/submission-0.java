class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0;
        int r = 0;
        for (int w: weights) {
            l = Math.max(w, l);
            r += w;
        }
        int res = r;

        while (l <= r) {
            int cap = l + (r - l) / 2;

            if (canShip(weights, days, cap)) {
                res = cap;
                r = cap - 1;
            } else {
                l = cap + 1;
            }
        }

        return res;
    }

    public boolean canShip(int[] weights, int days, int cap) {

        int ships = 1;
        int currCap = cap;
        for (int w: weights) {
            
            if (currCap - w < 0)  {
                ships++;
                if (ships > days) return false;
                currCap = cap;
            }
            currCap -= w;

        }

        return true;
    }
}