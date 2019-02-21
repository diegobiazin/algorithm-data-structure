import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class JumpingOnClouds {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int pulos = 0;
        int pulou = 0;

        for (int i = 0; i < c.length; i++){
            if(i == 0)
                continue;

            if(c[i-1] + c[i] == 0) {
                if(pulou == 1){
                    pulou =0;
                    continue;
                }
                pulos++;
                pulou++;
            }

            else if(c[i-1] == 1 & c[i] == 0){
                pulos++;
                pulou=0;
            }
        }

        return pulos;
    }

    public static void main(String[] args) throws IOException {

        int[] nuvens = {0,0,0,0,1,0};
        int result = jumpingOnClouds(nuvens);

    }
}
