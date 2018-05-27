package presentation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ControllerServlet
 */
public class ControllerServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;
  private static final String USER_VUE = "/webPages/userVue.jsp";

  /**
   * @see HttpServlet#HttpServlet()
   */
  public ControllerServlet() {
    super();
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    doWork(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    doWork(request, response);
  }

  private void doWork(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String selectedOption = request.getParameter("selectOption");
    if (selectedOption != null) {

      switch (selectedOption) {
        case "1":
          break;

        case "2":
          break;

        case "3":
          break;

        case "4":
          break;

        default:
          break;
      }
    }

    // Displays the User Vue
    this.getServletContext().getRequestDispatcher(USER_VUE).forward(request, response);
  }
}
