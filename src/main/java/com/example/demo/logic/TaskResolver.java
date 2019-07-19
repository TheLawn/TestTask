package com.example.demo.logic;

import java.util.*;

public class TaskResolver {

    int x[] = {1, 1, -1, -1, 2, 2, -2, -2};
    int y[] = {2, -2, 2, -2, 1, -1, 1, -1};
    //поиск пути по алгоритму Дейкстры
    public int task(int h,int w,Point a,Point b){
        int count=h*w;
        int[][] dist=new int[h][w];
        List<Point> v=new ArrayList<>();
        for(int i=0;i<h;i++){
            for (int j=0;j<w;j++){
                dist[i][j]=count;
                if(i==a.getX()-1&&j==a.getY()-1){
                    v.add(new Point(i,j,0));
                }else {
                    v.add(new Point(i, j, count));
                }
            }
        }
        dist[a.getX()-1][a.getY()-1]=0;
        while (!v.isEmpty()){
            Collections.sort(v);
            Point p=v.get(0);
            if(p.getDist()==count)break;
            v.remove(0);
            for (Point point:v) {
                for(int i=0;i<8;i++){
                    if(p.getX()+x[i]==point.getX()&&p.getY()+y[i]==point.getY()){
                        if(p.getDist()+1<point.getDist()){
                            point.setDist(p.getDist()+1);
                            dist[point.getX()][point.getY()]=point.getDist();
                        }
                    }
                }
            }
        }
        if(dist[b.getX()-1][b.getY()-1]<(count))return dist[b.getX()-1][b.getY()-1];
        return -1;
    }
}
