package controller;

import jobtrans.dal.AccountDAO;
import jobtrans.model.Account;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;


            }

            switch (action) {
                case "viewAllUser":
                    viewAllUser(req, resp);
                    break;
                case "viewAccountDetails":
                    showAccount(req, resp);
                    break;
                case "viewAdminAccount":
                    showAdminAccount(req, resp);
                    break;
                default:
                    throw new AssertionError();
            }
        } catch (Exception ex) {
            Logger.getLogger(AccountManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void viewAllUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Account> list = accountDAO.getAccountUser();
        req.setAttribute("list", list);
        req.getRequestDispatcher("user-manage.jsp").forward(req, resp);
    }

    private void showAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("accId"));
        Account account = accountDAO.getAccountById(id);
        req.setAttribute("account", account);
        req.getRequestDispatcher("inforUser.jsp").forward(req, resp);
    }

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
