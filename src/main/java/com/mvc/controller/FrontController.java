package com.mvc.controller;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.command.Command;

@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private HashMap<String, Object> commandmap = new HashMap<String, Object>();
	
    public FrontController() {
        super();
    }
    
    public void init(ServletConfig config) throws ServletException{
    	System.out.println();
    	System.out.println("FrontController init Start");
        String configFile = config.getInitParameter("configFile");
        System.out.println("String configFile = config.getInitParameter(\"configFile\") : " + configFile);
        String path = config.getServletContext().getRealPath(configFile);
        System.out.println("String path = config.getServletContext().getRealPath(configFile) : " + path);
        
        FileInputStream fis = null;
        System.out.println("FileInputStream fis : " + fis);
        BufferedInputStream bis = null;
        System.out.println("BufferedInputStream bis : " + bis);
        Properties pro = new Properties();
        System.out.println("Properties pro : " + pro);
                
        
        try {
            fis = new FileInputStream(path); // 물리적인 파일을 다운받음
            System.out.println("fis = new FileInputStream(path) : " + fis);
            bis = new BufferedInputStream(fis, 1024); // 파일을 버퍼단위로 쪼갬
            System.out.println("bis = new BufferedInputStream(fis, 1024) : "+ bis);
            pro.load(bis); // Properties객체에 정보를 버퍼단위로 담음
            System.out.println("pro pro.load(bis) : " + pro);
         } catch (Exception e) {
            e.printStackTrace();
         } finally {
            try {
               if(fis!=null) {
                  fis.close();   // close
               }
               if(bis!=null) {
                  bis.close();   // close
               }
            } catch (Exception e2) {
               e2.printStackTrace();
            }
         }
        
        // 자바의 컬렉션에 저장되어있는 요소를 읽어오는 표준 인터페이스(Iterator)
        Iterator<Object> keyIter = pro.keySet().iterator();
        System.out.println("Iterator<Object> keyIter = pro.keySet().iterator() : " + keyIter);
        
        while(keyIter.hasNext()) {
           String command = (String) keyIter.next();   	// ex) /member/main.do
           System.out.println("String command = (String) keyIter.next() : " + command);
           String className = pro.getProperty(command);  	 // ex) com.java.member.command.MainCommand
           System.out.println("String className = pro.getProperty(command) : " + className);
           
           try {                            // ex) className : java.com.member.command.RegisterCommand
              Class<?> handlerClass = Class.forName(className); // 의미상의 객체 생성 (객체에 대한 정보를 담는 handlerClass생성)
              System.out.println("Class<?> handlerClass = Class.forName(className) : " + handlerClass);
              // 정보를 이용하여 new를 통한 객체 생성
              Object handlerInstance = handlerClass.getDeclaredConstructor().newInstance();    // 인스턴스 부여
              System.out.println("Object handlerInstance = handlerClass.getDeclaredConstructor().newInstance() : " + handlerInstance);
              
              // getDeclaredConstructor : handlerClass(java.com.member.command.RegisterCommand)경로에 파일이 실제 존재한다면 해당 객체를 반환(newInstnace)해준다
              
              commandmap.put(command, handlerInstance);   // 주소와 객체 commandmap에 담는다
              System.out.println("commandmap.put(command, handlerInstance) commandmap : " + commandmap);
           } catch (Exception e) {
              e.printStackTrace();
           }
        }
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getServletPath();
		System.out.println("String cmd = request.getServletPath() : " + cmd);
		String viewPage = null;
		System.out.println("String viewPage = null : " + viewPage);
		try {
			 Command com = (Command) commandmap.get(cmd);
			 System.out.println("Command com = (Command) commandmap.get(cmd) : " + com);
			 viewPage = com.proRequest(request, response);
			 System.out.println("viewPage = com.proRequest(request, response) : " + viewPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	      if(viewPage!=null) {
	          RequestDispatcher rd = request.getRequestDispatcher(viewPage);   // RequestDispathcer을 통해 viewPage실행
	          System.out.println("RequestDispatcher rd = request.getRequestDispatcher(viewPage) : " + rd);
	          rd.forward(request, response);
	       }
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
