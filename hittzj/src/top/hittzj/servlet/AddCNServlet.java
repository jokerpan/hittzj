package top.hittzj.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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
import org.apache.log4j.Logger;

import top.hittzj.entity.Commodity_Type;
import top.hittzj.entity.User;
import top.hittzj.service.AddCNService;
import top.hittzj.service.AddCSService;
import top.hittzj.service.FindTypeById;

public class AddCNServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/error/404error.jsp").forward(request,
				response);
		return;
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String desc = null;
		String name = null;
		String money = null;
		String number = null;
		String location = null;
		String relativePath = null;
		// ȷ���û��Ƿ��¼
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			request.setAttribute("loginResult", "Ҫ��¼֮���ٷ���Ŷ~");
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
		}

		else {// һ�����ϴ���ͼƬ�ͱ���Ϣ
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 5mb
			upload.setFileSizeMax(1024 * 1024 * 5);
			upload.setSizeMax(1024 * 1024 * 5);
			upload.setHeaderEncoding("UTF-8");
			if (upload.isMultipartContent(request)) {
				try {
					List<FileItem> list = upload.parseRequest(request);
					for (FileItem item : list) {
						String field_name = item.getFieldName();
						if (item.isFormField()) {

							if ("desc".equals(field_name)) {
								desc = item.getString();
								 desc = new String(desc.getBytes("iso8859-1"),"utf-8");
							}
							if ("name".equals(field_name)) {
								name = item.getString();
								name = new String(name.getBytes("iso8859-1"),"utf-8");
							}
							if ("money".equals(field_name)) {
								money = item.getString();
								money = new String(money.getBytes("iso8859-1"),"utf-8");
							}
							if ("number".equals(field_name)) {
								number = item.getString();
								number = new String(number.getBytes("iso8859-1"),"utf-8");
							}
							if ("location".equals(field_name)) {
								location = item.getString();
								location = new String(location.getBytes("iso8859-1"),"utf-8");

							}
						} else {
							long size = item.getSize();
							if (size > 10) {
								String fileName = UUID.randomUUID().toString();
								// �õ�web��ĿĿ¼
								String rootPath = getServletContext()
										.getRealPath("/");
								// System.out.println(path);
								// �õ�������·��
								String completePath = rootPath +"/"+"n_img/"
										+ fileName + ".jpg";
								// System.out.println("·��" + completePath);
								File file = new File(completePath);
								file.createNewFile();
								item.write(file);
								item.delete();
								relativePath = "n_img/" + fileName + ".jpg";
								// System.out.println(relativePath);
							}
						}
					}
				} catch (FileUploadException e) {
					request.setAttribute("addCNResult", "��Ǹ���ϴ�ͼƬʧ����");
					request.getRequestDispatcher("/addCN.jsp").forward(request,
							response);
					return;
				} catch (Exception e) {
					request.setAttribute("addCNResult", "��Ǹ���ϴ���Ʒʧ����");
					request.getRequestDispatcher("/addCN.jsp").forward(request,
							response);
					return;
				}
			}
			// ����Ϣ
			AddCNService service = new AddCNService();
			boolean add = service.add(name, money, relativePath, location,
					desc, number, user);
			if (add) {
				request.setAttribute("addCNResult", "�����ɹ�");
				request.getRequestDispatcher("/index.jsp").forward(request,
						response);
				return;
			}
			request.setAttribute("addCNResult", "����ʧ��");
			request.getRequestDispatcher("/addCN.jsp").forward(request,
					response);
			return;
		}
	}
}
