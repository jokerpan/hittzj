package top.hittzj.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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

import top.hittzj.entity.Commodity_Type;
import top.hittzj.entity.User;
import top.hittzj.service.AddCSService;
import top.hittzj.service.FindTypeById;

/**
 * @author zy_q
 * 
 */
// �����ϴ�������Ʒ��servlet �������ļ��ϴ���
public class AddCSServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/error.jsp").forward(request, response);
		return;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Commodity_Type type = null;
		String desc = null;
		String name = null;
		String money = null;
		String number = null;
		String useTime = null;
		String flaw = null;
		String location = null;
		String relativePath = null;
		// ȷ���û��Ƿ��¼
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			request.setAttribute("loginResult", "Ҫ��¼֮���ٷ���Ŷ~");
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
			return;
		}
		// �������
		boolean haveImg = false;
		// һ�����ϴ���ͼƬ�ͱ���Ϣ
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
					// ����Ƿ��ļ�
					if (item.isFormField()) {
						String field_name = item.getFieldName();
						if ("typeId".equals(field_name)) {
							String typeid_ = item.getString();
							int typeid = Integer.parseInt(typeid_);
							FindTypeById findTypeById = new FindTypeById();
							type = findTypeById.find(typeid);
							if (type == null) {
								request.getRequestDispatcher("/error.jsp")
										.forward(request, response);
								return;
							}
						}
						if ("desc".equals(field_name)) {
							desc = item.getString();
							desc=new String(desc.getBytes("iso8859-1"),"utf-8");
						}
						if ("name".equals(field_name)) {
							name = item.getString();
							name=new String(name.getBytes("iso8859-1"),"utf-8");
						}
						if ("money".equals(field_name)) {
							money = item.getString();
							money=new String(money.getBytes("iso8859-1"),"utf-8");
						}
						if ("number".equals(field_name)) {
							number = item.getString();
							number=new String(number.getBytes("iso8859-1"),"utf-8");
						}
						if ("useTime".equals(field_name)) {
							useTime = item.getString();
							useTime=new String(useTime.getBytes("iso8859-1"),"utf-8");
						}
						if ("flaw".equals(field_name)) {
							flaw = item.getString();
							flaw=new String(flaw.getBytes("iso8859-1"),"utf-8");
						}
						if ("location".equals(field_name)) {
							location = item.getString();
							location=new String(location.getBytes("iso8859-1"),"utf-8");
						}
					} else {
						long size = item.getSize();
						if (size > 10) {
							haveImg = true;
							// ����ļ�����
							// ����һ��Ψһ��ǣ���ֹ����
							String id = UUID.randomUUID().toString();
							String fileName = id;
							// �õ�web��ĿĿ¼
							String rootPath = getServletContext().getRealPath(
									"/");
							// System.out.println(path);
							// �õ�������·��
							String completePath = rootPath + "s_img\\"
									+ fileName + ".jpg";
							// System.out.println("·��" + completePath);
							File file = new File(completePath);
							file.createNewFile();
							item.write(file);
							item.delete();
							relativePath = "s_img\\" + fileName + ".jpg";
							// System.out.println(relativePath);
						}
					}
				}
				if (!haveImg) {
					request.setAttribute("addCSResult", "�������ʵͼƬŶ");
					request.getRequestDispatcher("/addCS.jsp").forward(request,
							response);
					return;
				}
			} catch (FileUploadException e) {
				request.setAttribute("addCSResult", "�ϴ�ͼƬʧ����");
				request.getRequestDispatcher("/addCS.jsp").forward(request,
						response);
				return;
			} catch (Exception e) {
				request.setAttribute("addCSResult", "��Ʒ����ʧ��");
				request.getRequestDispatcher("/addCS.jsp").forward(request,
						response);
				return;
			}

		}
		// ����Ϣ

		AddCSService service = new AddCSService();
		boolean add = service.add(name, money, useTime, number, flaw, desc,
				location, relativePath, user, type);
		if (add) {
			request.setAttribute("addCSResult", "�����ɹ�");
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
			return;
		}
		request.setAttribute("addCSResult", "����ʧ��");
		request.getRequestDispatcher("/addCS.jsp").forward(request, response);
		return;
	}

}
