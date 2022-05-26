package Dao;

import java.util.List;

import dto.Phong;

public class PhongDao extends BaseDao<Phong> {

	@Override
	public Class<Phong> Clazz() {
		// TODO Auto-generated method stub
		return Phong.class;
	}

	public void edit(Phong p) throws Exception {
		List<Phong> lp = readData();
		searchById(p.getId());
		if (lp != null && lp.size() > 0) {
			for (Phong phong : lp) {
				if (phong.getId() == p.getId())
				{
					phong.setTenPhong(p.getTenPhong());
					phong.setGiaPhong(p.getGiaPhong().toString());
				}
			}
		}
		writeData(lp);
	}

}
