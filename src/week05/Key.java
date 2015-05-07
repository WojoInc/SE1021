package week05;

/**
 * Created by Owner on 5/7/2015.
 */
public class Key {
    private long n;
    private long e;

    public long getN() {
        return n;
    }

    public long getE() {
        return e;
    }

    Key(long n, long e){
        this.n = n;
        this.e = e;
    }
    public String toString(){
        String output ="";
        output = "Keypair is: " + n + " " + e;
        return output;
    }
}
