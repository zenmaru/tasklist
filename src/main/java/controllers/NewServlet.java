package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Task;

/**
 * Servlet implementation class NewServlet
 */
@WebServlet("/new")
public class NewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // CSRF対策
        request.setAttribute("_token", request.getSession().getId());

        //おまじないとしてのインスタンスを生成
        request.setAttribute("task", new Task());

        RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/tasks/new.jsp");
        rd.forward(request,response);
        /*
        EntityManager em = DBUtil.createEntityManager();
        em.getTransaction().begin();
      // Taskのインスタンスを生成
        Task t = new Task();
      // tの各フィールドにデータを代入
        String title="家事";
        t.setTitle(title);
        String content = "炊飯";
        t.setContent(content);
        Timestamp currentTime = new Timestamp(System.currentTimeMillis()); // 現在の日時を取得
        t.setCreated_at(currentTime);
        t.setUpdated_at(currentTime);
      // データべースに保存
        em.persist(t);
        em.getTransaction().commit();
      // 自動採番されたIDの値を表示
        response.getWriter().append(Integer.valueOf(t.getId()).toString());
        em.close();
        */
    }

}
