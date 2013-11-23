package client.servlet;

import client.controller.Action;
import client.controller.RequestHandler;
import client.entity.UpdateRequestInformation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/locate")
public class LocationProvider extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestHandler.getInstance().fetchLibrary(getServletContext());
        redirect("/library.jsp", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        UpdateRequestInformation bookInformation = new UpdateRequestInformation(
                req.getParameter("author"),
                req.getParameter("title"),
                req.getParameter("newValue")
        );
        Action action = Action.getByValue(req.getParameter("command"));
        RequestHandler.getInstance().process(action, bookInformation, getServletContext());
        redirect("/index.jsp", req, resp);
    }

    private void redirect(String url, HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
