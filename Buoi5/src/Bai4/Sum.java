package Bai4;

public class Sum<N> {
    private N soA, soB;

    public Sum(){
        this.soA = null;
        this.soB = null;
    }

    public Sum(N soA, N soB) {
        this.soA = soA;
        this.soB = soB;
    }

    public N getSoA() {
        return soA;
    }

    public void setSoA(N soA) {
        this.soA = soA;
    }

    public N getSoB() {
        return soB;
    }

    public void setSoB(N soB) {
        this.soB = soB;
    }
}