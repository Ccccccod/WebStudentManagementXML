/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Student;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

/**
 *
 * @author MR TU
 */
@WebServlet(name="HomeController",urlPatterns={"/HomeController"})
public class HomeController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            StudentManager manager = new StudentManager();

            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String dob = request.getParameter("dob");
            String address = request.getParameter("address");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");

            if (request.getParameter("add") != null) {
                manager.add(new Student(id, name, dob, address, email, phone));
                request.getRequestDispatcher("jsp/home.jsp").forward(request, response);
            } else if (request.getParameter("update") != null) {
                manager.update(new Student(id, name, dob, address, email, phone));
                request.getRequestDispatcher("jsp/home.jsp").forward(request, response);
            } else if (request.getParameter("delete") != null) {
                manager.delete(id);
                request.getRequestDispatcher("jsp/home.jsp").forward(request, response);
            } else if (request.getParameter("search") != null) {
                List<Student> students = manager.search(new Student(id, name, dob, address, email, phone));
                request.setAttribute("list", students);
                request.getRequestDispatcher("jsp/list.jsp").forward(request, response);
            } else if (request.getParameter("show") != null) {
                List<Student> students = manager.show();
                request.setAttribute("list", students);
                request.getRequestDispatcher("jsp/list.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("jsp/home.jsp").forward(request, response);
            }
        } catch (JAXBException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
