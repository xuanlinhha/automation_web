package vn.ldl.automation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.ldl.automation.dao.PiDao;
import vn.ldl.automation.entity.Pi;
import vn.ldl.automation.helper.PiInfoProcessor;

/**
 * @author xuanlinhha
 * 
 */
@Service
public class PiServiceImpl implements PiService {

	@Autowired
	PiDao piDao;

	public boolean saveInfo(String address, String piData) {
		Pi pi = PiInfoProcessor.convertPiInfo(address, piData);
		if (pi == null) {
			return false;
		}
		Pi databasePi = piDao.getById(pi.getId());
		if (databasePi != null) {
			if (!pi.getKey().equals(databasePi.getKey())) {
				return false;
			} else {
				pi.setOwner(databasePi.getOwner());
			}
		}
		piDao.saveOrUpdate(pi);
		return true;
	}

	public List<Pi> getAllInfos() {
		List<Pi> result = piDao.getAllInfos();
		return result;
	}

}
