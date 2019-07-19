package com.example.demo.servlets;
import com.example.demo.logic.Point;
import com.example.demo.logic.TaskResolver;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/servlet/count" , loadOnStartup = 1)
public class AppServlet extends HttpServlet  {
    private TaskResolver resolver=new TaskResolver();
    private static final long serialVersionUID = 1L;
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        doGet(request,response);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String width=request.getParameter("width");
        String height=request.getParameter("height");
        String start=request.getParameter("start");
        String end=request.getParameter("end");
        int w=0;
        int i=0;
        char c=width.charAt(i);
        while(i<width.length()-1){
            w*=10;
            w+=c-48;
            i++;
        }
        w*=10;
        w+=c-48;
        int h=0;
        i=0;
        c=height.charAt(i);
        while(i<height.length()-1){
            h*=10;
            h+=c-48;
            i++;
        }
        h*=10;
        h+=c-48;
        int ax,ay,bx,by;
        //Перевод координат доски в численные индексы
        c=start.charAt(0);
        ax=c-64;
        i=1;
        ay=0;
        c=start.charAt(i);
        while(i<start.length()){
            ay*=10;
            ay+=(c-48);
            i++;
            if(!(i<start.length()))break;
            c=start.charAt(i);
        }
        Point a=new Point(ax,ay);
        c=end.charAt(0);
        bx=c-64;
        i=1;
        by=0;
        c=end.charAt(i);
        while(i<end.length()){
            by*=10;
            by+=(c-48);
            i++;
            if(!(i<end.length()))break;
            c=end.charAt(i);
        }
        Point b=new Point(bx,by);
        int answ= resolver.task(h,w,a,b);
        out.println(answ);
        System.out.println(i);
        }
}