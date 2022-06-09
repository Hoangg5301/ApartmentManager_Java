package Dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dto.HoaDon;
// init hoa don
public class hoaDonD extends BaseDao<HoaDon> {

	@Override
	protected Class<HoaDon> Clazz() {
		// TODO Auto-generated method stub
		return HoaDon.class;
	}

	@Override
	public void add(HoaDon obj) {

		obj.setMahoadon("" + obj.getP().getTenPhong() + System.currentTimeMillis());
		super.add(obj);
	}

	public List<HoaDon> search(String ma, String p, String thang) {
		List<HoaDon> l = new ArrayList<HoaDon>();
		for (HoaDon h : super.allList()) {
			if (((ma != null && ma.length() > 0) ? h.getMahoadon().equals(ma) : true)
					&& ((p != null && p.length() > 0) ? h.getP().getTenPhong().equals(p) : true)
					&& ((thang != null && thang.length() > 0) ? ngay(h.getNgaytao())==Integer.parseInt(thang) : true)) {
				l.add(h);
			}
		}
		return l;
	}

	public int ngay(String ng) {
		try {
			return (new SimpleDateFormat("dd/MM/yy").parse(ng)).getMonth()+1;
		} catch (ParseException e) {
			// TODO Auto-generated catch block

			return 0;
		}
	}

}
