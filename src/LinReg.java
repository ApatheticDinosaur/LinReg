import java.util.HashMap;

/**
 * Linear regression algorithm
 * Created by Andy on 9/6/2016.
 */
public class LinReg {

    private HashMap data;
    private double error = 0;


    public LinReg(HashMap data) {
        this.data = data;
    }

    public HashMap getData() {
        return data;
    }

}
