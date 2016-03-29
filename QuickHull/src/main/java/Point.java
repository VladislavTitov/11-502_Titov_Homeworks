public class Point {
    private int x;
    private int y;
    private boolean flag = true;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag() {
        if (flag == true){
            flag = false;
        }
    }
}
