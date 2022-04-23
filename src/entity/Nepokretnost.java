package entity;

public class Nepokretnost {

    private int brojOpstine;
    private double povrsina;
    private Tip tip;

    public Nepokretnost(int brojOpstine, double povrsina, Tip tip) {
        this.brojOpstine = brojOpstine;
        this.povrsina = povrsina;
        this.tip = tip;
    }

    public int getBrojOpstine() {
        return brojOpstine;
    }

    public void setBrojOpstine(int brojOpstine) {
        this.brojOpstine = brojOpstine;
    }

    public double getPovrsina() {
        return povrsina;
    }

    public void setPovrsina(double povrsina) {
        this.povrsina = povrsina;
    }

    public Tip getTip() {
        return tip;
    }

    public void setTip(Tip tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        return "Nepokretnost{" +
                "brojOpstine=" + brojOpstine +
                ", povrsina=" + povrsina +
                ", tip=" + tip +
                '}';
    }
}
