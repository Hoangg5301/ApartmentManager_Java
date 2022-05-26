package views;

import Dao.PhongDao;
import dto.Phong;

public class test {

	public static void main(String[] args) {
		PhongDao p = new PhongDao();
//		Phong pp = new Phong("505");
//		p.writeData(pp);
//		
//		p.deleteById(3);
		for (Phong ps : p.readData()) {
			System.out.println(ps.getId()+" "+ps.getTenPhong());
		}
		//List<Phong> l = new ArrayList<>();
		
//		ObjectInputStream oi = null;
//		try {
//			oi = new  ObjectInputStream(new  FileInputStream(new File("dulieu\\Phong.txt")));
//			try {
//				System.out.println((l = (List<Phong>) oi.readObject()).get(0).getTenPhong());
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Phong p = new Phong("23234");
//		p.setId(0);
//		l.add(p);
//		ObjectOutputStream oo =null;
//		try {
//			oo = new ObjectOutputStream(new FileOutputStream(new File("dulieu\\Phong.txt")));
//			oo.writeObject(l);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			try {
//				oo.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//		
		

	}

}
