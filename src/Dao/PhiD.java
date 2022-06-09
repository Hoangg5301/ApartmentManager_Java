package Dao;

import java.util.ArrayList;
import java.util.List;

import dto.Phi;

public class PhiD extends BaseDao<Phi> {

	@Override
	protected Class<Phi> Clazz() {
		// TODO Auto-generated method stub
		return Phi.class;
	}
	public void edit(Phi p) {
		List<Phi> lp = new ArrayList<Phi>();
		lp.add(p);
		writeData(lp);
		
	}

}
