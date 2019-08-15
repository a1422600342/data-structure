package cn.nit.datastructure.sparsearray;

/**
 * @ClassName SparseArrayDemo
 * @Description TODO 稀疏数组demo
 * @Author dong <feng.db@uniteddata.com>
 * @Date 2019/8/15
 * @Version 1.0.0
 **/
public class SparseArrayDemo {

    private static int[][] chesses = new int[11][11];

    /**
     * 初始化棋盘
     * @param chesses 二维数组，相当于棋盘
     * @param init 初始值,默认0
     */
    public void init(int[][] chesses,int init){
        for (int[] i : chesses){
            for (int j : i){
                j = init;
            }
        }
        // 设置2个棋子
        chesses[1][2] = 1;
        chesses[2][3] = 2;
        System.out.println("初始棋盘如下");
        for (int[] i : chesses){
            for (int j : i){
                System.out.printf("%d  ",j);
            }
            System.out.println();
        }
    }

    /**
     * 创建稀疏数组
     */
    public int[][] createSparseArray(int[][] data, int init){
        int sum = 0; // 统计非空个数
        int col = 0;
        int row = 0;
        String memo = ""; // 记录数值元素信息(减少不必要的循环)
        // 统计原始数组中数据元素个数
        for (int[] i : data){
            col = 0;
            for (int j : i){
                if (j != init) {
                    sum++;
                    memo += row + "," + col + "," + j + ";";
                }
                col++;
            }
            row++;
        }
        int[][] sparseArray = new int[sum+1][3];
        // row col data
        sparseArray[0][0] = row;
        sparseArray[0][1] = col;
        sparseArray[0][2] = sum;

        System.out.println("临时存储数据为：" + memo);
        String[] m1 = memo.split(";");
        //
        for (int i = 1; i <= sum; ++i){
            String[] m2 = m1[i-1].split(",");
            for (int j = 0; j < 3; ++j){
                int r = Integer.parseInt(m2[0]);
                int c = Integer.parseInt(m2[1]);
                int d = Integer.parseInt(m2[2]);
                sparseArray[i][0] = r;
                sparseArray[i][1] = c;
                sparseArray[i][2] = d;
            }
        }
        System.out.println("稀疏矩阵为：");
        for (int[] i : sparseArray){
            for (int j : i){
                System.out.printf("%d  ",j);
            }
            System.out.println();
        }
        return sparseArray;
    }

    /**
     * 将稀疏数组还原成二维数组
     * @param sparseArray
     * @param init
     * @return
     */
    public int[][] reduceToArray(int[][] sparseArray,int init){
        int row = sparseArray[0][0];
        int col = sparseArray[0][1];
        int sum = sparseArray[0][2];
        int[][] arr = new int[row][col];
        for (int[] i : arr){
            for (int j : i){
                j = init;
            }
        }
        for (int i = 1; i <= sum; ++i) {
            for (int j = 0; j < 3; ++j) {
                int r = sparseArray[i][0];
                int c = sparseArray[i][1];
                int d = sparseArray[i][2];
                arr[r][c] = d;
            }
        }
        System.out.println("还原后的二维数组：");
        for (int[] i : arr){
            for (int j : i) {
                System.out.printf("%d  ",j);
            }
            System.out.println();
        }
        return arr;
    }


    public static void main(String[] args){
        SparseArrayDemo sparseArrayDemo = new SparseArrayDemo();
        sparseArrayDemo.init(chesses,0);
        int[][] sparseArray = sparseArrayDemo.createSparseArray(chesses, 0);
        sparseArrayDemo.reduceToArray(sparseArray,0);
    }
}
