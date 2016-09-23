package top.hittzj.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
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

import top.hittzj.entity.Commodity_Sell;
import top.hittzj.entity.User;
import top.hittzj.service.DeleCSService;
import top.hittzj.service.FindTypeById;
import top.hittzj.service.GetCSService;
import top.hittzj.service.ModifyCSService;

//ɾ����Ʒ
public class DeleCSServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Commodity_Sell commodity_Sell = null;
		int csid = 0;

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
				// ���ļ��ϴ�����
				if (item.isFormField()) {
					String field_name = item.getFieldName();
					// �õ�����
					if ("CSId".equals(field_name)) {
						String csid_ = item.getString();
						csid_=new String(csid_.getBytes("iso8859-1"),"utf-8");
						csid = Integer.parseInt(csid_);
						break;
					}
				}
			}
		}

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			request.setAttribute("loginResult", "���¼");
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
			return;
		}

		GetCSService service = new GetCSService();
		commodity_Sell = service.get(csid);
		if (commodity_Sell == null) {
			request.setAttribute("modifyCSResult", "û�ҵ������Ʒ");
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
			return;
		}
		if (!user.getCount().equals(commodity_Sell.getUser().getCount())) {
			request.setAttribute("modifyCSResult", "�����Ʒ������Ŀ�");
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
			return;
		}

		String img = commodity_Sell.getImg();
		String rootPath = getServletContext().getRealPath("/");
		File file = new File(rootPath + img);
		boolean deleteFile = file.delete();
		if (!deleteFile) {
			request.setAttribute("modifyCNResult", "ɾ��ʧ��");
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
			return;
		}

		// ����Ϣ
		DeleCSService deleCSService = new DeleCSService();
		boolean delet = deleCSService.delet(commodity_Sell);
		if (delet) {
			request.setAttribute("modifyCSResult", "ɾ���ɹ�");
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
			return;
		} else {
			request.setAttribute("modifyCSResult", "ɾ��ʧ��");
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
			return;
		}
	}
}
