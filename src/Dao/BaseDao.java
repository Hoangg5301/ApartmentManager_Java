package Dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import dto.Base;

/*
 * D class được kế thừa từ Base
 */
public abstract class BaseDao<D extends Base> {
	/*
	 * Clazz trả về class hiện tại (D extend Base)
	 */
	protected abstract Class<D> Clazz();

	/*
	 * trả về danh sách
	 */
	public List<D> allList() {
		List<D> ls = new ArrayList<>();
		ls = readData();
		return ls;

	}

	/*
	 * Thêm 1 phần tử vào file
	 */
	public void add(D obj) {
		try {
			List<D> ls = readData();
			obj.setId(nextId());
			ls.add(obj);
			writeData(ls);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	/*
	 * xóa theo id
	 */
	public void deleteById(int id) throws Exception{
		List<D> ls = readData();// lấy danh sách từ file
		D obj = null;
		if (ls != null && ls.size() > 0) {
			for (D d : ls) {// lấy tất cả các phần tử trong danh sách
				if (d.getId() == id)
					obj = d;
			}
		}
		if (obj != null)
			ls.remove(obj);
		else throw new Exception("Id không tồn tại!");
		writeData(ls);
	}

	public List<D> searchById(int id) throws Exception { 
		List<D> tg = new ArrayList<>();
		List<D> ls = readData();// lấy danh sách từ file
		D obj = null;
		if (ls != null && ls.size() > 0) {
			for (D d : ls) {// lấy tất cả các phần tử trong danh sách
				if (d.getId() == id)
					obj = d;
			}
		}
		if (obj == null) throw new Exception("Id không tồn tại!");
		else tg.add(obj);
		return tg;
	
	}
	/*
	 * đọc dữ liệu từ file
	 */
	public List<D> readData() {
		List<D> ls = new ArrayList<>();

		try {
			ObjectInputStream o = new ObjectInputStream(
					new FileInputStream(new File("dulieu\\" + Clazz().getSimpleName() + ".txt")));
			try {
				ls = (List<D>) o.readObject();
			} catch (ClassNotFoundException e) {

			}
			o.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return ls;
	}

//	/*
//	 * ghi 1 object vào file
//	 */
//	public void writeData(D obj) {
//		List<D> ls = readData();
//		obj.setId(nextId());
//		ls.add(obj);
//		writeData(ls);
//	}

	/*
	 * ghi list các object vào file
	 */
	public void writeData(List<D> ls) {
		ObjectOutputStream o = null;
		try {
			o = new ObjectOutputStream(new FileOutputStream(new File("dulieu\\" + Clazz().getSimpleName() + ".txt")));
			o.writeObject(ls);
			o.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * hàm tăng id khi list rỗng id cấp ms =1;
	 */
	public int nextId() {
		if (readData().size() > 0)
			return readData().get(readData().size() - 1).getId() + 1;
		return 1;
	}

}
