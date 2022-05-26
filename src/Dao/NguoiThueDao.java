package Dao;

import java.util.ArrayList;
import java.util.List;

import dto.Phong;
import dto.nguoiThue;

public class NguoiThueDao extends BaseDao<nguoiThue> {

	@Override
	protected Class<nguoiThue> Clazz() {
		// TODO Auto-generated method stub
		return nguoiThue.class;
	}

	public List<nguoiThue> getNguoiThueByPhong(Phong p) {
		List<nguoiThue> ln = new ArrayList<nguoiThue>();
		for (nguoiThue ng : allList()) {
			if (ng.getPhong() != null && ng.getPhong().getId() == p.getId()) {
				ln.add(ng);
			}
		}
		return ln;
	}

	public void deleteByPhong(nguoiThue n) {
		List<nguoiThue> ln = allList();
		for (nguoiThue ng : ln) {
			if (ng.getId() == n.getId()) {
				System.out.println(ng.getId());
				ng.setPhong(null);
				
			}
		}
		
		writeData(ln);
	}

}
