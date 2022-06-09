package Dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dto.Phong;
import dto.nguoiThue;

public class NguoiThueDao extends BaseDao<nguoiThue> {

	@Override
	protected Class<nguoiThue> Clazz() {
		// TODO Auto-generated method stub
		return nguoiThue.class;
	}

	public void addng(nguoiThue n) throws Exception {
		NguoiThueDao nd = new NguoiThueDao();
		if (n.getPhong().getSongP() > getNguoiThueByPhong(n.getPhong()).size()) {
			n.setNgayVao(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
			super.add(n);
		} else {
			throw new Exception("Phòng đã đầy!");
		}

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

	public void edit(nguoiThue n) throws Exception {
		NguoiThueDao nd = new NguoiThueDao();
		if (n.getPhong().getSongP() > getNguoiThueByPhong(n.getPhong()).size()) {
			List<nguoiThue> ln = allList();
			for (nguoiThue ng : ln) {
				if (ng.getId() == n.getId()) {
					ng.setCccd(n.getCccd());
					ng.setHoTen(n.getHoTen());
					ng.setDc(n.getDc());
					ng.setNs(n.getNs());
					ng.setPhong(n.getPhong());
					ng.setSdt(n.getSdt());

				}
			}
			writeData(ln);
		} else {
			throw new Exception("Phòng đã đầy!");
		}

	}

	public List<nguoiThue> search(String ten, String p, String ngv) {
		List<nguoiThue> l = new ArrayList<nguoiThue>();
		for (nguoiThue n : super.allList()) {
			if (((ten != null && ten.length() > 0) ? n.getHoTen().equals(ten) : true)
					&& ((p != null && p.length() > 0) ? n.getPhong().getTenPhong().equals(p) : true)
					&& ((ngv != null && ngv.length() > 0) ? n.getNgayVao().equals(ngv) : true)) {
				l.add(n);
			}
		}
		return l ;
	}

}
