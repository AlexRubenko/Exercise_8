import java.util.Arrays;

public class MatrixMxN
{
    private int m;
    private int n;
    int [][] matrix = new int[m][n];

    public MatrixMxN()
    {
        this.m = 2;
        this.n = 2;
        this.matrix = new int[m][n];
    }

    public MatrixMxN(int m, int n)
    {
        this.m = m;
        this.n = n;
        this.matrix = new int[m][n];
    }

    public static MatrixMxN matrixCreating(int m, int n)
    {
        MatrixMxN b;

        if(m == 2 && n == m) {
                b = new MatrixMxN();
        }
        else {
                b = new MatrixMxN(m, n);
        }
        b.matrixFill();

       return b;
    }

    public void matrixFill(){

        final int max = 100;

        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                this.matrix[i][j] = (int)(Math.random() * +max);
            }
        }
    }

    public void changeArrayRowMinMax(int k, int m, int n)
    {
        if(k > 0 && k <= n) {
            int min = this.getArrayElement(0, k-1);
            int max = this.getArrayElement(0, k-1);
            int min_i = 0;
            int max_i = 0;


            for(int i = 1; i < m; i++) {

                if (this.getArrayElement(i, k) < min) {
                    min = this.getArrayElement(i, k);
                    min_i = i;
                }
            }
            for(int i = 1; i < m; i++) {

                if(this.getArrayElement(i, k) > max){
                    max = this.getArrayElement(i, k);
                    max_i = i;
                }
            }
            for(int j = 0; j < n; j++)
            {
                int temp_array_elem;

                temp_array_elem = this.getArrayElement(min_i, j);
                this.setArrayElement(min_i, j, this.getArrayElement(max_i, j));
                this.setArrayElement(max_i, j, temp_array_elem);

            }
        }
        else System.out.println("Incorrect value of k !");

    }

    public void change_I_StringPowerTwo(int i)
    {
        if(i > 0 && i <= m)
        {
            for(int j = 0; j < n; j++){
                this.matrix[i-1][j]= matrix[i-1][j] * matrix[i-1][j];
            }
        }
        else System.out.println("Incorrect value of i !");
    }

    public int getArrayElement(int i, int j)
    {
        return this.matrix[i][j];
    }

    public int setArrayElement(int i, int j, int temp)
    {
        return this.matrix[i][j] = temp;
    }


    public void matrixPrint(){

        for(int i = 0; i < m; i++ ){
            for(int j = 0; j < n; j++)
            {
                System.out.print(this.getArrayElement(i, j) + "  ");

                if(j == n - 1)
                {
                    System.out.println();
                }
            }
        }
        System.out.println();
    }



    public static void main(String[] args)
    {
        int c = 3;
        int d = 3;

        MatrixMxN a = matrixCreating(c, d);

        a.matrixPrint();

        a.changeArrayRowMinMax(2, c , d);

        a.matrixPrint();

        a.change_I_StringPowerTwo(2);

        a.matrixPrint();
    }
}
