// package CloudGame;

// import java.util.Random;

// public class CloudGenerator {
//     public int Gravity = 10;

//     public int seedx, seedy;
//     public int min = 0;
//     public int maxx = 800;
//     public int maxy = 600;

//     CloudGenerator(){
//         Random r = new Random();
//         seedx = min + r.nextInt(maxx-min+1);
//         System.out.println(seedx);
//         seedy = min + r.nextInt(maxy-min+1);
//         System.out.println(seedy);
//     }
// }

package CloudGame;

import java.util.Random;

public class CloudGenerator {
    public int Gravity = 50;

    public int seedx, seedy;
    public int min = 0;
    private int maxx = 1400; 
    public int maxy = 700;

    Random random = new Random();

    public CloudGenerator() {
        seedx = min + random.nextInt(maxx - min + 1);
        System.out.println(seedx);
        seedy = min + random.nextInt(maxy - min + 1);
        System.out.println(seedy);
    }

    // Getter method for maxx
    public int getMaxx() {
        return maxx;
    }
}


