import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

class Matrix {
    int numberOfRow;
    int numberOfColumn;
    int[][] matrix;
    Matrix(int numberOfRow,int numberOfColumn){
        this.numberOfRow=numberOfRow;
        this.numberOfColumn=numberOfColumn;
        matrix=new int[numberOfRow][numberOfColumn];
    }
}

class Operations{

    public static void addition(Matrix[] matrixArray){
        //Check whether these two matrices compatible to addition
        if (matrixArray[0].numberOfRow==matrixArray[1].numberOfRow && matrixArray[0].numberOfColumn==matrixArray[1].numberOfColumn){
            System.out.println("Compatible to Addition");

            //Addition
            Matrix addmatrix=new Matrix(matrixArray[0].numberOfRow,matrixArray[0].numberOfColumn);
            for (int i = 0; i < matrixArray[0].numberOfRow; i++) {
                for (int j = 0; j < matrixArray[0].numberOfColumn; j++) {
                    addmatrix.matrix[i][j]=(matrixArray[0].matrix[i][j]+matrixArray[1].matrix[i][j]);
                }
            }

            //Print
            for (int p = 0; p < matrixArray[0].numberOfRow; p++) {
                for (int k = 0; k < matrixArray[0].numberOfColumn; k++) {
                    System.out.print(addmatrix.matrix[p][k]+" ");
                }
                System.out.println();
            }

        }else {
            System.out.println("Two matrix are incompatible to add");
        }
    }

    public static void subtraction(Matrix[] matrixArray){
        //Check whether these two matrices compatible to addition
        if (matrixArray[0].numberOfRow==matrixArray[1].numberOfRow && matrixArray[0].numberOfColumn==matrixArray[1].numberOfColumn){
            System.out.println("Compatible to Subtraction");

            //Addition
            Matrix addmatrix=new Matrix(matrixArray[0].numberOfRow,matrixArray[0].numberOfColumn);
            for (int i = 0; i < matrixArray[0].numberOfRow; i++) {
                for (int j = 0; j < matrixArray[0].numberOfColumn; j++) {
                    addmatrix.matrix[i][j]=(matrixArray[0].matrix[i][j]-matrixArray[1].matrix[i][j]);
                }
            }

            //Print
            for (int p = 0; p < matrixArray[0].numberOfRow; p++) {
                for (int k = 0; k < matrixArray[0].numberOfColumn; k++) {
                    System.out.print(addmatrix.matrix[p][k]+" ");
                }
                System.out.println();
            }

        }else {
            System.out.println("Two matrix are incompatible to subtract");
        }
    }

    public static void multiplication(Matrix[] matrixArray){
        //Check whether these two matrices compatible to addition
        if (matrixArray[0].numberOfColumn==matrixArray[1].numberOfRow){
            System.out.println("Compatible to Multiplication");

            //Addition
            Matrix addmatrix=new Matrix(matrixArray[0].numberOfRow,matrixArray[1].numberOfColumn);
            for (int j = 0; j < addmatrix.numberOfRow; j++) {
                for (int i = 0; i < addmatrix.numberOfColumn; i++) {
                    for (int k = 0; k < matrixArray[0].numberOfColumn; k++) {
                        addmatrix.matrix[j][i]+=(matrixArray[0].matrix[j][k]*matrixArray[1].matrix[k][i]);
                    }
                }

            }

            //Print -0
            for (int p = 0; p < addmatrix.numberOfRow; p++) {
                for (int k = 0; k < addmatrix.numberOfColumn; k++) {
                    System.out.print(addmatrix.matrix[p][k]+" ");
                }
                System.out.println();
            }

        }else {
            System.out.println("Two matrix are incompatible to Multiplication\nPlease checked the first matrix number of columns are equal to number of rows in second matrix.");
        }
    }

    public static void determinant(Matrix matrix){
        double determinant;

        determinant=(matrix.matrix[0][0]*matrix.matrix[1][1])-(matrix.matrix[0][1]*matrix.matrix[1][0]);

        System.out.println("Determinant :- "+determinant);

    }

    public static void inputMatrix(Matrix[] matrixArray,int matrixcount){
        Scanner input=new Scanner(System.in);
        int row;
        row = 0;
        int column;
        column = 0;
        for (int i = 0; i < matrixcount; i++) {
            System.out.print("Number of rows : ");
            row= input.nextInt();
            System.out.print("Number of column : ");
            column= input.nextInt();

            Matrix m1=new Matrix(row,column);
            matrixArray[i]=m1;

            //Add numbers in to the matrix
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < column; k++) {
                    m1.matrix[j][k]= input.nextInt();
                }
            }
        }

    }

    public static void findMinor(Matrix matrix,int index1,int index2){
        Matrix minorMatrix=new Matrix(matrix.numberOfRow-1,matrix.numberOfColumn-1);
        int[] array=new int[matrix.numberOfRow*matrix.numberOfRow];
        int q=0;

        for (int i = 0; i < matrix.numberOfRow; i++) {
            for (int j = 0; j < matrix.numberOfRow; j++) {
                if (i==index1 || j==index2){
                    continue;
                }else{
                    array[q]=matrix.matrix[i][j];
                    q++;
                }
            }
        }
        System.out.println(Arrays.toString(array));
        q=0;
        for (int i = 0; i < minorMatrix.numberOfRow; i++) {
            for (int j = 0; j < minorMatrix.numberOfColumn; j++) {
                minorMatrix.matrix[i][j]=array[q];
                q++;
            }

        }
        if (minorMatrix.numberOfRow>2){
            findMinor(minorMatrix);
        }
        determinant(minorMatrix);
    }
}
public class Demo {

    public static void main(String[] args) {
        //To store matrices
        Matrix[] matrixArray=new Matrix[2];
        Scanner input = new Scanner(System.in);

        //Select operations
        System.out.print("Enter command : ");
        int command = input.nextInt();
        
        
        //Operations
        if (command==1) {
            System.out.println("Addition");
            Operations.inputMatrix(matrixArray,2);
            Operations.addition(matrixArray);
        }else if (command==2){
            System.out.println("Subtraction");
            Operations.inputMatrix(matrixArray,2);
            Operations.subtraction(matrixArray);
        }else if (command==3){
            System.out.println("Multiplication");
            Operations.inputMatrix(matrixArray,2);
            Operations.multiplication(matrixArray);
        }else if (command==4){
            System.out.println("Find the Determinant");
            Operations.inputMatrix(matrixArray,1);
            Operations.determinant(matrixArray[0]);
        }else if (command==5){
            int index1;
            int index2;
            System.out.println("Find the Minor");
            do {
                System.out.print("Enter index 1 : ");
                index1=input.nextInt();
                System.out.print("Enter index 2 : ");
                index2=input.nextInt();

                Operations.inputMatrix(matrixArray,1);
                Operations.findMinor(matrixArray[0],index1,index2);

            }while (index1!=-1||index2!=-1);


        }
    }
}

