package top.hittzj.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import top.hittzj.entity.Commodity_Need;
import top.hittzj.entity.User;
import top.hittzj.service.DeleCNService;
import top.hittzj.service.GetCNService;

public class DeleCNServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Commodity_Need commodity_need = null;
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			request.setAttribute("loginResult", "请登录");
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
			return;
		}
		// 得到商品的id
		int cnid = 0;
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 5mb
		upload.setHeaderEncoding("UTF-8");
		if (upload.isMultipartContent(request)) {
			List<FileItem> list = null;
			try {
				list = upload.parseRequest(request);
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			for (FileItem item : list) {
				// 非文件上传部分
				if (item.isFormField()) {
					String field_name = item.getFieldName();
					// 得到参数
					if ("CNId".equals(field_name)) {
						String cnid_ = item.getString();
						cnid_=new String(cnid_.getBytes("iso8859-1"),"UTF-8");
						cnid = Integer.parseInt(cnid_);
						break;
					}
				}
			}
		}

		GetCNService service = new GetCNService();
		commodity_need = service.get(cnid);
		if (commodity_need == null) {
			request.setAttribute("modifyCNResult", "没找到这个商品");
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
			return;
		}
		if (!user.getCount().equals(commodity_need.getUser().getCount())) {
			request.setAttribute("modifyCNResult", "这个商品不是你的咯");
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
			return;
		}

		String img = commodity_need.getImg();
		String rootPath = getServletContext().getRealPath("/");
		File file = new File(rootPath + img);
		boolean deletefile = file.delete();

		// 表单信息
		DeleCNService deleCNService = new DeleCNService();
		boolean delet = deleCNService.delet(commodity_need);
		if (delet) {
			request.setAttribute("modifyCNResult", "删除成功");
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
			return;
		} else {
			request.setAttribute("modifyCNResult", "删除失败");
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
			return;
		}
	}
}
