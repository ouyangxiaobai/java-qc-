package update;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sql.DataProcess;

/**
 * Servlet implementation class UpdateSupplier
 */
@WebServlet("/UpdateSupplier")
public class UpdateSupplier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSupplier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		DataProcess con=new DataProcess();
		String preid=request.getParameter("preid");
		String supplierid=request.getParameter("sid");
		String suppliername=request.getParameter("sname");
		String suppliertel=request.getParameter("suppliertel");
		String supplieradd=request.getParameter("supplieradd");
		String sql="update supplier set supplier_id='"+supplierid+"',"+
				"supplier_name='"+suppliername+"',"+
				"supplier_tel='"+suppliertel+"',"+
				"supplier_add='"+supplieradd+"'"
				+ " where supplier_id='"+preid+"'";
		int i=con.ExeQuery(sql);
		if(i==-1) {
			request.setAttribute("msg","修改失败");	
		}else {
			request.setAttribute("msg","修改成功");
		}
		request.getRequestDispatcher("/supplier_list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
