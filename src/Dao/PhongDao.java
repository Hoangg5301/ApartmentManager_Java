package Dao;

import java.util.List;

import dto.Phong;
import dto.nguoiThue;

public class PhongDao extends BaseDao<Phong> {
	
	
	/**
	 * 
	 */
	public PhongDao() {
		NguoiThueDao nt = new NguoiThueDao();
		List<Phong> lp = readData();
		for (Phong p : lp) {
			p.setSong(nt.getNguoiThueByPhong(p).size());
		}
		writeData(lp);
	}
	@Override
	public Class<Phong> Clazz() {
		
		return Phong.class;
	}
	@Override
	public void deleteById(int id) throws Exception {
		NguoiThueDao nd = new NguoiThueDao();
		List<nguoiThue> ln = nd.getNguoiThueByPhong(searchById(id).get(0));
		for (nguoiThue n : ln) {
			n.setPhong(null);
		}
		nd.writeData(ln);
		super.deleteById(id);
		
	}
	public void edit(Phong p) throws Exception {
		List<Phong> lp = allList();
		if (lp != null && lp.size() > 0) {
			for (Phong phong : lp) {
				if (phong.getId() == p.getId())
				{
					phong.setTenPhong(p.getTenPhong());
					phong.setGiaPhong(p.getGiaPhong().toString());
					phong.setSongP(p.getSongP()+"");
				}
			}
		}
		writeData(lp);
	}
	public Phong searchByName(String t){
		for (Phong pg : allList()) {
			if(pg.getTenPhong().equals(t)) return pg;
		}
		return null;
	}

}
