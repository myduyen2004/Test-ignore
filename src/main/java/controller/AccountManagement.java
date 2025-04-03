package controller;

import jobtrans.dal.AccountDAO;
import jobtrans.model.Account;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;


    private void showAdminAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Mở comment sau khi hoàn tất task login, thay tên session bằng session tương ứng
        //        HttpSession session = req.getSession();
        //        Integer id = (Integer)session.getAttribute("accId");

        //Comment lại sau khi Mở comment ở trên
        Integer id = 1;
        if(id != null){
            int accId = id;
            Account account = accountDAO.getAccountByIdandRole(accId, "admin");
            req.setAttribute("accountAd", account);
            req.getRequestDispatcher("inforAdmin.jsp").forward(req, resp);
        }else{
            resp.getWriter().println("Không tìm thấy ID trong session.");
        }
    }
}
