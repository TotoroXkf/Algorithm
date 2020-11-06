class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        long X = Math.max(0, (long) Math.min(C, G) - (long) Math.max(A, E));
        long Y = Math.max(0, (long) Math.min(D, H) - (long) Math.max(B, F));
        long area1 = ((long) C - (long) A) * ((long) D - (long) B);
        long area2 = ((long) G - (long) E) * ((long) H - (long) F);
        long area3 = X * Y;
        return (int) (area1 + area2 - area3);
    }
}