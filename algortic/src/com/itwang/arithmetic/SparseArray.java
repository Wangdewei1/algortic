package com.itwang.arithmetic;

import java.io.*;

/**
 * 模仿五子棋存盘
 *
 * 稀疏数组
 */
public class SparseArray {
    public static void main(String[] args) throws IOException {

        //1.创建一个二维数组 11 * 11
        //0：表示没有棋子 1：代表黑子 2：代表蓝子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[10][5] = 1;
        chessArr1[5][5] = 2;
        for(int[] rows : chessArr1){
            for(int data : rows){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        System.out.println("------------------------------");

        //将稀疏数组转成原始数组
        //1.先遍历二维数组 得到非0数据的个数
        int sum = 0 ;
        for (int[] arrary : chessArr1) {
            for (int data : arrary) {
                if (data != 0) {
                    sum += 1;
                }
            }
        }
        System.out.println("有棋子的个数：" + sum);

        //2.创建对应的稀疏数组
        int[][] sparseArr = new int[sum+1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        //遍历
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        //输出稀疏数组
        System.out.println("------------------------------");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }


        System.out.println("--------------------------------");
        /**
         * 将稀疏数组恢复成原来的数组
         */
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];

        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        //输出恢复后的二维数组
        for (int[] array : chessArr2) {
            for (int data : array) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

//        InputStream inputStream = new FileInputStream();
        //将稀疏数组保存到磁盘上
        //写稀疏数组到map.data文件
//        FileWriter fileWriter = new FileWriter("map.data");
//        for (int[] array : sparseArr) {
//            for (int data : array) {
//                fileWriter.write(data + "\t");
//            }
//            fileWriter.write("\n");
//        }
//        fileWriter.close();


        //写入方式二
        FileOutputStream fos = new FileOutputStream("map.data");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        for (int i = 0; i < sparseArr.length; i++) {
            for (int j = 0; j < sparseArr[i].length; j++) {
                bw.write(sparseArr[i][j] +"\t");
            }
            if(i != sparseArr.length - 1)
                bw.write("\n");
        }
        bw.flush();
        bw.flush();
        bw.close();
        System.out.println("存储成功");


        //读取
        int[][] sparseArray2 = new int[sum+1][3];
        FileInputStream fis = new FileInputStream("map.data");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String str = null;
        int row = 0;
        while((str = br.readLine()) != null){
            String[] temp = str.split("\t");
            for(int j = 0;j<temp.length;j++){
                sparseArray2[row][j] = Integer.parseInt(temp[j]);
            }
            row++;
        }
        br.close();
        System.out.println("显示读出来的数组");
        for(int i=0;i<sparseArray2.length;i++){
            for(int j=0;j<3;j++){
                System.out.print(sparseArray2[i][j]+"\t");
            }
            System.out.println();
        }


    }

}

