/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tests.jsplogin.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Rohit
 */
public class FileUploadController extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        ServletFileUpload sf=new ServletFileUpload(new DiskFileItemFactory());
        try {
            List<FileItem> files=sf.parseRequest(request);
            for(FileItem f: files ){
                f.write(new File("/"+f.getName()));
            }
            System.out.println("Upload done");
            RequestDispatcher rd = request.getRequestDispatcher("welcomepg.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            System.out.println(e);

        }
    


    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
